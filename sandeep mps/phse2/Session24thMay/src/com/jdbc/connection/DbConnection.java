package com.jdbc.connection;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class DbConnection {
	private static String drivername, conString, uname, pwd;
	
	public static Connection  getConnection()
	{
		Connection con = null;
		try
		{
			getDbInfo();
			Class.forName(drivername);
			con =  DriverManager.getConnection(conString, uname, pwd);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
	
	public static void getDbInfo() throws IOException
	{
		String app_path = System.getProperty("user.dir");
		app_path = app_path + "\\src\\dbinfo.properties";
		
		FileReader freader = new FileReader(app_path);
		
		Properties  prop = new Properties();
		prop.load(freader);
		
		drivername  = prop.getProperty("drivername");
		conString = prop.getProperty("connectionString");
		uname = prop.getProperty("username");
		pwd = prop.getProperty("password");
	}
}
