User Table:

INSERT INTO User(userName, userEmail, userPhone, userRole, userCredits, userPass) values 
("Kanishka", "thapliyalkanishka@gmail.com", "7734832646", "Manager", 2000, "kanishka");

INSERT INTO User(userName, userEmail, userPhone, userRole, userCredits, userPass) values
("Vani", "vaniagarwal@gmail.com", "9453605961", "Manager", 2000, "vani");

 INSERT INTO User(userName, userEmail, userPhone, userRole, userPass) values
 ("Tejas", "tejas@gmail.com", "8983757960", "Admin", "tejas");

INSERT INTO User(userName, userEmail, userPhone, userRole, userPass) values
("Manan", "shahmanan@gmail.com", "8999511181", "Admin", "manan");

 INSERT INTO User(userName, userEmail, userPhone, userRole, userPass) values
 ("Kanika", "kanika@gmail.com", "8920565888", "Member", "kanika");
 
 INSERT INTO User(userName, userEmail, userPhone, userRole, userPass) values
 ("Dharmesh", "dharmesh@gmail.com", "9798416266", "Member", "dharmesh");
 
 Meeting Table: 
 
INSERT INTO Meeting( meetingtitle, organisedBy, meetingDate, startTime, endTime, meetingType) values
 (" Discuss stuff" , 1 ,"20-10-2021","12:00"," 15:00","Classroom Training");
 
 MeetingRoom Table:
 
INSERT INTO MeetingRoom Values ("Meeting Room 1", 15, 4, 30, "Tejas");

 INSERT INTO MeetingRoom Values ("Meeting Room 2", 10, 5, 20, "Tejas");
 
 Amenities Table:
 
 INSERT INTO AMENITIES(projector,whiteboard,meetingRoomName) VALUES(1,1,"Meeting Room 1");
 
 INSERT INTO AMENITIES(projector,whiteboard,meetingRoomName) VALUES(1,1,"Meeting Room 2");
 
 