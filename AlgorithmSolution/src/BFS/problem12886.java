package BFS;
import java.util.*;
public class problem12886{
	public static boolean check[][] = new boolean[1501][1501];
	public static int sum = 0;
	public static void go(int a,int b) {
		if(check[a][b]) {
			return;
		}
		check[a][b] = true;
		int temp[] = {a,b,sum-a-b};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(temp[i]<temp[j]) {
					int temp2[] = {a,b,sum-a-b};
					temp2[i]+=temp[i];
					temp2[j] -=temp[i];
					go(temp2[0],temp2[1]);
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a= scan.nextInt();
		int b= scan.nextInt();
		int c= scan.nextInt();
		sum = a+b+c;
		if(sum%3!=0) {
			System.out.println(0);
			return;
		}
		
		go(a,b);
		
		if(check[sum/3][sum/3]) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
}