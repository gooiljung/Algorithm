package A_Type_Test;
import java.util.*;

class Position{
	int x,y;
	int dist=1000,left=1000;
	Position(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class problem17135 {

	public static int N,M,D;
	public static int map[][];
	public static int min =-1;
	public static int turn;
	public static ArrayList<Position> originEnemy;


	public static void go(ArrayList<Integer> archer) {
		ArrayList<Position> enemy = new ArrayList<Position>();
		
		for(int i=0;i<originEnemy.size();i++) {
			enemy.add(new Position(originEnemy.get(i).x,originEnemy.get(i).y));
		}

		int numOfKill=0;

		
		
		for(int j=0;j<turn;j++) {
			int kill[] = new int[3];
			Arrays.fill(kill, -1);
			Position archer1 = new Position(N,archer.get(0));
			Position archer2 = new Position(N,archer.get(1));
			Position archer3 = new Position(N,archer.get(2));
			for(int i=0;i<enemy.size();i++) {
				
				int x = enemy.get(i).x;
				int y = enemy.get(i).y;
			
				int temp;
				temp=Math.abs(archer1.x-x)+Math.abs(archer1.y-y);
				if(temp<=D) {
					if(archer1.dist>temp) {
						
						archer1.dist=temp;
						archer1.left=y;
						kill[0] = i;
				
						

					}else if(archer1.dist==temp) {
						if(archer1.left>y) {
							archer1.dist=temp;
							archer1.left=y;
							kill[0] = i;
							
						}
					}
				}
				temp=Math.abs(archer2.x-x)+Math.abs(archer2.y-y);
				if(temp<=D) {
					if(archer2.dist>temp) {
						archer2.dist=temp;
						archer2.left=y;
						kill[1] = i;
					}else if(archer2.dist==temp) {
						if(archer2.left>y) {
							archer2.dist=temp;
							archer2.left=y;
							kill[1] = i;
						}
					}
				}
				temp=Math.abs(archer3.x-x)+Math.abs(archer3.y-y);
				if(temp<=D) {
					if(archer3.dist>temp) {
						archer3.dist=temp;
						archer3.left=y;
						kill[2] = i;
					}else if(archer3.dist==temp) {
						if(archer3.left>y) {
							archer3.dist=temp;
							archer3.left=y;
							kill[2] = i;
						}
					}
				}
				
			}
		
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for(int k=0;k<3;k++) {
				
				if(!ar.contains(kill[k])&&kill[k]!=-1) {
					ar.add(kill[k]);
				
				}
			}
		
			numOfKill+=ar.size();
			
			
			ArrayList<Position> enemyTemp = new ArrayList<Position>();
			
			for(int k=0;k<enemy.size();k++) {
				if(!(ar.contains(k))&&(enemy.get(k).x+1)<N) {
					
					enemyTemp.add(new Position((enemy.get(k).x+1),enemy.get(k).y));
				}
			}
		
			
			enemy.removeAll(enemy);
			for(int k=0;k<enemyTemp.size();k++) {
				enemy.add(new Position(enemyTemp.get(k).x,enemyTemp.get(k).y));
		

			}

	
		}

		min=Math.max(min,numOfKill);
	
		
		
		

	}
	public static void combination(ArrayList<Integer> arr,int n,int r,int target) {
		if(r==0) {
			go(arr);
			return;
		}else if(target==n) {
			return;
		}else {
			arr.add(target);
		}
		combination(arr,n,r-1,target+1);
		arr.remove(arr.size()-1);
		combination(arr,n,r,target+1);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int t =0;
		boolean ch=true;
		originEnemy = new ArrayList<Position>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(scan.nextLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {

					originEnemy.add(new Position(i,j));
					if(ch) {
						ch=false;
						t=i;
					}

				}
			}
		}
	
		turn =N-t;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		combination(arr,M,3,0);
		System.out.println(min);
	
	}
}













