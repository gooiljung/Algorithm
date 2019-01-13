package BFS;
import java.util.*;

class Emoticon{
	int screen;
	int clip;
	int time;
	
	Emoticon(int screen,int clip,int time){
		this.screen = screen;
		this.clip = clip;
		this.time = time;
	}
}

public class problem14226 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int S = scan.nextInt();
		Boolean check[][] = new Boolean[S+1][S+1];
		for(int i=0;i<check.length;i++) {
			Arrays.fill(check[i], false);
		}
		Queue<Emoticon> q = new LinkedList<Emoticon>();
		q.add(new Emoticon(1,0,0));
		check[1][0]=true;
		while(!q.isEmpty()) {
			Emoticon emo = q.remove();
			if(emo.screen == S) {
				System.out.println(emo.time);
				return;
			}
			if(check[emo.screen][emo.screen]==false) {
				q.add(new Emoticon(emo.screen,emo.screen,emo.time+1));
				check[emo.screen][emo.clip]=true;
				
			}
			
			
			if(emo.screen+emo.clip<=S&&emo.clip>0&&check[emo.screen+emo.clip][emo.clip]==false) {
				q.add(new Emoticon(emo.screen+emo.clip,emo.clip,emo.time+1));
				check[emo.screen+emo.clip][emo.clip]=true;
			}
			if(emo.screen>3&&check[emo.screen-1][emo.clip]==false) {
				q.add(new Emoticon(emo.screen-1,emo.clip,emo.time+1));
				check[emo.screen-1][emo.clip]=true;
			}
			
			
		}
	}
}

















