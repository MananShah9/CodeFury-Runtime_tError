package com.AMRApp.factory;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */

import com.AMRApp.dao.AdminEditRoomDaoImpl;
import com.AMRApp.dao.AdminEditRoomDaoInterface;
import com.AMRApp.service.AdminEditRoomServiceImpl;
import com.AMRApp.service.AdminEditRoomServiceInterface;

public class AdminEditRoomFactory {

	public static AdminEditRoomServiceInterface createServiceObject() {
		return new AdminEditRoomServiceImpl();

	}

	public static AdminEditRoomDaoInterface createDaoObject() {
		
		return new AdminEditRoomDaoImpl();
	}

}
