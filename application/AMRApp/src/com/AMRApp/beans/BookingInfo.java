package com.AMRApp.beans;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */
import java.util.Objects;

public class BookingInfo {
	private int bookingId;
	private MeetingRoom meetingRoom;
	private String bookingDate;
	private String startTime;
	private String endTime;
	private int organiserId;
	
	//non-parameterized constructor
	public BookingInfo() {
		
	}
	
	//initializing members
	public BookingInfo(int bookingId, MeetingRoom meetingRoom, String bookingDate, String startTime, String endTime,
			int organiserId) {
		this.bookingId = bookingId;
		this.meetingRoom = meetingRoom;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.organiserId = organiserId;
	}

	//getters and setters
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getOrganiserId() {
		return organiserId;
	}

	public void setOrganiserId(int organiserId) {
		this.organiserId = organiserId;
	}

	//overriding toString()
	@Override
	public String toString() {
		return "BookingInfo [bookingId=" + bookingId + ", meetingRoom=" + meetingRoom + ", bookingDate=" + bookingDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", bookedById=" + organiserId + "]";
	}

	//overriding equals() and hashcode()
	@Override
	public int hashCode() {
		return Objects.hash(organiserId, bookingDate, bookingId, endTime, meetingRoom, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingInfo other = (BookingInfo) obj;
		return organiserId == other.organiserId && Objects.equals(bookingDate, other.bookingDate)
				&& bookingId == other.bookingId && Objects.equals(endTime, other.endTime)
				&& Objects.equals(meetingRoom, other.meetingRoom) && Objects.equals(startTime, other.startTime);
	}
	
}
