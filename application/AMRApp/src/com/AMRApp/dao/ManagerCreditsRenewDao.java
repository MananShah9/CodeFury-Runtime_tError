package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AMRApp.beans.Meeting;
import com.AMRApp.utility.ConnectionManager;

public class ManagerCreditsRenewDao implements ManagerCreditsRenewDaoInterface {

	static PreparedStatement pList;
	static Connection con;
	
	@Override
	public void renewCredits() {
		// TODO Auto-generated method stub
		
		try {
			con = ConnectionManager.getConnection();
			pList=con.prepareStatement("update user set userCredits=2000 where userRole='Manager'");
		
			
			pList.executeUpdate();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
