package com.AMRApp.beans;
/**
 * @author Shivani Sharma
 * @author Ananya Dwivedi
 * @author Dharmesh Soni
 *
 */

import java.util.Objects;

public class User {
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private int userCredits;
	private String userRole;
	private String userPass;
	//Non-parameterized constructor
	public User() {
		
	}
	
	//intializing members
	public User(int userId, String userName, String userEmail, String userPhone, int userCredits, String userRole,String userPass) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userCredits = userCredits;
		this.userRole = userRole;
		this.userPass = userPass;
	}
	
	//getter setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserPass() {
		return userPass;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserCredits() {
		return userCredits;
	}

	public void setUserCredits(int userCredits) {
		this.userCredits = userCredits;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	//Overriding toString()
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userCredits=" + userCredits + ", userRole=" + userRole + ", userPass=" + userPass
				+ "]";
	}

	//Overriding equals() and hash code()
	@Override
	public int hashCode() {
		return Objects.hash(userCredits, userEmail, userId, userName, userPass, userPhone, userRole);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userCredits == other.userCredits && Objects.equals(userEmail, other.userEmail) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userPass, other.userPass)
				&& Objects.equals(userPhone, other.userPhone) && Objects.equals(userRole, other.userRole);
	}

	
	
	
  
}
