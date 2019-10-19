package A_Type_Test;
import java.util.*;
class Temp{
	int arrive,time;
	Temp(int arrive,int time){
		this.arrive=arrive;
		this.time=time;
	}
}
public class last {
	
	public static void combination(ArrayList<Integer> arr,int n,int r,int target) {
		if(r==0) {
			//할일 
			for(int i=0;i<arr.size();i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			return;
		}
		
		if(target>=n) {
			return;
		}else {
			arr.add(target);
		}
		combination(arr,n,r-1,target+1);
		arr.remove(arr.size()-1);
		combination(arr,n,r,target+1);
		
	
	}
	public static void permutation(ArrayList<Integer> arr,int n) {
		if(arr.size()==n) {
			//할일 
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!arr.contains(i)) {
				arr.add(i);
				permutation(arr,n);
				arr.remove(arr.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
//		combination(arr,6,3,0);
		permutation(arr,5);
		
		PriorityQueue<Temp> q = new PriorityQueue<Temp>(new Comparator<Temp>() {
			@Override
			public int compare(Temp t1,Temp t2) {
				if(t1.arrive>t2.arrive) {
					return -1;
				}else if(t1.arrive==t2.arrive) {
					if(t1.time>t2.time) {
						return -1;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
		});
		Temp t1 = new Temp(1,4);
		Temp t2 = new Temp(2,3);
		Temp t3 = new Temp(2,4);
		Temp t4 = new Temp(0,4);
		Temp t5 = new Temp(1,5);
		Temp t6 = new Temp(4,4);
		Temp t7 = new Temp(0,2);
		
		q.add(t1);
		q.add(t2);
		q.add(t3);
		q.add(t4);
		q.add(t5);
		q.add(t6);
		q.add(t7);
		
		
		while(!q.isEmpty()) {
			Temp t = q.remove();
			
			System.out.println("arrive="+t.arrive+" time="+t.time);
		}
		
		
		
	}
}















