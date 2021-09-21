package com.AMRApp.service;

import java.util.List;

import com.AMRApp.beans.User;
import com.AMRApp.dao.GetAllUsersImpl;
import com.AMRApp.dao.GetAllUsersInterface;

public class GetUserTable implements GetUserTableInterface {
	GetAllUsersInterface gDao ;
	public GetUserTable() {
		gDao= new GetAllUsersImpl();
	}

	@Override
	public List<User> getUsers() {
		return gDao.getUserNames();
	}

}
