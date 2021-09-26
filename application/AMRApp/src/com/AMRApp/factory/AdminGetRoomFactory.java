package com.AMRApp.factory;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
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
