package com.AMRApp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		try {
//			
//			User user = UserFactory.createObject ();		
//			user.setUserId(Integer.parseInt(( request.getParameter ( "userId" ) ))); // Getting User Credentials
//			user.setUserPass( request.getParameter ( "userPass" ) );
//			
//			UserServiceInterface login_object = UserServiceFactory.createObject ();
//			
//			user = login_object.userLogin ( user );	//Validating User
//			
//			if ( user != null ) { 
//				
//				HttpSession session = request.getSession (); //Creating Session
//								
//				session.setAttribute ( "userId", user.getUserId());
//				session.setAttribute ( "name", user.getUserName());
//				
//				session.setAttribute ( "email", user.getUserEmail());
//				session.setAttribute ( "phone", user.getUserPhone());
//				
//				session.setAttribute ( "role", user.getUserRole());
//				
//				System.out.println(user.getUserRole());
//
//				if ( user.getUserRole().equals ( "Member" ) ) {
//					
//					request.getRequestDispatcher("member.jsp").forward ( request, response );
//					
//				} else if ( user.getUserRole().equals ( "Admin" ) ) {
//					
//					request.getRequestDispatcher("AdminHomePage.jsp").forward ( request, response );
//					
//				} else {
//					
//					//login_object.manageCredits(user.getUserId());
//					
//					
//					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
//					    	 
//			        LocalDate dt = LocalDate.now();
//			  
//			       String temp =  dtf.format(dt);
//			        
//			        System.out.println(dt.getDayOfWeek());
//			        
//					
//					RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");
//					rd.forward(request, response);
//
//				}
//				
//			} else {	// if user does not exists redirect to login page
//				
//				String login_message = "<div class='alert alert-danger alert-dismissible fade in'>" +
//						"<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
//						"<strong> User Not Found </strong>" + 
//						"</div>";
//				
//				request.setAttribute ( "login_message", login_message );
//				
//				request.getRequestDispatcher("login.jsp").forward ( request, response );
//			}
//		}
//		catch (ServletException | IOException e) {
//			
//			System.out.println(e);
//		}
//		catch (Exception e) {
//			
//			System.out.println(e);
//		}
//		
//	
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			User user = UserFactory.createObject ();		
			user.setUserId(Integer.parseInt(( request.getParameter ( "userId" ) ))); // Getting User Credentials
			user.setUserPass( request.getParameter ( "userPass" ) );
			
			UserServiceInterface login_object = UserServiceFactory.createObject ();
			
			user = login_object.userLogin ( user );	//Validating User
			
			if ( user != null ) { 
				
				HttpSession session = request.getSession (); //Creating Session
								
				session.setAttribute ( "userId", user.getUserId());
				session.setAttribute ( "name", user.getUserName());
				
				session.setAttribute ( "email", user.getUserEmail());
				session.setAttribute ( "phone", user.getUserPhone());
				
				session.setAttribute ( "role", user.getUserRole());
				
				System.out.println(user.getUserRole());

				if ( user.getUserRole().equals ( "Member" ) ) {
					
					request.getRequestDispatcher("member.jsp").forward ( request, response );
					
				} else if ( user.getUserRole().equals ( "Admin" ) ) {
					request.setAttribute("name",user.getUserName());
					request.setAttribute("email", user.getUserEmail());
					
					System.out.println(user.getUserEmail()+" "+user.getUserName());
					request.getRequestDispatcher("admin.jsp").forward ( request, response );
					
				} else {
					
					RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");
					rd.forward(request, response);
				}
				
			} else {
				
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
