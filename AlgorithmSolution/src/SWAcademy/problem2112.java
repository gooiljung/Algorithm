package SWAcademy;
import java.util.*;

public class problem2112 {
	public static int D,W,K;
	public static int film[][];
	public static List<Integer> list;
	public static List<Integer> list2;
	public static int min = Integer.MAX_VALUE;


	public static void complete(int temp[][]) { // 배열에 연속된 k 확인
		for(int i=0;i<W;i++) {
			int count = 1;
			boolean tf = false;

			for(int j=1;j<D;j++) {
				if(temp[j-1][i]==temp[j][i]) {
					count+=1;
				}else {
					count=1;
				}
				if(count>=K) {
					tf=true;
					break;
				}
			}
			if(!tf) {
				list.add(i);
				return;
			}
		}	
	}
	public static int[][] copy(int real[][]){
		int temp[][] = new int [D][W];
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				temp[i][j]=real[i][j];
			}
		}
		return temp;
	}
	public static void changeValue(int temp[][],int x,int changeValue) {
		for(int i=0;i<W;i++) {
			temp[x][i]=changeValue;
		}
	}
	// x 를 -1 부터 보내면 될듯 
	public static void getSuccess(int x,int cnt,int check[][]) {
		if(cnt>=min) {
			return;
		}
		if(x>=D) {
			list = new ArrayList<Integer>();
			complete(check);
			if(list.size()==0) {
				min = Math.min(min, cnt);
			}
			return;
		}
		int temp[][] = copy(check);
		getSuccess(x+1,cnt,temp);
		changeValue(temp,x,0);
		getSuccess(x+1,cnt+1,temp);
		changeValue(temp,x,1);
		getSuccess(x+1,cnt+1,temp);

		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		int T = Integer.parseInt(st.nextToken());

		for(int a=1;a<=T;a++) {
			st = new StringTokenizer(scan.nextLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int [D][W];

			for(int i=0;i<D;i++) {
				st = new StringTokenizer(scan.nextLine());
				for(int j=0;j<W;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			list=new ArrayList<Integer>();
			complete(film);
			if(list.size()==0) {
				System.out.println("#"+a+" "+0);
				continue;
			}
				
			int temp[][] = copy(film);
			
			getSuccess(0,0,temp);
			System.out.println("#"+a+" "+min);
			min=D;
		}
	}
}

















