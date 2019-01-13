package permutation;
import java.util.*;


class Calcul{
	int maximum=-1000000000,minimum=1000000000;
	int now;
	int getMaximum() {
		return maximum;
	}
	int getMinimum() {
		return minimum;
	}
	
	void result(int a[],int operation[],int aIndex,int operIndex) {
		if(aIndex == 0) {
			now = a[aIndex];
			aIndex++;
		}
		if(aIndex == a.length) {
			if (now>maximum) {
				maximum=now;
			}
			if(now<minimum) {
				minimum = now;
			}
			return;
		}
		
		switch(operation[operIndex]) {
		case 0:
			now+=a[aIndex];
			aIndex++;
			operIndex++;
			break;
		case 1:
			now -=a[aIndex];
			aIndex++;
			operIndex++;
			break;
		case 2:
			now *=a[aIndex];
			aIndex++;
			operIndex++;
			break;
		case 3:
			if(now < 0) {
				now = -now;
				now/=a[aIndex];
				now = -now;
				aIndex++;
				operIndex++;
			}else {
				now/=a[aIndex];
				aIndex++;
				operIndex++;
			}
			break;
		}
		
		result(a,operation,aIndex,operIndex);
	}
	int factorial(int a) {
		if(a<=1) {
			return a;
		}else {
			return a*factorial(a-1);
		}
		
	}

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


public class problem14888 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a[] = new int[N];
		int operation[] = new int [4];
		int index[]=new int[N-1]; // operation 이 가지고 있는 index 
		for(int i=0;i<N;i++) {
			a[i]=scan.nextInt();
		}
		
		for(int i=0;i<4;i++) {
			operation[i] = scan.nextInt();
		}
		int j=0;
		for(int i=0;i<N-1;i++) {
			if(operation[j]>1) {
				index[i]=j;
				operation[j]-=1;
			}else if(operation[j]==1){
				index[i]=j;
				operation[j]-=1;
				j++;
			}else {
				j++;
				i--;
			}
		}
		
		
		Calcul cal = new Calcul();
		int total = cal.factorial(N);
		cal.result(a, index, 0, 0);
		for(int i=0;i<total;i++) {
			if(cal.next_permutation(index)) {
				cal.result(a, index, 0, 0);
			}
		}
		
		System.out.println(cal.maximum);
		System.out.println(cal.minimum);
		
		
	}
}























