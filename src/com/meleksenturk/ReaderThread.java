package com.meleksenturk;

/// ReaderThread sınıfımız Runnable interface sini implements etmiş bu sınıfında tek bir kuralı var run methonudunu Override etmek
public class ReaderThread implements Runnable
// public class ReaderThread extends Thread
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 5; i++)
		{
			/// Burada ise Seat sınıfındaki reader methonudunu çağrıyoruz çalışan threadimizin adını veriyoruz.
			Seat.reader(Thread.currentThread().getName());
			
			/// Burada ise 450ms kadar bekleme veriyoruz.
			try{Thread.sleep(450);}catch(Exception e){};
		}
	}
}