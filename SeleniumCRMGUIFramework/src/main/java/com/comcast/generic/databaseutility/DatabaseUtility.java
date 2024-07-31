package com.comcast.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	String url;
	public DatabaseUtility(String url)
	{
		this.url=url;
	}
	public DatabaseUtility()
	{
	
	}
	public void getDbConnection() throws Throwable 
	{
		try 
		{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root" );
		}
		catch (Exception e)
		{
			
		}
	}
		
	public void getDbConnection(String username, String password) throws Throwable 
	{
		try 
		{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		
		con = DriverManager.getConnection(url,username,	password );
		}
		catch (Exception e) 
		{
			
		}
	}
	 public void CloseDbConnection() throws SQLException 
	 {
	    try 
	    {
	    con.close();
	    } 
	    catch (Exception e)
	    {
	    }
	 }

	 public ResultSet executeSelectQuery(String query) throws SQLException 
	 {
		ResultSet result= null;
	    try 
	    {
	    Statement stat = con.createStatement();
		result = stat.executeQuery(query);
	    }
	    catch (Exception e) 
	    {
	    	}
		return result;
		 
	 }
	 public int executeNonSelectQuery(String query) throws SQLException 
	 {
		 int result=0;
		 try 
		 {
			 Statement stat= con.createStatement();
			 result= stat.executeUpdate(query);
		 }
		 catch (Exception e) 
		 {
		 }
		 return result;
		 
	 }
}
