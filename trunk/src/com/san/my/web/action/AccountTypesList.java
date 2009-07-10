
package com.san.my.web.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.util.springs.ServiceLocator;
import com.san.my.service.AccountService;

public class AccountTypesList extends ActionSupport
{
    List accountTypes = new ArrayList<String[]>();
    AccountService accountService;

    public String execute() throws Exception    {
        
        accountTypes = accountService.listAllAccountTypes();
        return SUCCESS;
    }

    public List getAccountTypes()
    {
        return accountTypes;
    }

    public void setAccountTypes(List accountTypes)
    {
        this.accountTypes = accountTypes;
    }

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
