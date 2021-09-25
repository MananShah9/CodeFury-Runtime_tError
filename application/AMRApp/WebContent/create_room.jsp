<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*"%>
    
     
     <%@ page isELIgnored="false" %>


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
  <title>Create Room</title>
</head>

<body>
 
 
	<jsp:include page="sidebar.jsp"/>
	  <main>
	  	<h1>Create Room</h1>
	    
	    <section>
	    		
	    	<div class="mask d-flex align-items-center">
			    <div class="container">
			      <div class="row d-flex justify-content-center align-items-center">
			        <div class="col-12 col-md-9 col-lg-9 col-xl-9">
			          <div class="card" style="border-radius: 15px;height: 32rem;">
			            <div class="card-body p-4">
			              <form  method="post" action="AdminCreateRoom">
			                <div class="form-outline">
			                  <label class="form-label" for="name">Name</label>
			                  <input type="text" id="name" name="meetingname" class="form-control form-control-lg" required />
			                </div>
			
			                <div class="form-outline mb-4">
			                  <label class="form-label" for="seatingcapacity">Seating Capacity</label>
			                  <input type="number" id="seatingcapacity" name="seatingcapacity" class="form-control form-control-lg" required />
			                </div>
			
			                <div class="form-outline mb-2">
			                  <label class="form-label" for="amenities" id="cberror">Amenities Available</label><br />
			                  <span style="color: red;" id="checkboxSelectError"></span>
			                </div>
							
			               <div class="form-check d-flex  mb-2">
			                <input class="form-check-input me-2" type="checkbox" value="Projector" id="projector" name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="projector">Projector</label>
			                </div>
			                <div class="form-check d-flex  mb-2">
			                	<input class="form-check-input me-2" type="checkbox" value="WiFi Connection" id="wificonnection" name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="wificonnection">WiFi Connection</label>
			                </div>
			                 <div class="form-check d-flex mb-2">
			                	<input class="form-check-input me-2" type="checkbox" value="Conference call facility" id="conferencecallfacility" name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="conferencecallfacility">Conference Call Facility</label>
			                </div>
			                <div class="form-check d-flex  mb-2">
			                	<input class="form-check-input me-2" type="checkbox" value="Whiteboard" id="whiteboard" name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="whiteboard">Whiteboard</label>
			                </div>
			                <div class="form-check d-flex  mb-2">
			                	<input class="form-check-input me-2" type="checkbox" value=" Water dispenser" id="waterdispenser" name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="waterdispenser">Water Dispenser</label>
			                </div>
			                <div class="form-check d-flex  mb-2">
			                	<input class="form-check-input me-2" type="checkbox" value="TV" id="tv"name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="tv">TV</label>
			                </div>
			                <div class="form-check d-flex  mb-4">
			                	<input class="form-check-input me-2" type="checkbox" value="Coffee Machine" id="coffeemachine" name="amenities"/>
			                    <label class="form-check-label" name="amenities" for="coffeemachine">Coffee Machine</label>
			                    
			                    <div style="margin-left:45%;">
			                    	 <button type="submit" class="btn btn-success ml-3 mb-3">SAVE</button>
			                    	<a href="admin.jsp" class="btn btn-danger ml-3 mb-3">CANCEL</a>
			                    </div>
			                   
			                </div>
			               
			               </form>
			            </div>
			          </div>
			        </div>
			      </div>
			    </div>
  			</div>
	    	
	    </section>
	  </main>
	  
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/createRoomValidate.js"></script>
</body>
</html>
