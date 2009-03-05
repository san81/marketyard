package com.san.my.service;

import com.san.my.web.action.account.AccountForm;

/**
 * @author Administrator
 *
 */
public interface AccountService {

	public void saveAccount(AccountForm form);
	
	public boolean isLoginNameExists(String loginName);
}
