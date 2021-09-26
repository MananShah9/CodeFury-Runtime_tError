package com.AMRApp.dao;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface MemberHomePageDAOInterface {

	public List<Meeting> getScheduledMemberMeetings(int user);

	public User MemberInfo(int userId);

	
}
