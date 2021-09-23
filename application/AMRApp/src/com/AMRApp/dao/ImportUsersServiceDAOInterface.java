package com.AMRApp.dao;

import java.util.List;

import com.AMRApp.beans.User;

public interface ImportUsersServiceDAOInterface {
	public boolean importUsers(List<User> listOfUsers) ;
}
