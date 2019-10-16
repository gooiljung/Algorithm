package A_Type_Test;
import java.util.*;

public class problem17281 {

	public static int max=Integer.MIN_VALUE;

	public static void permutation(ArrayList<Integer> arr) {
		if(arr.size()==9&&arr.get(3)==0) {
			max = Math.max(max, calcul(arr));
	
			return;
		}

		for(int i=0;i<9;i++) {
			if(!arr.contains(i)) {
				arr.add(i);
				permutation(arr);
				arr.remove(arr.size()-1);
			}
		}
	}

	public static int calcul(ArrayList<Integer> arr) {
		int lastPlay=0;
		int score=0;
		
		for(int i=0;i<inning;i++) {
			int outCount=0;
			int runner[] = new int[3];
			Arrays.fill(runner, -1);
			while(outCount!=3) {
				if(lastPlay==9) lastPlay=0;
				switch(player[i][arr.get(lastPlay)]) {
				case 0:
					outCount++;
					break;
				case 1:
					if(runner[2]!=-1) {
						score++;
						runner[2]=-1;
					}
					if(runner[1]!=-1) {
						runner[2]=0;
						runner[1]=-1;
					}
					if(runner[0]!=-1) {
						runner[1]=0;
						
					}
					runner[0]=0;
					break;
				case 2:
					if(runner[2]!=-1) {
						score++;
						runner[2]=-1;
					}
					if(runner[1]!=-1) {
						score++;
						runner[1]=-1;
					}
					if(runner[0]!=-1) {
						runner[2]=0;
						runner[0]=-1;
						
					}
					runner[1]=0;
					break;
				case 3:
					if(runner[2]!=-1) {
						score++;
						runner[2]=-1;
					}
					if(runner[1]!=-1) {
						score++;
						runner[1]=-1;
					}
					if(runner[0]!=-1) {
						score++;
						runner[0]=-1;
						
					}
					runner[2]=0;
					break;
				case 4:
					int cnt=0;
					for(int j=0;j<3;j++) {
						if(runner[j]!=-1) cnt++;
						runner[j]=-1;
					}
					score+=cnt+1;
					break;

				}


				lastPlay++;
			}
		}

		return score;
	}
	public static int inning=0;
	public static int player[][];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		inning = Integer.parseInt(st.nextToken());
		player = new int[inning][9];

		for(int i=0;i<inning;i++) {
			st = new StringTokenizer(scan.nextLine());
			for(int j=0;j<9;j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		permutation(arr);
		System.out.println(max);
	}
}








