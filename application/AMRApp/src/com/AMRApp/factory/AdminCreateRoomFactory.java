package com.AMRApp.factory;

import com.AMRApp.dao.AdminCreateRoomDaoImpl;
import com.AMRApp.dao.AdminCreateRoomDaoInterface;
import com.AMRApp.service.AdminCreateRoomServiceImpl;
import com.AMRApp.service.AdminCreateRoomServiceInterface;
public class AdminCreateRoomFactory {

	public static AdminCreateRoomServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new AdminCreateRoomServiceImpl ();

	}

	public static AdminCreateRoomDaoInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new AdminCreateRoomDaoImpl ();

	}
}
