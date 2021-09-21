
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.AMRApp.service.*"%>
<%@page import="com.AMRApp.beans.*"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	GetUserTableInterface meetingService = new GetUserTable();

List<User> userList = meetingService.getUsers();
List<String> searchedUserList = new ArrayList<>();

try {

	String name = request.getParameter("name");

	for (User user : userList) {
		if (user.getUserName().startsWith(name)) {
	searchedUserList.add(user.getUserName());
		}
	}

	//convert arraylist to json string

	String userListJson = "[";
	for (int i = 0; i < searchedUserList.size(); i++) {
		if (i != 0)
	userListJson = userListJson + ",";
		userListJson = userListJson + "\""+searchedUserList.get(i).toString()+ "\"";
	}
	userListJson = userListJson + "]";

	// return json

	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	out.print(userListJson);
} catch (Exception e) {

	e.printStackTrace();
}
%>