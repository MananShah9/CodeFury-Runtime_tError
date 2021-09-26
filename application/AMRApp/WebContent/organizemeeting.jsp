<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="com.AMRApp.controller.*" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">

        <link rel="stylesheet" href="css/organize.css">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <title>Organize Meeting</title>


    </head>
    
    <script>
    

    function generateDropDownDom() {
    	var dropDownContent;
    	var elements =document.getElementsByName("membersdiv");
    	for(var ele =0;ele<elements.length ;ele++){
    		console.log(elements[ele]);
    		elements[ele].style.display = "none";
    	}
    	var starting = document.getElementById("toSearch").value;
    	
    	for (var userId in users) {
    		if(users[userId].startsWith(starting)){
    			document.getElementById(userId+"div").style.display = "block";
    			
    		}
    	}

    }

    function getUserSuggestions() {
    	var name = document.querySelector(".input-container input").value;
    	var x = new XMLHttpRequest();
    	//step 2 how xhr will open connection with server
    	
    	
    	x.open("GET", "searchUser.jsp");
    	//step 3 how xhr will send request
    	x.send();

    	//step 4 how xhr will get response from server
    	//state={0,1,2,3,4}

    	x.onreadystatechange = function () {
    		if (x.readyState == 4) {
    			 users = JSON.parse(x.responseText);

    			 dropDownContent = ` <ul> `;
    				for (var userId in users) {
    					
    					dropDownContent += 
    					"<div name=\"membersdiv\" id=\""+userId+"div\"  >   <input type=\"checkbox\" id=\""+userId+"\"  name=\"members\" class=\"members\" value="+userId+">&nbsp;&nbsp;<label>"+ users[userId]+"</label></div>";
    				}
    				dropDownContent += `</ul > `;
    				document.querySelector(".content-container").innerHTML = dropDownContent;
    			
    		}
    	}
    }
    var users;
     
    </script>

    <body onload="getUserSuggestions()">
        <jsp:include page="header.jsp" />

        <div class="heading-organize">
            <h2>Organize a Meeting</h2>
        </div>
        <form onSubmit="validateOrganizeMeetingForm(event)" action="OrganizeMeetingServlet" method="POST" id="organizeMeetingForm">
            <div class="container">
                <div class="row">
                    <div class="col-lg-1">

                    </div>
                    <div class="col-lg-10 mt-5">
                        <div>
                            <select onblur="validateMeetingType()" required name="meetingType" id="meetingType"
                                class="form-select" aria-label="Default select example">
                                <option selected>Select the type of Meeting</option>
                                <option value="Classroom Training">Classroom Training</option>
                                <option value="Online Training">Online Training</option>
                                <option value="Conference Call">Conference Call</option>
                                <option value="Business">Business</option>
                            </select>
                            <span id="errorMeetingType"></span>
                        </div>
                        <div class="input-group mb-3 mt-4">
                            <div class="mb-3">
                                <label class="form-label">
                                    <h5>Title of the Meeting : </h5>
                                </label>
                                <input onblur="validateMeetingTitle()" required name="meetingTitle" id="meetingTitle"
                                    type="text" class="form-control">
                                <span id="errorMeetingTitle"></span>
                            </div>
                        </div>
                        <div class="input-group mb-3 mt-4">
                            <div class="mb-3">
                                <label class="form-label">
                                    <h5>Meeting Date : </h5>
                                </label>
                                <input onblur="validateMeetingDate()" required name="meetingDate" id="meetingDate"
                                    type="date" class="form-control">
                                <span id="errorMeetingDate"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="input-group mb-3 mt-3">
                                    <div class="mb-3">
                                        <label class="form-label">
                                            <h5>Start Time : </h5>
                                        </label>
                                        <input onblur="validateTime()" required id="startTime" name="startTime"
                                            type="time" class="form-control">
                                        <span id="timeError"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="input-group mb-3 mt-3">
                                    <div class="mb-3">
                                        <label class="form-label">
                                            <h5>End Time : </h5>
                                        </label>
                                        <input onblur="validateTime()" required id="endTime" name="endTime" type="time"
                                            class="form-control">
                                        <span id="timeError"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="input-group mb-3 mt-3">
                                    <div class="mb-3">
                                        <label class="form-label">
                                            <h5>Duration: </h5>
                                        </label>
                                        <br />
                                        <span><b id="durationHrsMin"></b></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class='input-container'>

                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                data-bs-target="#addMembersModal">
                                Add Members
                            </button>
                            <button onclick="checkMembersAddedOrNot(event)" class="btn btn-success" type="submit">Search for Available Rooms</button>
							<br />
                            <!-- Modal -->
                            <div class="modal fade" id="addMembersModal" tabindex="-1" aria-labelledby="addMembersModal"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="addMembersModal">Add Members for the Meeting
                                            </h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                       
	                                        <div class="modal-body">
	                                            <input placeholder="Search for Members!" type=text class="form-control width100" id="toSearch"
	                                                onkeyup="generateDropDownDom();">
	                                                <span style="color: red;" id="membersContainer"></span>
	                                            <div class="content-container">
	                                            </div>
	
	                                        </div>
	                                        <div class="modal-footer">
	                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Save</button>
	                                            
	                                        </div>
                                      
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-1">

                        </div>
                    </div>
                    <br />
                </div>
            </div>
        </form>
        <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/validate.js"></script>
    </body>

    </html>
