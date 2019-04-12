package SAMSUNG;
import java.util.*;

public class problem2579 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int dp[][] = new int [n][2];
		int stair[] = new int [n];
		for(int i=0;i<n;i++) {
			stair[i] = scan.nextInt();
		}
		scan.nextLine();
		
		dp[0][0]= 0;
		dp[0][1]=stair[0];
		dp[1][0]=dp[0][1];
		dp[1][1]=dp[0][1]+stair[1];
		
		for(int i=2;i<n;i++) {
			dp[i][0]=dp[i-1][1];
			dp[i][1]=Math.max(dp[i-2][1],dp[i-2][0]+stair[i-1])+stair[i];
		}
		System.out.println(dp[n-1][1]);
		
		
	
	}
}
