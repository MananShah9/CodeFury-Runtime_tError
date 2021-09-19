package com.AMRApp.service;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.dao.AdminEditRoomDaoInterface;
import com.AMRApp.dao.AdminGetRoomDaoInterface;
import com.AMRApp.factory.AdminGetRoomFactory;
public class AdminGetRoomServiceImpl implements AdminGetRoomServiceInterface{

	private AdminGetRoomDaoInterface dao;

	public AdminGetRoomServiceImpl() {

		dao = AdminGetRoomFactory.createDaoObject();
	}

	@Override
	public int getRoom(String room) {
		
		return dao.getRoom(room);
	}
	
	

}
