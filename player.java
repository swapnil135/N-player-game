package game;
import java.io.*;
import java.util.*;

public class player implements Runnable {
	
	public int playerID;
	public int strikes=0;
	public int[] arr = new int[10];
	public Gamedata g;
	public Moderator m;
	public int currnum;
	public player(int id,Gamedata g,Moderator m)
	{
		this.m=m;
		this.g=g;
		this.playerID=id;
		Random rand=new Random();
		for(int i=0;i<10;i++)
		{
			arr[i]=rand.nextInt(51);
		}
		currnum=69;
	}
	void printPlayer()
	{
		System.out.println(this.playerID + " player's nubmers are:");
		for(int i=0;i<10;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public void strike()
	{
		for(int j:arr)
		{
			if(j==currnum && g.isStrike(currnum))
			{
				strikes++;
				System.out.println("player " + this.playerID + " strikes "+ currnum + ". Total strikes =" + strikes);
				if(strikes==3) System.out.println("Player" + this.playerID+ " wins.");
			}
		}
	}
	void gameOver()
	{
		if (this.strikes==3)
			g.win=true;
	}
	public void run()
	{
		currnum=m.getNext();
		this.strike();
		this.gameOver();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
