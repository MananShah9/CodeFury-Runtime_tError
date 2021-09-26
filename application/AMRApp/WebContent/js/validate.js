//------------------validate the type of meeting---------------------------
function validateMeetingType()
{
	let meetingType = document.getElementById("meetingType").value;
	if(meetingType=="")
		{
			document.getElementById("errorMeetingType").innerHTML = "Kindly select the meeting type!"
				document.getElementById("submitButton").disabled = true;

		}
	else{
		document.getElementById("errorMeetingType").innerHTML = ""
			document.getElementById("submitButton").disabled = false;

	}
	
}


//------------------validate the title of meeting---------------------------
function validateMeetingTitle(){
	let meetingTitle = document.getElementById("meetingTitle").value;
	if(meetingTitle=="")
		{
		document.getElementById("errorMeetingTitle").innerHTML = "Kindly give the meeting title!"
			document.getElementById("submitButton").disabled = true;

		}
	else{
		document.getElementById("errorMeetingTitle").innerHTML = ""
			document.getElementById("submitButton").disabled = false;

	}
	
}


//------------------validate the date of meeting---------------------------
function validateMeetingDate(){
	let meetingDate = document.getElementById("meetingDate").value;
	let date = new Date()
	
	var selectedDate = new Date(meetingDate);
	   var now = new Date();
	   if (selectedDate < now) {
		   document.getElementById("errorMeetingDate").innerHTML = "Date must be in the future!"
				document.getElementById("submitButton").disabled = true;

	   }
	   else{
		   document.getElementById("errorMeetingDate").innerHTML = ""
				document.getElementById("submitButton").disabled = false;

	   }
}


//------------------validate the time of meeting---------------------------
function validateTime(){
	
	let startTime = document.getElementById("startTime").value;
	let endTime = document.getElementById("endTime").value;
	
	let[startTimeHours, startTimeMinutes] = startTime.split(":");
	let[endTimeHours, endTimeMinutes] = endTime.split(":");
	
	let validationFailed = false;
	document.getElementById('timeError').innerHTML = '';

	if (startTime === '' || endTime === '') return

	if (startTimeHours > endTimeHours) {
		validationFailed = true;
	}
	else if (startTimeHours === endTimeHours && startTimeMinutes >= endTimeMinutes) {
		validationFailed = true;
	}

	if (validationFailed) {
		document.getElementById('timeError').innerHTML = 'Start time should always be less than end time!';
		document.getElementById("submitButton").disabled = true;

	}
	
	//------------------Display the duration of meeting---------------------------
	let durationHrsMin = ``
	let hours;
	let minutes;
	if(endTimeHours > startTimeHours){
		hours = endTimeHours - startTimeHours
		
		if (hours>1){
			durationHrsMin += `${hours} Hours `
		}
		else if (hours == 1){
			durationHrsMin += `${hours} Hour `
		}
	}
	
	if(endTimeMinutes > startTimeMinutes){
		minutes = endTimeMinutes - startTimeMinutes
		
		if (minutes==1){
			durationHrsMin += `${minutes} Minute`
		}
		else if (minutes > 1){
			durationHrsMin += `${minutes} Minutes`
		}
		else {
			durationHrsMin += " "
		}
	}

	if (!validationFailed)
	{
		document.getElementById("durationHrsMin").innerHTML = durationHrsMin;
		document.getElementById("submitButton").disabled = false;

	}
	else{
		document.getElementById("submitButton").disabled = true;

	}
	
}


    function addAtleastOne(event)
    {
    	event.preventDefault()
		var membersList = document.querySelectorAll(".members")
		var count = 0;
		for(let i=0;i<membersList.length;i++)
		{
			if(membersList[i].checked){
				count = count+1
			}
		}
		
		if (count < 1){
			document.getElementById("membersContainer").innerHTML = "Select atleast a Member!"
				document.getElementById("submitButton").disabled = true;

		}
		else
		{
			document.getElementById("membersContainer").innerHTML = ""
				document.getElementById("submitButton").disabled = false;

		}
	

    		
    }



function checkMembersAddedOrNot(event)
{
	event.preventDefault()
	var membersList = document.querySelectorAll(".members")
		var count = 0;
		for(let i=0;i<membersList.length;i++)
		{
			if(membersList[i].checked){
				count = count+1
			}
		}
		
		if (count < 1){
			alert("Kindly select the Meeting Members!")
						document.getElementById("submitButton").disabled = true;

			return false;
		}
		else
		{
			document.getElementById('organizeMeetingForm').submit()
						document.getElementById("submitButton").disabled = false;


			return true;
		}
	
}
function validateAll(){
	validateMeetingType();
	validateMeetingTitle();
	validateMeetingDate();
	validateTime();
	addAtleastOne();
	checkMembersAddedOrNot();
}