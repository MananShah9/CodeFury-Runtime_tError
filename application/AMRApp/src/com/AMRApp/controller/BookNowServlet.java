package com.AMRApp.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import com.AMRApp.service.ManagerBookServiceInterface;


@WebServlet("/BookNowServlet")
public class BookNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String meetingRoomName= request.getParameter("meetingRoomName");
		
		HttpSession session = request.getSession (); //Creating Session

		Meeting m = (Meeting) session.getAttribute("meetingInfo");
				
		ArrayList<String> meetParticipants = (ArrayList<String>) session.getAttribute("meetParticipants");
		
		ManagerBookServiceInterface mBook = new ManagerFactory().getServiceInstanceBook();
		
		//ManagerBookServiceInterface mBook = new ManagerBookService();
		System.out.println(meetingRoomName);
		
		System.out.println("++++++++++++++++++++++++++++++++");
		for(String strMp : meetParticipants) {
			System.out.println(strMp);
		}
		int meetingId = mBook.saveMeetingService(m);	
		
		mBook.saveUser(meetParticipants, meetingId);
		
		mBook.saveBookingInfo(m, meetingRoomName, m.getOrganiserId());
	
		mBook.decreaseManagerCredits(m, meetingRoomName);
		
	//	mBook.saveBookingInfo(mlist,m);
		
		RequestDispatcher rd=request.getRequestDispatcher("ThanksForOrganizing.jsp");
		rd.forward(request, response);
		
		
		
	}

}
