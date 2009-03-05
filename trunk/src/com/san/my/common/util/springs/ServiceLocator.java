package com.san.my.common.util.springs;

import org.apache.log4j.Logger;

import com.san.my.service.AccountService;

public class ServiceLocator {
	static Logger logger = Logger.getLogger(ServiceLocator.class);
	
	public static AccountService getAccountService() throws Exception{
		AccountService accountService = (AccountService)BeanLocatorFactory.getBean("accountService");
		return accountService;
	}
	
}
