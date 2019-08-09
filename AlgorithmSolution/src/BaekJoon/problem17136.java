package BaekJoon;
import java.util.*;

public class problem17136 {
	public static int num;
	public static int min = Integer.MAX_VALUE;
	public static int numOfPaper[]= {0,5,5,5,5,5};
	public static int use[]= {0,0,0,0,0,0};
	public static int reuse=0;
	public static boolean check(int x,int y,int size,boolean visited[][]) {

		if(9<x+size-1||9<y+size-1) return false;

		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {

				if(map[i][j]!=1||visited[i][j]) {
					return false;
				}
				
			}
		}
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(map[i][j]==1) {
					visited[i][j] = true;
				}	
			}
		}
		return true;
	}

	public static int count(boolean visited[][]) {
		int cnt=0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(visited[i][j]&&map[i][j]==1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static boolean[][] copy(boolean prev[][]) {
		boolean [][]temp = new boolean[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				
				temp[i][j] = prev[i][j];
			}
		}
		return temp;
	}
	public static void go(int x,int y,boolean visited[][],int cnt) {
		System.out.println("x,y = "+x+" , "+y+" cnt = "+cnt+" 현재 true "+count(visited));
		if(x>9||y>9) return;
		if(cnt>min) return;
		if(num==count(visited)) {
			min = Math.min(min, cnt); 
			return;
		}
		if(map[x][y]==0||visited[x][y]) {
			if(y+1<=9) {
				go(x,y+1,visited,cnt);
			
			}else {
				if(x+1<=9) {
					go(x+1,0,visited,cnt);
				}
				
			}
		}
	
		// 1 이라는 것 
		
		for(int i=5;i>=1;i--) {
			boolean temp[][] = copy(visited);
			if(numOfPaper[i]>0&&check(x,y,i,temp)) {
				numOfPaper[i]--;
				go(x,y,temp,cnt+1);
				numOfPaper[i]++;
			}
		}
			
		
	}
	public static int map[][];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int [10][10];
		num =0;
		for(int i=0;i<10;i++) {
		
			for(int j=0;j<10;j++) {
				map[i][j]=scan.nextInt();
				if(map[i][j]==1) {
					num++;
				}
			}
		}
		boolean check[][] = new boolean [10][10];
		go(0,0,check,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else{
			System.out.println(min);
		}
		scan.close();




	}
}
