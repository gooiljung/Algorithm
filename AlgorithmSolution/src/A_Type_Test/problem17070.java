package A_Type_Test;
import java.util.*;


public class problem17070 {
	public static int map[][];
	public static int result=0;
	public static int N;
	public static void go(int x,int y,int state) {
		if(x==N-1&&y==N-1) {
			result++;
			return;
		}
		if(state ==1) {
			if(y+1<N) {
				if(map[x][y+1]!=1) {
					go(x,y+1,1);
				}
				if(x+1<N&&map[x+1][y+1]!=1&&map[x+1][y]!=1&&map[x][y+1]!=1) {
					go(x+1,y+1,3);
				}
			}
		}else if(state ==2) {
			if(x+1<N) {
				if(map[x+1][y]!=1) {
					go(x+1,y,2);
				}
				if(y+1<N&&map[x+1][y+1]!=1&&map[x+1][y]!=1&&map[x][y+1]!=1) {
					go(x+1,y+1,3);
				}
			}
		}else {
			if(y+1<N) {
				if(map[x][y+1]!=1) {
					go(x,y+1,1);
				}
				if(x+1<N&&map[x+1][y+1]!=1&&map[x+1][y]!=1&&map[x][y+1]!=1) {
					go(x+1,y+1,3);
				}
			}
			if(x+1<N) {
				if(map[x+1][y]!=1) {
					go(x+1,y,2);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		N= Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(scan.nextLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,1,1);
		System.out.println(result);
		
	}
	
}













