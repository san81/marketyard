package com.san.my.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.AccountService;
import com.san.my.service.AccountSummary;
import com.san.my.viewobj.AccountSummaryForm;
import com.san.my.viewobj.AccountsView;

public class AccountsList extends ActionSupport{
	long totalCount;
	List<AccountsView> accounts;
	List accountIdAndNameList=new ArrayList<String[]>();
	AccountService accountService;
	AccountSummary accountSummary;
	AccountSummaryForm accountSummaryForm;
	
	
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
	
	public String listForSelection() throws Exception{
		accountIdAndNameList=accountService.listAccountIdsAndNames();
		return SUCCESS;
	}
	public List getAccountIdAndNameList() {
		return accountIdAndNameList;
	}
	public void setAccountIdAndNameList(List accountIdAndNameList) {
		this.accountIdAndNameList = accountIdAndNameList;
	}
	
	public String listAccountBTransactions(){
		List<BussinessTransactionDO> accountBTransactions = accountSummary.listAccountBTransactions(accountSummaryForm);
		for(BussinessTransactionDO bt : accountBTransactions){
			System.out.println(bt.getTransFlow());
		}
		this.accountSummaryForm.setAccountBTransactions(accountBTransactions);
		return SUCCESS;
	}
	public AccountSummaryForm getAccountSummaryForm() {
		return accountSummaryForm;
	}
	public void setAccountSummaryForm(AccountSummaryForm accountSummaryForm) {
		this.accountSummaryForm = accountSummaryForm;
	}
	public void setAccountSummary(AccountSummary accountSummary) {
		this.accountSummary = accountSummary;
	}
	
}
