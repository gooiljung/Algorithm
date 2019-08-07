package SWAcademy;

public class powerSet {
	static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
	    if(idx == n) {
	    		print(arr,visited,n);       
	        return;
	    }
	 
	    visited[idx] = false;
	    powerSet(arr, visited, n, idx + 1);
	 
	    visited[idx] = true;
	    powerSet(arr, visited, n, idx + 1);
	}

	static void print(int[] arr, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
	public static void main(String[] args) {
		int temp[] = {6,1,9,7};
		boolean tf[] = new boolean[4];
		powerSet(temp,tf,4,0);
		
	}
}
