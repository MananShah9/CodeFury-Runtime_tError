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

	<!-- NAVBAR -->

	<div class="container">

		<nav class="navbar navbar-inverse navbar-fixed-top">

			<div class="container-fluid">

				<div class="navbar-header">

					<a class="navbar-brand" href="ManagerHomePage.jsp"> <img
						src="images/logo/hsbc-logo-dark_navbar.png"
						style="height: 20px; width: 110px;" />
					</a>

				</div>

				<ul class="nav navbar-nav">

					<li class="active"><a href="ManagerHomePage.jsp"> Manager
							Home </a></li>

					<li><a href="organizeMeeting.jsp"> Organize Meeting </a></li>

					<li><a href="#myModal" role="button" data-toggle="modal">
							Manager Information </a></li>

					<li><a href="Logout"> Logout </a></li>

				</ul>

			</div>

		</nav>

	</div>

	<!-- NAVBAR -->


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

	<% 	String userId=(String)session.getAttribute("user_id");
	//User u=new User();
	//u.setUserId(userId);
	int uid=Integer.parseInt(userId);
	//MeetingRoomsServiceInterface s=MeetingServiceFactory.createObject("admin service");
//	User user=s.managerInfoService(u);
	
	//LogServiceInterface ls=LogServiceFactory.createObject();
	//Time t=ls.displayLastLoginService(u);
	ManagerServiceInterface s=new ManagerService();
	 //user=s.listManagerMeeting(u);
	
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
	
	
		
		List<Meeting> listOfMeetings= s.listManagerMeeting(uid);
	
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


	<!-- Footer -->

	<div class="content"></div>

	<footer id="myFooter">

		<div class="container">

			<div class="row">

				<div class="col-sm-3">

					<h2 class="logo">
						<a href="ManagerHomePage.jsp"> <img
							src="images/logo/hsbc-logo-dark_2.png"
							style="height: 70px; width: 150px;" align="left" />
						</a>
					</h2>

				</div>

				<div class="col-sm-2">

					<h5>Get started</h5>

					<ul>

						<li><a href="ManagerHomePage.jsp"> Home </a></li>
						<li><a href="Logout"> Logout </a></li>

					</ul>

				</div>

				<div class="col-sm-2">

					<h5>About us</h5>

					<ul>

						<li><a href="about_us.jsp"> Information </a></li>

						<li><a href="feedback.jsp"> Give Feedback </a></li>

					</ul>

				</div>

				<div class="col-sm-2">

					<h5>Support</h5>

					<ul>

						<li><a href="#"> FAQ </a></li>

						<li><a href="#"> Help desk </a></li>

					</ul>

				</div>

				<div class="col-sm-3">

					<br> <a href="#">
						<button type="button" class="btn">Contact us</button>
					</a>

				</div>

			</div>

		</div>

		<div class="footer-copyright">

			<p>Developed By WFS BATCH-1 @ HSBC-CodeFury</p>

		</div>

	</footer>
</body>

</html>