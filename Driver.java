package game;
import java.util.*;
public class Driver {

	public static void main(String[] args) {
		int n;
		System.out.println("enter number of players");
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		Moderator m=new Moderator();
		Gamedata g=new Gamedata(n,m);
		Thread t1=new Thread(g);
		Thread t2=new Thread(m);
		while(!g.win)
		{
			if(m.curr==0)
				{
				System.out.println("New round begins");
				}
			System.out.println(m.getNext());
			for(int i=0;i<n;i++)
			{
				Thread t=new Thread(g.players[i]);
				t.run();
				
				
			}
			t1.run();
			t2.run();
			try
			{
				Thread.sleep(500);
			} catch(InterruptedException e) {}
			if(m.curr==10)
			{
				g.refresh();
				m.refresh();
			}
			
		}

	}

}
