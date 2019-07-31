package SWAcademy;


import java.util.*;
class Pair{
	int x,y;
	
	Pair(int x,int y){
		this.x =x;
		this.y =y;
	
		
	}
	
}

public class problem2382 {
	public static int N,M,K;
	public static Pair bugs[];
	public static int bugCnt[],direction[];
	public static void go(int going,int num) {
		switch(going) {
		case 1:
			bugs[num].x-=1;
			break;
		case 2:
			bugs[num].x +=1;
			break;
		case 3:
			bugs[num].y -=1;
			break;
		case 4:
			bugs[num].y+=1;
			break;
			
		}
	}
	public static void changeDirection(int going,int num) {
		switch(going) {
		case 1:
			direction[num]=2;
			break;
		case 2:
			direction[num]=1;
			break;
		case 3:
			direction[num]=4;
			break;
		case 4:
			direction[num]=3;
			break;
			
		}
	}
	

	//1 상 2 하 3 좌 4 우 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());
		for(int a=1;a<=T;a++) {
			String str[] = scan.nextLine().split(" ");
			N=Integer.parseInt(str[0]);
			M=Integer.parseInt(str[1]);
			K=Integer.parseInt(str[2]);
			
			bugs = new Pair [K];
			
			
			bugCnt=new int [K];
			direction = new int[K];
			for(int i=0;i<K;i++) {
				String temp[] = scan.nextLine().split(" ");
				bugs[i] = new Pair(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
				bugCnt[i] = Integer.parseInt(temp[2]);
				direction[i] = Integer.parseInt(temp[3]);
				
			}
			
			
			//bugs 반되는조건 x 좌표 0 or N-1 ,y좌표 0or N-1 이때 반 죽이고 1<->2  3<->4
			for(int i=0;i<M;i++) {
				boolean check[][] = new boolean[N][N];
				int indexCheck[][] = new int[N][N];
				Pair xy[] = new Pair[K];
				int temp=0;
				for(int j=0;j<K;j++) {
					if(bugCnt[j]==0) {
						continue;
					}
					go(direction[j],j);
					int x = bugs[j].x;
					int y = bugs[j].y;
					indexCheck[x][y]+=1;
					if(indexCheck[x][y]>=2) {
						if(!check[x][y]) {
							xy[temp++]=new Pair(x,y);
						}
						check[x][y] =true;

					}
					
					
					if(x==0||x==N-1||y==0||y==N-1) {
						bugCnt[j]/=2;
						changeDirection(direction[j],j);
					}
				}
				for(int j=0;j<temp;j++) {
					int x = xy[j].x;
					int y = xy[j].y;
					int compare[] = new int[K];
					
					int cnt=0;
					for(int t=0;t<K;t++) {
						if(bugs[t].x==x&&bugs[t].y==y) {
							compare[cnt++]=t;
						}
					}
					int surviveIndex=compare[0];
					int sum=bugCnt[compare[0]];
					int max = bugCnt[compare[0]];
					
					for(int t=1;t<cnt;t++) {
						sum+=bugCnt[compare[t]];
						
						if(max < bugCnt[compare[t]]) {
							surviveIndex=compare[t];
							max=bugCnt[compare[t]];
						}
					}
					
					for(int t=0;t<cnt;t++) {
						if(surviveIndex==compare[t]) {
							bugCnt[surviveIndex]=sum;
						}else {
							bugCnt[compare[t]]=0;
						}
					}
					
				}
				
			}
			int result =0;
			for(int i=0;i<K;i++) {
				result+=bugCnt[i];
			}
			System.out.println("#"+a+" "+result);
		}
		scan.close();
	}
}










