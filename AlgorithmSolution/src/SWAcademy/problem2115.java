package SWAcademy;
import java.util.*;

class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y =y;
	}
}
public class problem2115 {
	public static int N,M,C;
	public static int honey[][];
	public static boolean check[][];
	public static int initX;
	public static int Max;

	public static int Max2;
	//Max 값 조정 필요 
	public static void go(int x,int y) {

//		System.out.println("x , y = "+x+","+y);
//		System.out.println(Max+" , "+Max2);
//		System.out.println("sum= "+(Max+Max2));
		if(x>=N) return;

		int nextY=y+M;
		if(initX==x) { // 선택한 라인과 같읕 라인 일시 
			if(nextY<N&&(nextY+M-1)<N) {
				int temp[] = new int [M];
				for(int i=0;i<M;i++) {  
					temp[i]=honey[x][nextY+i];  // 한곳이 선택됨 그 해당 값들이 temp배열에 들어가잇다 이때 cal함수 호출하자  호출한 초기 x랑 같은 라인일시 
				}
				boolean visited[] = new boolean[M];
				cal(temp,visited,M,0);
				go(x,nextY+1);
			} else {
				go(x+1,0);
			}
		}else { // 선택한 라인과 다른 라인 
			
			if(y+M-1<N) {
				int temp[] = new int [M];
				for(int i=0;i<M;i++) {  
					temp[i]=honey[x][y+i];  // 한곳이 선택됨 그 해당 값들이 temp배열에 들어가잇다 이때 cal함수 호출하자  호출한 초기 x랑 같은 라인일시 
				}
				boolean visited[] = new boolean[M];
				cal(temp,visited,M,0);
				go(x,y+1);
			} else {
				go(x+1,0);
			}
		}



	}
	public static void cal(int arr[],boolean[] visited,int n,int idx) {
		if(idx == n) {
			Max=Math.max(Max,powerSet(arr,visited,n)); 
			return;
		}

		visited[idx] = false;
		cal(arr, visited, n, idx + 1);

		visited[idx] = true;
		cal(arr, visited, n, idx + 1);

	}

	public static void cal2(int arr[],boolean[] visited,int n,int idx) {
		if(idx == n) {
			Max2=Math.max(Max2,powerSet(arr,visited,n));    

			return;
		}

		visited[idx] = false;
		cal2(arr, visited, n, idx + 1);

		visited[idx] = true;
		cal2(arr, visited, n, idx + 1);

	}
	static int powerSet(int[] arr, boolean[] visited, int n) { 
		int max=0;
		int sum=0;
		for(int i=0; i<n; i++) {

			if(visited[i] == true) {
				sum+=arr[i];
				max+=arr[i]*arr[i];
			}
		}
		if(sum>C) {
			return -1;
		}else {
			return max;
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		int T = Integer.parseInt(st.nextToken());

		for(int a=1;a<=T;a++) {
			st = new StringTokenizer(scan.nextLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(scan.nextLine());
				for(int j=0;j<N;j++) {
					honey[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			check = new boolean[N][N];
			int result =0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					Max=0;Max2=0;
					initX=i;
					int arr[] = new int[M];
					int index=0;
					for(int k=j;k<j+M;k++) {
						arr[index++]=honey[i][k];

					}
					boolean tf[] = new boolean[M];
					cal2(arr,tf,M,0);
//					System.out.println("@@@@@@@@@@@@@@");

					go(i,j);
					//					System.out.println("Max = "+Max+" Max2="+Max2);
					result=Math.max(result,Max+Max2);

				}
			}
			System.out.println("#"+a+" "+result);


		}

	}
}
