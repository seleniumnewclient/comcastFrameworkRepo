package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con =null;

	public void getDbConnection(String url,String userName,String password)
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, userName, password);
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getDbConnection()
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("http://49.249.28.218:8888/", "root", "root1234");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void closeDatabaseConnection() throws SQLException
	{
		con.close();
	}


	public ResultSet executeSelectQuery(String Query) throws SQLException
	{
		ResultSet rs =null;
		try {
			Statement st =con.createStatement();
			rs = st.executeQuery(Query);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public int executeNonSelectQuery(String Query) throws SQLException
	{
		int result =0;
		try
		{
			Statement st = con.createStatement();
			result =st.executeUpdate(Query);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}


}
