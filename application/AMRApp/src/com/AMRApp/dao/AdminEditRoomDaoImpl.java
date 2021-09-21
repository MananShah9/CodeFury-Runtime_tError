package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.utility.ConnectionManager;

public class AdminEditRoomDaoImpl implements AdminEditRoomDaoInterface {

	@Override
	public int editRoom(MeetingRoom room) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Connection con = null;

		try { // get connection to database
			con = ConnectionManager.getConnection();

			con.setAutoCommit(false); // initiate transaction

			int per_hour_cost = 0; // to calculate per hour cost

			// edit existing meeting room details

			ps = con.prepareStatement("update MEETING_ROOM set seating_capacity = ? where unique_name = ?");

			ps.setInt(1, room.getRoomCapacity());
			ps.setString(2, room.getRoomName());

			if (!(ps.executeUpdate() > 0)) {

				con.rollback(); // roll back uncommitted changes

				return 0; // unsuccessful insertion
			}

			// prepare query to delete data from room_amenities

			ps = con.prepareStatement("delete from ROOM_AMENITIES where meeting_room_id = ?");

			ps.setString(1, room.getRoomName());

			if (!(ps.executeUpdate() > 0)) {

				con.rollback(); // roll back uncommitted changes

				return 0; // successful insertion
			}

			// insert new amenities

			for (String temp : room.getRoomAmenities()) {

				// prepare query to enter data into ROOM AMENITIES database

				ps = con.prepareStatement("insert into ROOM_AMENITIES values (?, ?)");

				ps.setString(1, room.getRoomName());
				ps.setString(2, temp);

				if (!(ps.executeUpdate() > 0)) {

					con.rollback(); // roll back uncommitted changes

					return 0; // return 0 if unsuccessful insertion
				}
			}

			// get cost from table for new amenities

			int size = room.getRoomAmenities().size();
			size--;

			String query = "select SUM(credit) from amenities where ";

			for (String temp : room.getRoomAmenities()) {

				query = query + "id = " + temp;

				if (size != 0) {

					query = query + " or ";
					size--;
				}
			}

			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery(); // get cost

			if (rs.next()) {

				per_hour_cost = rs.getInt(1);

			} else {

				con.rollback(); // roll back uncommitted changes

				return 0;
			}

			if (room.getRoomCapacity() > 5 && room.getRoomCapacity() <= 10) {

				per_hour_cost += 10;

			} else if (room.getRoomCapacity() > 10) {

				per_hour_cost += 20;
			}

			// prepare query to enter data into ROOM AMENITIES database

			ps = con.prepareStatement("update MEETING_ROOM set per_hour_cost = " + per_hour_cost
					+ "  where unique_name = '" + room.getRoomName() + "'");

			if (ps.executeUpdate() > 0) {

				con.commit(); // commit transactions

				return 1; // return on success
			}

		} catch (SQLException  e) {

			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection();
		}
		return 0;

	}

}
