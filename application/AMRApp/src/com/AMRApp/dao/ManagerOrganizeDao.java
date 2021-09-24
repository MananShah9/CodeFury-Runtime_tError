package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class ManagerOrganizeDao implements ManagerOrganizeDaoInterface {
	static PreparedStatement pList,pgetById;
	static Connection con;

	@Override
	public ArrayList<MeetingRoom> getAvailableMeetingRooms(Meeting m, int noOfMembers,int duration) {
		ArrayList<MeetingRoom> mlist= new ArrayList<MeetingRoom>();
		
		try {
			con = ConnectionManager.getConnection();
			String query="";
			if(m.getMeetingType().equals("Classroom Training"))
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.whiteBoard=1 and a.projector=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in "
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?) and (select u.userCredits from user u where u.userId=?)> mr.perHourCost * ?";
			else if(m.getMeetingType().equals("Online Training"))
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.wifi=1 and a.projector=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in"
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?) and (select u.userCredits from user u where u.userId=?)> mr.perHourCost * ?";
			else if(m.getMeetingType().equals("Conference Call"))
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.conCall=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in"
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?) and (select u.userCredits from user u where u.userId=?)> mr.perHourCost * ?";
			else
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.projector=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in"
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?) and (select u.userCredits from user u where u.userId=?)> mr.perHourCost * ?";
			pList=con.prepareStatement(query);
			
			MeetingRoom mr=null;
			pList.setInt(1, noOfMembers);
			pList.setString(2, m.getMeetingDate());
			pList.setString(3, m.getEndTime());
			pList.setString(4, m.getStartTime());
			pList.setInt(5, m.getOrganiserId());
			pList.setInt(6, duration);
			
			System.out.println(m.toString()+noOfMembers+duration);
			
			ResultSet rs=pList.executeQuery();

			while(rs.next())
			{
				mr=new MeetingRoom();
				mr.setRoomName(rs.getString(1));				
				mr.setRoomCapacity(rs.getInt(2));
				mr.setRoomRating(rs.getInt(3));
				mr.setRoomPerHourCost(rs.getInt(4));
				mlist.add(mr);
				System.out.println(mr.toString());
			}
			
//			int managerId=m.getOrganiserId();
//			pgetById=con.prepareStatement("select userCredits from user where userId=?");
//			pgetById.setInt(1, managerId);
//			ResultSet rs2=pgetById.executeQuery();
//			int managerCredits=0;
//			while(rs.next())
//			{
//				managerCredits=rs.getInt(1);
//			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mlist;
	}



}
