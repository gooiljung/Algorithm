package BFS;
import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class problem2178 {
	public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int map[][]=new int[n][m];
		String a=new String();
		scan.nextLine();
		for(int i=0;i<n;i++) {
			a=scan.nextLine();
			for(int j=0;j<m;j++) {
				if(a.charAt(j)=='0') {
					map[i][j] = 0;
				}else {
					map[i][j] = 1;
				}		
			}
		}
	
		Boolean check[][]=new Boolean[n][m];
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				check[i][j] = false;	
			}
		}
		
		int dist[][] = new int [n][m];
		check[0][0] = true;
		dist[0][0] = 1;
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
	
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx&&nx<n&& 0<=ny&&ny<m) {
					if(check[nx][ny]==false&&map[nx][ny]==1) {
						q.add(new Pair(nx,ny));
						dist[nx][ny] = dist[x][y]+1;
						check[nx][ny] = true;
						
					}
					
				}
				
			}
		}
		System.out.println(dist[n-1][m-1]);
		
		
	}
}















