package com.san.my.common.util.springs;

import org.apache.log4j.Logger;

import com.san.my.service.AccountService;
import com.san.my.service.SeedsService;

public class ServiceLocator {
	static Logger logger = Logger.getLogger(ServiceLocator.class);
	
	public static AccountService getAccountService() throws Exception{
		AccountService accountService = (AccountService)BeanLocatorFactory.getBean("accountService");
		return accountService;
	}
	
	public static SeedsService getSeedsService() throws Exception{
		SeedsService seedsService = (SeedsService)BeanLocatorFactory.getBean("SeedsService");
		return seedsService;
	}
	
}
