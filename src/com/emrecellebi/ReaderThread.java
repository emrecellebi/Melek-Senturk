package com.emrecellebi;

public class ReaderThread implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 5; i++)
		{
			Seat.reader(Thread.currentThread().getName());
			try{Thread.sleep(450);}catch(Exception e){};
		}
	}
}