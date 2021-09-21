package com.AMRApp.dao;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;

public interface ManagerOrganizeDaoInterface {

	
	public ArrayList<MeetingRoom> getAvailableMeetingRooms(Meeting m); 
	public ArrayList<User> findUser(User u);
	
	// add 2 exceptions NotEnoughCreditsException, MeetingRoomAlreadyBookedException.
	public boolean storeMeeting(Meeting m, ArrayList<User> memberList);
	public int getCreditsDao(User u);
	
}
