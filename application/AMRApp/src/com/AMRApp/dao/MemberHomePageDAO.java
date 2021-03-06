package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class MemberHomePageDAO implements MemberHomePageDAOInterface {

	static PreparedStatement pList;
	static Connection con;
	
	
	@Override
	public List<Meeting> getScheduledMemberMeetings(int userId) {
		// TODO Auto-generated method stub
	
		List<Meeting> mlist= new ArrayList();
		try {
			con = ConnectionManager.getConnection();
			pList=con.prepareStatement("select * from meeting,meetingsandmembers where meeting.meetingId = meetingsandmembers.meetingId and memberId = ?;");
		
			Meeting m=null;
			
			pList.setInt(1, userId);

			ResultSet rs=pList.executeQuery();

			while(rs.next())
			{
				m=new Meeting();
				m.setMeetingId(rs.getInt(1));
				m.setMeetingTitle(rs.getString(2));				
				m.setMeetingDate(rs.getString(4));
				m.setStartTime(rs.getString(5));
				m.setEndTime(rs.getString(6));
				m.setMeetingType(rs.getString(7));
				mlist.add(m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mlist;
		
		
		
		
	}


	@Override
	public User MemberInfo(int userId) {
		// TODO Auto-generated method stub
	
User user=null;
		
		//getting manager information
		
		PreparedStatement ps;
		try {
			con = ConnectionManager.getConnection();
			 ps = con.prepareStatement ( "select * from user where userId=?" );
			
			ps.setInt(1, userId);
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				//i=true;
				user =new User();
				user.setUserName(res.getString("userName"));
				user.setUserPhone(res.getString("userPhone"));
				user.setUserRole(res.getString("userRole"));
				user.setUserId(res.getInt("userId"));
				user.setUserEmail(res.getString("userEmail"));	
				user.setUserCredits(res.getInt("userCredits"));
			}
			
		} 
		catch (SQLException e) {

			//LOGR.error(e.toString());
			System.out.println(e.toString());
		}
					
		return user;
		
		
		
		
	}

}
