package com.AMRApp.dao;

import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface AdminGetRoomDaoInterface {

	int getRoom(String room);
	public List<MeetingRoom> getAllRooms();
}
