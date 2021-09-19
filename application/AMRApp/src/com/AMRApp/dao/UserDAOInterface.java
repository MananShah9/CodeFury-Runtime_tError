package com.AMRApp.dao;

import com.AMRApp.beans.User;

public interface UserDAOInterface {

	User logInUser(User user);

	void manageCreditsDao(int userId);

}
