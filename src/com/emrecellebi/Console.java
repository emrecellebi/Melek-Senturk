package com.emrecellebi;

public class Console
{	
	public static void main(String[] args)
	{
		if(args.length == 1)
		{
			if(args[0].equals("--reset"))
			{
				SQLiteConnection connect = new SQLiteConnection("database.db");
				connect.update("update fly_reservation set Reservation = 0");
				connect.close();
			}
		}
		else
		{
			int i = 1;
			while(i <= 3)
			{
				
				new Thread(new ReaderThread(), "ReaderThread-" + i).start();
				new Thread(new WriterThread(), "WriterThread-" + i).start();				
				try{Thread.sleep(1000);}catch(Exception e){};
				
				i++;
			}
		}
	}
}