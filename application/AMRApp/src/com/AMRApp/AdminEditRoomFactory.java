package com.AMRApp.factory;

import com.AMRApp.dao.AdminEditRoomDao;
import com.AMRApp.dao.AdminEditRoomDaoImpl;
import com.AMRApp.dao.AdminEditRoomDaoInterface;
import com.AMRApp.service.AdminEditRoomServiceImpl;
import com.AMRApp.service.AdminEditRoomServiceInterface;

public class AdminEditRoomFactory {

	public static AdminEditRoomServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new AdminEditRoomServiceImpl();

	}

	public static AdminEditRoomDaoInterface createDaoObject() {
		
		return new AdminEditRoomDaoImpl();
	}

}
