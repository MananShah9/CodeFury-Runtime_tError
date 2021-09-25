<%
		// check for existing session
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	response.setHeader("Pragma", "no-cache");

	response.setHeader("Expires", "0");

		
	if ( session.getAttribute ( "role" ) == null ) {
		
		request.getRequestDispatcher("login.jsp").forward ( request, response );		
	
	} else { // session exists
		
		if ( session.getAttribute ( "role" ).toString().equalsIgnoreCase ( "member" ) ) {
			
			request.getRequestDispatcher("member.jsp").forward ( request, response );
			
		} else if ( session.getAttribute ( "role" ).toString().equalsIgnoreCase ( "Admin" ) ) {
			
			// Do Nothing
			
		} else {
			
			request.getRequestDispatcher("ManagerHomePage.jsp").forward ( request, response );
		}
	}

%>

<html>

<head>
  <title>Admin Panel Page</title>
  <link rel="stylesheet" href="css/sidebar.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

  <link href="https://fonts.googleapis.com/css2?family=Noto+Serif&display=swap" rel="stylesheet">

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
  <nav>

    <header>
      <span><img style="border-radius:50%; width:60px; height:60px; font-size:13px;" src="images/profile.png" alt="Insert Profile"></span>
      <%=request.getSession().getAttribute("name")%>
    </header>
	
	<h3 class="admin-info-header"><i>Admin Info</i></h3>
    <ul style="color: white;">
   
   
      <li>Name: <i><%=request.getSession().getAttribute("name")%></i></li>
      <li>Email: </li><i><%=request.getSession().getAttribute("email")%></i></li>
    </ul>

  </nav>

</body>


</html>