package com.emrecellebi;

import java.io.FileWriter;

public class Logger
{
	private FileWriter fw;
	
	public Logger()
	{
		try
		{
			fw = new FileWriter("Logger.txt");
		}
		catch(Exception e){}
	}
	
	public void log(String data)
	{
		try
		{
			fw.write(data);
			fw.flush();
		}
		catch(Exception e){}
	}
	
	public void close()
	{
		try
		{
			fw.close();
		}
		catch(Exception e){}
	}
}