package com.AMRApp.service;

import com.AMRApp.dao.AdminCreateRoomDaoInterface;
import com.AMRApp.dao.AdminDeleteRoomDaoInterface;
import com.AMRApp.factory.AdminDeleteRoomFactory;

public class AdminDeleteRoomServiceImpl implements  AdminDeleteRoomServiceInterface{

	private AdminDeleteRoomDaoInterface dao;

	public AdminDeleteRoomServiceImpl() {

		dao = AdminDeleteRoomFactory.createDaoObject();
	}
	@Override
	public int deleteRoom(String roomName) {
		return dao.deleteRoom(roomName);
	}

}
