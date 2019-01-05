package BruteForce;
import java.util.*;


class Find{
	int sum=0;
	int select1,select2;
	
	void findingPeople(int [] people) {
		for (int i =0; i<people.length-1;i++) {
			for(int j=i+1;j<people.length;j++) {
				
				for(int k=0;k<people.length;k++) {
					
					if(k!=i&&k!=j) {
						sum+=people[k];
					}
					
				}
				if(sum==100) {
					select1=i;
					select2=j;
					return;
				}else {
					sum=0;
				}
				
			}
		}
	}
}

public class problem2309 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int people[] = new int[9];

		for (int i=0; i<people.length;i++) {
			people[i]=scan.nextInt();
		
		}
		Find find = new Find();
		find.findingPeople(people);
		
		int result[] = new int[7];
		int temp = 0;
		for(int k=0;k<people.length;k++) {
			
			if(k!=find.select1&&k!=find.select2) {
				result[temp] = people[k];
				temp++;
			}
		}
		
		
		
		
		
		
		
		for(int i=result.length-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(result[i]<result[j]) {
					temp = result[i];
					result[i] = result[j];
					result[j]=temp;
				}
			}
		}
		

		
		for (int i=0; i<7;i++) {
			System.out.println(result[i]);
		}
		
		
		
	}
}
