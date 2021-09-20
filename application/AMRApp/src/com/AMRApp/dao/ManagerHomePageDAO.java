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

public class ManagerHomePageDAO implements ManagerHomePageDAOInterface {

	static PreparedStatement pList;
	static Connection con;
	//Connection con= ConnectionManager.getConnection();
    static {
    	
		try {
			con = ConnectionManager.getConnection();
			pList=con.prepareStatement("select m.meetingId, m.meetingtitle, m.meetingDate, m.startTime, m.endTime, m.meetingType from Meeting m where m.organisedBy=?");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
	
	@Override
	public List<Meeting> getScheduledMeetings(int user) {
		List<Meeting> mlist= new ArrayList();
		try {
			Meeting m=null;
			pList.setInt(1, user);
			ResultSet rs=pList.executeQuery();
			while(rs.next())
			{
				m=new Meeting();
				m.setMeetingId(rs.getInt(1));
				m.setMeetingTitle(rs.getString(2));				
				m.setMeetingDate(rs.getString(3));
				m.setStartTime(rs.getString(4));
				m.setEndTime(rs.getString(5));
				m.setMeetingType(rs.getString(6));
				mlist.add(m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mlist;
	}

}
