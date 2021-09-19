package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AMRApp.utility.ConnectionManager;

public class AdminGetRoomDaoImpl implements AdminGetRoomDaoInterface {

	@Override
	public int getRoom(String room) {

		PreparedStatement ps;
		Connection con=null;
		
		try  { 
			con = ConnectionManager.getConnection() ;
			
			ps = con.prepareStatement ( "select unique_name from MEETING_ROOM where unique_name = ?" );
			
			ps.setString ( 1, room);
			
			ResultSet rs = ps.executeQuery ();
			
			if ( rs.next () ) {
				
				return 0;
			}
			
			return 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		finally {
			
			ConnectionManager.closeConnection();
		}
		return 0;
	}
}
