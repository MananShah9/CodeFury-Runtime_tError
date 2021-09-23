package com.AMRApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.AMRApp.beans.User;
import com.AMRApp.utility.ConnectionManager;

public class ImportUsersServiceDAOImpl implements ImportUsersServiceDAOInterface {
	static PreparedStatement pList;
	static Connection con;

	@Override
	public boolean importUsers(List<User> listOfUsers) {
		try {

			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);

			pList = con.prepareStatement(
					"INSERT INTO user (userName,userEmail,userPhone,userRole,userCredits,userPass)VALUES (?,?,?,?,?,?)");

			for (User user : listOfUsers) {
				// Add each parameter to the row.
				pList.setString(1, user.getUserName());
				pList.setString(2, user.getUserEmail());
				pList.setString(3, user.getUserPhone());
				pList.setString(4, user.getUserRole());
				pList.setInt(5, user.getUserCredits());
				pList.setString(6, user.getUserPass());

				// Add row to the batch.
				pList.addBatch();
			}
			pList.executeBatch();

			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
