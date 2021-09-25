package com.AMRApp.service;

import com.AMRApp.dao.ManagerCreditsRenewDaoInterface;
import com.AMRApp.factory.ManagerFactory;

public class ManagerCreditsRenewService implements ManagerCreditsRenewServiceInterface {

	ManagerCreditsRenewDaoInterface mdao;
	
	public ManagerCreditsRenewService() {
		mdao= new ManagerFactory().getDaoInstanceCredits();
	}


	@Override
	public void renewCredits() {
		mdao.renewCredits();
	}

}
