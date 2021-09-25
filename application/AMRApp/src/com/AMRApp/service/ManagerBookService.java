package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerBookDAO;
import com.AMRApp.dao.ManagerBookDAOInterface;
import com.AMRApp.factory.ManagerFactory;

public class ManagerBookService implements ManagerBookServiceInterface {
	
	ManagerBookDAOInterface mbd;	
	
	public ManagerBookService() {
		
		mbd = new ManagerFactory().getDaoInstanceBook();
	}


	@Override
	public int saveMeetingService(Meeting m) {
		return mbd.storeMeeting(m);
	}
	
	@Override
	public  void saveUser(ArrayList<String> u,int meetingId) {
		mbd.storeUser(u, meetingId);
	}


	@Override
	public void saveBookingInfo(Meeting m, String meetingRoomName, int managerId) {
		mbd.storeBookingInfo(m, meetingRoomName, managerId);
	}


	@Override
	public void decreaseManagerCredits(Meeting m, String meetingRoomName) {
		mbd.decreaseUserCredits(m,meetingRoomName);
		
	}
}
