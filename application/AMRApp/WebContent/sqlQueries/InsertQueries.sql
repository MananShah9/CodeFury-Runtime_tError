
| meetingId | meetingtitle  | organisedBy | meetingDate | startTime | endTime | meetingType     |
+-----------+---------------+-------------+-------------+-----------+---------+-----------------+
|         1 | Discuss stuff |           3 | 20-05-2021  | 12:00     | 3:00    | Online Training

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
 
 
 INSERT INTO Meeting( meetingtitle, organisedBy, meetingDate, startTime, endTime, meetingType) values 
 (" Discuss stuff" , 1 ,"20-05-2021","12:00"," 3:00"," Online Training");