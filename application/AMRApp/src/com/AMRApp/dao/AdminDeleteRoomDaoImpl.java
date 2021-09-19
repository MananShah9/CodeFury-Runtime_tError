package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AMRApp.utility.ConnectionManager;

public class AdminDeleteRoomDaoImpl implements AdminDeleteRoomDaoInterface {

	@Override
	public int deleteRoom(String roomName) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Connection con;

		try {
			con = ConnectionManager.getConnection(); // get connection to database

			con.setAutoCommit(false); // initiate transaction

			ps = con.prepareStatement("delete from MEETING_ROOM where unique_name = ?");

			ps.setString(1, roomName);

			if (!(ps.executeUpdate() > 0)) {

				con.rollback(); // roll back uncommitted changes

				return 0; // unsuccessful insertion
			}

			con.commit(); // commit transactions

			return 1; // successful deletion

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			ConnectionManager.closeConnection();
		}

		return 0;

	} // end of deleteRoom function

}
