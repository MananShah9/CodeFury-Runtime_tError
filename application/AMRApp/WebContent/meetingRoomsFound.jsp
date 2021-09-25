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
<link rel="stylesheet" href="css/meetingRoomsFound.css">
<style>

</style>
<script type="text/javascript">
function highlightMeetingRoom()
{
	let meetingName = document.querySelector('.card-header').getAttribute('data-name')
	
	document.getElementById("meetingRoomName").value=meetingName;
	document.querySelector('.card').style.border = "thick solid black"
	
	
	
			let meetingCapacity = document.querySelector('.card-title').getAttribute('data-capacity')
			let meetingRatings = document.querySelector('.card-text').getAttribute('data-ratings')
				
			

			
}

</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<form method="post" action="BookNowServlet">
	 <div class="container meeting-rooms">
        <h2 style="margin-top: 75px; text-align: center">Available Meeting Rooms</h2>
        <div class="row mt-5">
		<span style="color:red;" id="selectMeetingRoomError"></span>
	
	<% 
	List<MeetingRoom> meetingRoomList=new ArrayList<MeetingRoom>();
	
	meetingRoomList = (ArrayList<MeetingRoom>)session.getAttribute("meetingRoomList"); 
	for(MeetingRoom meetingRoom:meetingRoomList){ %>
	
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div onclick="highlightMeetingRoom()" class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div data-name=<%= meetingRoom.getRoomName() %> class="card-header">
                    	<%= meetingRoom.getRoomName() %>
                    </div>
                    <div class="card-body">
                        <h6 class="card-title" data-capacity=<%= meetingRoom.getRoomCapacity() %>><b>Seating Capacity: <%= meetingRoom.getRoomCapacity() %></b></h6>
                        <p>YAHA KUCH NAYA AAYEGA</p>
			
			<p class="card-text" data-ratings=<%= meetingRoom.getRoomRating() %>>Ratings: </p>
			
			<% for(int j=0;j<meetingRoom.getRoomRating();j++){ %>

                        	<i class="fa fa-star"></i>
			
			<% } %>

                    </div>
                </div>
            </div>
	
	<% } %>

	</div>
</div>
<input type="hidden" id="meetingRoomName" name="meetingRoomName"/>
<input type="submit" style="float:right; margin-right: 25px; "  class="btn btn-success" id="organizeMeeting">ORGANIZE
	
	<jsp:include page="footer.jsp"/>
	<script type="text/javascript" src="js/meetingRoomsFound.js"></script>
</form>
</body>
</html>
