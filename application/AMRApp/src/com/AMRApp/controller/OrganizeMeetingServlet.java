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
import javax.servlet.http.HttpSession;

import com.AMRApp.beans.Meeting;
import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.factory.ManagerFactory;
import com.AMRApp.service.ManagerOrganizeService;
import com.AMRApp.service.ManagerOrganizeServiceInterface;

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

		List<String> temp = new ArrayList<>();
		for (String member:meetingMembers)
		{
			System.out.println(member);
			temp.add(member);
		}
		
		HttpSession session = request.getSession (); //Creating Session
		int managerId=(int)session.getAttribute("userId");
		Meeting m = new Meeting();
		m.setMeetingTitle(meetingTitle);
		m.setMeetingType(meetingType);
		m.setMeetingDate(meetingDate);
		m.setStartTime(meetingStartTime);
		m.setEndTime(meetingEndTime);
		m.setOrganiserId(managerId);
		
		int durationHours=Integer.parseInt(m.getEndTime().substring(0,2))-Integer.parseInt( m.getStartTime().substring(0,2));
    	
    	int durationMinutes=Integer.parseInt(m.getEndTime().substring(3))-Integer.parseInt( m.getStartTime().substring(3));
    	
    	if(durationMinutes!=0)
    		++durationHours;
    	
		ManagerOrganizeServiceInterface mOrganizeService = new ManagerFactory().getServiceInstanceOrganize();
		ArrayList<MeetingRoom> mlist=mOrganizeService.listValidMeetingRooms(m,meetingMembers.length,durationHours);
		
		if(mlist.isEmpty())
		{
			 RequestDispatcher rd = request.getRequestDispatcher("noRoomsFound.jsp");
		        rd.forward(request, response);
		}
		
		for (MeetingRoom mr1 : mlist)
		System.out.println(mr1);
		
		
        session.setAttribute("meetingRoomList",mlist);
        session.setAttribute("meetingInfo",m);
        session.setAttribute("meetParticipants",temp);
        RequestDispatcher rd = request.getRequestDispatcher("meetingRoomsFound.jsp");
        rd.forward(request, response);
        System.out.println("hello servlet");
	}
}
