package com.AMRApp.service;

import com.AMRApp.dao.ManagerCreditsRenewDaoInterface;

public class ManagerCreditsRenew implements ManagerCreditsRenewInterface {

	ManagerCreditsRenewDaoInterface mdao;
	
	@Override
	public void renewCredits() {
		mdao.renewCredits();
	}

}
