<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%@ page import="com.AMRApp.service.*"%>
	<%@ page import="com.AMRApp.beans.*"%>
	
	
	<%
			int userId=(int)session.getAttribute("userId");
			
			ManagerHomePageServiceInterface s=new ManagerHomePageService();
			User user = s.ManagerInfo(userId);	 
	%>
	
<!-- The Modal for Manager information in the navbar -->

				

				<!-- Modal body -->

				<div class="modal-body">

					<table class="table">
						<tr>
							<th>User ID</th>

							<th>Name</th>
							
							<th>Email id</th>
							
							<th>Phone Number</th>
							
							<th>Role</th>
							
							<th>Credits</th>

							<th>Last Logged In</th>
						</tr>
						<%
		
		if(user!=null){
			// for getting last accessed time of the manager
			
%>
						<tr>

							<td><%=user.getUserId()%></td>
								
							<td><%=user.getUserName()%></td>
							
							<td><%=user.getUserEmail()%></td>
							
							<td><%=user.getUserPhone()%></td>
							
							<td><%=user.getUserRole()%></td>
							
							<td><%=user.getUserCredits()%></td>

		

						</tr>

						<%}%>
					</table>

				</div>

				<!-- Modal footer -->
				<div class="modal-footer">

					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>

				</div>

	

	<!-- Modal Close -->




</body>
</html> --%>