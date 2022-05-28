package com.meleksenturk;

import java.util.Random;

/// WriterThread sınıfımız Runnable interface sini implements etmiş bu sınıfında tek bir kuralı var run methonudunu Override etmek
public class WriterThread implements Runnable
// public class WriterThread extends Thread
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 5; i++)
		{
			/// Burada ise Seat sınıfndaki writer methonudunu çağrıyoruz çalışan threadimizin adını ve döngümüzün değerini veriyoruz.
			Seat.writer(Thread.currentThread().getName(), i);
			
			/// Burada eğer istersen koltuk sayılarını Rastgele gönderebilirsin
			// Seat.writer(Thread.currentThread().getName(), new Random().nextInt((3 + 1) + 1) + 1);
			
			/// Burada ise 500ms kadar bekleme veriyoruz.
			try{Thread.sleep(500);}catch(Exception e){};
		}
	}
}