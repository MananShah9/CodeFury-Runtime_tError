<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

<link href="css/Footer-with-button-logo.css" rel="stylesheet">

<script src="javaScript/jQuery_v3.5.1.js"></script>
<script src="javaScript/bootstrap_v4.5.2.js"></script>


<title>Manager Home Page</title>

</head>

<body>

	


	<!-- Importing ConnectionManager Modules -->

	<%@ page import="java.sql.Connection"%>
	<%@ page import="com.AMRApp.service.*"%>
	<%@ page import="com.AMRApp.beans.*"%>
	<%@ page import="java.sql.DriverManager"%>
	<%@ page import="java.sql.PreparedStatement"%>
	<%@ page import="java.sql.ResultSet"%>
	<%@ page import="java.sql.SQLException"%>
	<%@ page import="java.text.*"%>
	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.Connection"%>

	<%
			int userId=(int)session.getAttribute("userId");
			
			//MeetingRoomsServiceInterface s=MeetingServiceFactory.createObject("admin service");
		//	User user=s.managerInfoService(u);
			
		
			//LogServiceInterface ls=LogServiceFactory.createObject();
			//Time t=ls.displayLastLoginService(u);
			ManagerHomePageServiceInterface s=new ManagerHomePageService();
			 //user=s.listManagerMeeting(u);
			 
			 User user = s.ManagerInfo(userId);
			 
			 
	%>


	

	<!-- DISPLAY MEETING LISTS -->


	<div class="container">

		<!-- Displaying list of meetings scheduled by the manager  -->

		<h2>Scheduled Meetings</h2>

		<table class="table table-striped table-hover">

			<thead>

				<tr>

					<th>Meeting Name</th>

					<th>Meeting Room</th>

					<th>Start Date</th>

					<th>Start Time</th>

					<th>End Time</th>

					<th>Meeting type</th>

				</tr>

			</thead>

			<tbody>



				<%
	// getting the details of scheduled meetings
	
		
		List<Meeting> listOfMeetings= s.listManagerMeeting(userId);
	
		for(Meeting m : listOfMeetings) {
%>
				<tr>
					<td><%= m.getMeetingTitle() %></td>
					<td><%= m.getMeetingId() %></td>
					<td><%= m.getMeetingDate() %></td>
					<td><%= m.getStartTime() %></td>
					<td><%= m.getEndTime() %></td>
					<td><%= m.getMeetingType() %></td>
				</tr>
				<%	}	%>
			</tbody>
		</table>
	</div>


	
	<a href="ManagerInfoDisplayPage.jsp" role="button" data-toggle="modal">
							Manager Information </a>
	
	<!--  <button type="button" action="ManagerInfoDisplayPage.jsp">Manager Information </button>
	-->

	

</body>

</html>