package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.User;
import com.AMRApp.dao.ImportUsersServiceDAOImpl;
import com.AMRApp.dao.ImportUsersServiceDAOInterface;

public class ImportUsersServiceImpl implements ImportUsersServiceInterface {
	ImportUsersServiceDAOInterface importUserDAO= new ImportUsersServiceDAOImpl();
	@Override
	public boolean importUsers(List<User> listOfUsers) {
		return importUserDAO.importUsers(listOfUsers);
	}

}
