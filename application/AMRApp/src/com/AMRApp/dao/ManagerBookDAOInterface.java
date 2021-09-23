package com.AMRApp.dao;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface ManagerBookDAOInterface {

	public  void storeUser(ArrayList<String> u, int meetingId);
	// add 2 exceptions NotEnoughCreditsException, MeetingRoomAlreadyBookedException.
	public int storeMeeting(Meeting m);
	
}
