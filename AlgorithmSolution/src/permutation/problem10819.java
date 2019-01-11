package permutation;
import java.util.*;
import java.math.*;
class Calculate{
	int maximum;
	
	int result(int a[]) {
		maximum = 0;
		int temp;
		for(int i=0;i<a.length-1;i++) {
			temp = Math.abs(a[i]-a[i+1]);
			maximum+=temp;
		}
		return maximum;
	}
}


class NextPermu{
	boolean nextOne(int a[]) {
		   int i = a.length-1;
	        while (i > 0 && a[i-1] >= a[i]) {
	            i -= 1;
	        }

	        if (i <= 0) {
	            return false;
	        }

	        int j = a.length-1;
	        while (a[j] <= a[i-1]) {
	            j -= 1;
	        }

	        int temp = a[i-1];
	        a[i-1] = a[j];
	        a[j] = temp;

	        j = a.length-1;
	        while (i < j) {
	            temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	            i += 1;
	            j -= 1;
	        }
	        return true;
	}

}
public class problem10819 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a[] = new int[N];
		
		for(int i=0;i<N;i++) {
			a[i] = scan.nextInt();
		}
		NextPermu next = new NextPermu();
		Calculate cal = new Calculate();
		
		Arrays.sort(a);
		int maximum=0;
		int temp;
		do {
			temp = cal.result(a);
			maximum = Math.max(maximum, temp);
		}while(next.nextOne(a));
		
		System.out.println(maximum);
	}
}



















