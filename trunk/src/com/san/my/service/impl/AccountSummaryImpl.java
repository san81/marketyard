/**
 * 
 */
package com.san.my.service.impl;

import java.util.Date;
import java.util.List;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.AccountSummary;
import com.san.my.viewobj.AccountSummaryForm;

/**
 * @author radhika
 *
 */
public class AccountSummaryImpl  implements AccountSummary{
	
	public AccountDAO accountDAO;
	public AccountSummaryUtil accountSummaryUtil;
	
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setAccountSummaryUtil(AccountSummaryUtil accountSummaryUtil) {
		this.accountSummaryUtil = accountSummaryUtil;
	}

	public List<BussinessTransactionDO> listAccountBTransactions(AccountSummaryForm accountSummaryForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
