package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.utility.ConnectionManager;

public class FeedBackDAO implements FeedBackDAOInterface {

	static PreparedStatement pList, ps1,ps2,ps3;
	static Connection con;
	
	
	@Override
	public List<MeetingRoom> getMeetRooms() {
		// TODO Auto-generated method stub
		
		List<MeetingRoom> meetingRoomList= new ArrayList();
		try {
			con = ConnectionManager.getConnection();
			pList=con.prepareStatement("select * from meetingroom");
		
			MeetingRoom m=null;
			
			ResultSet rs=pList.executeQuery();

			while(rs.next())
			{
				m=new MeetingRoom();
				
				m.setRoomName(rs.getString(1));
				m.setRoomCapacity(rs.getInt(2));
				m.setRoomRating(rs.getInt(3));
				m.setRoomPerHourCost(rs.getInt(4));
				m.setOrganiser(rs.getString(5));
				
				meetingRoomList.add(m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return meetingRoomList;
		
		
	}


	@Override
	public void calculateRatings(String mr,int userId, int currRatings) {
		// TODO Auto-generated method stub
		try {
		con = ConnectionManager.getConnection();
		
		String query1 = "insert into feedback(meetingRoomName,userId,rating) values (?,?,?)";
		String query2= "select meetingRoomName,rating from feedback where meetingRoomName=?";
		String query3 = "update meetingroom set ratings=? where meetingRoomName=?";
		
		ps1 = con.prepareStatement(query1);
		
		ps1.setString(1,mr);
		ps1.setInt(2,userId);
		ps1.setInt(3,currRatings);
		
		ps1.executeUpdate();
		
		ps2 = con.prepareStatement(query2);
		ps2.setString(1, mr);
		
		ResultSet rs = 	ps2.executeQuery();
		
		
		int freq=0;
		
		int uptilNow=0;
		
		while(rs.next())
		{
			uptilNow+=rs.getInt(2);
			freq+=1;
		}
		
		int newRating = (int)Math.ceil((uptilNow+currRatings)/freq);
		
		ps3 = con.prepareStatement(query3);
		
		ps3.setInt(1, newRating);
		ps3.setString(2, mr);
		
		ps3.executeUpdate();
		
		
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
