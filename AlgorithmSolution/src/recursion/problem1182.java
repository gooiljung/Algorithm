package recursion;
import java.util.*;

class Cnt{
	int cnt =0;
	void go(int a[],int sum,int S,int index) {
		if (sum == S && index == a.length) {
			cnt ++;	
			return;
		}
		if(index>=a.length) return;
		go(a,sum+a[index],S,index+1);
		go(a,sum,S,index+1);
		

	}
}

public class problem1182 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N,S;
		N= scan.nextInt();
		S=scan.nextInt();
		int [] a = new int [N];
		for(int i=0;i<N;i++) {
			a[i]=scan.nextInt();
		}
		Cnt result = new Cnt();
		result.go(a,0,S,0);
		if(S==0) {
			result.cnt -=1;
		}
		System.out.println(result.cnt);
		
		
	}

}
