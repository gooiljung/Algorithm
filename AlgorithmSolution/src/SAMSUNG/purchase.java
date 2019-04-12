package SAMSUNG;
import java.util.*;


public class purchase {
	boolean check[] = new boolean [50];
	public static void go(int price[],int i,int now,int M,purchase index) {
		purchase temp=new purchase();
		if(now==M) {
			
			for(int j=0;j<50;j++) {
			
				if(index.check[j]) {
					System.out.println(j);
				}
			}
			return;
			 
		}
	
		
		if(i<price.length) {
			for(int j=0;j<50;j++) {
				temp.check[j]=index.check[j];
			}
			temp.check[i]=false;
			go(price,i+1,now,M,temp);// i 번째 구매 X
		}
		
			
			
			
		if(i<price.length&&price[i]+now<=M) {
			for(int j=0;j<50;j++) {
				temp.check[j]=index.check[j];
			}
			temp.check[i]=true;
			go(price,i+1,now+price[i],M,temp);
		}
	
		
		
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int price[] = new int[N];
		
		
		int M;
		for(int i=0;i<N;i++) {
			price[i] = scan.nextInt();
		}
		M = scan.nextInt();
		purchase temp=new purchase();
		go(price,0,0,M,temp);
		
		
		
		
		
		
	}
}
