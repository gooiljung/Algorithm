package BruteForce;
import java.util.*;
class Number3{
	int a[] = new int[9];
	StringBuilder sb = new StringBuilder();
	void go(int index,int start,int n,int m) {
		if(index ==m) {
			
			for(int i=0;i<index;i++) {
				sb.append(a[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			if(i>=start) {
				a[index]=i;
				start = i;
				go(index+1,start,n,m);
			}
			
		}
	}
}

public class problem15652 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N,M;
		N=scan.nextInt();
		M=scan.nextInt();
		Number3 num = new Number3();
		num.go(0,0,N,M);
		System.out.print(num.sb);
		
	}
}
