package SAMSUNG;
import java.util.*;
public class problem2133 {
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		if(N%2!=0) {
			System.out.println(0);
			return;
		}
		
		int dp[] = new int [31];
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		for(int i = 3; i <= N; i++){
			dp[i] += dp[i - 2] * 3;

			for(int j = 4; j <= i; j += 2) dp[i] += dp[i - j] * 2;
		}
		System.out.println(dp[N]);
	}

}
