package SWAcademy;
import java.util.*;
class Pair{
	int x,y,cnt;
	Pair(int x,int y,int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}

public class problem2105 {
	public static int N;
	public static int map[][];
	static final int dx[] = {1, -1, -1, 1}; // 대각선 방향으로 이동하기 위한 dx, dy 좌표
	static final int dy[] = {1, 1, -1, -1};
	public static boolean check[][];
	public static int numCheck[];
	public static Pair result[][];
	public static Pair startPoint;
	public static int findMax;
	
	public static void go(int i,int j,int cnt,int dir) {
		check[i][j]=true;
		numCheck[map[i][j]]=1;
		for(int a=dir;a<4;a++) {
			int nx =dx[a]+i;
			int ny = dy[a]+j;
			
			if(0<=nx&&nx<N&&0<=ny&&ny<N) {
				if((nx==0&&ny==0)||(nx==N-1&&ny==0)||(nx==0&&ny==N-1)||(nx==N-1&&ny==N-1)) continue;
				
				if((nx==startPoint.x)&&(ny==startPoint.y)&&cnt>3) {
					findMax = Math.max(findMax, cnt);
				}
				if(check[nx][ny]||numCheck[map[nx][ny]]==1) continue;
				
				go(nx,ny,cnt+1,a);
			}
			
		}		
		check[i][j] = false;
		numCheck[map[i][j]]=0;		

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		int T= Integer.parseInt(st.nextToken());
		for(int a=1;a<=T;a++) {
			st=new StringTokenizer(scan.nextLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			

			for(int i=0;i<N;i++) {
				st=new StringTokenizer(scan.nextLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					
				}
			}
			
			findMax=-1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					numCheck=new int [101];
					if((i==0&&j==0)||(i==N-1&&j==0)||(i==0&&j==N-1)||(i==N-1&&j==N-1)) continue; // 각 꼭지점은 사각형을 그릴수 없다.
					startPoint = new Pair(i,j,1);
					result = new Pair[N][N];
					result[i][j] = new Pair(i,j,1);
					check = new boolean[N][N];
					
					go(i,j,1,0);
				
				}
			}
		
			

			System.out.println("#"+a+" "+findMax);
			



		}

	}
}
