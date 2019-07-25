package SWAcademy;


import java.util.*;
class Pair{
	int x,y,max;
	Pair(int x,int y,int max){
		this.x=x;
		this.y=y;
		this.max=max;
	}
}


public class problem1949 {
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0}; //우 왼 위 아
	public static int N,K;
	public static int map[][];
	public static boolean visit[][];
	public static int result;


	public static void go(int x,int y,int max,boolean check) {
		if(visit[x][y]) return;
		visit[x][y]=true;


		if(result<max) {
			result=max;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny =y+dy[i];
//			System.out.println("(x,y) = "+x+","+y+" max= "+max+" map[x][y]="+map[x][y]);
			if(nx>=0&&nx<N &&ny>=0&&ny<N&&!visit[nx][ny]) {
				if(map[x][y]>map[nx][ny]) {
					go(nx,ny,max+1,check);
					
					
				}
				if(check!=true&&(map[x][y]<=map[nx][ny])) {
					if((map[nx][ny]-map[x][y])<K) {
						int temp = map[nx][ny];
						map[nx][ny]=map[x][y]-1;
//						System.out.println("(nx,ny) = "+"("+nx+","+ny+") "+" map[nx][ny] = "+map[nx][ny]+"@@@");
					
						go(nx,ny,max+1,true);
						map[nx][ny]=temp;
						
					}
					
				}
				
			}
			
		}
		visit[x][y]=false;

	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int a=1;a<=T;a++) {
			N = scan.nextInt();
			K=scan.nextInt();
			map= new int[N][N];
			
			int highest =0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=scan.nextInt();
					if(map[i][j]>highest) {
						highest = map[i][j];
					}
				}
			}
			int ix[]=new int[5];
			int iy[]=new int[5];
			
			Arrays.fill(ix,-1);
			Arrays.fill(iy, -1);
			int temp=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(map[i][j]==highest) {
						ix[temp]=i;
						iy[temp]=j;
						temp++;
					}
				}
			}
			
			result=1;
			for(int start=0;start<5;start++) {
				visit = new boolean[N][N];
				int x = ix[start];
				int y = iy[start];
		
				if(x!=-1&&y!=-1) go(x,y,1,false);
//				System.out.println("@@@@@@@@@@@@@@@");
				
			}
			System.out.println("#"+a+" "+result);
			
		}
	}
}
