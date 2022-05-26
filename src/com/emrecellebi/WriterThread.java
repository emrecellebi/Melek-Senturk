package com.emrecellebi;

import java.util.Random;

public class WriterThread implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 5; i++)
		{
			Seat.writer(Thread.currentThread().getName(), new Random().nextInt((3 + 1) + 1) + 1);
			try{Thread.sleep(500);}catch(Exception e){};
		}
	}
}