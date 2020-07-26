package game;
import java.util.*;
public class Moderator implements Runnable {
	int[] num=new int[10];
	int curr;
	public Moderator()
	{
		Random rand=new Random();
		for(int i=0;i<10;i++)
		{
			num[i]=rand.nextInt(51);
//			System.out.print(num[i]+ " ");
		}
		curr=0;
	}
	public void refresh()
	{
		Random rand=new Random();
		for(int i=0;i<10;i++)
		{
			num[i]=rand.nextInt(51);
//			System.out.print(num[i]+ " ");
		}
		curr=0;
	}
	public void show()
	{
		System.out.println("Moderator's numbers are" + " ");
		for(int i=0;i<10;i++)
		{
			System.out.print(num[i]+ " ");
		}
		System.out.println();
	}

	int getNext()
	{
		return num[curr];
	}
	public void run()
	{
		curr++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
