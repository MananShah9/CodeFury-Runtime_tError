<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
		 <div class="heading-login">
        <h2>Login</h2>
    </div>

    <div class="profile-container">
    	<img src="../images/profile.png" alt="login-profile" />
    </div>
        <div class="container form-container">
            <div class="row">
                <div class="col-lg-2">

                </div>
                <div class="col-lg-8">
                    <form>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">
                                <i class="fa fa-user"></i>
                            </span>
                            <input required name="username" type="text" id="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" onblur="validateUsername()">
                            <span id="errorUsername"></span>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">
                                <i class="fa fa-eye-slash"></i>
                            </span>
                            <input required name="password" type="password" id="password" class="form-control" placeholder="Password" aria-label="Username" aria-describedby="basic-addon1" onblur="validatePassword()">
                            <span id="errorPassword"></span>
                        </div>
                        <button type="submit" class="btn btn-dark btn btn-lg login-button">LOGIN</button>
                        
                    </form>
                </div>
                <div class="col-lg-2">
                    
                </div>
            </div>
        </div>
	
	
	<script type="text/javascript" src="../js/loginValidate.js"></script>
</body>
</html>
