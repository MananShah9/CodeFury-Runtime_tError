<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.AMRApp.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to AutomatedBooking</title>
<link rel="stylesheet" href="css/main.css">
<style>

</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	 <div class="container meeting-rooms">
        <h2 style="margin-top: 55px; text-align: center">Our Meeting Rooms</h2>
        <div class="row mt-5">
		<form action="bookTimeSlot.jsp" method = "post">
	<% 
	List<MeetingRoom> meetingRoomList=new ArrayList<MeetingRoom>();
	meetingRoomList = (List<MeetingRoom>)request.getAttribute("meetingRoomList"); 
	for(MeetingRoom meetingRoom:meetingRoomList){ %>
	
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">
                    	<%= meetingRoom.getRoomName() %>
                    </div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: <%= meetingRoom.getRoomCapacity() %></b></h6>
                        <p>YAHA KUCH NAYA AAYEGA</p>
			
			<p class="card-text">Ratings: </p>
			
			<% for(int j=0;j<meetingRoomList.size();j++){ %>

                        	<i class="fa fa-star"></i>
			
			<% } %>

                    </div>
                </div>
            </div>
	
	<% } %>
</form>
	</div>
	 <button type="submit" class="btn btn-dark">Organize Meeting</button>
</div>

	 
	
	<jsp:include page="footer.jsp"/>
</body>
</html>