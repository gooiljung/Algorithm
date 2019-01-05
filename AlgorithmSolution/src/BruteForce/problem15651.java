package BruteForce;
import java.util.*;
class Number2{
	int a[] = new int[8];
	Boolean c[] = new Boolean[8];
	StringBuilder sb = new StringBuilder();
	
	void go(int index,int n,int m) {
		if(index == m) {
			for(int i=0;i<index;i++) {
				sb.append(a[i]);
				if(i!=m-1) {
					sb.append(' ');
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			
			a[index]=i;
			go(index+1,n,m);
			
			
		}
		
	}

}


public class problem15651 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N,M;
		N = scan.nextInt();
		M = scan.nextInt();
		Number2 num = new Number2();
		num.go(0, N, M);
		System.out.print(num.sb);
		
		
	}
}
