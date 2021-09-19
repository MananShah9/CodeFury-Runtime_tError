
CREATE TABLE Meeting(meetingId int PRIMARY KEY AUTO_INCREMENT, meetingtitle varchar(60), organisedBy int, meetingDate varchar(20), startTime varchar(20), endTime varchar(20), meetingmembers int,  meetingType varchar(30), CONSTRAINT fk_oid FOREIGN KEY (organisedBy) REFERENCES User(userId),  CONSTRAINT fk_mid FOREIGN KEY (meetingmembers) REFERENCES MeetingsAndMembers(Id));

CREATE TABLE MeetingsAndMembers(id int AUTO_INCREMENT, meetingId int , memberId int, CONSTRAINT fk_meetingid FOREIGN KEY meetingId REFERENCES Meeting(meetingId), CONSTRAINT fk_oid FOREIGN KEY (organisedBy) REFERENCES User(userId) );

CREATE TABLE Amenities(amenityId int PRIMARY KEY AUTO_INCREMENT,projector int, wifi int, conCall int, whiteboard int, waterDispenser int, TV int, Coffee int);

CREATE TABLE MeetingRoom(meetingName varchar(60) PRIMARY KEY, seatingCapacity int, ratings int, amenitiesAvail int , perHourCost int, CONSTRAINT fk_aid FOREIGN KEY (amenitiesAvail) REFERENCES Amenities(amenityId) );

CREATE TABLE CreditsAvailable(id int  PRIMARY KEY AUTO_INCREMENT, managerId int, CONSTRAINT fk_cid FOREIGN KEY(managerID) REFERENCES User(userId));

CREATE TABLE User(userId int PRIMARY KEY AUTO_INCREMENT,userName varchar(30),userEmail varchar(50),userPhone varchar(30),userCredits int,userRole varchar(10),userPass varchar(20),CONSTRAINT fk_uCredits FOREIGN KEY (userCredits) REFERENCES CreditsAvailable(id));
	
CREATE TABLE BookingInfo(bookingId int PRIMARY KEY AUTO_INCREMENT,meetingRoomName varchar(20),bookingDate varchar(20),startTime varchar(20),endTime varchar(20),organiserId int,CONSTRAINT fk_oId FOREIGN KEY (organiserId) REFERENCES User(userId),CONSTRAINT fk_meetRoomName FOREIGN KEY (meetingRoomName) REFERENCES MeetingRoom(roomName));