package com.AMRApp.service;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */

import java.util.List;

import com.AMRApp.beans.MeetingRoom;

import com.AMRApp.dao.AdminCreateRoomDaoInterface;
import com.AMRApp.factory.*;


public class AdminCreateRoomServiceImpl implements AdminCreateRoomServiceInterface {
	private AdminCreateRoomDaoInterface dao;

	public AdminCreateRoomServiceImpl() {

		dao = AdminCreateRoomFactory.createDaoObject();
	}

	@Override
	public int createRoom(MeetingRoom entity) {
		return dao.createRoom(entity);
		}

	

}
