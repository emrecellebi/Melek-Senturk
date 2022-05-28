package com.meleksenturk;

public class Console
{
	public static void main(String[] args) throws Exception
	{
		/// Burada Thread nesnesi oluşturuken tanımlanan sınıfın ya Runnable bir sınıf olaması gerekir yada Thread dınıfını extends etmesi gerekir.
		Thread t1 = new Thread(new ReaderThread(), "ReaderThread-" + 1);
		Thread t2 = new Thread(new ReaderThread(), "ReaderThread-" + 2);
		Thread t3 = new Thread(new WriterThread(), "WriterThread-" + 1);
		Thread t4 = new Thread(new WriterThread(), "WriterThread-" + 2);
		Thread t5 = new Thread(new WriterThread(), "WriterThread-" + 3);
		
		/// Eğerki ReaderThread ve WriterThread sınıfkarı Thread sınıfını extends ederse bunu kullanabilirsin fakata yukarıdakileri yoruma alırsın.
		// ReaderThread t1 = new ReaderThread();
		// ReaderThread t2 = new ReaderThread();
		// WriterThread t3 = new WriterThread();
		// WriterThread t4 = new WriterThread();
		// WriterThread t5 = new WriterThread();
		
		/// start methodu threadlerimizi başlatır.
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		/// Join methodu ise bir ilk thread başladığında bu thread bitmeden diğer threadleri başlatmaz
		// t1.join();
		// t2.join();
		// t3.join();
		// t4.join();
		// t5.join();
		
		/// SQLite veri tabanına bağlantımızı yapoyoruz
		// SQLiteConnection connect = new SQLiteConnection("database.db");
		
		/// Ve içerisinde bulunan update methodunu çağrıyoruz.
		// connect.update("update fly_reservation set Reservation = 0");
		
		/// Sontasında SQLite Bağlantımızı kapatıyoruz.
		// connect.close();
	}
}