package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.beans.User;

public interface ManagerOrganizeServiceInterface {

	public ArrayList<MeetingRoom> listValidMeetingRooms(Meeting m, int nom, int duration); 
	// add 2 exceptions NotEnoughCreditsException, MeetingRoomAlreadyBookedException.
	
	
}
