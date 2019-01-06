package recursion;
import java.util.*;
class Retire{
	int temp = 0;
	void getMoney(int price,int day,int finalDay,int T[],int P[]) {
		if(day>finalDay) {
			
			return;
		}
		if(day==finalDay) {
			if(price>temp) {
				temp = price;
			}
			return;
		}
		
		if(price>temp) {
			temp =price;
		}
		
		
		getMoney(price+P[day-1],day+T[day-1],finalDay,T,P);
		getMoney(price,day+1,finalDay,T,P);
		
		
		
	}
}

public class problem14501 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;
		N= scan.nextInt();
		int T[] = new int [N];
		int P[] = new int [N];
		for(int i=0; i<N;i++) {
			T[i] = scan.nextInt();
			P[i]= scan.nextInt();
		}
		Retire rt = new Retire();
		rt.getMoney(0, 1, N+1, T, P);
		System.out.println(rt.temp);
	}
}
