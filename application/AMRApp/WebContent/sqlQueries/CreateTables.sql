CREATE TABLE User(userId int PRIMARY KEY AUTO_INCREMENT,userName varchar(30),userEmail varchar(50),
	userPhone varchar(30),userRole varchar(10),userCredits int default 0, userPass varchar(20));

CREATE TABLE Meeting(meetingId int PRIMARY KEY AUTO_INCREMENT, meetingtitle varchar(60), organisedBy int, meetingDate varchar(20), 
	startTime varchar(20), endTime varchar(20),  meetingType varchar(30),
	 CONSTRAINT fk_oid FOREIGN KEY (organisedBy) REFERENCES User(userId) ON DELETE CASCADE);

CREATE TABLE MeetingsAndMembers(id int PRIMARY KEY AUTO_INCREMENT, meetingId int , memberId int,
 CONSTRAINT fk_meetingid FOREIGN KEY (meetingId) REFERENCES Meeting(meetingId) ON DELETE CASCADE,
  CONSTRAINT fk_memid FOREIGN KEY (memberId) REFERENCES User(userId) ON DELETE CASCADE );

CREATE TABLE MeetingRoom(meetingRoomName varchar(60) PRIMARY KEY, seatingCapacity int, ratings int,
	perHourCost int, organiser varchar(60));	
	
CREATE TABLE Amenities(amenityId int PRIMARY KEY AUTO_INCREMENT,projector int, wifi int, conCall int, whiteboard int,
 waterDispenser int, TV int, Coffee int,meetingRoomName varchar(60),
 CONSTRAINT fk_meid FOREIGN KEY (meetingRoomName) REFERENCES MeetingRoom(meetingRoomName) ON DELETE CASCADE);

CREATE TABLE BookingInfo(bookingId int PRIMARY KEY AUTO_INCREMENT,
	meetingRoomName varchar(20),bookingDate varchar(20),startTime varchar(20),
	endTime varchar(20),organiserId int,CONSTRAINT fk_orgId FOREIGN KEY (organiserId) REFERENCES User(userId) ON DELETE CASCADE,
	CONSTRAINT fk_meetRoomName FOREIGN KEY (meetingRoomName) REFERENCES MeetingRoom(meetingRoomName) ON DELETE CASCADE);

CREATE TABLE Feedback (
id int primary key AUTO_INCREMENT,
meetingRoomName varchar (30),
userId int(50),
rating int default 0,
foreign key (userId) references User(userId) ON DELETE CASCADE,
foreign key (meetingRoomName) references MeetingRoom(meetingRoomName) ON DELETE CASCADE
);


//Below tables are just 0n Trial Basis:

CREATE table MeetingsAndTheirCorrespondingRooms(meetingId int, meetingRoomName varchar(60), 
CONSTRAINT fk_meetingRoomName FOREIGN KEY (meetingRoomName) REFERENCES MeetingRoom(meetingRoomName) ON DELETE CASCADE,
CONSTRAINT fk_meetId FOREIGN KEY (meetingId) REFERENCES Meeting(meetingId) ON DELETE CASCADE);