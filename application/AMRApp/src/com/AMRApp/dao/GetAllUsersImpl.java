package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class GetAllUsersImpl implements GetAllUsersInterface {
	static PreparedStatement pList;
	static Connection con;
	@Override
	public List<User> getUserNames() {
		PreparedStatement ps;
		User user;
		List<User> listOfUsers=new ArrayList<>(); 
		try {
			con = ConnectionManager.getConnection();
			 ps = con.prepareStatement ( "select * from user" );
			
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				user =new User();
				user.setUserName(res.getString("userName"));
				user.setUserPhone(res.getString("userPhone"));
				user.setUserRole(res.getString("userRole"));
				user.setUserId(res.getInt("userId"));
				user.setUserEmail(res.getString("userEmail"));	
				user.setUserCredits(res.getInt("userCredits"));
				listOfUsers.add(user);
			}
			
		} 
		catch (SQLException e) {
			System.out.println(e.toString());
		}
			return listOfUsers;
	}

}
