package com.AMRApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
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
		//will get duration from front-end
		int duration=2;
		
		System.out.println("here");
		List<String> temp = new ArrayList<>();
		for (String member:meetingMembers)
		{
			System.out.println(member);
			temp.add(member);
		}
		

		
		//Will come from session later
		int managerId=1; 
		Meeting m = new Meeting();
		m.setMeetingTitle(meetingTitle);
		m.setMeetingType(meetingType);
		m.setMeetingDate("20-10-2021");
		m.setStartTime("13:00");
		m.setEndTime("16:00");
		m.setOrganiserId(managerId);
		
		ManagerOrganizeServiceInterface mOrganizeService = new ManagerOrganizeService();
		ArrayList<MeetingRoom> mlist=mOrganizeService.listValidMeetingRooms(m,meetingMembers.length,duration);
		System.out.println("here");
		for(MeetingRoom mr : mlist)
			System.out.println(mr.toString());
        request.setAttribute("meetingRoomList",mlist);
        
        
        request.setAttribute("meetingInfo",m);
        request.setAttribute("meetParticipants",temp);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("meetingRoomsFound.jsp");
        rd.forward(request, response);
	
		
		
	}

}
