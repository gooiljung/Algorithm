package A_Type_Test;
import java.util.*;



// 상어의 정보는 다섯 정수 r, c, s, d, z
// (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.

class Shark{
	int r,c,s,d,z;
	Shark(int r,int c,int s,int d,int z){
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
public class problem17143 {
	
	public static int R,C,M;
	public static int sum=0;
	public static void hunt(int now) {
		int index=-1;
		int temp=101;
		for(int i=0;i<M;i++) {
			Shark sh = shark.get(i);
			
			if(sh.z==-1) continue;
		
			if(sh.c==now) {
				if(temp>sh.r) {
					index=i;
					temp=sh.r;
				}
			}
		}
//		System.out.println("@@@@@@@"+(now+1)+"@@@@@@");
		if(index==-1) return;
//		System.out.println("@@chatch@@  "+index);
		sum+= shark.get(index).z;
		shark.get(index).z=-1;
	}
	public static void move() {
		int map[][] = new int [R][C];
		int value,etc,temp;
		for(int i=0;i<M;i++) {
			Shark sh = shark.get(i);
			if(sh.z==-1) continue;
			switch(sh.d) {
			case 1:
				// 몫이 1보다 커야지 만 방향바뀜 
				
				if(sh.r>=sh.s) {
					sh.r-=sh.s;
				}else {
					temp = sh.s-sh.r;
					value =temp/(R-1);
					etc = temp%(R-1);
					if(temp<R) {
						sh.r=temp;
						sh.d=2;
					}else {
						
						if(value%2==0) {
							sh.d=2;
							
							sh.r=etc;
							if(value==0) {
								sh.r=temp;
							}
							
						}else {
							sh.r=R-1-etc;
						}
					}
					
					
				}
					
				break;
			case 2:
				if(sh.r+sh.s<R) {
					sh.r+=sh.s;
				}else {
					temp = sh.s-(R-sh.r-1);
					value =temp/(R-1);
					etc = temp%(R-1);
					
					if(temp<R) {
						sh.r=R-1-temp;
						sh.d=1;
					}else {
						if(value%2==0) {
							sh.d=1;
							sh.r=R-1-etc;
							if(value==0) {
								sh.r=R-1-temp;
							}
						
						}else {
							sh.r=etc;
						}
					}
				}
				
				break;
			case 3:
				if(sh.c+sh.s<C) {
					sh.c+=sh.s;
				}else {
					temp = sh.s-(C-sh.c-1);
					value =temp/(C-1);
					etc = temp%(C-1);
					if(temp<C) {
						sh.c=C-1-temp;
						sh.d=4;
					}else {
						if(value%2==0) {
							sh.d=4;
							sh.c=C-1-etc;
							if(value==0) {
								sh.c=C-1-temp;
							}
						}else {
							sh.c=etc;
						}
					}
					
				}
				
				
				break;
			case 4:
				if(sh.c>=sh.s) {
					sh.c-=sh.s;
				}else {
					temp = sh.s-sh.c;
					value =temp/(C-1);
					etc = temp%(C-1);
					if(temp<C) {
						sh.c=temp;
						sh.d=3;
					}else {
						if(value%2==0) {
							sh.c=etc;
							if(value==0) {
								sh.c=temp;
							}
						}else {
							sh.c=C-1-etc;
						}
					}
					
					
				}
				break;
			}
//10 10 2
//1 9 8 2 1
//5 10 7 4 2
			
			shark.set(i, sh);
			

			if(map[sh.r][sh.c]==0) {
			
				map[sh.r][sh.c]=(i+1);
			}else {
				// 상어 겹침 
				
				int t = map[sh.r][sh.c]-1;
				if(shark.get(t).z<shark.get(i).z) {
					shark.get(t).z=-1;
					map[sh.r][sh.c]=i+1;
				}else {
					shark.get(i).z=-1;
				}
			}
//			System.out.println("#"+(i+1)+" "+sh.r+","+sh.c+" size="+sh.z+" sum="+sum);
		}
		
	}
	public static ArrayList<Shark> shark;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		shark = new ArrayList<Shark>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(scan.nextLine());
			shark.add(new Shark(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		for(int i=0;i<C;i++) {
			hunt(i);
			move();
		}
		System.out.println(sum);
	}
}
/*
 * r,c   상어는  크기와 속도를(1초에 몇칸 ) 가지고 있다 상어는 격자판의 경계에서 방향을 반대로 바꿈 
 * 
 * 사람은 0,0  맵은 r,c  사람이 c에 도착하면 이동 멈춘다.
 * 사람은 오른쪽 한칸 이동 , 낙시왕과 같은 열에 있는 상어중 땅과 제일 가까운 상어를 잡는다 ,상어 이동한다.  
 * 순서대로 1초동안 발생 ->
 * 
 * 상어 이동후 같은 칸에 있는 상어는 크기가 큰 상어만 남는다 
 * 
 * 낚시왕이 잡은 상어 크기의 합 
 * 
 * 상어를 어레이 인덱스 맵에 항상 상어의 위치를 인덱스로 놓는다 . 
 */
