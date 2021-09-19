<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create Room</title>
<link rel="stylesheet" href="../css/create_room.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"> 

<script type="text/javascript">
	function validateCheckboxes(){
		var checkboxes= new checkboxes(document.querySelector("form"));
    if(checkboxes.getAll("amenities").length < 2){
    	document.getElementById("cberror").innerHTML="Atleast two checkboxes has be selected";
			return false;
    }else{
    	return true;
    }
	}
</script>
</head>

<body>
	<main>
	<h2>Create Room</h2>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<center>
	<table style="border=1px;">
	<form  method="post" onsubmit="return validateCheckboxes()">
	<tbody>
			<tr>
			<td><label>Name *</label></td><td><input type="text" name="name" required /></td>
			</tr>
			<tr>
			<td><label>Seating capacity *</label></td><td><input type="number" name="seating_capacity" required /></td>
			</tr>
			<tr>
			<td><label id=cberror>Amenities available </label></td>
			</tr>
			<tr>
			<td><input type="checkbox" name="amenities"> Projector</input></td>
			</tr>	
			<tr><td><input type="checkbox" name="amenities"> Wifi Connection</input></td>
				</tr>	
			<tr><td><input type="checkbox" name="amenities"> Conference call facility</input></td>
			</tr>	
			<tr><td><input type="checkbox" name="amenities"> Whiteboard</input></td>
			</tr>	
			<tr><td><input type="checkbox" name="amenities"> Water dispenser</input></td>
			</tr>	
			<tr><td><input type="checkbox"name=" amenities"> TV</input></td>
			</tr>	
			<tr><td><input type="checkbox" name="amenities"> Coffee Machine</input></td>
			</tr>			
</tbody>
</table>
<button style="margin:10px" type="submit" value="Submit">Submit</button>
<button type="reset" value="cancel">Cancel</button>
</form>
</center>
</main>
</body>
</html>