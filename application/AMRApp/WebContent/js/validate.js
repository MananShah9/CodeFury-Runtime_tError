function validateOrganizeMeetingForm(event){
	
	event.preventDefault();
	
	let meetingType = document.getElementById("meetingType").value;
	let meetingTitle = document.getElementById("meetingTitle").value;
	let meetingDate = document.getElementById("meetingDate").value;
	let startTime = document.getElementById("startTime").value;
	let endTime = document.getElementById("endTime").value;
	let duration = document.getElementById("duration").value;
	
	let searchRooms = document.getElementById("searchRooms");
	
	if(meetingType && meetingTitle && meetingDate && startTime && endTime)
		{
			searchRooms.removeAttribute("disabled")
		}
	
}