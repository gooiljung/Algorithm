package SAMSUNG;
import java.util.*;
class site{
	int x,y;
	site(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class problem2468 {
	public static int height=0;
	
	public static void go(int a[][],boolean check[][],int max,int now) {
		Queue <site> q = new LinkedList<site>();
		int numOfPart =0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(now<a[i][j]) {
					check[i][j] = true;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(check[i][j]) {		
					q.add(new site(i,j));	
					while(!q.isEmpty()) {
						site p = q.remove();
						check[p.x][p.y]=false;
						
						if(p.y+1<a.length&&check[p.x][p.y+1]) {
							// right
							q.add(new site(p.x,p.y+1));
							check[p.x][p.y+1] =false;
						}
						if(p.y-1>=0&&check[p.x][p.y-1]) {
							// left
							q.add(new site(p.x,p.y-1));
							check[p.x][p.y-1]=false;
						}
						if(p.x+1<a.length&&check[p.x+1][p.y]) {
							//down
							q.add(new site(p.x+1,p.y));
							check[p.x+1][p.y]=false;
						}
						if(p.x-1>=0&&check[p.x-1][p.y]) {
							//up
							q.add(new site(p.x-1,p.y));
							check[p.x-1][p.y]=false;
						}	
					}
					numOfPart +=1;
					
				}
			}
			
		}
		
		
		
		
		now+=1;
		if(now > height) {
			
			System.out.println(numOfPart>max?numOfPart:max);
			return;
		}
		if(now<=height) {
			if(numOfPart>max) {
				go(a,check,numOfPart,now);
			}else {
				go(a,check,max,now);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a[][] = new int [N][N];

		boolean check [][] = new boolean[N][N];
		
		for (int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp = scan.nextInt();
				if (temp>height) {
					height = temp;
					
				}
				a[i][j] = temp;
			}
		}
		
		go(a,check,1,1);
		
	}
}
