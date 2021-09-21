package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;

public interface ManagerOrganizeServiceInterface {

	public ArrayList<MeetingRoom> listValidMeetingRooms(Meeting m); 
	public ArrayList<User> searchUser(User u);
	
	// add 2 exceptions NotEnoughCreditsException, MeetingRoomAlreadyBookedException.
	public boolean saveMeetingService(Meeting m, ArrayList<User> memberList);
	public int getCredits(User u);
	
	
}
