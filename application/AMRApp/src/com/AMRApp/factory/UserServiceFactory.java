package com.AMRApp.factory;

import com.AMRApp.service.UserService;
import com.AMRApp.service.UserServiceInterface;

public class UserServiceFactory {

	public static UserServiceInterface createObject() {
		 return new UserService ();
	}

}
