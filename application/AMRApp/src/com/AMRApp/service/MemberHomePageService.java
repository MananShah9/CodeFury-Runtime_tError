package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerHomePageDAOInterface;
import com.AMRApp.dao.MemberHomePageDAO;
import com.AMRApp.dao.MemberHomePageDAOInterface;

public class MemberHomePageService implements MemberHomePageServiceInterface {

	MemberHomePageDAOInterface mdao= null;

	public MemberHomePageService()
	{
		
		mdao = new MemberHomePageDAO();
		
	}
	
	
	@Override
	public List<Meeting> listMemberMeeting(int user) {
		// TODO Auto-generated method stub
		return mdao.getScheduledMemberMeetings(user);
	}


	

	@Override
	public User MemberInfo(int userId) {
		return mdao.MemberInfo(userId);
	}
	
	
}
