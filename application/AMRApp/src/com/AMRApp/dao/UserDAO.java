package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class UserDAO implements UserDAOInterface {

	private Connection con;

	public UserDAO() {
		try {
		con = ConnectionManager.getConnection();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

	@Override
	public User logInUser(User user) {
		// TODO Auto-generated method stub
		try {

			// prepare query

			PreparedStatement ps = con.prepareStatement("select * from user where userId = ? and userPass = ?");

			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserPass());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUserId(rs.getInt(1));

				user.setUserName(rs.getString(2));
				user.setUserEmail(rs.getString(3));

				user.setUserPhone(rs.getString(4));
				user.setUserRole(rs.getString(5));
				user.setUserCredits(rs.getInt(6));
				return user;
			}

		} catch (SQLException e) {

			System.out.println(e);
		}

//		finally {
//
//			ConnectionManager.closeConnection();
//		}

		return null;

	}

	@Override
	public void manageCreditsDao(int userId) {
		// TODO Auto-generated method stub
		try {

			con.setAutoCommit(false); 


			PreparedStatement ps = con
					.prepareStatement("select next_Renewal_Date from credit_renewal where user_id = ?");

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Timestamp currentTimestamp = Timestamp.from(Instant.now()); // current date

				Timestamp renewalDate = Timestamp.valueOf(rs.getString(1)); // get renewal date

				if (currentTimestamp.after(renewalDate)) { // check if current date is past renewal date

					// if passed renewal date update credits

					ps = con.prepareStatement("update users set credits = 2000 where user_id = ?");
					ps.setInt(1, userId);

					if (!(ps.executeUpdate() > 0)) {

						con.rollback(); // roll back uncommitted changes

						return;
					}

					// set next renewal date

					ps = con.prepareStatement("update CREDIT_RENEWAL set next_Renewal_Date = ? where user_id = ?");
					//ps.setString(1, DateTimeManipulation.addDays(renewalDate, 7).toString());
					ps.setInt(2, userId);

					if (!(ps.executeUpdate() > 0)) {

						con.rollback(); // roll back uncommitted changes

						return;
					}

				}
			}

			con.commit(); // commit transactions

		} catch (SQLException sql) {

			sql.printStackTrace();
		}

		finally {

			ConnectionManager.closeConnection();

		}

	}

}
