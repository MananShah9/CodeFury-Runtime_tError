package com.AMRApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AMRApp.beans.MeetingRoom;
import com.AMRApp.factory.AdminEditRoomFactory;
import com.AMRApp.service.AdminEditRoomServiceInterface;

@WebServlet("/AdminEditRoom")
public class AdminEditRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminEditRoom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		MeetingRoom room = new MeetingRoom();

		HttpSession session = request.getSession(false);

		room.setRoomName(request.getParameter("meetingname")); // getting meeting name
		room.setRoomCapacity(Integer.parseInt(request.getParameter("seatingcapacity"))); // getting seating capacity
		room.setOrganiser(session.getAttribute("name").toString()); //getting name
		String meetingType = request.getParameter("meetingtype"); //getting type of meeting
		
		
		List<String> list = new ArrayList<String>();

		String amenity_list[] = request.getParameterValues("amenities"); // list to store amenities
		for(int i=0; i<amenity_list.length;i++) {
			System.out.println(amenity_list[i]);
		}
		System.out.println(request.getParameter("meetingname"));
		System.out.println(request.getParameter("seatingcapacity"));
		System.out.println(meetingType);
		for (String temp : amenity_list) {

			if (temp != null) {
				list.add(temp);
			}
		}

		room.setRoomAmenities(list); 

			
			AdminEditRoomServiceInterface service = AdminEditRoomFactory.createServiceObject ();
			
			// To check room is edit or not

			if ( service.editRoom ( room ) == 1 ) {
				
				String errorMessage = "<div class='alert alert-success alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> Edit Successful... </strong>" + 
						"</div>";
	
				request.setAttribute ( "Admin_home_page_message", errorMessage );
				
				request.getRequestDispatcher("admin.jsp").forward ( request, response );
				
			} else {
				
				String errorMessage = "<div class='alert alert-danger alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> Edit Unsuccessful... </strong>" + 
						"</div>";
	
				request.setAttribute ( "Admin_home_page_message", errorMessage );
				
				request.getRequestDispatcher("admin.jsp").forward ( request, response );
			}
		}
		catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
