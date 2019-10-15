package SWAcademy;
import java.util.*;
public class problem4012 {
	
	public static void combination(ArrayList<Integer> arr, int n, int r, int target) {
		
		if (r == 0) {
			getIndex(arr);
			
			return;
		}
		else if (target == n) {
			
			return; 
		}else {
			arr.add(target);
		}
		
		combination(arr, n, r - 1, target + 1); 
		arr.remove(arr.size()-1);
		combination(arr, n, r, target + 1); 
		
	}
	
	public static void getIndex(ArrayList<Integer> arr) {
		
		int first=0,second=0;
		for(int i=0;i<N;i++) {
			boolean tf=false;
			if(arr.contains(i)) {
				tf =true;
			}
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(tf) {
					if(arr.contains(j)) {
						first+= value[i][j];
					}
				}else {
					if(!arr.contains(j)) {
						second+=value[i][j];
					}
				}
				
			}
		}
		min = Math.min(min,Math.abs(first-second));
		

	}
	
	public static int min;
	public static int N;
	public static int value[][];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int a=1;a<=T;a++) {
			min= Integer.MAX_VALUE;
			st = new StringTokenizer(scan.nextLine());
			N = Integer.parseInt(st.nextToken());
			value = new int [N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(scan.nextLine());
				for(int j=0;j<N;j++) {
					value[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList <Integer> arr = new ArrayList<Integer>();
			combination(arr,N,N/2,0);
			System.out.println("#"+a+" "+min);
			
		}
		
	}
}

