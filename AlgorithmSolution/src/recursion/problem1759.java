package recursion;
import java.util.*;

class Password{
	
	Boolean c[] = new Boolean[15];
	int mo =0, ja=0;
	
	
	Password(){
		for(int i =0; i<c.length;i++) {
			c[i]=false;
		}
	}
	void makePassword(String now,int goal,String[] str,int k) {
		if(now.length()==goal) {
			check(now);
			
			if(mo>=1&&ja>=2) {
				System.out.println(now);
			}
			mo=0;ja=0;
			return;
		}
		if(now.length()>goal||k>=str.length) {
			return;
		}
		makePassword(now+str[k],goal,str,k+1);
		makePassword(now,goal,str,k+1);
		
		
		
	}
	void check(String now) {
		for(int i=0;i<now.length();i++) {
			char temp = now.charAt(i);
			if(temp=='a'||temp=='e'||temp=='i'||temp=='o'||temp=='u') {
				mo +=1;
			}else {
				ja+=1;
			}
		}
		
	}
}

public class problem1759 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int L,C;
		L = scan.nextInt();
		C = scan.nextInt();
		String str[] = new String[C];
	
		for(int i =0; i<C;i++) {
			str[i] = scan.next();
		
		}
		Arrays.sort(str);
		Password pw = new Password();
	
		
		
		pw.makePassword("", L, str,0);
		
		
		
	}
}
