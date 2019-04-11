package SAMSUNG;
import java.util.*;
class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}

	boolean check(Queue <Pair> pair,char color[],char rgb[][],boolean check[][]) {
		boolean inside =false;
		while(!pair.isEmpty()) {
			inside=true;
			Pair p = pair.remove();
			if(check[p.x][p.y]) {
				continue;
			}else {
				check[p.x][p.y]=true;
			}
			
			//up
			if(p.x-1>=0&&(rgb[p.x-1][p.y]==color[0]||rgb[p.x-1][p.y]==color[1])) {
				if(!check[p.x-1][p.y]) {
					pair.add(new Pair(p.x-1,p.y));
				}
			}
			//down
			if(p.x+1<rgb.length&&(rgb[p.x+1][p.y]==color[0]||rgb[p.x+1][p.y]==color[1])) {
				if(!check[p.x+1][p.y]) {
					pair.add(new Pair(p.x+1,p.y));
				}
				
			}
			//right
			if(p.y+1<rgb.length&&(rgb[p.x][p.y+1]==color[0]||rgb[p.x][p.y+1]==color[1])) {
				if(!check[p.x][p.y+1]) {
					pair.add(new Pair(p.x,p.y+1));
				}
				
				
			}
			//left
			if(p.y-1>=0&&(rgb[p.x][p.y-1]==color[0]||rgb[p.x][p.y-1]==color[1])) {
				
				if(!check[p.x][p.y-1]) {
					pair.add(new Pair(p.x,p.y-1));	
				}
				
				
			}
			
		}
		
		return inside;
	}
}
public class problem10026 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		char rgb[][] = new char[n][n];
	
		int rx=0,ry=0,gx=0,gy=0,bx=0,by=0;
		for(int i=0;i<n;i++) {
			String temp =new String();
			temp=scan.nextLine();
			for(int j=0;j<n;j++) {
				rgb[i][j] = temp.charAt(j);				
			}
		}
	
		int handicap=0,normal=0;
		
		Queue <Pair> red = new LinkedList<Pair>();
		Queue <Pair>	 green = new LinkedList<Pair>();
		Queue <Pair> blue = new LinkedList<Pair>();
		Queue <Pair> handi = new LinkedList<Pair>();
		Queue <Pair> handiBlue = new LinkedList<Pair>();
		boolean check[][] = new boolean[n][n];
		boolean handicheck[][] = new boolean[n][n];
		
		int count =0;
		int a=0,b=0;
		while(count!=n*n) {
		
			count++;
			if(check[a][b]) {
				if(b+1<n) {
					b++;
				}else {
					b=0;
					a++;
					if(a==n) {
						System.out.println(normal+" "+handicap);
						
						return;
					}
				}
				continue;
			}
			
			if(rgb[a][b]=='R') {
				red.add(new Pair(a,b));
				
			}else if(rgb[a][b]=='G') {
				green.add(new Pair(a,b));
				
			}else {
				blue.add(new Pair(a,b));
				
			}
			if(rgb[a][b]=='R'||rgb[a][b]=='G') {
				if(!handicheck[a][b]) {
					handi.add(new Pair(a,b));
				}
				
			}else {
				handiBlue.add(new Pair(a,b));
			}
			Pair p = new Pair(0,0);
			
			if(!red.isEmpty()) {
				char ch[]= {'R','R'};
				if(p.check(red,ch,rgb,check)) {
					normal++;
				}
			}
			if(!green.isEmpty()) {
				char ch[]= {'G','G'};
				if(p.check(green,ch,rgb,check)) {
					normal++;
				}
			}
			if(!blue.isEmpty()) {
				char ch[]= {'B','B'};
				if(p.check(blue,ch,rgb,check)) {
					normal++;
					
				}
			}
			if(!handi.isEmpty()) {
				char ch[]= {'R','G'};
				if(p.check(handi,ch,rgb,handicheck)) {
					handicap++;
				}
			}
			if(!handiBlue.isEmpty()) {
				char ch[]= {'B','B'};
				if(p.check(handiBlue,ch,rgb,handicheck)) {
					handicap++;
				
					
				}
			}
			if(b+1<n) {
				b++;
			}else {
				b=0;
				a++;
				if(a==n) {
					System.out.println(normal+" "+handicap);
				
					return;
				}
			}
		}
		
		
	
		
	}
}














