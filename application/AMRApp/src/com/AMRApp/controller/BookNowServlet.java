package com.AMRApp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.service.ManagerBookService;
import com.AMRApp.service.ManagerBookServiceInterface;


@WebServlet("/BookNowServlet")
public class BookNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<MeetingRoom> mlist = (ArrayList<MeetingRoom>) request.getAttribute("meetingRoomList");
		
		Meeting m = (Meeting) request.getAttribute("meetingInfo");
				
		ArrayList<String> meetParticipants = (ArrayList<String>) request.getAttribute("meetParticipants");
		
		ManagerBookServiceInterface mBook = new ManagerBookService();
		
		int meetingId = mBook.saveMeetingService(m);	
		
		mBook.saveUser(meetParticipants, meetingId);
		
		
		mBook.saveBookingInfo(mlist,m);
		
		
		
		
		
	}

}
