package com.AMRApp.beans;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */

import java.util.List;
import java.util.Objects;

public class Meeting {
	private int meetingId;
	private String meetingTitle;
	private int organiserId;
	private String meetingDate;
	private String startTime;
	private String endTime;
	private String meetingType;
	private List<String> meetingMembers;
	
	//non-parameterized constructor
	public Meeting() {
		
	}
	
	//initializing members
	public Meeting(int meetingId, String meetingTitle, int organiserId, String meetingDate, String startTime,
			String endTime, String meetingType, List<String> meetingMembers) {
		this.meetingId = meetingId;
		this.meetingTitle = meetingTitle;
		this.organiserId = organiserId;
		this.meetingDate = meetingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.meetingType = meetingType;
		this.meetingMembers = meetingMembers;
	}

	
	//getters and setters
	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}

	public int getOrganiserId() {
		return organiserId;
	}

	public void setOrganiserId(int organiserId) {
		this.organiserId = organiserId;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
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

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public List<String> getMeetingMembers() {
		return meetingMembers;
	}

	public void setMeetingMembers(List<String> meetingMembers) {
		this.meetingMembers = meetingMembers;
	}

	//overriding toString()
	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingTitle=" + meetingTitle + ", organiserId=" + organiserId
				+ ", meetingDate=" + meetingDate + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", meetingType=" + meetingType + ", meetingMembers=" + meetingMembers + "]";
	}

	//overriding equals() and hashcode()
	@Override
	public int hashCode() {
		return Objects.hash(endTime, meetingDate, meetingId, meetingMembers, meetingTitle, meetingType, organiserId,
				startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meeting other = (Meeting) obj;
		return Objects.equals(endTime, other.endTime) && Objects.equals(meetingDate, other.meetingDate)
				&& meetingId == other.meetingId && Objects.equals(meetingMembers, other.meetingMembers)
				&& Objects.equals(meetingTitle, other.meetingTitle) && Objects.equals(meetingType, other.meetingType)
				&& organiserId == other.organiserId && Objects.equals(startTime, other.startTime);
	}
	
	
}
