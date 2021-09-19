package com.AMRApp.beans;
import java.util.*;

public class MeetingRoom {
	private String roomName;
	private int roomCapacity;
	private int roomRating;
	private List<String> roomAmenities;
	private int roomPerHourCost;
	private String meetingRoomType;
	private int totalMeetings;
	private String organiser;
	
	//non-parameterized constructor
	public MeetingRoom() {
		
	}

	//initializing members
	public MeetingRoom(String roomName, int roomCapacity, int roomRating, List<String> roomAmenities,
			int roomPerHourCost, String meetingRoomType, int totalMeetings, String organiser) {
		this.roomName = roomName;
		this.roomCapacity = roomCapacity;
		this.roomRating = roomRating;
		this.roomAmenities = roomAmenities;
		this.roomPerHourCost = roomPerHourCost;
		this.meetingRoomType = meetingRoomType;
		this.totalMeetings = totalMeetings;
		this.organiser=organiser;
	}

	//getters and setters
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public int getRoomRating() {
		return roomRating;
	}

	public void setRoomRating(int roomRating) {
		this.roomRating = roomRating;
	}

	public List<String> getRoomAmenities() {
		return roomAmenities;
	}

	public void setRoomAmenities(List<String> roomAmenities) {
		this.roomAmenities = roomAmenities;
	}

	public int getRoomPerHourCost() {
		return roomPerHourCost;
	}

	public void setRoomPerHourCost(int roomPerHourCost) {
		this.roomPerHourCost = roomPerHourCost;
	}

	public String getMeetingRoomType() {
		return meetingRoomType;
	}

	public void setMeetingRoomType(String meetingRoomType) {
		this.meetingRoomType = meetingRoomType;
	}

	public int getTotalMeetings() {
		return totalMeetings;
	}

	public void setTotalMeetings(int totalMeetings) {
		this.totalMeetings = totalMeetings;
	}
	
	public String getOrganiser() {
		return organiser;
	}

	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}

	//overriding toString()
	@Override
	public String toString() {
		return "MeetingRoom [roomName=" + roomName + ", roomCapacity=" + roomCapacity + ", roomRating=" + roomRating
				+ ", roomAmenities=" + roomAmenities + ", roomPerHourCost=" + roomPerHourCost + ", meetingRoomType="
				+ meetingRoomType + ", totalMeetings=" + totalMeetings + ", organiser=" + organiser + "]";
	}

	//overriding hashcode() and equals() method

	@Override
	public int hashCode() {
		return Objects.hash(meetingRoomType, organiser, roomAmenities, roomCapacity, roomName, roomPerHourCost,
				roomRating, totalMeetings);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingRoom other = (MeetingRoom) obj;
		return Objects.equals(meetingRoomType, other.meetingRoomType) && Objects.equals(organiser, other.organiser)
				&& Objects.equals(roomAmenities, other.roomAmenities) && roomCapacity == other.roomCapacity
				&& Objects.equals(roomName, other.roomName) && roomPerHourCost == other.roomPerHourCost
				&& roomRating == other.roomRating && totalMeetings == other.totalMeetings;
	}



	
	
	}
