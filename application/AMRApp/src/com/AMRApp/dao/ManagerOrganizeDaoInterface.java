package com.AMRApp.dao;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;

public interface ManagerOrganizeDaoInterface {

	
	public ArrayList<MeetingRoom> getAvailableMeetingRooms(Meeting m, int noOfMembers, int duration); 
	
	
	
}
