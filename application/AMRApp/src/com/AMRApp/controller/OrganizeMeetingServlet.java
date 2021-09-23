package com.AMRApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AMRApp.beans.Meeting;
import com.AMRApp.service.ManagerOrganizeService;
import com.AMRApp.service.ManagerOrganizeServiceInterface;

/**
 * Servlet implementation class OrganizeMeetingServlet
 */
@WebServlet("/OrganizeMeetingServlet")
public class OrganizeMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String meetingType = request.getParameter("meetingType");
		String meetingTitle = request.getParameter("meetingTitle");
		String meetingDate = request.getParameter("meetingDate");
		String meetingStartTime = request.getParameter("startTime");
		String meetingEndTime = request.getParameter("endTime");
		String[] meetingMembers = request.getParameterValues("members");
		System.out.println("here");
		for (String member:meetingMembers)
			System.out.println(member);
		
		
		
		//Will come from session later
		int managerId=3; 
		Meeting m = new Meeting();
		m.setMeetingTitle(meetingTitle);
		m.setMeetingType(meetingType);
		m.setMeetingDate(meetingDate);
		m.setStartTime(meetingStartTime);
		m.setEndTime(meetingEndTime);
		m.setOrganiserId(managerId);
		
		ManagerOrganizeServiceInterface mOrganizeService = new ManagerOrganizeService();
		
		mOrganizeService.listValidMeetingRooms(m);
		
		//int meetingId = mOrganizeService.saveMeetingService(m);
		
		
		
//		
//		mOrganizeService.saveMeetingService(m, memberList);
//		
//		Meeting m = new Meeting();
		
		
	}

}
