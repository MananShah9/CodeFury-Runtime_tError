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

		try {
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

		return null;

	}

}
