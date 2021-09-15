package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
	/**
	 * @return
	 * @throws SQLException
	 * getDbConnection() method is to connect java application with Oracle database.
	 */
	public static Connection getDbConnection() throws SQLException  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "password-1";
		Connection con = DriverManager.getConnection(url,userName,password);
		return con;
	}
}