package com.AMRApp.dao;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;

public class ManagerOrganizeDao implements ManagerOrganizeDaoInterface {

	@Override
	public ArrayList<MeetingRoom> getAvailableMeetingRooms(Meeting m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> findUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean storeMeeting(Meeting m, ArrayList<User> memberList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCreditsDao(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
