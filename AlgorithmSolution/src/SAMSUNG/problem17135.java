package SAMSUNG;
import java.util.*;
class Enemy{
	int x, y,choose;
	Enemy(int x,int y){
		this.x=x;
		this.y=y;
	}
	int distance(Enemy a,Enemy b) { //궁수 공격 가능 거리 판단 func
		
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
		
	}
	void position(int archer[],int column[]) {
		int max =-1;
		int k=0;
		while(k<3) {
			if(k==0) {
				for(int i=0;i<column.length;i++) {
					if(column[i]>max) {
						max=column[i];    // archer[0] 은 이렇게하면 가장 큰 컬럼, 같은값일시는 왼쪽으로 배
						archer[k++]=i;
					}
				}
			}else {
				boolean in = true;
				for(int i=0;i<column.length;i++) {
					if(i==archer[0]||i==archer[1]||i==archer[2]) {
						continue;
					}
					if(column[i]==max) {
						max=column[i];    // archer[0] 은 이렇게하면 가장 큰 컬럼, 같은값일시는 왼쪽으로 배
						archer[k++]=i;
						in =false;
						if(k==3) {
							break;
						}
					}
				}
				
				if(in) {
					max-=1;
				}
			}
			
			
		}
	}
	
}
public class problem17135 {
	
	public static void main(String[] args) {
		int N,M,D;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		D=scan.nextInt();
		
		int nm[][] = new int[N+1][M];// N행에는 성벽 및 궁수 배치

		int column[] = new int[M];
		int archer[] = new int[3];
		
		
		int killOfEnemy =0;
		Queue <Enemy> q = new LinkedList<Enemy>();
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				nm[i][j] = scan.nextInt();
		
				if(nm[i][j]==1) {
					column[j]+=1;
				
					q.add(new Enemy(i,j)); // 적 위치 queue 에 넣음.
				}
			}
		}
		for(int i=0;i<3;i++) {
			archer[i]=-1;
		}
		Enemy position = new Enemy(0,0);
		position.position(archer, column);
		for(int i=0;i<3;i++) {
			nm[N][archer[i]]=2;  // 성벽 N 행에 궁수 배치 표시를 2를 넣어서 했다.
		}
		Queue <Enemy> archer1 = new LinkedList<Enemy>();
		Queue <Enemy> archer2 = new LinkedList<Enemy>();
		Queue <Enemy> archer3 = new LinkedList<Enemy>();
		for(int i=0;i<N;i++) {

			while(!q.isEmpty()) {
				
				Enemy p = q.remove();
				
				for(int j=0;j<3;j++) {
					
					Enemy attack = new Enemy(N,archer[j]);
					p.choose=p.distance(attack, p);
					
					if(p.choose<=D){
						switch(j) {
						case 0: 
							Enemy one = new Enemy(p.x,p.y);
							one.choose = p.choose;
							archer1.add(one);
							break;
						case 1: 
							Enemy two = new Enemy(p.x,p.y);
							two.choose = p.choose;
							archer2.add(two);
							break;
						case 2:
							Enemy three = new Enemy(p.x,p.y);
							three.choose = p.choose;
							archer3.add(three);
							break;
						
						}
					}
				}
				
				
			}
			int min =100;
			int count=0;
			while(!archer1.isEmpty()) {
				if(count==archer1.size()) {
					break;
				}
				Enemy attack = archer1.remove();

				if(attack.choose<min) {
					min=attack.choose;
				}
				archer1.add(attack);
				count++;
			}
			Queue <Enemy> q1 = new LinkedList<Enemy>();
			while(!archer1.isEmpty()) {
				
				Enemy attack = archer1.remove();
				if(attack.choose==min) {
					q1.add(new Enemy(attack.x,attack.y));
					
				}
				
			}
			int qx=100,qy=100;
			while(!q1.isEmpty()) {
				Enemy ee=q1.remove();
				if(ee.y<qy) {
					qy=ee.y;
					qx=ee.x;
				}
			}
			if(qx<N&&qy<M&&nm[qx][qy]==1) {
				
				nm[qx][qy] = 0;
				killOfEnemy++;
				
			}
			min=100;
			count=0;
			while(!archer2.isEmpty()) {
				
				if(count==archer2.size()) {
					break;
				}
				Enemy attack = archer2.remove();
				
				if(attack.choose<min) {

					min=attack.choose;
				}

				archer2.add(attack);
				count++;
			}
			
			while(!archer2.isEmpty()) {
				
				Enemy attack = archer2.remove();
				
				if(attack.choose==min) {

					q1.add(new Enemy(attack.x,attack.y));
					
				}
				
			}
			qx=100;qy=100;
			while(!q1.isEmpty()) {
				Enemy ee=q1.remove();
				if(ee.y<qy) {
					qy=ee.y;
					qx=ee.x;
				}
			}
			if(qx<N&&qy<M&&nm[qx][qy]==1) {
				
				nm[qx][qy] = 0;
				killOfEnemy++;
				
			}
			min=100;
			count=0;
			while(!archer3.isEmpty()) {
				if(count==archer3.size()) {
					break;
				}
				Enemy attack = archer3.remove();
				if(attack.choose<min) {
					min=attack.choose;
				}
				archer3.add(attack);
				count++;
			}
			
			while(!archer3.isEmpty()) {
				
				Enemy attack = archer3.remove();
				if(attack.choose==min) {
					q1.add(new Enemy(attack.x,attack.y));					
				}
				
			}
			qx=100;qy=100;
			while(!q1.isEmpty()) {
				Enemy ee=q1.remove();
				if(ee.y<qy) {
					qy=ee.y;
					qx=ee.x;
				}
			}
			if(qx<N&&qy<M&&nm[qx][qy]==1) {
				
				nm[qx][qy] = 0;
				killOfEnemy++;
				
			}
			for(int a=N-1;a>0;a--) {
				for(int b=0;b<M;b++) {
					nm[a][b]=nm[a-1][b];
				}
			}
			for(int a=0;a<M;a++) {
				nm[i][a]=0;
			}
			q.clear();
			
			for(int a=0;a<N;a++) {
				for(int b=0;b<M;b++) {
					
					if(nm[a][b]==1) {
						
						q.add(new Enemy(a,b)); // 적 위치 queue 에 넣음.
					}
				}
			
			}
		
		}
		System.out.println(killOfEnemy);
		
		
	}
}

















