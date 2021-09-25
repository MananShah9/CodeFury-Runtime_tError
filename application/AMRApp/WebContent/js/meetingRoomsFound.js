//--------------------Get the Meeting Data in the button---------------------------------------------

function giveMeetingData()
{
	
	if(document.querySelector('.organizeMeeting').hasAttribute('data-name') == false)
	{
		document.getElementById("selectMeetingRoomError").innerHTML = "Kindly select the Meeting Room!"
	}
	else
	{
		document.querySelector('.organizeMeeting').style.visibility="visible"
		document.getElementById("selectmeetingRoomError").innerHTML = null
	}
}


//------------------------------When the Card gets Clicked---------------------------------------------
function highlightMeetingRoom()
{
	document.querySelector('.card').style.border = "thick solid black"
	
	document.querySelector('.organizeMeeting').style.visibility="visible"
	
			let meetingName = document.querySelector('.card-header').getAttribute('data-name')
			let meetingCapacity = document.querySelector('.card-title').getAttribute('data-capacity')
			let meetingRatings = document.querySelector('.card-text').getAttribute('data-ratings')
			
			document.querySelector('.organizeMeeting').setAttribute('data-name',meetingName)
			document.querySelector('.organizeMeeting').setAttribute('data-capcity',meetingCapacity)
			document.querySelector('.organizeMeeting').setAttribute('data-ratings',meetingRatings)
			
}
