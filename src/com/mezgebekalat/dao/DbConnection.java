package com.mezgebekalat.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/entries?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "fathergod1");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}