//--------------------Get the Meeting Data in the button----------------------------------------------
function giveMeetingData(event)
{
	event.preventDefault()
	if(document.querySelector('.organizeMeeting').hasAttribute('data-name') == false)
	{
		document.getElementById("selectMeetingRoomError").innerHTML = "Kindly select the Meeting Room!"
	}
	else
	{
		document.getElementById("selectmeetingRoomError").innerHTML = null
		window.location.href = "bookTimeSlot.jsp"
	}
}


//------------------------------When the Card gets Clicked---------------------------------------------
function highlightMeetingRoom()
{
	document.querySelector('.card').style.border = "thick solid black"
	
			let meetingName = document.querySelector('.card-header').getAttribute('data-name')
			let meetingCapacity = document.querySelector('.card-title').getAttribute('data-capacity')
			let meetingRatings = document.querySelector('.card-text').getAttribute('data-ratings')
			
			document.querySelector('.organizeMeeting').setAttribute('data-name',meetingName)
			document.querySelector('.organizeMeeting').setAttribute('data-capcity',meetingCapacity)
			document.querySelector('.organizeMeeting').setAttribute('data-ratings',meetingRatings)
			
}

