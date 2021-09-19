package com.AMRApp.factory;

import com.AMRApp.dao.AdminDeleteRoomDaoInterface;
import com.AMRApp.service.AdminDeleteRoomServiceImpl;
import com.AMRApp.service.AdminDeleteRoomServiceInterface;

public class AdminDeleteRoomFactory {

	public static AdminDeleteRoomServiceInterface createObject() {
		// TODO Auto-generated method stub
		return new AdminDeleteRoomServiceImpl ();
	}

	public static AdminDeleteRoomDaoInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new AdminDeleteRoomDaoImpl();
	}

}
