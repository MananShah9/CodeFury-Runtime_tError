package com.AMRApp.factory;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
import com.AMRApp.dao.UserDAO;
import com.AMRApp.dao.UserDAOInterface;

public class UserDAOFactory {

	public static UserDAOInterface createObject() {
		return new UserDAO ();
	}

}
