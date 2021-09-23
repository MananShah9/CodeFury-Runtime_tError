package com.AMRApp.service;
import java.util.List;

import com.AMRApp.beans.User;
public interface ImportUsersServiceInterface {
	public boolean importUsers( List<User> listOfUsers);
}
