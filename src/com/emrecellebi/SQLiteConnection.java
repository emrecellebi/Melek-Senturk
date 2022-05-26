package com.emrecellebi;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.JDBCType;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class SQLiteConnection
{
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet result = null;
	private ResultSetMetaData resultData = null;
	private PreparedStatement pstmt = null;
	
	public SQLiteConnection(String dbname)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:" + dbname);		/// Verilen Veritabanı URL sine Bağlantı Kurmaya Çalışır
			statement = connect.createStatement();								/// Veritabanına SQL deyimleri göndermek için bir Statement nesnesi oluşturur
		}
		catch(Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void createTable(String sql)
	{
		try
		{
			/// INSERT, UPDATE veya DELETE ifadesi veya SQL DDL ifadesi gibi hiçbir şey döndürmeyen bir SQL ifadesi olabilen verilen SQL ifadesini yürütür.
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void insert(String sql)
	{
		try
		{
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void update(String sql)
	{
		try
		{
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void delete(String sql)
	{
		try
		{
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public List<Integer> query(String sql)
	{
		/**
		https://www.tutorialspoint.com/sqlite/sqlite_java.htm
		https://www.tutorialspoint.com/how-to-get-the-data-type-name-from-the-java-sql-type-code-using-jdbc
		https://www.tutorialspoint.com/how-to-get-all-the-column-names-from-a-resultset-using-jdbc
		https://www.tutorialspoint.com/jdbc/jdbc-select-records.htm
		https://www.programcreek.com/java-api-examples/?class=java.sql.ResultSet&method=getRef
		**/
		
		List<Integer> data = new ArrayList<Integer>();
		
		try
		{
			ResultSet result = statement.executeQuery(sql);
			while(result.next())
			{
				
				data.add(result.getInt("Reservation"));
			}
		
			result.close();
		}
		catch(SQLException e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return data;
	}
	
	public void close()
	{
		try
		{
			statement.close();
			connect.close();
		}
		catch(SQLException e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

}