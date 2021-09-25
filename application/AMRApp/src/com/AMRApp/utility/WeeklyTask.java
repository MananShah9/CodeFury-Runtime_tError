package com.AMRApp.utility;

import com.AMRApp.factory.ManagerFactory;
import com.AMRApp.service.ManagerCreditsRenewServiceInterface;

public class WeeklyTask implements Runnable {


@Override
public void run() {
	ManagerCreditsRenewServiceInterface mCreditsService = new ManagerFactory().getServiceInstanceCredits();
}

}
