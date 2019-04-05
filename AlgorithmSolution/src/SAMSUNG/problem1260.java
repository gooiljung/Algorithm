package SAMSUNG;
import java.util.*;

public class problem1260 {
	public static void dfs(int a[][],boolean check[],int v) {

		Stack <Integer> stack = new Stack<Integer>();
		boolean flag = true;
		stack.push(v);
		check[v] = true;
		System.out.print(v + " ");
		while(!stack.isEmpty()) {
			v = stack.peek();
			flag = false;
			for(int i=1;i<a[v].length;i++) {
				if(a[v][i]==1&&!check[i]) {
					stack.add(i);
					System.out.print(i+" ");
					check[i]=true;
					flag = true;
					break;
				}
			}
			if(!flag) {
				stack.pop();
			}
			
		}
		
		
	}
	public static void bfs(int a[][],boolean check[],int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		check[v] = true;
		
		while(!q.isEmpty()) {
			
			v = q.remove();
			System.out.print(v+" ");
			
			for (int i=1;i<a[v].length;i++) {
				if(a[v][i]==1&&!check[i]) {
					q.add(i);
					check[i] =true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int N,M,V;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		int a[][] = new int[N+1][N+1];
		boolean check [] = new boolean [N+1];
		Arrays.fill(check, false);
		
		for(int i=0;i<M;i++) {
			int temp=scan.nextInt(),temp2=scan.nextInt();
			a[temp][temp2] = 1;
			a[temp2][temp] = 1;
		}
		
		
		dfs(a,check,V);
		System.out.println();
		Arrays.fill(check, false);
		bfs(a,check,V);
		System.out.println();
		
		
	}
}
