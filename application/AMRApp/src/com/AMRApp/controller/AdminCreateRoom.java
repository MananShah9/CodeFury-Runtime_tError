package com.AMRApp.controller;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */

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
import com.AMRApp.factory.AdminCreateRoomFactory;
import com.AMRApp.service.AdminCreateRoomServiceInterface;

@WebServlet("/AdminCreateRoom")
public class AdminCreateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//non-parameterized constructor
	public AdminCreateRoom() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			MeetingRoom room = new MeetingRoom();

			HttpSession session = request.getSession(false);

			room.setRoomName(request.getParameter("meetingname")); // getting meeting name
			room.setRoomCapacity(Integer.parseInt(request.getParameter("seatingcapacity"))); // getting seating capacity
			room.setOrganiser(session.getAttribute("name").toString());// getting name


			List<String> list = new ArrayList<String>();

			String amenity_list[] = request.getParameterValues("amenities"); // list to store amenities
			for(int i=0; i<amenity_list.length;i++) {
				System.out.println(amenity_list[i]);
			}
			System.out.println(request.getParameter("meetingname"));
			System.out.println(request.getParameter("seatingcapacity"));

			for (String temp : amenity_list) {

				if (temp != null) {
					list.add(temp);
				}
			}

			room.setRoomAmenities(list);
			

			AdminCreateRoomServiceInterface service = AdminCreateRoomFactory.createServiceObject();

			// To check if room exists or not
			if (service.createRoom(room) == 1) {

				String errorMessage = "<div class='alert alert-success alert-dismissible fade in'>"
						+ "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
						+ "<strong> Room Creation Successful... </strong>" + "</div>";

				request.setAttribute("Admin_home_page_message", errorMessage);

				request.getRequestDispatcher("admin.jsp").forward(request, response);

			} else {

				String errorMessage = "<div class='alert alert-danger alert-dismissible fade in'>"
						+ "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
						+ "<strong> Room Creation Unsuccessful... </strong>" + "</div>";

				request.setAttribute("Admin_home_page_message", errorMessage);

				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
