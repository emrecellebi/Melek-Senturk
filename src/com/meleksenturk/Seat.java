package com.meleksenturk;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Seat
{
	/// SQLite veri tabanına bağlantımızı sağlıyan değikenimiz.
	// private static SQLiteConnection connect;
	
	/// Buda Saati:Dakika:Saniye yi çekmemizi sağlıyan Sınıfımız.
	private static Date date = new Date();
	
	/// Buda dosya içerisinine yazmamızı sağlayan Logger değikeni;
	private static Logger logger;
	
	/// Integer tipinde listemiz
	private static List<Integer> data = null;
	
	/// Peki burası nedir. Her sınıfda bir yapıcı method vardır her şeyden önce çalışır buda static sınıflar için geçerli olan yapıcı block diye adlandıra biliriz.
	static
	{
		/// logger sınıfımızdan bir nesne oluşturuyoruz.
		logger = new Logger();
		
		/// SQLite sıfırdan bir nesne oluşturuyoruz.
		// connect = new SQLiteConnection("database.db");
		
		/// data listemizi null drumunu kontrol edip veri tabanından verileri liste olarak çekiyoruz.
		// if(data == null) data = connect.query("select * from fly_reservation");
		
		/// data listemizi null durumunu control ediyoruz eğer ki null ise bir ArrayList oluşturuyoruz.
		if(data == null) data = new ArrayList<Integer>();
		
		/// data listemiz boş oladuğu için içerisine beş defa sıfır ekliyoruz.
		for(int i = 1; i <= 5; i++) data.add(0);
	}
	
	/// Reader Methodumuz
	public static void reader(String name)
	{
		/// Bir tane time isiminde String tanımlanır sırasıyla saat:dakika:saniye çekilir.
		String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
		
		/// Console üzerine çıktıyı yazar sırasıyla time + name ve Liste içerisindeki 5 tane değer
		System.out.println(time + name + " Seat No 1: " + data.get(0) + " Seat No 2: " + data.get(1) + " Seat No 3: " + data.get(2) + " Seat No 4: " + data.get(3) + " Seat No 5: " + data.get(4));
		
		/// Console da ataya bir çizgi çekiyoruz..
		System.out.println("-------------------------------------------------------------------------------");
		
		/// Bir dosya içerisine sırasıyla time + name ve Liste içerisindeki 5 tane değer
		logger.log(time + name + " Seat No 1: " + data.get(0) + " Seat No 2: " + data.get(1) + " Seat No 3: " + data.get(2) + " Seat No 4: " + data.get(3) + " Seat No 5: " + data.get(4) + "\n");
		
		/// Bir dosya içerisinde da bir çizgi çekiyoruz..
		logger.log("-------------------------------------------------------------------------------\n\n");
		
		/// Tek yaptığı sadece boş bir println yani yeni satır yapar
		System.out.println();
	}
	
	/// Writer Methodumuz
	public static void writer(String name, int seat)
	{
		/// Tanımlanan data Listemiz içerisinde dönüyoruz
		for(int i = 0; i < data.size(); i++)
		{
			/// Methodan gelen seat değerini karşılaştırıyoruz i değeri ile fakat i nin bir fazlasını alarak
			if(seat == (i + 1))
			{
				/// Liste içerisindeki değeri çekiyoruz eğer ki bir e eşitse bu şart gerçekleştirilir
				if(data.get(i) == 1)
				{
					/// Bir tane time isiminde String tanımlanır sırasıyla saat:dakika:saniye çekilir.
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					
					/// Console üzerine çıktıyı yazdırır. time + name + koltuk rezervasyonu dolu olduğunu yazdır koltuk numarası ile
					System.out.println(time + name + " Could not booked seat number " + (i + 1) + " since it has been already booked");
					
					/// Bunun görevini bilyorsun zaten yeni bir satır yapar.
					System.out.println();
					
					/// Yuakrıdaki console çıktısının dosya içerisine yazılmış hali
					logger.log(time + name + " Could not booked seat number " + (i + 1) + " since it has been already booked\n\n");
					
					/// Pekiya bu nedir? döngüyü kırıp çıkıyoruz mesela döngümüz sıfırdan başladı liste kadar dönücek ikinci index de bir geldi döngü atrık devam etmez kırar çıkar.
					break;
				}
				else
				{
					/// Burayı açıklama gerek yok zaten biliyorsun Sistem satini çekiyoruz.
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					
					/// Burada ise listeden gelen değerlerde bir değeri yok ise rezer vasyon işlemini burada tamamlar
					System.out.println(time + name + " Tries to book the seat " + seat + " successfully");
					
					/// Bunun ne anlama geldiğini biliyorsun zaten :)
					System.out.println();
					
					/// Buda Yukarıdaki nin aynısını dosya içerisine yazar.
					logger.log(time + name + " Tries to book the seat " + seat + " successfully\n\n");
					// connect.update("update fly_reservation set Reservation = 1 where Id = " + (i + 1));
					// data = connect.query("select * from fly_reservation");
					
					/// pekiya burası nedir listemizde gelen indexin içeriğini burada değiştiriyoruz.
					data.set(i, 1);
					
					/// Bunu zaten anlamışsındır ne diye düşünüyorum :)
					break;
				}
			}
		}
	}
	
	public static void writer2(String name, int seat)
	{
		for(int i = 0; i < data.size(); i++)
		{
			if(seat == (i + 1))
			{
				if(data.get(i) == 1)
				{
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					System.out.println(time + name + " Could not booked seat number " + (i + 1) + " since it has been already booked");
					System.out.println();
					logger.log(time + name + " Could not booked seat number " + (i + 1) + " since it has been already booked\n\n");
					break;
				}
				else
				{
					synchronized(Seat.class)
					{
						String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
						System.out.println(time + name + " Tries to book the seat " + seat + " successfully");
						System.out.println();
						logger.log(time + name + " Tries to book the seat " + seat + " successfully\n\n");
						// connect.update("update fly_reservation set Reservation = 1 where Id = " + (i + 1));
						// data = connect.query("select * from fly_reservation");
						data.set(i, 1);
						break;
					}
				}
			}
		}
	}
}