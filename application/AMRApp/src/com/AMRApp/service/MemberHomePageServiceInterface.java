package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface MemberHomePageServiceInterface {
	public List<Meeting> listMemberMeeting(int user);	

	public User MemberInfo(int userId);

	
}
