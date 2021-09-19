#Not complete file. Vani has to put a couple of queries

CREATE TABLE Meeting(meetingId int PRIMARY KEY, meetingtitle varchar(60), organisedBy int, meetingDate varchar(20), startTime varchar(20), meetingmembers int,  meetingType varchar(30), , CONSTRAINT fk_oid FOREIGN KEY (organisedBy) REFERENCES User(userId),  CONSTRAINT fk_mid FOREIGN KEY (meetingmembers) REFERENCES MeetingsAndMembers(Id)));

CREATE TABLE MeetingsAndMembers(id int, meetingId int , memberId int, CONSTRAINT fk_meetingid FOREIGN KEY meetingId REFERENCES Meeting(meetingId), CONSTRAINT fk_oid FOREIGN KEY (organisedBy) REFERENCES User(userId) );

CREATE TABLE Amenities(amenityId int PRIMARY KEY,projector int, wifi int, conCall int, whiteboard int, waterDispenser int, TV int, Coffee int);

CREATE TABLE MeetingRoom(meetingName varchar(60) PRIMARY KEY, seatingCapacity int, ratings int, amenitiesAvail int , perHourCost int, CONSTRAINT fk_aid FOREIGN KEY (amenitiesAvail) REFERENCES Amenities(amenityId) );

CREATE TABLE CreditsAvailable(id int, managerId int, CONSTRAINT fk_cid FOREIGN KEY(managerID) REFERENCES User(userId));