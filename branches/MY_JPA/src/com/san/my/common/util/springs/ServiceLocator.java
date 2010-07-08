package com.san.my.common.util.springs;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import com.san.my.common.exception.BeanLookupException;
import com.san.my.service.AccountService;
import com.san.my.service.SeedsService;

public class ServiceLocator {
	static Logger logger = Logger.getLogger(ServiceLocator.class);
	
	public static AccountService getAccountService() throws Exception{
		AccountService accountService = (AccountService)BeanLocatorFactory.getBean("accountService");
		return accountService;
	}
	
	public static SeedsService getSeedsService() throws Exception{
		SeedsService seedsService = (SeedsService)BeanLocatorFactory.getBean("seedsService");
		return seedsService;
	}
    
    public static MessageSource getMessageSource(){
        MessageSource messageSource = null;
        try {
            messageSource = (MessageSource)BeanLocatorFactory.getService(MessageSource.class);
        }
        catch (BeanLookupException e) {
            e.printStackTrace();
        }
        
        return messageSource;
    }
	
}
