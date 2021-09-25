package com.AMRApp.factory;

import com.AMRApp.dao.AdminCreateRoomDaoImpl;
import com.AMRApp.dao.AdminCreateRoomDaoInterface;
import com.AMRApp.service.AdminCreateRoomServiceImpl;
import com.AMRApp.service.AdminCreateRoomServiceInterface;
public class AdminCreateRoomFactory {

	public static AdminCreateRoomServiceInterface createServiceObject() {
		return new AdminCreateRoomServiceImpl ();

	}

	public static AdminCreateRoomDaoInterface createDaoObject() {
		return new AdminCreateRoomDaoImpl ();

	}
}
