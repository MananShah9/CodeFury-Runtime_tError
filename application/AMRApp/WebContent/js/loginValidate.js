//---------------Validating Password----------------------------


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
		console.log("here")
		document.getElementById("errorPassword").innerHTML = ""
			document.getElementById("loginForm").submit();
	}
}


