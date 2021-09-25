package com.AMRApp.factory;

import com.AMRApp.dao.ManagerBookDAO;
import com.AMRApp.dao.ManagerBookDAOInterface;
import com.AMRApp.dao.ManagerCreditsRenewDao;
import com.AMRApp.dao.ManagerCreditsRenewDaoInterface;
import com.AMRApp.dao.ManagerHomePageDAO;
import com.AMRApp.dao.ManagerHomePageDAOInterface;
import com.AMRApp.dao.ManagerOrganizeDao;
import com.AMRApp.dao.ManagerOrganizeDaoInterface;
import com.AMRApp.service.ManagerBookService;
import com.AMRApp.service.ManagerBookServiceInterface;
import com.AMRApp.service.ManagerCreditsRenewService;
import com.AMRApp.service.ManagerCreditsRenewServiceInterface;
import com.AMRApp.service.ManagerHomePageService;
import com.AMRApp.service.ManagerHomePageServiceInterface;
import com.AMRApp.service.ManagerOrganizeService;
import com.AMRApp.service.ManagerOrganizeServiceInterface;

public class ManagerFactory {

	public ManagerHomePageDAOInterface getDaoInstanceHomePage() {
		return new ManagerHomePageDAO();
	}
	
	public ManagerBookDAOInterface getDaoInstanceBook() {
		return new ManagerBookDAO();
	}
	
	public ManagerOrganizeDaoInterface getDaoInstanceOrganize() {
		return new ManagerOrganizeDao();
	}
	
	public ManagerCreditsRenewDaoInterface getDaoInstanceCredits() {
		return new ManagerCreditsRenewDao();
	}
	
	public ManagerHomePageServiceInterface getServiceInstanceHomePage() {
		return new ManagerHomePageService();
	}
	
	public ManagerBookServiceInterface getServiceInstanceBook() {
		return new ManagerBookService();
	}
	
	public ManagerOrganizeServiceInterface getServiceInstanceOrganize() {
		return new ManagerOrganizeService();
	}
	
	public ManagerCreditsRenewServiceInterface getServiceInstanceCredits() {
		return new ManagerCreditsRenewService();
	}
	
	
	
}