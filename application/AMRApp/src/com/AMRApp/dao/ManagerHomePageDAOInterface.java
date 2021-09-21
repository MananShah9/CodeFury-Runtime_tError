package com.AMRApp.dao;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface ManagerHomePageDAOInterface {

	public List<Meeting> getScheduledMeetings(int user);

	public User ManagerInfo(int userId);
	
}
