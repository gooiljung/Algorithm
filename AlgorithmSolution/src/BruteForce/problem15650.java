package BruteForce;
import java.util.*;

class Num{
	Boolean c[] = new Boolean[9];
	int a[] = new int[9];
	Num() {
		for(int i=0;i<8;i++) {
			c[i] = false;
			a[i] = 0;
		}
	}
	void go(int index,int start,int n,int m) {
		if(index == m) {
			for(int i=0;i<index;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i =1;i<=n;i++) {
			
			if(i>start) {
				c[i] = true;
				a[index] = i;
				start =i;
				go(index+1,start,n,m);
				c[i]=false;
			}
			
		}
	}
}
public class problem15650 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N,M;
		N= scan.nextInt();
		M = scan.nextInt();
		Num find = new Num();
		find.go(0,0,N,M);
		
	}
	
}
