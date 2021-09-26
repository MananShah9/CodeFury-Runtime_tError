package com.AMRApp.service;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
import java.util.List;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.dao.AdminEditRoomDaoInterface;
import com.AMRApp.factory.AdminEditRoomFactory;

public class AdminEditRoomServiceImpl implements AdminEditRoomServiceInterface{

	private AdminEditRoomDaoInterface dao;

	public AdminEditRoomServiceImpl() {

		dao = AdminEditRoomFactory.createDaoObject();
	}
	@Override
	public int editRoom(MeetingRoom room) {
		
		return dao.editRoom(room);
	}
	

}
