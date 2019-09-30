package DP;
import java.util.*;
public class problem1699 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int dp[] = new int[100001];
		Arrays.fill(dp, 100000);
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=100000;i++) {
			for(int j=1;j<=(int)Math.sqrt(i);j++) {
				dp[i]=Math.min(dp[i],dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);
	}


}
