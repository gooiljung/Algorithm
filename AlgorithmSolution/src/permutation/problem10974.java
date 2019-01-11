package permutation;
import java.util.*;


class Factorial {
	int factorial(int n) {
		if(n<=1) {
			return n;
		}else {
			return n*factorial(n-1);
		}
		
	}
	
}

class NextOne{
	boolean next_permutation(int[] a) {
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

public class problem10974 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Permutation permu = new Permutation();
		int a[] = new int[N];
		for(int i=0; i<N;i++) {
			a[i] = i+1;
		}
		Factorial fac = new Factorial();
		int total = fac.factorial(N);
		for(int i=0; i<N;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		NextOne next = new NextOne();
		
		for (int i=0;i<total;i++) {
			if(next.next_permutation(a)) {
				for(int j =0 ; j<N;j++) {
					System.out.print(a[j]+" ");
				
				}	
			}
			
			System.out.println();
			
		}
		
	}
}
