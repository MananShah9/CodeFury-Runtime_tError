package com.AMRApp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection con;

	private ConnectionManager() { // Constructor

	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			return con;
		} catch (SQLException | ClassNotFoundException e) {

			throw e;
		}
	}

	public static void closeConnection() {
		// TODO Auto-generated method stub
		try {
			con.close();
		}
		catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}

}
