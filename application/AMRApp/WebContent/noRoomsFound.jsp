<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OOPS!</title>
 <link rel="stylesheet" href="css/noRoomsFound.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<% if ( session.getAttribute ( "role" ) == null ) {
    response.sendRedirect("login.jsp");

}  %>
</head>
<body>
	
	<div class="sorry-image-container">
		<img src="images/noRoomsFound.png" alt="Sorry! No Rooms Found" />
	</div>
	<div class="sorry-message">
		<h2>OOPS! No Rooms Found</h2>
	</div>
	
	<div class="home-page">
		<a class="btn btn-dark" href="home.jsp">Go Back to Home Page</a>
		<a class="btn btn-dark" href="organizemeeting.jsp">Go to Organize Page</a>
	</div>
	
</body>
</html>

