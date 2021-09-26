package com.AMRApp.dao;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.utility.ConnectionManager;

public class AdminGetRoomDaoImpl implements AdminGetRoomDaoInterface {
	PreparedStatement ps;
	Connection con=null;
	@Override
	public int getRoom(String roomName) {

		try  { 
			con = ConnectionManager.getConnection() ; //connection to database
			
			//query to select room name
			ps = con.prepareStatement ( "select  meetingRoomName from MeetingRoom where meetingRoomName = ?" );
			
			ps.setString ( 1, roomName);
			
			ResultSet rs = ps.executeQuery ();
			
			if ( rs.next () ) {
				
				return 0;
			}
			
			return 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionManager.closeConnection(); //close connection
		}
		return 0;
	}
	
	public List<MeetingRoom> getAllRooms(){
		con = ConnectionManager.getConnection() ;
		List<MeetingRoom> list = new ArrayList();
		try {
			
			ps = con.prepareStatement ( "select * from MeetingRoom" );
			ResultSet rs = ps.executeQuery();
			MeetingRoom room = null;
			while(rs.next()) {
				room = new MeetingRoom();
				room.setRoomName(rs.getString(1));
				room.setRoomCapacity(rs.getInt(2));
				room.setRoomPerHourCost(rs.getInt(4));
				room.setOrganiser(rs.getString(5));
				
				list.add(room);
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
