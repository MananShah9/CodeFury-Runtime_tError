<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.AMRApp.controller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="../css/organize.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.jquery.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.css">
<title>Organize Meeting</title>
<script type="text/javascript">

function generateDropDownDom() {
	var dropDownContent;
	dropDownContent = ` <ul> `;
	for (var userId of suggestedUsers) {
		dropDownContent += `
					<li onclick = addUsertoMeeting(${userId})> ${userIdToNameMap[userId]}
					</li> `;
	}
	dropDownContent += `</ul > `;
	document.querySelector(".content-container").innerHTML = dropDownContent;

}

function getUserSuggestions() {
	var name = document.querySelector(".input-container input").value;
	var x = new XMLHttpRequest();
	//step 2 how xhr will open connection with server
	x.open("GET", "searchUser.jsp?name=" + name, true);

	//step 3 how xhr will send request
	x.send();

	//step 4 how xhr will get response from server
	//state={0,1,2,3,4}

	x.onreadystatechange = function () {
		if (x.readyState == 4) {
			console.log(x.responseText);
			var users = JSON.parse(x.responseText);
			suggestedUsers = [];
			for (var user of users) {
				userIdToNameMap[user.userId] = user.name;
				if (!usersPresentInMeeting.includes(user.userId)) {
					suggestedUsers.push(user.userId)
				}
			}
			generateDropDownDom();
		}
	}
}
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	 <div class="heading-organize">
        <h2>Organize a Meeting</h2>
    </div>
    <form onSubmit="validateOrganizeMeetingForm(event)" action="OrganizeMeetingServlet" method="post">
    	<div class="container">
	        <div class="row">
	            <div class="col-lg-1">
	
	            </div>
	            <div class="col-lg-10 mt-5">
		            <div>
		            	<select onblur="validateMeetingType()" required name="meetingType" id="meetingType" class="form-select" aria-label="Default select example">
		                    <option selected>Select the type of Meeting</option>
		                    <option value="1">Business</option>
		                    <option value="2">Casual</option>
		                    <option value="3">Budget</option>
	                	</select>
	                	<span id="errorMeetingType"></span>
		            </div>
		             <div class="input-group mb-3 mt-4">
	               		<div class="mb-3">
	  						<label class="form-label"><h5>Title of the Meeting : </h5></label>
	  						<input onblur="validateMeetingTitle()" required name="meetingTitle" id="meetingTitle" type="text" class="form-control">
	  						<span id="errorMeetingTitle"></span>
						</div>
					</div>
	               <div class="input-group mb-3 mt-4">
	               		<div class="mb-3">
	  						<label class="form-label"><h5>Meeting Date : </h5></label>
	  						<input onblur="validateMeetingDate()" required name="meetingDate" id="meetingDate" type="date" class="form-control">
	  						<span id="errorMeetingDate"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="input-group mb-3 mt-3">
			               		<div class="mb-3">
			  						<label class="form-label"><h5>Start Time : </h5></label>
			  						<input onblur="validateTime()" required id="startTime" name="startTime" type="time" class="form-control">
			  						<span id="timeError"></span>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="input-group mb-3 mt-3">
			               		<div class="mb-3">
			  						<label class="form-label"><h5>End Time : </h5></label>
			  						<input onblur="validateTime()" required id="endTime" name="endTime" type="time" class="form-control">
			  						<span id="timeError"></span>
								</div>
							</div>
						</div>
						<div class="col-lg-2">
							<div class="input-group mb-3 mt-3">
			               		<div class="mb-3">
			  						<label class="form-label"><h5>Duration: </h5></label>
			  						<br />
			  						<span><b id="durationHrsMin"></b></span>
								</div>
							</div>
						</div>
					</div>
					<div class='input-container'>
			<input type=text class='width100' onkeyup="getUserSuggestions();"> 
			<div class="content-container">
		</div>
					<!-- Button trigger modal -->
					<button  type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#addMembersModal">
					  Add Members
					</button>
					<button id="searchRooms" type="button" class="btn btn-dark">
					 Search Meeting Rooms
					</button>
					<!-- Modal -->
					<div class="modal fade" id="addMembersModal" tabindex="-1" aria-labelledby="addMembersModal" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="addMembersModal">Add Members for the Meeting</h5>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body">
					      	
	                		<!-- <select required name="members" id="members" class="form-select" aria-label="Default select example" multiple="true">
			                    <option selected>Add Members to Meeting</option>
			                    <option value="1">Kanika Bagri</option>
			                    <option value="2">Manan Shah</option>
			                    <option value="3">Kanishka</option>
			                    <option value="4">Ananya Dwivedi</option>
	                		</select> -->
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					        <button type="button" class="btn btn-dark">Save</button>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
	            <div class="col-lg-1">
	
	            </div>
	        </div>
	        	<button style="margin-left:80%; margin-top: 25px; margin-bottom: 25px" type="submit" class="btn btn-success organize-button">
					Organize Meeting
				</button>
				<br />
	    </div>
    </form>
	<jsp:include page="footer.jsp"/>
	<script src="../js/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
$(function() {
    $(".members").chosen();
});
</script>
</body>
</html>
