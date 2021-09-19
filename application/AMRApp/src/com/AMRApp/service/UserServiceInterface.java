package com.AMRApp.service;

import com.AMRApp.beans.User;

public interface UserServiceInterface {

	User userLogin(User user);

	void manageCredits(int userId);

}
