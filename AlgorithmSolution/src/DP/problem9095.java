package DP;
import java.util.*;
public class problem9095 {
	public static int count = 0;
	public static void go(int n,int now) {
		if(n<now) return;
		if(n==now) count++;
		go(n,now+1);
		go(n,now+2);
		go(n,now+3);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int n[] = new int [T];
		for(int i=0;i<T;i++) {
			n[i] = scan.nextInt();
		}
		for(int i=0;i<T;i++) {
			problem9095 temp = new problem9095();
			temp.go(n[i], 0);
			System.out.println(temp.count);
			count =0;
		}
		
	}
}
