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
    
    public List<String> listAllAccountTypes();
    
    /**
     * Method to return a list of String[] objects holding 
     * accountId and accounts login name in sequence.
     * this method is used to display the accounts in 
     * autofill combo boxes in the stuts form.
     *  
     * @return
     */
    public List<String[]> listAccountIdsAndNames();
}
