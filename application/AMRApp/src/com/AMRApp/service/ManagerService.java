package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerDAO;
import com.AMRApp.dao.ManagerDAOInterface;
import com.AMRApp.factory.Factory;

public class ManagerService implements ManagerServiceInterface {

	ManagerDAOInterface mdao= null;
	public ManagerService()
	{
		//Factory obj= new Factory();
		//obj.getManagerDaoInstance();
		mdao= new ManagerDAO();
		
	}

	@Override
	public List<Meeting> listManagerMeeting(int user) {
		return mdao.getScheduledMeetings(user);
	}

	@Override
	public User managerInformation(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
