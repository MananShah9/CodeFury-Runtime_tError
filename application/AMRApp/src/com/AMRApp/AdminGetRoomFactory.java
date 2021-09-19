package com.AMRApp.factory;

import com.AMRApp.dao.AdminGetRoomDaoImpl;
import com.AMRApp.dao.AdminGetRoomDaoInterface;
import com.AMRApp.service.AdminGetRoomServiceImpl;
import com.AMRApp.service.AdminGetRoomServiceInterface;

public class AdminGetRoomFactory {

	public static AdminGetRoomServiceInterface createServiceObject() {

		return new AdminGetRoomServiceImpl();
	}

	public static AdminGetRoomDaoInterface createDaoObject() {

		return new AdminGetRoomDaoImpl();
	}

}
