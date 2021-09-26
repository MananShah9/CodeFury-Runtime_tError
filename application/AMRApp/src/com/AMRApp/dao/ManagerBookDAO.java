package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class ManagerBookDAO implements ManagerBookDAOInterface{

	
	static PreparedStatement pList;
	static Connection con;

	
	@Override
	public void storeUser(ArrayList<String> memberId, int meetingId) {
		try {

			System.out.println("in DAO->storeUser");
			con = ConnectionManager.getConnection();
			
			pList = con.prepareStatement("INSERT INTO MeetingsandMembers (meetingId, memberId) VALUES(?,?)");

			for(String mId: memberId)
			{
				pList.setInt(1, meetingId);
				pList.setInt(2, Integer.parseInt(mId));
				// Add row to the batch.
				pList.addBatch();
			}
			
			try
			{
				
				pList.executeBatch();

			}

			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			
			
		} catch (SQLException e) 
		{

			e.printStackTrace();
			
		} catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}

		System.out.println("out of DAO->storeUser");
	}

	@Override
	public int storeMeeting(Meeting m) {
		System.out.println("in DAO->storeMeeting");
		int id=0;
		try {

System.out.println(m.toString());
con=ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into meeting (meetingtitle, organisedBy,meetingDate,startTime,endTime,meetingType) VALUES(?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, m.getMeetingTitle());
			
			ps.setInt(2, m.getOrganiserId());
			
			ps.setString(3, m.getMeetingDate());
			
			ps.setString(4, m.getStartTime());
			
			ps.setString(5, m.getEndTime());
			
			ps.setString(6, m.getMeetingType());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys(); // get the generated key
			
			while(rs.next()) 
			{
				
				id = rs.getInt(1);
			
			}

		} catch (SQLException e)
		{

			System.out.println(e);
			
			return -1;
		}

		System.out.println("out of DAO->storeMeeting");
		return id;
	}

	@Override
	public void storeBookingInfo(Meeting m, String meetingRoomName, int managerId) 
	{
		System.out.println("in DAO->storeBookingInfo");
		System.out.println(m.toString());
		System.out.println(meetingRoomName);
		System.out.println(managerId);

		con=ConnectionManager.getConnection();
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into bookinginfo(meetingRoomName, BookingDate, startTime, endTime, organiserId) VALUES(?,?,?,?,?) ");

			ps.setString(1, meetingRoomName);
			
			ps.setString(2, m.getMeetingDate());
			
			ps.setString(3, m.getStartTime());
			
			ps.setString(4, m.getEndTime());
			
			ps.setInt(5, managerId);

			ps.executeUpdate();


		} catch (SQLException e) {

			System.out.println(e);
		}
		System.out.println("out of DAO->storeBookingInfo");
		
	}

	@Override
	public void decreaseUserCredits(Meeting m, String meetingRoomName) {
		con=ConnectionManager.getConnection();

	
    System.out.println(m.toString());
    System.out.println(meetingRoomName);
    System.out.println("+++++++++----------------+++++++++++++++++");
    try {
    	
    	int durationHours=Integer.parseInt(m.getEndTime().substring(0,2))-Integer.parseInt( m.getStartTime().substring(0,2));
    	
    	int durationMinutes=Integer.parseInt(m.getEndTime().substring(3))-Integer.parseInt( m.getStartTime().substring(3));
    	
    	if(durationMinutes!=0)
    		++durationHours;
	
    	String query="UPDATE User u set u.userCredits= u.userCredits - ((SELECT mr.perHourCost from MeetingRoom mr where mr.meetingRoomName = ? )* ?) "
    			+"where u.userId= ? ";
    	
    	pList=con.prepareStatement(query);
		
		pList.setString(1, meetingRoomName);
		
		pList.setInt(2, durationHours);
		
		pList.setInt(3, m.getOrganiserId());
		
    	pList.executeUpdate();
    	
    } catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}

	
	
	
	
}
