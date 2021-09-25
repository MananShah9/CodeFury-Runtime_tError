<%@ page import="com.AMRApp.service.*"%>
<%@ page import="com.AMRApp.beans.*"%>

<html>

<head>
  <title>Manager Panel Page</title>
  <link rel="stylesheet" href="css/sidebar.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

  <link href="https://fonts.googleapis.com/css2?family=Noto+Serif&display=swap" rel="stylesheet">

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>


<!-- -------Manager Information from Backend------- -->
	
	
	<%
			int userId=(int)session.getAttribute("userId");
			ManagerHomePageServiceInterface s=new ManagerHomePageService();
			 User user = s.ManagerInfo(userId);
			 
			 
	%>
  <nav>

    <header>
      <span><img style="border-radius:50%; width:60px; height:60px; font-size:13px;" src="images/profile.png" alt="Insert Profile"></span>
      <%=user.getUserName()%>
    </header>
	
	<h3 class="admin-info-header"><i>Manager Info</i></h3>
    <ul style="color: white;">
      <li>ID: <i><%=user.getUserId()%></i></li>
      <li>Email: <i><%=user.getUserEmail()%></i></li>
       <li>Contact: <i><%=user.getUserPhone()%></i></li>
       <li>Credits: <i><%=user.getUserCredits()%></i></li>
    </ul>

  </nav>

</body>


</html>