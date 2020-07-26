package game;

public class Gamedata implements Runnable{
	int n;
	Moderator m;
	player[] players;
	int[] striked=new int[51];
	public boolean win=false;
	public Gamedata(int n,Moderator m)
	{
		this.n=n;
		players=new player[n];
		this.m=m;
		for(int i=0;i<n;i++)
		{
			players[i]=new player(i,this,this.m);
			players[i].printPlayer();
		}
		for(int i=0;i<51;i++)
		{
			striked[i]=-1;
		}
	}
	void addstrike()
	{
		striked[m.getNext()]=1;
	}
	boolean isStrike(int n)
	{
		return(striked[n]==1);
	}
	
	void refresh()
	{
		for(player i:players)
		{
			i.strikes=0;
		}
		for(int i:striked)
		{
			i=-1;
		}
	}
	public void run()
	{
		addstrike();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
