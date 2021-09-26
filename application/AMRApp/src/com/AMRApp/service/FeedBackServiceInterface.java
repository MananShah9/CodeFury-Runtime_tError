package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface FeedBackServiceInterface {

	public List<MeetingRoom> getAllMeetRooms();
	
	public void calculateRatings(String mr, int userId, int rating);
	
}
