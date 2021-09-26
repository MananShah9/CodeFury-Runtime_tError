<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to AutomatedBooking</title>
<link rel="stylesheet" href="../css/main.css">
<style>
body {
    background-image: linear-gradient(to right, #74c567, #28b487);
    margin: 0;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	  <div class="timeline">
        <div class="timeline-container">
            <img class="timeline-image" src="images/timeline.jpeg" alt="Timeline Image">
            <div class="timeline-text">
                <div class="initial">Automates the procedure of booking a </div>
                <div class="name">MEETING ROOM</div>
                <div class="cover-info">Happy Meeting!</div>
            </div>
        </div>
    </div>

    <div class="container meeting-rooms">
        <h2 style="margin-top: 55px; text-align: center">Our Meeting Rooms</h2>
        <div class="row mt-5">
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">Room 1</div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: 5 Members</b></h6>
                        <p class="card-text">Meetings Conducted: 15</p>
                        <p class="card-text">Ratings:</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">Room 1</div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: 5 Members</b></h6>
                        <p class="card-text">Meetings Conducted: 15</p>
                        <p class="card-text">Ratings: </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">Room 1</div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: 5 Members</b></h6>
                        <p class="card-text">Meetings Conducted: 15</p>
                        <p class="card-text">Ratings: </p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">Room 1</div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: 5 Members</b></h6>
                        <p class="card-text">Meetings Conducted: 15</p>
                        <p class="card-text">Ratings:</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">Room 1</div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: 5 Members</b></h6>
                        <p class="card-text">Meetings Conducted: 15</p>
                        <p class="card-text">Ratings: </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xs-6 col-sm-6">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-header">Room 1</div>
                    <div class="card-body">
                        <h6 class="card-title"><b>Seating Capacity: 5 Members</b></h6>
                        <p class="card-text">Meetings Conducted: 15</p>
                        <p class="card-text">Ratings: </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>