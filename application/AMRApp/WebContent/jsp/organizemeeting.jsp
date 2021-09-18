<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/organize.css">
<title>Organize Meeting</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	 <div class="heading-organize">
        <h2>Organize a Meeting</h2>
    </div>
    <form onSubmit="validateOrganizeMeetingForm(event)">
    	<div class="container">
	        <div class="row">
	            <div class="col-lg-1">
	
	            </div>
	            <div class="col-lg-10 mt-5">
		            <div>
		            	<select required name="meetingType" id="meetingType" class="form-select" aria-label="Default select example">
		                    <option selected>Select the type of Meeting</option>
		                    <option value="1">Business</option>
		                    <option value="2">Casual</option>
		                    <option value="3">Budget</option>
	                	</select>
		            </div>
		             <div class="input-group mb-3 mt-4">
	               		<div class="mb-3">
	  						<label class="form-label"><h5>Title of the Meeting : </h5></label>
	  						<input required name="meetingTitle" id="meetingTitle" type="text" class="form-control">
						</div>
					</div>
	               <div class="input-group mb-3 mt-4">
	               		<div class="mb-3">
	  						<label class="form-label"><h5>Meeting Date : </h5></label>
	  						<input required name="meetingDate" id="meetingDate" type="date" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="input-group mb-3 mt-3">
			               		<div class="mb-3">
			  						<label class="form-label"><h5>Start Time : </h5></label>
			  						<input required id="startTime" name="startTime" type="time" class="form-control">
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="input-group mb-3 mt-3">
			               		<div class="mb-3">
			  						<label class="form-label"><h5>End Time : </h5></label>
			  						<input required id="endTime" name="endTime" type="time" class="form-control">
								</div>
							</div>
						</div>
						<div class="col-lg-2">
							<div class="input-group mb-3 mt-3">
			               		<div class="mb-3">
			  						<label class="form-label"><h5>Duration : </h5></label>
			  						<input id="duration" name="duration" type="text" class="form-control" disabled> Minutes
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button  type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#addMembersModal">
					  Add Members
					</button>
					<button id="searchRooms" type="button" class="btn btn-dark" disabled="true">
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
					        ...
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
	        	<button style="margin-left:80%; margin-top: 25px; margin-bottom: 25px" type="button" class="btn btn-success organize-button">
					Organize Meeting
				</button>
				<br />
	    </div>
    </form>
	<jsp:include page="footer.jsp"/>
	<script src="../js/validate.js" type="text/javascript"></script>
</body>
</html>