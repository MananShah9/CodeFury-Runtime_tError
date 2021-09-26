package com.AMRApp.service;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface AdminGetRoomServiceInterface {
	public int getRoom(String room);
	public List<MeetingRoom> getAllRooms();
}
