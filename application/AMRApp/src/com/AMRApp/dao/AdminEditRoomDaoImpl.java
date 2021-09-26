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

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.utility.ConnectionManager;

public class AdminEditRoomDaoImpl implements AdminEditRoomDaoInterface {

	@Override
	public int editRoom(MeetingRoom room) {
		PreparedStatement ps;
		Connection con = null;

		try { 
			con = ConnectionManager.getConnection(); // get connection to database

			con.setAutoCommit(false); // initiate transaction
			int credits = 0;
			
			//query to update the room's amenities
			ps = con.prepareStatement("update Amenities set projector = ?,wifi = ?,conCall = ?,whiteboard = ?,waterDispenser = ?,TV = ?,Coffee = ? where meetingRoomName = ?");
			ps.setInt(1, 0);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			
			for (String temp : room.getRoomAmenities()) {

				switch (temp) {
				case "Projector":

					ps.setInt(1, 1);
					credits+=5;
					break;
				case "WiFi Connection":

					ps.setInt(2, 1);
					credits+=10;
					break;
				case "Conference call facility":

					ps.setInt(3, 1);
					credits+=15;
					break;
				case "Whiteboard":
					ps.setInt(4, 1);
					credits+=5;
					break;
				case " Water dispenser":
					ps.setInt(5, 1);
					credits+=5;
					break;
					
				case "TV":
					credits+=10;
					ps.setInt(6, 1);
					break;
					
				case "Coffee Machine":
					
					ps.setInt(7, 1);
					credits+=10;
					break;
				}
			}
			ps.setString(8, room.getRoomName());
			ps.executeUpdate();
			
			if(room.getRoomCapacity()<=5) {
				credits=0+credits;
			}
			else if(5<room.getRoomCapacity() && room.getRoomCapacity()<=10) {
				credits+=10;
			}
			else {
				credits+=20;
			}
			
			room.setRoomPerHourCost(credits);
			
			String query = "update MeetingRoom set seatingCapacity = ?,perHourCost = ? where meetingRoomName = ?";
			ps = con.prepareStatement(query);
			
			ps.setInt(1,room.getRoomCapacity());
			ps.setInt(2,room.getRoomPerHourCost());
			ps.setString(3,room.getRoomName());

			if (ps.executeUpdate() > 0) {

				con.commit(); // commit transactions

				return 1;
			}

			

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection();
		}
		return 1;

	}

}
