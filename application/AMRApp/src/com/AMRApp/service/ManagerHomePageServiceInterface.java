package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface ManagerHomePageServiceInterface {
	
	public List<Meeting> listManagerMeeting(int user);	
	
	public User ManagerInfo(int userId);
	
}
