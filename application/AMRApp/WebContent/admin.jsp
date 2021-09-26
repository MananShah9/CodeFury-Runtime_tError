<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.AMRApp.controller.*,com.AMRApp.factory.AdminGetRoomFactory, com.AMRApp.service.AdminGetRoomServiceInterface,com.AMRApp.beans.User, com.AMRApp.beans.MeetingRoom"%>
    

<html>

<head>
  <title>Admin</title>
  <link rel="stylesheet" href="css/admin.css">
  <style >
  .button1{  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;}
  </style>
<%  out.println( session.getAttribute ( "role" ));
if ( session.getAttribute ( "role" ) == null ) {
    response.sendRedirect("login.jsp");
   

}  %>
</head>

<body>
 <script>
 function logout(){
	 window.location.href="logout.jsp";
 }
 </script>
	<jsp:include page="sidebar.jsp"/>
	  <main>
	  	<h1>Admin Dashboard</h1>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	     <span style="float:right; margin-top:-8%; font-size: 13px;">
		  	<a href="home.jsp" onclick="logout()">
	          <h4>LOGOUT</h4>
	        </a>
        </span>
	    <section>
	    	<div class="section-header">
	    		<h3>Meeting Rooms</h3>
	    	</div>
	    	
	    	<div class="meeting-rooms">
	    		<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Room Name</th>
				      <th scope="col">Created By </th>
				      <th scope="col">Seating Capacity</th>
				      <th scope="col">Per Hour Cost</th>
				      
				     
				    </tr>
				  </thead>
				  <tbody>
				  <% 
				  List<MeetingRoom> list = null;
					AdminGetRoomServiceInterface service = AdminGetRoomFactory.createServiceObject();
					list = service.getAllRooms();
				  for (MeetingRoom room:list ) { %>
					
				    <tr>
				      <th><%=room.getRoomName()%></th>
				      <td><%=room.getOrganiser()%></td>
				      <td><%=room.getRoomCapacity()%></td>
				      <td><%=room.getRoomPerHourCost()%></td>
				    </tr>
				    <% } %>
				  </tbody>
				</table>
	    	</div>
	    	<br>
	    	<form action="create_room.jsp">
   			 <input type="submit" class="button1" value="Create Room" />
			</form> <br>
			<form action="AdminEditRoom.jsp">
   			 <input type="submit"  class="button1" value="Edit Room" />
			</form>
			
	    </section>
	  </main>
	  
	 

</body>
</html>
