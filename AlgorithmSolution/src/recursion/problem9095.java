package recursion;
import java.util.*;

class Number{
	int cnt=0;
	void go(int sum,int goal) {
		if(sum==goal) {
			
			cnt++;
		}
		if(sum>goal) {
			return;
		}
		go(sum+1,goal);
		go(sum+2,goal);
		go(sum+3,goal);
	
	}

}
public class problem9095 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T;
		
		T = scan.nextInt();
		int k;
		for(int i=0;i<T;i++) {
			k = scan.nextInt();
			Number num = new Number();
			num.go(0,k);
			System.out.println(num.cnt);
			
			
		}
	}
}
