package com.AMRApp.service;

import java.util.ArrayList;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.User;

public interface ManagerBookServiceInterface {

	
	public int saveMeetingService(Meeting m);

	public  void saveUser(ArrayList<String> members,int meetingId);	

	
}
