package com.san.my.service.impl;

import java.util.Calendar;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountsDO;
import com.san.my.service.AccountService;
import com.san.my.web.action.account.AccountForm;

public class AccountServiceImpl implements AccountService {

	public AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void saveAccount(AccountForm form) {
		AccountsDO accountsDO = new AccountsDO();
		accountsDO.setLoginName(form.getLoginName());
		accountsDO.setName(form.getName());
		accountsDO.setAddress(form.getAddress());
		accountsDO.setVillage(form.getVillage());
		accountsDO.setRegdate(Calendar.getInstance().getTime());
		
		accountDAO.saveAccount(accountsDO);
	}	
	
	public boolean isLoginNameExists(String loginName){
		return accountDAO.isLoginNameExists(loginName);
		
	}

}
