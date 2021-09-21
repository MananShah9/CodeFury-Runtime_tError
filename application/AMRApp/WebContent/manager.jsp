
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

<html>

<head>
  <title>Manager</title>
  <link rel="stylesheet" href="css/admin.css">
</head>

<body>

<!-- -----Get the Meeting details organized by the Logged In Manager---- -->

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
 
	<jsp:include page="managerSidebar.jsp"/>
	  <main>
	  	<h1>Manager Dashboard</h1>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    
	    <section>
	    	<div class="section-header">
	    		<h3>Scheduled Meetings</h3>
	    	</div>
	    	
	    	<div class="meeting-rooms">
	    		<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Meeting Name</th>
				      <th scope="col">Meeting Room</th>
				      <th scope="col">Start Date</th>
				      <th scope="col">Start Time</th>
				      <th scope="col">End Time</th>
				      <th scope="col">Meeting Type</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				<%
		// --------getting the details of scheduled meetings-------
	
		
		List<Meeting> listOfMeetings= s.listManagerMeeting(userId);
	
		for(Meeting m : listOfMeetings) {
		%>
				    <tr>
				     <th scope="row"><a href="editRoom.jsp"><%= m.getMeetingTitle() %></a></th>
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
	    </section>
	  </main>
	  
	 

</body>
</html>