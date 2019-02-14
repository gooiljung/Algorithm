package DP;
import java.util.*;
public class problem11052 {
	public static int p[];
	public static int N;
	public static int d[];
	public static void go(int n,int p[]) {
		
	
		for (int i=1;i<N+1;i++) {
			for(int j=1;j<=i;j++) {
				int temp=Math.max(p[i],p[j]+d[i-j]);
				d[i] = Math.max(d[i], temp);
//				System.out.println(d[i]);
			}
		}
	
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		p = new int[N+1];
		d = new int[N+1];
		for(int i=1;i<N+1;i++) {
			p[i]=scan.nextInt();
		}
		d[0]=0;
	
		go(0,p);
		System.out.println(d[N]);

	}
}
