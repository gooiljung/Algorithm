package A_Type_Test;
import java.util.*;

class sort{
	int num,cnt;

	sort(int num,int cnt){
		this.num = num;
		this.cnt =cnt;
	}
}
public class problem17140 {
	public static int arr[][];
	public static int r,c,k;
	public static int row=3,column=3;
	public static int time =100;


	// 각각의 수 파악해야하고 수의 등장 횟수가 커지는순  등장회수 같을시는 수가 커지는 순 정렬 후 다시 배열에 
	// 어떤 수가 들어가있는지는 Array 사용  -> 정렬 
	// count 배열에 인덱스로 접근 해서 몇변했는지 
	public static int[][] operation(int array[][]) {


		//정렬 순 새로운 어레이 만들기 
		PriorityQueue<sort> q = new PriorityQueue<sort>(new Comparator<sort>() {
			@Override
			public int compare(sort s1,sort s2) {
				if(s1.cnt>s2.cnt) {
					return 1;
				}else if(s1.cnt==s2.cnt) {
					if(s1.num>s2.num) {
						return 1;
					}else {
						return -1;
					}
				}else {
					return -1;
				}
			}
		}) ;
		int changed[][] = new int[100][100];
		
		if(row>=100) {
			row=100;
		}
		if(column>=100) {
			column= 100;
		}
		if(row>=column) {

			for(int i=0;i<row;i++) {
				q.removeAll(q);
				int countNum [] = new int[101]; // 1부터 100까지의 count 
				ArrayList<Integer> number = new ArrayList<Integer>();
				for(int j=0;j<column;j++) {
					if(array[i][j]!=0) {
						if(!number.contains(array[i][j])) {
							number.add(array[i][j]);
						}
						countNum[array[i][j]] ++;
					}
				}
				for(int j=0;j<number.size();j++) {
					q.add(new sort(number.get(j),countNum[number.get(j)]));
				}
				int temp=0;
				while(!q.isEmpty()) {

					sort s = q.remove();
					changed[i][temp++] = s.num;
					changed[i][temp++] = s.cnt;
				}
				column = Math.max(column, temp);

			}
		}else {
			//row index change 
			for(int i=0;i<column;i++) {
				q.removeAll(q);
				int countNum [] = new int[101]; // 1부터 100까지의 count 
				ArrayList<Integer> number = new ArrayList<Integer>();
				for(int j=0;j<row;j++) {
					if(array[j][i]!=0) {
						if(!number.contains(array[j][i])) {
							number.add(array[j][i]);
						}
						countNum[array[j][i]] ++;
					}
				}
				for(int j=0;j<number.size();j++) {
					q.add(new sort(number.get(j),countNum[number.get(j)]));
				}
				int temp=0;
				while(!q.isEmpty()) {

					sort s = q.remove();
					changed[temp++][i] = s.num;
					changed[temp++][i] = s.cnt;
				}
				row = Math.max(row, temp);

			}
			
		}
		
		return changed;

	}
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());


		// 초기 연산 할시에 해당 값으로 새로운 배열에 값 할당하기 
		arr = new int [100][100];

		for(int i=0;i<3;i++) {
			st = new StringTokenizer(scan.nextLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(arr[r-1][c-1]==k) {
			System.out.println(0);
			return;
		}


		for(int i=0;i<100;i++) {

			arr = operation(arr);
			if(arr[r-1][c-1]==k) {
				System.out.println(i+1);
				return;
			}
		}
		

	}
}


/*
 * R 연산 행에 대해서 정렬   행의 수 >= 열의 수   
 * C연산  열에 대해서 정렬   행의 수 < 열의 수 
 * 
 * 각각의 수 파악해야하고 수의 등장 횟수가 커지는순  등장회수 같을시는 수가 커지는 순 정렬 후 다시 배열에 
 * 
 * 정렬 결과를 배열에 넣을 시에 수와 등장횟수를 넣고 수가먼저 
 * 
 *  행 또는 열의 크기가 100넘어가면 처음 100개를 제외하곤 버린다. 
 * 
 */