package com.AMRApp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.AMRApp.utility.WeeklyCreditsRenew;

/**
 * Servlet implementation class MondayRenew
 */
@WebServlet("/servletMondayRenewal")
public class servletMondayRenewal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMondayRenewal() {
        super();
        // TODO Auto-generated constructor stub
        
        new WeeklyCreditsRenew();
    }

}
