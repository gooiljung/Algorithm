package DP;
import java.util.*;
public class problem1463 {
	public static int []d;
	public static int count=0;
	public static int go(int n) {
		if(n==1) {
			return 0;
		}
		d[n]= go(n-1)+1;
		
		if(n%2==0) {
			int temp = go(n/2)+1;
			if(d[n]>temp) d[n] =temp;
		}
		if(n%3==0) {
			int temp = go(n/3)+1;
			if(d[n]>temp) d[n] =temp;
		}
		return d[n];
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		d =new int[N+1];
		
		System.out.println(go(N));
		
	}
}
