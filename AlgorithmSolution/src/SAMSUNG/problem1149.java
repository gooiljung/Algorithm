package SAMSUNG;
import java.util.*;



public class problem1149 {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int rgb[][] = new int [N][3];
		
		for(int i=0; i<N;i++) {
			for(int j=0;j<3;j++) {
				rgb[i][j]=scan.nextInt();
			}
		}
		int result [][] = new int[N][3];
		result[0][0]=rgb[0][0];
		result[0][1]=rgb[0][1];
		result[0][2]=rgb[0][2];
		if(N>1) {
			for(int i=1;i<N;i++) {
				result[i][0] = Math.min(result[i-1][1], result[i-1][2])+rgb[i][0];
				result[i][1] = Math.min(result[i-1][0], result[i-1][2])+rgb[i][1];
				result[i][2] = Math.min(result[i-1][0], result[i-1][1])+rgb[i][2];
				
				
				
			}
		}
		
		System.out.println(Math.min(result[N-1][0], Math.min(result[N-1][1], result[N-1][2])));
		
		
		
		
	}
}
