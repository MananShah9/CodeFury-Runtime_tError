package com.AMRApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.service.FeedBackService;
import com.AMRApp.service.FeedBackServiceInterface;

/**
 * Servlet implementation class RenewFeedBack
 */
@WebServlet("/renewFeedBack")
public class RenewFeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenewFeedBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mr = request.getParameter("meetingRoomName");
		int rating=  Integer.parseInt(request.getParameter("ratingNo"));
		HttpSession session = request.getSession (); //Creating Session
		
		int userId = (int)session.getAttribute("userId");

		FeedBackServiceInterface obj = new FeedBackService();
		obj.calculateRatings(mr, userId, rating);
		
		RequestDispatcher rd=request.getRequestDispatcher("member.jsp");
		rd.forward(request, response);
		
		
	}

}
