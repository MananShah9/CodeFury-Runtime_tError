package com.AMRApp.service;

import com.AMRApp.beans.User;
import com.AMRApp.dao.UserDAOInterface;
import com.AMRApp.factory.UserDAOFactory;

public class UserService implements UserServiceInterface {
	
	private UserDAOInterface User_object;
	
public UserService () {
		
		User_object = UserDAOFactory.createObject ();
		
	}
	@Override
	public User userLogin(User user) {
		return User_object.logInUser ( user );
	}
}
