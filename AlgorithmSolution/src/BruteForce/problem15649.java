package BruteForce;
import java.util.*;
class Number{
	Boolean c[]= new Boolean[10];
	int a[] = new int [10];
	Number() {
		for(int i=0;i<10;i++) {
			c[i]=false;
			a[i]=0;
		}
		
	}
	void go (int index,int n,int m) {
		if(index ==m) {
			for(int i=0;i<index;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(c[i]) continue;
			
			c[i] = true;
			a[index] = i;
			go(index+1,n,m);
			c[i]=false;
		}
	}

}	

public class problem15649 {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int N,M;
		N=scan.nextInt();
		M=scan.nextInt();
		Number num = new Number();
		
		num.go(0, N, M);
		
		
	}
}
