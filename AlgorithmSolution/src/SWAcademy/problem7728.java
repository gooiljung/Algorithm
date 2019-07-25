package SWAcademy;
 import java.util.Scanner;
public class problem7728 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		for(int i=1;i<=T;i++) {
			
			String temp = scan.nextLine();
			boolean check []= new boolean [10];
			for(int j=0;j<temp.length();j++) {
				int index = temp.charAt(j)-'0';
				check[index]=true;
				
			
			}
			int diversity = 0;
			for(int a=0;a<10;a++) {
				if(check[a]) {
					diversity++;
				}
			}
			System.out.println("#"+i+" "+diversity);
		}
	}
}
