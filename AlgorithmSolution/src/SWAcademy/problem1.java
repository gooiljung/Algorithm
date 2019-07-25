package SWAcademy;
import java.util.Scanner;
public class problem1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		int sum=0;
		for(int i=0;i<T;i++) {
			
			for(int j=0;j<10;j++) {
				int temp = scan.nextInt();
				if(temp%2!=0) {
					sum+=temp;
				}
			}
			System.out.println("#"+(i+1)+" "+sum);
			sum=0;
			
		}
	}
}
