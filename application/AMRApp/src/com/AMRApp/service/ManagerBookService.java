package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerBookDAO;
import com.AMRApp.dao.ManagerBookDAOInterface;

public class ManagerBookService implements ManagerBookServiceInterface {
	
	ManagerBookDAOInterface mbd;
	
	
	
	public ManagerBookService() {
		super();
		mbd = new ManagerBookDAO();
	}


	@Override
	public int saveMeetingService(Meeting m) {
		return mbd.storeMeeting(m);
	}
	
	@Override
	public  void saveUser(ArrayList<String> u,int meetingId) {
		// TODO Auto-generated method stub
		mbd.storeUser(u, meetingId);
	}
}