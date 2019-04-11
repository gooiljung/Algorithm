package SAMSUNG;
import java.util.*;
class Pair{
	int x,y;
	Pair(int x,int y){
		this.x =x;
		this.y = y;
	}
}
public class problem2573 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int iceberg[][] = new int[n][m];
		int temp[][] = new int [n][m];
	
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				iceberg[i][j] = scan.nextInt();
				temp[i][j] = iceberg[i][j];
			}
		}
	
		int a=0,b=0;
		int init = 0;
		int year = 0;
		while(true) {
			if(temp[a][b]==0) {
				if(b+1<m) {
					b+=1;
					
				}else {
					b=0;
					a+=1;
					
				}
				if(a==n) {
					a=0;
					init=1;  // n,m 이 5,7 인 경우 4,6을 하고난다음에 초기화되고 0,1일로 다시넘어가서하니
				}
				if(a==0&&b==0) {
					
				}else {
					continue;
				}
				
			}
			int count =0;
			//up
			if(a-1>=0&&temp[a-1][b]==0) {
				count+=1;
			}
			//down
			if(a+1<n&&temp[a+1][b]==0) {
				count+=1;
			}
			
			//left
			if(b-1>=0&&temp[a][b-1]==0) {
				count+=1;
			}
			//right
			if(b+1<m&&temp[a][b+1]==0) {
				count+=1;
			}
			
			iceberg[a][b]-=count;
			
			if(iceberg[a][b]<0) {
				iceberg[a][b]=0;
			}
			if(b+1<m) {
				b+=1;
				
			}else {
				b=0;
				a+=1;
			}
			if(a==n) {
				a=0;
			}
			int qi=0,qj=0;
			boolean in=false;
			if(init==1) {
				Queue <Pair> q = new LinkedList<Pair>();
				
				year++;
				int zero=0;
				
				int check =0;
				//이곳에 빙산 나누는 알고리즘 생각할것 동서남북의 값이 0일시에빙산이 조각난다
				
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(iceberg[i][j]==0) {
							zero+=1;
							
						}else {
							in = true;
							qi=i;
							qj=j;
							check+=1;
						}
						
						temp[i][j] = iceberg[i][j];
					}
				
				}
				
				if(in) {
					q.add(new Pair(qi,qj));
					
				}
				int qcheck=0;
				//43% 때에서 틀림 아마 boolean check 다시 해야할듯
				boolean tf[][] =new boolean[n][m];
				while(!q.isEmpty()) {
					Pair p = q.remove();
					
					if(tf[p.x][p.y]) {
						continue;
					}
					tf[p.x][p.y]=true;
					//up
					if(p.x-1>=0&&iceberg[p.x-1][p.y]!=0) {
						if(!tf[p.x-1][p.y]) {
							q.add(new Pair(p.x-1,p.y));
						}
						
						
					}
					//down
					if(p.x+1<n&&iceberg[p.x+1][p.y]!=0) {
						if(!tf[p.x+1][p.y]) {
							q.add(new Pair(p.x+1,p.y));
						}
						
					}
					//left
					if(p.y-1>=0&&iceberg[p.x][p.y-1]!=0) {
						if(!tf[p.x][p.y-1]) {
							q.add(new Pair(p.x,p.y-1));
						}
					}
					//right
					if(p.y+1<m&&iceberg[p.x][p.y+1]!=0) {
						if(!tf[p.x][p.y+1]) {
							q.add(new Pair(p.x,p.y+1));
						}
					}
					qcheck+=1;
					
				}
				
				if(zero==n*m) {
					System.out.println(0);
					return;
				}
				if(qcheck!=check) {
					System.out.println(year);
					return;
				}
				init=0;
			}
			
		}
		
		
	}
}
