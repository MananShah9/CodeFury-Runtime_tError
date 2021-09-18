//function validateOrganizeMeetingForm(event){
//	
//	event.preventDefault();
//	
//	
//	let meetingTitle = document.getElementById("meetingTitle").value;
//	let meetingDate = document.getElementById("meetingDate").value;
//	let startTime = document.getElementById("startTime").value;
//	let endTime = document.getElementById("endTime").value;
//	let duration = document.getElementById("duration").value;
//	
//	let searchRooms = document.getElementById("searchRooms");
//	
//	if(meetingType && meetingTitle && meetingDate && startTime && endTime)
//		{
//			searchRooms.removeAttribute("disabled")
//		}
//	
//}


function validateMeetingType()
{
	let meetingType = document.getElementById("meetingType").value;
	if(meetingType=="")
		{
			document.getElementById("errorMeetingType").innerHTML = "Kindly select the meeting type"
		}
}

function validateMeetingTitle(){
	let meetingTitle = document.getElementById("meetingTitle").value;
	if(meetingTitle=="")
		{
		document.getElementById("errorMeetingTitle").innerHTML = "Kindly give the meeting title"
		}
}


function validateMeetingDate(){
	let meetingDate = document.getElementById("meetingDate").value;
	let date = new Date()
	
	var selectedDate = new Date(meetingDate);
	   var now = new Date();
	   if (selectedDate < now) {
		   document.getElementById("errorMeetingDate").innerHTML = "Date must be in the future"
	   }
}

function validateTime(){
	
	let startTime = document.getElementById("startTime").value;
	let date = new Date()
	var nowTime = date.getTime()
	
	let selectedTime
}
