//---------------Validating username----------------------------

function validateUsername()
{
	let username = document.getElementById("username").value
	if(username == ""){
		document.getElementById("errorUsername").innerHTML = "Username can't be Empty!"
	}
	else{
		document.getElementById("errorUsername").innerHTML = ""
	}
}

//---------------Validating password-----------------------------
function validatePassword()
{
	
	let password = document.getElementById("password").value
	if(password == ""){
		document.getElementById("errorPassword").innerHTML = "Password can't be Empty!"
	}
	else if (password.length < 8){
		document.getElementById("errorPassword").innerHTML = "Password must be atleast 8 characters long!"
	}
	else{
		document.getElementById("errorPassword").innerHTML = ""
	}
}
