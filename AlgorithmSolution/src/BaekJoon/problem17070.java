package BaekJoon;
import java.util.*;

class Pair{
	int x,y,status;
	
	Pair(int x,int y,int status){
		this.x=x;
		this.y=y;
		this.status=status;
	}
}

public class problem17070 {
	public static int N;
	public static int map[][];
	public static int dx[]= {0,1,1}; // 밑으로 오른쪽 오른쪽밑대각  //상태 가로일 경우 1 index 안됨  세로일 경우 0 인덱스 안됨 
	public static int dy[] ={1,0,1};  // 0 가로 1 세로 2 대각 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(scan.nextLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());

			}
		}
		Queue <Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,1,0));
		int arrival=0;
		boolean check [][] = new boolean[N][N];
		while(!q.isEmpty()) {
			
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int status = p.status;
			System.out.println("x,y = "+x+" , "+y+" status = "+status);
			if(x==N-1&&y==N-1) {
				arrival++;
				continue;
			}
			
			for(int i=0;i<3;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx&&nx<N&&0<=ny&&ny<N) {
					if(i==0&&status!=1) { //가로 
						if(map[nx][ny]!=1) {
							q.add(new Pair(nx,ny,0));
						}
						
					}else if(i==1&&status!=0) { // 세로
						if(map[nx][ny]!=1) {
							q.add(new Pair(nx,ny,1));
						}
					}else if(i==2){//대각 
						if(map[nx][ny]!=1&&map[nx][ny-1]!=1&&map[nx-1][ny]!=1) {
							
							q.add(new Pair(nx,ny,2));
						}
					}
		
				}
				
			}
		
		}
		System.out.println(arrival);
		
		
	}
}

















