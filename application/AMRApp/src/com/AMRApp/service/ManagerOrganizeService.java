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
	public ArrayList<MeetingRoom> listValidMeetingRooms(Meeting m, int nom,int duration) {
		return  mod.getAvailableMeetingRooms(m, nom,duration);
	}
}
