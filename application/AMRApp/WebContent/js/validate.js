//------------------validate the type of meeting---------------------------
function validateMeetingType()
{
	let meetingType = document.getElementById("meetingType").value;
	if(meetingType=="")
		{
			document.getElementById("errorMeetingType").innerHTML = "Kindly select the meeting type"
		}
	else{
		document.getElementById("errorMeetingType").innerHTML = ""
	}
	
}


//------------------validate the title of meeting---------------------------
function validateMeetingTitle(){
	let meetingTitle = document.getElementById("meetingTitle").value;
	if(meetingTitle=="")
		{
		document.getElementById("errorMeetingTitle").innerHTML = "Kindly give the meeting title"
		}
	else{
		document.getElementById("errorMeetingTitle").innerHTML = ""
	}
	
}


//------------------validate the date of meeting---------------------------
function validateMeetingDate(){
	let meetingDate = document.getElementById("meetingDate").value;
	let date = new Date()
	
	var selectedDate = new Date(meetingDate);
	   var now = new Date();
	   if (selectedDate < now) {
		   document.getElementById("errorMeetingDate").innerHTML = "Date must be in the future"
	   }
	   else{
		   document.getElementById("errorMeetingDate").innerHTML = ""
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
		document.getElementById("durationHrsMin").innerHTML = durationHrsMin
	}
	
}
