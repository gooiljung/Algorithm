package SWAcademy;
import java.util.*;

import SWAcademy.problem2383.Pair;
class Recep{
	int recepNum,endTime;
	Recep(int recepNum,int endTime){
		this.recepNum=recepNum;
		this.endTime=endTime;
	}
}
class Cust{
	int custNum,stTime,endTime,recepNum,lastNum;
	Cust(int custNum,int stTime,int endTime,int recepNum,int lastNum){
		this.custNum =custNum;
		this.stTime =stTime;
		this.endTime = endTime;
		this.recepNum = recepNum;
		this.lastNum = lastNum;
	}
}

public class problem2477 {

	public static int N,M,K,A,B;
	public static int ai[],bj[],tk[];
	public static int dest[][];
	public static Cust cust[];
	public static int now;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());
		for(int a=1;a<=T;a++) {
			StringTokenizer st = new StringTokenizer(scan.nextLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken()); 
			B=Integer.parseInt(st.nextToken());

			dest = new int[N][M]; // A-1,B-1 에 간 고객번호(index)+1 합하기 
			ai = new int[N];
			bj = new int[M];
			tk = new int[K];
			PriorityQueue<Cust> q = new PriorityQueue<>(new Comparator<Cust>() {
				@Override
				public int compare(Cust r1, Cust r2) {
					if(r1.custNum>r2.custNum) {
						return 1;
					}else {
						return -1;
					}
				}
			});
			PriorityQueue<Cust> q2 = new PriorityQueue<>(new Comparator<Cust>() {
				@Override
				public int compare(Cust r1, Cust r2) {
					if(r1.endTime>r2.endTime) {
						return 1;
					}else if(r1.endTime==r2.endTime){
						if(r1.recepNum>r2.recepNum) {
							return 1;
						}else {
							return -1;
						}
					}else {
						return -1;
					}
				}
			});
			//			PriorityQueue<Recep> q = new PriorityQueue<>(new Comparator<Recep>() {
			//				@Override
			//				public int compare(Recep r1, Recep r2) {
			//					if(r1.endTime>r2.endTime) {
			//						return 1;
			//					}else if(r1.endTime==r2.endTime) {
			//						if(r1.recepNum>r2.recepNum) return 1;
			//						else return -1;
			//					}else {
			//						return -1;
			//					}
			//				}
			//			});
			st = new StringTokenizer(scan.nextLine());
			for(int i=0;i<N;i++) {
				ai[i]=Integer.parseInt(st.nextToken()); // 1번 창구 소요시간 

			}
			st = new StringTokenizer(scan.nextLine());
			for(int i=0;i<M;i++) {
				bj[i]=Integer.parseInt(st.nextToken()); // 2번 창구 소요시간 

			}

			st = new StringTokenizer(scan.nextLine());
			cust = new Cust[K];

		
			now=0;
			for(int i=0;i<K;i++) {
				tk[i]=Integer.parseInt(st.nextToken()); //사람 도착시간 
				cust[i]=new Cust(i,tk[i],0,-1,-1);
				q.add(new Cust(i,tk[i],0,-1,-1));

			}

			int recep1[] = new int[N];
			
			while(!q.isEmpty()) {
				int min=100000;
				Cust c = q.remove();
				boolean tf=true;
				int num = c.custNum;
				if(now<c.stTime) {
					now=c.stTime;
					q.add(new Cust(c.custNum,c.stTime,c.endTime,c.recepNum,c.lastNum));
					continue;

				}else {
					for(int i=0;i<N;i++) {
						if(now>=recep1[i]) {
							recep1[i]=now+ai[i];
							cust[num].recepNum = i;
							cust[num].endTime = recep1[i];
							tf=false;
							break;
						}
						if(min>recep1[i]) {
							min=recep1[i];
						}
					}
					if(tf) {
						now = min;
						q.add(new Cust(c.custNum,c.stTime,c.endTime,c.recepNum,c.lastNum));
					}
				}

				
			}
		
			for(int i=0;i<K;i++) {
				q2.add(new Cust(cust[i].custNum,cust[i].stTime,cust[i].endTime,cust[i].recepNum,cust[i].lastNum));
//				System.out.println("custNum = "+(cust[i].custNum+1)+" custEndTime = "+cust[i].endTime+" custREcep = "+(cust[i].recepNum+1));
			}

			Cust temp = q2.peek();
			int recep2[]=new int[M];
			Arrays.fill(recep2,temp.endTime);
			now = temp.endTime;
//			System.out.println(now);
			while(!q2.isEmpty()) {
				int min=100000;
				Cust c = q2.poll();
				boolean tf=true;
				int num = c.custNum;
				if(now<c.endTime) {
					now=c.endTime;
					q2.add(new Cust(c.custNum,c.stTime,c.endTime,c.recepNum,c.lastNum));
					continue;

				}else {
					for(int i=0;i<M;i++) {
						if(now>=recep2[i]) {
							recep2[i]=now+bj[i];
							cust[num].lastNum = i;
							tf=false;
							break;
						}
						if(min>recep2[i]) {
							min=recep2[i];
						}
					}
					if(tf) {
						now = min;
						q2.add(new Cust(c.custNum,c.stTime,c.endTime,c.recepNum,c.lastNum));
					}
				}

							
			}
			
			for(int i=0;i<K;i++) {
				
				if(cust[i].recepNum==A-1&&cust[i].lastNum==B-1) {
					dest[A-1][B-1]+=cust[i].custNum+1;
//					System.out.println(dest[A-1][B-1]);
				}
			}
			if(dest[A-1][B-1]==0) {
				System.out.println("#"+a+" -1");
			}else {
				System.out.println("#"+a+" "+dest[A-1][B-1]);
			}
			


		}
	}
}


















