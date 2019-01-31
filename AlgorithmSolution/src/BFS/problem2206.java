package BFS;
import java.util.*;
class Pair {
	int x,y,z;
	Pair(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
}


public class problem2206{
	public static final int dx[] = {0,0,1,-1};
	public static final int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int NM[][] = new int [N][M];
		String a = new String();
		scan.nextLine();
		for(int i=0;i<N;i++) {
			a = scan.nextLine();
			for(int j=0;j<M;j++) {

				if(a.charAt(j)=='0') {
					NM[i][j] = 0;
				}else {
					NM[i][j] = 1;
				}		
			}
		}
		int dist[][][] = new int[N][M][2];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,0));
		dist[0][0][0]=1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			
			for(int i = 0 ;i <4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M) {
					continue;
				}
				
				if(NM[nx][ny]==0&&dist[nx][ny][z]==0) {
					q.add(new Pair(nx,ny,z));
					dist[nx][ny][z] = dist[x][y][z]+1;
				}
				
				if(z==0&&NM[nx][ny]==1&&dist[nx][ny][z+1]==0) {
					q.add(new Pair(nx,ny,z+1));
					dist[nx][ny][z+1] = dist[x][y][z]+1;
				}
				
			}
		}
		
		if(dist[N-1][M-1][0]!=0&&dist[N-1][M-1][1]!=0) {
			System.out.println(Math.min(dist[N-1][M-1][0]+1, dist[N-1][M-1][1]));
		}else if(dist[N-1][M-1][0]!=0) {
			System.out.println(dist[N-1][M-1][0]);
		}else if(dist[N-1][M-1][1]!=0){
			System.out.println(dist[N-1][M-1][1]);
			
		}else {
			System.out.println(-1);
		}

	}


}



