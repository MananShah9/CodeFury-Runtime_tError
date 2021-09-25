package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.utility.ConnectionManager;

public class AdminCreateRoomDaoImpl implements AdminCreateRoomDaoInterface {

	@Override
	public int createRoom(MeetingRoom room) {
		PreparedStatement ps,psm;
		Connection con = null;
		try {
			System.out.println("Try tk phuch rha hai");
			
			con = ConnectionManager.getConnection(); // get connection to database


			int credits = 0; // to calculate per hour cost(setting credit to zero)
		 
			//Inserting into meeting room table
			
			String query = "insert into MeetingRoom(meetingRoomName, seatingCapacity,ratings, organiser) values(?,?,?,?)";
			psm = con.prepareStatement(query);
			
			psm.setString(1,room.getRoomName());
			psm.setInt(2,room.getRoomCapacity());
			psm.setInt(3,room.getRoomRating());
		
			psm.setString(4,room.getOrganiser());
			
			psm.executeUpdate();
			System.out.println("Fuck this shit 1");	
			//con.commit();
			
			System.out.println("In Dao");
			for (String name : room.getRoomAmenities()) {
				System.out.println(name);
			}
			
			//query to insert amenities into table
			query = "insert into Amenities(projector,wifi,conCall,whiteboard,waterDispenser,TV,Coffee,meetingRoomName) values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
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
			
			//Update perHourCost
			query="Update MeetingRoom set perHourCost=? where meetingRoomName=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,room.getRoomPerHourCost());
			ps.setString(2,room.getRoomName());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Catch me ja rha hai bc");
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.closeConnection();
			
		}

		return 1;

	}


}
