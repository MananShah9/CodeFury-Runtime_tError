function validateCheckboxes(event){
	
    const checkboxes = document.querySelectorAll("input[type=checkbox]");

	var count = 0;
	for(let i=0;i<checkboxes.length;i++)
	{
		if(checkboxes[i].checked){
			count = count+1
		}
	}
	
	if (count < 2){
		document.getElementById("checkboxSelectError").innerHTML = "Select atleast 2 Amenities!"
			document.getElementById("submitButton").disabled = true;

	}
	else
	{
		document.getElementById("checkboxSelectError").innerHTML = ""
			document.getElementById("submitButton").disabled = false;

	}
}