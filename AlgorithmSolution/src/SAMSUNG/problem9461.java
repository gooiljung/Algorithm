package SAMSUNG;
import java.util.*;
public class problem9461 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int p[] = {1,1,1,2,2,3,4,5,7,9};
		
		long result[] = new long [101];
		for(int i=0; i<p.length;i++) {
			result[i+1] = p[i];
		}
		for(int i=11;i<101;i++) {
			result[i] = result[i-1]+result[i-5];
		}
		int k[] = new int [N];
		for(int i=0;i<N;i++) {
			k[i] = scan.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(result[k[i]]);
		}
		
	}
}
