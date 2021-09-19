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
import com.AMRApp.factory.AdminGetRoomFactory;
import com.AMRApp.service.*;

@WebServlet("/AdminGetRoom")
public class AdminGetRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminGetRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoom room = new MeetingRoom ();
		HttpSession session = request.getSession (false);
		
		try {
			room.setRoomName( request.getParameter("meeting_name") ); // getting meeting name
			
			room.setRoomCapacity( Integer.parseInt ( request.getParameter ( "seating_capacity" ) ) ); // get seating capacity
			
			room.setOrganiser( session.getAttribute ( "user_id" ).toString() ); // to store who created the meeting
			
			// get amenities List
			
			List <String> list = new ArrayList <String> (); 
			
			String amenity_list [] = request.getParameterValues( "amenitites" );	// store checkBoxes values 
			
			for ( String temp : amenity_list ) {
				
				if ( temp != null ) {
					
					list.add(temp);
				}
			}
			
			room.setRoomAmenities(list); // setting amenity list
			
			AdminGetRoomServiceInterface service = AdminGetRoomFactory.createServiceObject();
			
			if ( service.getRoom ( room ) == 1 ) {
				
				String errorMessage = "<div class='alert alert-success alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> Edit Successful... </strong>" + 
						"</div>";
	
				request.setAttribute ( "Admin_home_page_message", errorMessage );
				
				request.getRequestDispatcher("AdminHomePage.jsp").forward ( request, response );
				
			} else {
				
				String errorMessage = "<div class='alert alert-danger alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> Edit Unsuccessful... </strong>" + 
						"</div>";
	
				request.setAttribute ( "Admin_home_page_message", errorMessage );
				
				request.getRequestDispatcher("AdminHomePage.jsp").forward ( request, response );
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
