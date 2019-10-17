package A_Type_Test;
import java.util.*;

//3:01
/*
 * N 개의 구역 1~N
 */
public class problem17471 {
	public static int N;
	public static int people[];
	public static int map[][];
	public static int totalNum=0;
	public static int min = Integer.MAX_VALUE;
	// arr , arr2  2구역으로 나눴다. 이제 여기서 연결되는지 체크 후 연결이되면 true 
	public static boolean connection(ArrayList<Integer> arr) {
		boolean check[] = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		int cnt =1;
		q.add(arr.get(0));
		check[arr.get(0)]=true;
		while(!q.isEmpty()) {
			int now = q.remove();
			for(int i=0;i<N;i++) {
				if(map[now][i]==1&&arr.contains(i)&&!check[i]) {
					q.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		if(cnt == arr.size()) {
			Queue <Integer> q2 = new LinkedList<>();
			Arrays.fill(check, false);
			for(int i=0;i<N;i++) {
				if(!arr.contains(i)) {	
					q2.add(i);
					check[i]=true;
					break;
				}
			}
			
			cnt=1;
			while(!q2.isEmpty()) {
				int now = q2.remove();
				for(int i=0;i<N;i++) {
					if(map[now][i]==1&&!arr.contains(i)&&!check[i]) {
						q2.add(i);
						check[i] = true;
						cnt++;
					}
				}
			}
			if(cnt==(N-arr.size())) {
				return true;
			}
		}
		
		
		return false;
	}
	public static void combination(ArrayList<Integer> arr, int n,int r,int target) {
		if(r==0) {
			//connection 호출후 true 인경우만 해당 인원의 차이  
			if(connection(arr)) {
				int sum=0;
				for(int i=0;i<arr.size();i++) {
					sum+=people[(arr.get(i))];
				}
				
				min = Math.min(min,Math.abs(totalNum-(sum*2)));
			}
			return;
		}
		if(target>=n) {
			return;
		}else {
			arr.add(target);
		}
		
		combination(arr,n,r-1,target+1);
		arr.remove(arr.size()-1);
		combination(arr,n,r,target+1);
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		st = new StringTokenizer(scan.nextLine());
		people = new int[N];
		for(int i=0;i<N;i++) {
			people[i]= Integer.parseInt(st.nextToken());
			totalNum+=people[i];
		}
	
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(scan.nextLine());
			int temp = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<temp;j++) {
				int t = Integer.parseInt(st.nextToken());
				map[i][t-1] = 1;
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=1;i<=N/2;i++) {
			combination(arr,N,i,0);
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			
		}else {
			System.out.println(min);
		}
		
	}
}
