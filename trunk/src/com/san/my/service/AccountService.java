package com.san.my.service;

import java.util.List;

import com.san.my.dataobj.AccountsDO;
import com.san.my.viewobj.AccountsView;
import com.san.my.web.action.account.AccountForm;

/**
 * @author Administrator
 *
 */
public interface AccountService {

	public void saveAccount(AccountForm form);
	
	public boolean isLoginNameExists(String loginName);
	
	public List<AccountsView> listAllAccounts();
}
