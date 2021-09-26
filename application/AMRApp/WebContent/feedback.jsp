<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Feedback Time</title>
</head>
<style>
table {
}
td {
  padding: 15px;
}
fieldset {
	margin:auto;
    width:35%;
    border:2px solid blue;
    border-radius:5px;
}
</style>
<body>
	<jsp:include page="header.jsp"/>
<center><h2>Give your ratings</h2></center>
<form action="renewFeedBack" method="post">
<fieldset>
 		<%
	
 		
 		
 		FeedBackServiceInterface obj = new FeedBackService();
		List<MeetingRoom> m = obj.getAllMeetRooms() ;
		
		%> 
		<table id="myTable" align="center">
		<tr><td>
		Select a meeting room
		</td></tr>
		<tr>
		<td>
		<select name="meetingRoomName" id="meetingRoomName">
 		  <% 
		for(int i=0;i<m.size();i++){
		%>  
				 <option value="<%= m.get(i).getRoomName()%>"><%=m.get(i).getRoomName()%></option>  
		  
		 
		  <%} %>  
		</select>
		</td></tr>
		<tr><td>
		Enter rating here
		</td></tr>
		<tr><td>
		<input name="ratingNo" type="number" id="ratingnumber" min="1" max="5">
		</td></tr>
		<tr><td>
 			<button type="submit" class="btn btn-success">Submit</button>
 			</td></tr>
		</table>
	</fieldset>	
</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>