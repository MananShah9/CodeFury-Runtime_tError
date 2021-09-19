package com.AMRApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AMRApp.beans.User;
import com.AMRApp.factory.UserFactory;
import com.AMRApp.factory.UserServiceFactory;
import com.AMRApp.service.UserServiceInterface;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {

			User user = UserFactory.createObject ();		
			user.setUserId(Integer.parseInt(( request.getParameter ( "user_id" ) ))); // Getting User Credentials
			user.setUserPass( request.getParameter ( "user_password" ) );
			
			UserServiceInterface login_object = UserServiceFactory.createObject ();
			
			user = login_object.userLogin ( user );	//Validating User
			
			if ( user != null ) { 
				
				HttpSession session = request.getSession (); //Creating Session
								
				session.setAttribute ( "user_id", user.getUserId());
				session.setAttribute ( "name", user.getUserName());
				
				session.setAttribute ( "email", user.getUserEmail());
				session.setAttribute ( "phone", user.getUserPhone());
				
				session.setAttribute ( "role", user.getUserRole());
				
				
				if ( user.getUserRole().equals ( "member" ) ) {
					
					request.getRequestDispatcher("member.jsp").forward ( request, response );
					
				} else if ( user.getUserRole().equals ( "admin" ) ) {
					
					request.getRequestDispatcher("AdminHomePage.jsp").forward ( request, response );
					
				} else {
					
					login_object.manageCredits(user.getUserId());
					
					request.getRequestDispatcher("ManagerHomePage.jsp").forward ( request, response );
				}
				
			} else {	// if user does not exists redirect to login page
				
				String login_message = "<div class='alert alert-danger alert-dismissible fade in'>" +
						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
						"<strong> User Not Found </strong>" + 
						"</div>";
				
				request.setAttribute ( "login_message", login_message );
				
				request.getRequestDispatcher("login.jsp").forward ( request, response );
			}
		}
		catch (ServletException | IOException e) {
			
			System.out.println(e);
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
	
	}

}
