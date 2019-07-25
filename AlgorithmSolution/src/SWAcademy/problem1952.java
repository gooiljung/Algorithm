package SWAcademy;
import java.util.*;
public class problem1952 {
	public static int price[];
	public static int month[];
	public static int bestPrice;

	public static void go(int i,int next) {
		if(i>11) {
			if(bestPrice>next) {
				bestPrice = next;
			}
			return;
		}
		if(month[i]!=0) {
			go(i+1,next+(price[0]*month[i]));
			go(i+1,next+price[1]);

			go(i+3,next+price[2]);

		}else {
			go(i+1,next);
		}

	}
	//	
	//	 Scanner sc = new Scanner(System.in);
	//     int t = Integer.parseInt(sc.nextLine());
	//
	//     for(int tc = 1; tc <= t; tc++) {
	//         n = Integer.parseInt(sc.nextLine());
	//         int result = -1;
	//
	//         arr = new int[n][n];
	//         dp = new int[n][n];
	//
	//         for (int i = 0; i < n; i++) {
	//             String[] temp = sc.nextLine().split(" ");
	//             for(int j = 0; j < n; j++) {
	//                 arr[i][j] = Integer.parseInt(temp[j]);
	//                 dp[i][j] = -1;
	//             }
	//         }


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());

		for(int a=1;a<=T;a++) {
			price = new int[4];

			String[] str = scan.nextLine().split(" ");

			for(int i=0;i<str.length;i++) {
				price[i]=Integer.parseInt(str[i]);	

			}
			month =new int[12];
			str=scan.nextLine().split(" ");
			for(int i=0;i<str.length;i++) {
				month[i]=Integer.parseInt(str[i]);


			}
			scan.nextLine();
			bestPrice=1000000;
			go(0,0);
			if(bestPrice>price[3]) {
				System.out.println("#"+a+" "+price[3]);
			}else {
				System.out.println("#"+a+" "+bestPrice);
			}

		}


	}
}
