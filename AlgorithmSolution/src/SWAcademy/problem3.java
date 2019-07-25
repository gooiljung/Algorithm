package SWAcademy;
import java.util.Scanner;
public class problem3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=1;i<=T;i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			if(num1>num2) {
				System.out.println("#"+i+" >");
			}else if(num1==num2) {
				System.out.println("#"+i+" =");
			}else {
				System.out.println("#"+i+" <");
			}
		}
	}
}
