package com.san.my.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.service.AccountService;
import com.san.my.viewobj.AccountsView;

public class AccountsList extends ActionSupport{
	long totalCount;
	List<AccountsView> accounts;
	AccountService accountService;
	
	public List getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountsView> accounts) {
		this.accounts = accounts;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public String execute() throws Exception{		
		accounts = accountService.listAllAccounts();
		return SUCCESS;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
