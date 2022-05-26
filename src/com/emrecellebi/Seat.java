package com.emrecellebi;

import java.util.Date;
import java.util.List;

public class Seat
{
	private static SQLiteConnection connect;
	private static Date date = new Date();
	private static Logger logger;
	private static List<Integer> data = null;
	
	static
	{
		logger = new Logger();
		connect = new SQLiteConnection("database.db");
		if(data == null) data = connect.query("select * from fly_reservation");
	}
	
	public static void reader(String name)
	{
		String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
		System.out.println(time + name + " Seat No 1: " + data.get(0) + " Seat No 2: " + data.get(1) + " Seat No 3: " + data.get(2) + " Seat No 4: " + data.get(3) + " Seat No 5: " + data.get(4));
		System.out.println("-------------------------------------------------------------------------------");
		logger.log(time + name + " Seat No 1: " + data.get(0) + " Seat No 2: " + data.get(1) + " Seat No 3: " + data.get(2) + " Seat No 4: " + data.get(3) + " Seat No 5: " + data.get(4) + "\n");
		logger.log("-------------------------------------------------------------------------------\n\n");
		System.out.println();
	}
	
	public static void writer(String name, int seat)
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
					String time = "Time: " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n";
					System.out.println(time + name + " Tries to book the seat " + seat + " successfully");
					System.out.println();
					logger.log(time + name + " Tries to book the seat " + seat + " successfully\n\n");
					connect.update("update fly_reservation set Reservation = 1 where Id = " + (i + 1));
					data = connect.query("select * from fly_reservation");
					break;
				}
			}
		}
	}
}