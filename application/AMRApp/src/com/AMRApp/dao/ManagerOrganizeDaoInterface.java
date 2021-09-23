package com.AMRApp.dao;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;

public interface ManagerOrganizeDaoInterface {

	
	public ArrayList<MeetingRoom> getAvailableMeetingRooms(Meeting m); 
	public  void storeUser(ArrayList<User> u, int meetingId);
	// add 2 exceptions NotEnoughCreditsException, MeetingRoomAlreadyBookedException.
	public int storeMeeting(Meeting m);
	public int getCreditsDao(User u);
	
	
}
