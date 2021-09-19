package com.AMRApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AMRApp.factory.AdminDeleteRoomFactory;
import com.AMRApp.service.AdminDeleteRoomServiceInterface;

@WebServlet("/AdminDeleteRoom")
public class AdminDeleteRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminDeleteRoom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AdminDeleteRoomServiceInterface service = AdminDeleteRoomFactory.createObject ();
			
			if ( service.deleteRoom ( request.getParameter( "unique_name" ) ) == 1 ) {
				
				String errorMessage = "<div class='alert alert-success alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> Delete Successful... </strong>" + 
						"</div>";
	
				request.setAttribute ( "Admin_home_page_message", errorMessage );
				
				request.getRequestDispatcher("AdminHomePage.jsp").forward ( request, response );
				
			} else {
				
				String errorMessage = "<div class='alert alert-danger alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> Delete Unsuccessful... </strong>" + 
						"</div>";
	
				request.setAttribute ( "Admin_home_page_message", errorMessage );
				
				request.getRequestDispatcher("AdminHomePage.jsp").forward ( request, response );
			}
		}
		catch (ServletException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}

}
