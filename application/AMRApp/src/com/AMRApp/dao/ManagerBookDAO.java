package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class ManagerBookDAO implements ManagerBookDAOInterface{

	
	static PreparedStatement pList;
	static Connection con;

	
	@Override
	public void storeUser(ArrayList<String> memberId, int meetingId) {
		try {

			con = ConnectionManager.getConnection();
			
			pList = con.prepareStatement("INSERT INTO MeetingsandMembers (meetingId, memberId) VALUES(?,?)");

		/*	for (User user : users) {
				// Add each parameter to the row.
				pList.setInt(1, meetingId);
				pList.setInt(2, user.getUserId());
				// Add row to the batch.
				pList.addBatch();
			}
		*/
			for(String mId: memberId)
			{
				pList.setInt(1, meetingId);
				pList.setInt(2, Integer.parseInt(mId));
				// Add row to the batch.
				pList.addBatch();
			}
			
			try {
				pList.executeBatch();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int storeMeeting(Meeting m) {
		int id=0;
		try {


			PreparedStatement ps = con.prepareStatement("insert into meeting (meetingtitle, organisedBy,meetingDate,startTime,endTime,meetingType) VALUES(?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, m.getMeetingTitle());
			ps.setInt(2, m.getOrganiserId());
			ps.setString(3, m.getMeetingDate());
			ps.setString(4, m.getStartTime());
			ps.setString(5, m.getEndTime());
			ps.setString(6, m.getMeetingType());

			ps.executeQuery();

			ResultSet rs = ps.getGeneratedKeys(); // get the generated key
			while(rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {

			System.out.println(e);
			return -1;
		}

		return id;
	}

	
	
	
	
}
