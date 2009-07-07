package com.san.my.web.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.util.springs.ServiceLocator;
import com.san.my.service.AccountService;
import com.san.my.viewobj.AccountsView;

public class AccountsList extends ActionSupport{
	long totalCount;
	List accounts = new ArrayList<AccountsView>();
	
	public List getAccounts() {
		return accounts;
	}
	public void setAccounts(List accounts) {
		this.accounts = accounts;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public String execute() throws Exception{
		AccountService service = ServiceLocator.getAccountService();
		accounts = service.listAllAccounts();
		return SUCCESS;
	}
}
