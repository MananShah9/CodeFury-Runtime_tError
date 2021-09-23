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
	static PreparedStatement pList;
	static Connection con;

	@Override
	public ArrayList<MeetingRoom> getAvailableMeetingRooms(Meeting m, int noOfMembers) {
		ArrayList<MeetingRoom> mlist= new ArrayList<MeetingRoom>();
		try {
			con = ConnectionManager.getConnection();
			String query="";
			if(m.getMeetingType().equals("Classroom Training"))
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.whiteBoard=1 and a.projector=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in "
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?)";
			else if(m.getMeetingType().equals("Online Training"))
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.wifi=1 and a.projector=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in"
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?)";
			else if(m.getMeetingType().equals("Conference Call"))
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.conCall=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in"
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?)";
			else
				query="SELECT mr.meetingRoomName,mr.seatingCapacity, mr.ratings, mr.perHourCost from MeetingRoom mr, Amenities a where "
						+ "a.meetingRoomName=mr.meetingRoomName and a.projector=1 and mr.seatingCapacity>= ? and mr.meetingRoomName not in"
						+"(Select meetingRoomName from BookingInfo bi where bi.bookingDate= ? and bi.startTime < ? and bi.endTime > ?)";
			pList=con.prepareStatement(query);
		
			MeetingRoom mr=null;
			pList.setInt(1, noOfMembers);
			pList.setString(2, m.getMeetingDate());
			pList.setString(3, m.getEndTime());
			pList.setNString(4, m.getStartTime());
			ResultSet rs=pList.executeQuery();

			while(rs.next())
			{
				mr=new MeetingRoom();
				mr.setRoomName(rs.getString(1));				
				mr.setRoomCapacity(rs.getInt(2));
				mr.setRoomRating(rs.getInt(3));
				mr.setRoomPerHourCost(rs.getInt(4));
				mlist.add(mr);
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
	public int getCreditsDao(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
