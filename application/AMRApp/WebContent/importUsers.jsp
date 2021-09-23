<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="../css/importUsers.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<title>Import Users</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<div class="heading-users">
        <h2>Import Users</h2>
    </div>

    <div class="users-container">
    	<img src="../images/importUsers.png" alt="Import Users" />
    </div>
        <div class="container import-users-container">
            <div class="row">
                <div class="col-lg-2">

                </div>
                <div class="col-lg-8">
                    <form id="uploadUsersForm" method="post" action="ImportXMLServlet"  enctype="multipart/form-data">
                       <div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1">
  								<i class="fa fa-users"></i>
  							</span>
  							<input required name="importUsers" id="importUsers" type="file" class="form-control" placeholder="Add File to Import Users" aria-label="importUsers" aria-describedby="basic-addon1">
						</div>
						<button class="btn btn-success add-button">Import Users</button>
                    </form>
                </div>
                <div class="col-lg-2">
                    
                </div>
            </div>
        </div>
</body>
</html>
