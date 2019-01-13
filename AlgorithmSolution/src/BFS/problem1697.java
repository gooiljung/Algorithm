package BFS;
import java.util.*;

class Meet{
	int now;
	int count;
	Meet(int now,int count){
		this.now =now;
		this.count=count;
	}
}

public class problem1697 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(),K=scan.nextInt();
		Queue<Meet> q = new LinkedList<Meet>();
		Boolean check[] = new Boolean[100001];
		for(int i=0;i<check.length;i++) {
			check[i] = false;
		}
		q.add(new Meet(N,0));
	
		while(!q.isEmpty()) {
			Meet where = q.remove();

			if(where.now == K) {
				System.out.println(where.count);
				return;
			}
			
			if(where.now+1<=100000&&check[where.now+1]==false) {
				q.add(new Meet(where.now+1,where.count+1));
				check[where.now+1]=true;
				
				
			}
			if((where.now-1)>=0&&check[where.now-1]==false) {
				q.add(new Meet(where.now-1,where.count+1));
				check[where.now-1]=true;
			}
			
			if(where.now*2<=100000&&check[where.now*2]==false) {
				q.add(new Meet(where.now*2,where.count+1));
				check[where.now*2]=true;
				
			}
		}
		
	}
}
