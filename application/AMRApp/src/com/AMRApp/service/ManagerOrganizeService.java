package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;
import com.AMRApp.dao.ManagerOrganizeDao;
import com.AMRApp.dao.ManagerOrganizeDaoInterface;
import com.AMRApp.factory.ManagerFactory;

public class ManagerOrganizeService implements ManagerOrganizeServiceInterface {
	ManagerOrganizeDaoInterface mod;
	public ManagerOrganizeService() {
		mod = new ManagerFactory().getDaoInstanceOrganize();
	}

	@Override
	public ArrayList<MeetingRoom> listValidMeetingRooms(Meeting m, int nom,int duration) {
		return  mod.getAvailableMeetingRooms(m, nom,duration);
	}
}
