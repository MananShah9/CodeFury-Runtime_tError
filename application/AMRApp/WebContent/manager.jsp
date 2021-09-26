
	<!-- Importing ConnectionManager Modules -->

	<%@ page import="java.sql.Connection"%>
	<%@ page import="com.AMRApp.factory.*"%>
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
  <% if ( session.getAttribute ( "role" ) == null ) {
    response.sendRedirect("login.jsp");

}  %>
</head>

<body>

<script>
 function logout(){
	 window.location.href="logout.jsp";
 }
 </script>

<!-- -----Get the Meeting details organized by the Logged In Manager---- -->
<%
			int userId=(int)session.getAttribute("userId");
			ManagerHomePageServiceInterface s= new ManagerFactory().getServiceInstanceHomePage();
			User user = s.ManagerInfo(userId);				 
	%>
 
	<jsp:include page="managerSidebar.jsp"/>
	  <main>
	  	<h1>Manager Dashboard</h1>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	      <span style="float:right; margin-top:-8%; font-size: 13px;">
		  	<a href="home.jsp" onclick="logout()">
	          <h4>LOGOUT</h4>
	        </a>
        </span>
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
				     <th scope="row"><%= m.getMeetingTitle() %></th>
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
	    	<a href="organizemeeting.jsp">Organize Meeting</a>
	    </section>
	  </main>
</body>
</html>
