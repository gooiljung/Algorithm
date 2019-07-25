package SWAcademy;
import java.util.Scanner;
public class problem2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T= scan.nextInt();
		
		for(int i=0;i<T;i++) {
			double sum=0;
			for(int j=0;j<10;j++) {
				sum+=scan.nextInt();
			}
			
			System.out.println(String.format("#%d %.0f", (i+1),sum/10));
		}
	}
}
