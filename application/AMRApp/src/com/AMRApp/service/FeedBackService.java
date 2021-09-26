package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.dao.FeedBackDAO;
import com.AMRApp.dao.FeedBackDAOInterface;

public class FeedBackService implements FeedBackServiceInterface {

	FeedBackDAOInterface fdao;
	
	
	public FeedBackService() {
		fdao = new FeedBackDAO();
	}


	@Override
	public List<MeetingRoom> getAllMeetRooms() {
		return fdao.getMeetRooms();
	}


	@Override
	public void calculateRatings(String mr, int userId, int rating) {
		// TODO Auto-generated method stub
		fdao.calculateRatings(mr, userId, rating);
	}

}
