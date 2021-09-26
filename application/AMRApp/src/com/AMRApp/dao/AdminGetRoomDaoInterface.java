package com.AMRApp.dao;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface AdminGetRoomDaoInterface {

	int getRoom(String room);
	public List<MeetingRoom> getAllRooms();
}
