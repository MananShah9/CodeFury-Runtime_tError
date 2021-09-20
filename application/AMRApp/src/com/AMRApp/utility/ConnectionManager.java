package com.AMRApp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	
	
	//singleton pattern
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
		if(conn==null) {
			String url="jdbc:mysql://localhost:3306/project_db?useSSL=false";
			String username="root";
			String password="password";
			System.out.println("Yha error aari hai");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Neeche error aara h");
			conn=DriverManager.getConnection(url,username,password);
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
