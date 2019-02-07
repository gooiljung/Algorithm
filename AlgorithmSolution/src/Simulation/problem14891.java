package Simulation;
import java.util.*;

class Index{
	int right(int a) {
		return (a+7)%8;
	}
	int left(int a) {
		return (a+1)%8;
	}
	
	int leftOne(int a) {
		return (a+2)% 8;
	}
	int rightOne(int a) {
		return (a+6)%8;
	}
}


public class problem14891 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first[] = new int [8];
		int second[] = new int [8];
		int third[] = new int [8];
		int fourth[] = new int [8];
		String temp[] = new String[4];
		for(int i=0;i<4;i++) {
			temp[i] = scan.nextLine();
		}
//		scan.nextLine();
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<8;j++) {
				switch(i) {
				case 0:
					if(temp[i].charAt(j)=='0') {
						first[j] = 0;
					}else {
						first[j] = 1;
					}
					
					break;
				case 1:
					if(temp[i].charAt(j)=='0') {
						second[j] = 0;
					}else {
						second[j] = 1;
					}
					break;
				case 2:
					if(temp[i].charAt(j)=='0') {
						third[j] = 0;
					}else {
						third[j] = 1;
					}
					break;
				case 3:
					if(temp[i].charAt(j)=='0') {
						fourth[j] = 0;
					}else {
						fourth[j] = 1;
					}
					break;
				}
			}
		}
		
		int index[] = new int [5]; //1,2,3,4 톱니바퀴의 index 
		Arrays.fill(index, 0);
		
		int k = scan.nextInt();
		// 시계 +7 % 8
		// 반시계는 +1 % 8 
		
		//왼쪽 톱니바퀴 +2 %8
		//오른쪽 +6 %8
		
		Index ind = new Index();
		//continue 확인;
		int before;
		while(k-->0) {
			int choose = scan.nextInt();
			int direction = scan.nextInt();
			if(choose == 1) { 
				
				if(direction == 1) {
					//시계 
					before = index[1];
					index[choose] = ind.right(index[choose]);  
					
					if(first[ind.leftOne(before)]==second[ind.rightOne(index[2])]) {
						continue;
					}else {
						// second 가 반시계 
						before = index[2];
						index[2] = ind.left(index[2]);
						
						if(second[ind.leftOne(before)]==third[ind.rightOne(index[3])]) {
							continue;
						}else {
							// third 가 시계 
							before = index[3];
							index[3] = ind.right(index[3]);
							
							if(third[ind.leftOne(before)]==fourth[ind.rightOne(index[4])]){
								continue;
							}else {
								//fourth  반시계 
								index[4] = ind.left(index[4]);
							}
						}
						
					}
	
				}else {
					// 반시
					before = index[1];
					index[choose] = ind.left(index[choose]);  
					if(first[ind.leftOne(before)]==second[ind.rightOne(index[2])]) {
						continue;
					}else {
						// second 가 시계 
						before = index[2];
						index[2] = ind.right(index[2]);
						
						if(second[ind.leftOne(before)]==third[ind.rightOne(index[3])]) {
							continue;
						}else {
							// third 가 반시계 
							before = index[3];
							index[3] = ind.left(index[3]);
							
							if(third[ind.leftOne(before)]==fourth[ind.rightOne(index[4])]){
								continue;
							}else {
								//fourth  시계 
								index[4] = ind.right(index[4]);
							}
						}
					}
				}
				
				
			}else if (choose == 2) {
				if(direction == 1) {
					// seocond 시계 
					before = index[2];
					index[choose] = ind.right(index[choose]);  
					if(first[ind.leftOne(index[1])]==second[ind.rightOne(before)]) {
						
					}else {
						//first 가 반시계 
						index[1] = ind.left(index[1]);
					}
					if(second[ind.leftOne(before)]==third[ind.rightOne(index[3])]) {
						continue;
					}else {
						//third 반시계 
						before = index[3];
						index[3] = ind.left(index[3]);
						
						if(third[ind.leftOne(before)]==fourth[ind.rightOne(index[4])]) {
							continue;
						}else {
							//fourth 시계
							index[4] = ind.right(index[4]);
							
							
						}
					}
	
				}else {
					// seocond 반시계 
					before = index[2];
					index[choose] = ind.left(index[choose]);  
					if(first[ind.leftOne(index[1])]==second[ind.rightOne(before)]) {
						
					}else {
						//first 가 시계 
						index[1] = ind.right(index[1]);
					}
					if(second[ind.leftOne(before)]==third[ind.rightOne(index[3])]) {
						continue;
					}else {
						//third 시계 
						before = index[3];
						index[3] = ind.right(index[3]);
						
						if(third[ind.leftOne(before)]==fourth[ind.rightOne(index[4])]) {
							continue;
						}else {
							//fourth 반시계
							index[4] = ind.left(index[4]);
							
							
						}
					}
				}
			}else if (choose == 3) {
				if(direction == 1) {
					// third 시계 
					before = index[3];
					index[choose] = ind.right(index[choose]);  
					if(third[ind.leftOne(before)]==fourth[ind.rightOne(index[4])]) {
						
					}else {
						//fourth 반시계  
						index[4] = ind.left(index[4]);
					}
					if(second[ind.leftOne(index[2])]==third[ind.rightOne(before)]) {
						continue;
					}else {
						//second 반시계 
						before = index[2];
						index[2] = ind.left(index[2]);
						
						if(first[ind.leftOne(index[1])]==second[ind.rightOne(before)]) {
							continue;
						}else {
							//first 시계
							index[1] = ind.right(index[1]);
							
							
						}
					}
				}else {
					// third 반시계 
					before = index[3];
					index[choose] = ind.left(index[choose]);  
					if(third[ind.leftOne(before)]==fourth[ind.rightOne(index[4])]) {
						
					}else {
						//fourth 시계  
						index[4] = ind.right(index[4]);
					}
					if(second[ind.leftOne(index[2])]==third[ind.rightOne(before)]) {
						continue;
					}else {
						//second 시계 
						before = index[2];
						index[2] = ind.right(index[2]);
						
						if(first[ind.leftOne(index[1])]==second[ind.rightOne(before)]) {
							continue;
						}else {
							//first 반시계
							index[1] = ind.left(index[1]);
							
							
						}
					}
				}
			}else{
				if(direction == 1) {
					// fourth 시계 
					before = index[4];
					index[choose] = ind.right(index[choose]);  
					if(third[ind.leftOne(index[3])]==fourth[ind.rightOne(before)]) {
						continue;
					}else {
						// third 가 반시계 
						before = index[3];
						index[3] = ind.left(index[3]);
						
						if(second[ind.leftOne(index[2])]==third[ind.rightOne(before)]) {
							continue;
						}else {
							// second 가 시계 
							before = index[2];
							index[2] = ind.right(index[2]);
							
							if(first[ind.leftOne(index[1])]==second[ind.rightOne(before)]){
								continue;
							}else {
								//first  반시계 
								index[1] = ind.left(index[1]);
							}
						}
					}
	
				}else {
					// fourth 반 시계 
					before =index[4];
					index[choose] = ind.left(index[choose]);  
					if(third[ind.leftOne(index[3])]==fourth[ind.rightOne(before)]) {
						continue;
					}else {
						// third 가 시계 
						before = index[3];
						index[3] = ind.right(index[3]);
						
						if(second[ind.leftOne(index[2])]==third[ind.rightOne(before)]) {
							continue;
						}else {
							// second 가 반시계 
							before = index[2];
							index[2] = ind.left(index[2]);
							
							if(first[ind.leftOne(index[1])]==second[ind.rightOne(before)]){
								continue;
							}else {
								//first  시계 
								index[1] = ind.right(index[1]);
							}
						}
					}
				}
			}
			
			
		}
	
		int sum = first[index[1]]+(second[index[2]]*2)+(third[index[3]]*4)+(fourth[index[4]]*8);
		System.out.println(sum);
		
		
	}
}
