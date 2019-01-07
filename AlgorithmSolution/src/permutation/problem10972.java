package permutation;
import java.util.*;

class Permutation{
	int cnt =0;
	int[] result(int a[],int pivot1,int pivot2) {
		int maximum=0;
		for(int i=a.length-1;i>=0;i--) {
			for(int j=a.length-1;j>=i;j--) {
				
				if(a[j]>a[i]&&maximum<a[j]) {
					if(cnt!=0) {
						continue;
					}else {
						maximum=a[j];
						pivot1=i;
						pivot2=j;
						cnt ++;
					}
					
					
				}
			}
		}

		swap(a,pivot1,pivot2);

		int y =a.length-1;
		for(int i=pivot1+1;i<a.length;i++) {
			if(y>i) {
				swap(a,i,y);
				y--;
			}
			
		}
		
		int result[] = {-1};
		if(cnt ==0) {
			return result;
		}else {
			return a;
		}
		

		
		
	}
	
	void swap(int t[],int a,int b) {
		int temp = t[a];
		t[a]=t[b];
		t[b]=temp;
		
	}
}



public class problem10972 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a[] = new int[N];
		for(int i=0;i<N;i++) {
			a[i]=scan.nextInt();
		}
		Permutation num = new Permutation();
		int t[]=num.result(a,0,0);
		for(int i=0;i<t.length;i++) {
			System.out.print(t[i]+" ");
		}
		
	}
}
