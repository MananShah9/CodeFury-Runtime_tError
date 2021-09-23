package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.MeetingRoom;

public interface ManagerDisplayRoomInterface {
	public List<MeetingRoom> checkTimeClashes(String meetingDate,String meetingStartTime,String meetingEndTime,String meetingType);
}
