package com.AMRApp.dao;

import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface FeedBackDAOInterface {
	
	public List<MeetingRoom> getMeetRooms();

	public void calculateRatings(String mr, int userId, int ratings);
		
		
}
