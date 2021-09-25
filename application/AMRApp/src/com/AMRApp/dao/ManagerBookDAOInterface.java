package com.AMRApp.dao;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface ManagerBookDAOInterface {

	public  void storeUser(ArrayList<String> u, int meetingId);
	public int storeMeeting(Meeting m);
	public void storeBookingInfo(Meeting m, String meetingRoomName, int managerId);
	public void decreaseUserCredits(Meeting m, String meetingRoomName);
	
}
