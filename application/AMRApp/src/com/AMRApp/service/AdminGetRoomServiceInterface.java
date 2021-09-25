package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface AdminGetRoomServiceInterface {
	public int getRoom(String room);
	public List<MeetingRoom> getAllRooms();
}
