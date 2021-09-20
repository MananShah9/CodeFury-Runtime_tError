package com.AMRApp.factory;

import com.AMRApp.dao.UserDAO;
import com.AMRApp.dao.UserDAOInterface;

public class UserDAOFactory {

	public static UserDAOInterface createObject() {
		
		return new UserDAO ();
	}

}
