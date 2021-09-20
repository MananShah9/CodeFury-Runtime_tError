package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerHomePageDAO;
import com.AMRApp.dao.ManagerHomePageDAOInterface;
import com.AMRApp.factory.Factory;

public class ManagerHomePageService implements ManagerHomePageServiceInterface {

	ManagerHomePageDAOInterface mdao= null;
	public ManagerHomePageService()
	{
		//Factory obj= new Factory();
		//obj.getManagerDaoInstance();
		mdao= new ManagerHomePageDAO();
		
	}

	@Override
	public List<Meeting> listManagerMeeting(int user) {
		return mdao.getScheduledMeetings(user);
	}

}
