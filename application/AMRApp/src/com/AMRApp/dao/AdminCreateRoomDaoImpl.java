package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.utility.ConnectionManager;

public class AdminCreateRoomDaoImpl implements AdminCreateRoomDaoInterface{

	@Override
	public int createRoom(MeetingRoom entity) {
		PreparedStatement ps;
		Connection con = null;
		try  { 
			con = ConnectionManager.getConnection(); // get connection to database
			
			con.setAutoCommit(false); // initiate transaction
			
			int per_hour_cost = 0; // to calculate per hour cost			
			
				// prepare query to enter data into meeting_room database
			
			ps = con.prepareStatement ( "insert into MEETING_ROOM (unique_name, seating_capacity, per_hour_cost, total_meetings_conducted, created_by) values (?,?,?,?,?)" );
			
			ps.setString ( 1, entity.getRoomName () );
			ps.setInt ( 2, entity.getRoomCapacity() );
			
			ps.setInt ( 3, per_hour_cost );
			ps.setInt ( 4, 0 );
			
			ps.setString ( 5, entity.getOrganiser());			
			
			if ( !( ps.executeUpdate () > 0) ) {
				
				con.rollback(); // roll back uncommitted changes
			
				return 0; // insertion unsuccessful				
			}
			
				// insert into room_amenities all amenities
			
			for ( String temp : entity.getRoomAmenities() ) {
				
					// prepare query to enter data into ROOM AMENITIES database
				
				ps = con.prepareStatement ( "insert into ROOM_AMENITIES values (?, ?)" );
				
				ps.setString (1, entity.getRoomName ());
				ps.setString (2, temp);	
				
				if ( !( ps.executeUpdate () > 0 ) ) {
					
					con.rollback(); // roll back uncommitted changes
					
					return 0; // return 0 if unsuccessful insertion
				}
			}
			
				// get cost from table
			
			int size = entity.getRoomAmenities().size ();
			size--;
			
			String query = "select SUM(credit) from amenities where ";
			
			for ( String temp : entity.getRoomAmenities() ) {
				
				query = query + "id = " + temp;
				
				if ( size != 0 ) {
				
					query = query + " or ";
					size--;
				}
			}
			
			ps = con.prepareStatement ( query );
			
			ResultSet rs = ps.executeQuery ();	// get cost
			
			if ( rs.next () ) {
				
				per_hour_cost = rs.getInt ( 1 );
				
			} else {
				
				con.rollback(); // roll back uncommitted changes
				
				return 0;
			}
			
			if ( entity.getRoomCapacity() > 5 && entity.getRoomCapacity() <= 10 ) {
				
				per_hour_cost += 10;
			
			} else if ( entity.getRoomCapacity() > 10 ) {
				
				per_hour_cost += 20;
			}
			
				// 	prepare query to enter data into ROOM AMENITIES database
			
			ps = con.prepareStatement ( "update MEETING_ROOM set per_hour_cost = " + per_hour_cost + "  where unique_name = '" + entity.getRoomName () + "'" );
		
			if ( ps.executeUpdate () > 0 ) {
				
				con.commit(); // commit transactions
				
				return 1;
			}
			
			
		} catch (SQLException e ) {

			e.printStackTrace();
		}
		finally {
			ConnectionManager.closeConnection();
		}
		
		return 0;
	
		
	}
		
}
