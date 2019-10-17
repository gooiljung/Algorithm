package A_Type_Test;
import java.util.*;


//4:40
class Pair{
	int x,y,time;
	Pair(int x,int y,int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
}

public class	 problem17142 {
	
	public static int N,M;
	public static int map[][];
	public static int blank=0;
	public static boolean originCheck[][];
	public static int result=Integer.MAX_VALUE;
	public static void combination(ArrayList<Integer> arr , int n,int r, int target) {
		if(r==0) {

			result = Math.min(result, go(arr));
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
	
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static int go(ArrayList<Integer> arr) {
		boolean check[][] = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				check[i][j] = originCheck[i][j];
			}
		}
		int count =0;
		Queue <Pair> q = new LinkedList<Pair>();
		for(int i=0;i<arr.size();i++) {
			int temp = arr.get(i);
			Pair p = possible.get(temp);
			q.add(new Pair(p.x,p.y,0));
		}
		int realT=0;
		while(!q.isEmpty()) {
	
			Pair p = q.remove();
			int x = p.x;
			int y=p.y;
			int time = p.time;
			
			check[x][y] = true;
			if(map[x][y]==0) count++;
			
			if(count==blank) {
				
				return realT;
			}
			for(int i=0;i<4;i++) {
				int nx = x+ dx[i];
				int ny = y+ dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				
				if(!check[nx][ny]) {
					q.add(new Pair(nx,ny,time+1));
					check[nx][ny]=true;
					if(map[nx][ny]==0) {
						realT=Math.max(realT, time+1);
					}
					
					
				}
				
			}
			
			
		}
	
		return Integer.MAX_VALUE;
		
	}
	
	public static ArrayList<Pair> possible;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new int [N][N];
		originCheck = new boolean[N][N];
		
		possible = new ArrayList<Pair>();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(scan.nextLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				//채워야하는 빈칸 수 
				if(map[i][j]==0) {
					blank++;
				}else if(map[i][j]==2) {
					//가능한 바이러스 위치 
					possible.add(new Pair(i,j,0));
//					originCheck[i][j]=true;
				}else {
					//벽면 
					originCheck[i][j]=true;
				}
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		combination(arr,possible.size(),M,0);
		if(blank==0) {
			System.out.println(0);
			return;
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
}
