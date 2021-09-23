package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerOrganizeDao;
import com.AMRApp.dao.ManagerOrganizeDaoInterface;

public class ManagerOrganizeService implements ManagerOrganizeServiceInterface {
	ManagerOrganizeDaoInterface mod;
	public ManagerOrganizeService() {
		mod=new ManagerOrganizeDao();
		
	}

	@Override
	public ArrayList<MeetingRoom> listValidMeetingRooms(Meeting m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  void saveUser(ArrayList<User> u,int meetingId) {
		// TODO Auto-generated method stub
		mod.storeUser(u, meetingId);
	}

	@Override
	public int saveMeetingService(Meeting m) {
		return mod.storeMeeting(m);
	}

	@Override
	public int getCredits(User u) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
