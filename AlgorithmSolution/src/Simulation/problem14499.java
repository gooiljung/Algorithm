package Simulation;
import java.util.*;


public class problem14499{
	public static final int dx[] = {0,0,-1,1};
	public static final int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int k = scan.nextInt();
		
		int map[][] = new int [N][M];
		for (int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]= scan.nextInt();
			}
		}
		int dice[] = new int [7]; 
		Arrays.fill(dice,0);
		
		
		while(k-->0) {
			int oper = scan.nextInt();
			int nx = x+dx[oper-1];
			int ny = y+dy[oper-1];
			
			if(nx<0||nx>=N||ny<0||ny>=M) {
				continue;
			}else {
				x = nx;
				y = ny;
			}
			// dice[6] 이 윗면 dice[1] 이 아랫면
			switch(oper) {
			case 1:  //동 
				int temp = dice[6];
				dice[6] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = temp;
				
				break;
			case 2: // 서 
				temp = dice[6];
				dice[6] = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = temp;
				
				break;
				
			case 3: // 북
				temp = dice[6];
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = temp;
				
				break;
				
			case 4: //남
				temp = dice[6];
				dice[6] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = temp;
				
				break;
				
			}
			
			if(map[x][y] == 0) {
				map[x][y] = dice[1];
			}else {
				dice[1] = map[x][y];
				map[x][y] = 0;
				
			}
			System.out.println(dice[6]);
			
			
			
			
			
		}
		
		
		
	}
}







