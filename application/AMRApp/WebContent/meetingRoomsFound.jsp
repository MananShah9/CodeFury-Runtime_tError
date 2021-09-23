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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<style>

</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
<form action="bookTimeSlot.jsp" method = "POST">
	 <div class="container meeting-rooms">
        <h2 style="margin-top: 75px; text-align: center">Available Meeting Rooms</h2>
        <div class="row mt-5">
	
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
			
			<% for(int j=0;j<meetingRoom.getRoomRating();j++){ %>

                        	<i class="fa fa-star"></i>
			
			<% } %>

                    </div>
                    <div class="card-footer">
                    	<button type="submit" class="btn btn-success">SELECT ROOM</button>
                    </div>
                </div>
            </div>
	
	<% } %>

	</div>
</div>
</form>
	 
	
	<jsp:include page="footer.jsp"/>
</body>
</html>