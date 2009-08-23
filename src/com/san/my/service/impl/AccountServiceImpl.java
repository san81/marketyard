package com.san.my.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountDO;
import com.san.my.service.AccountService;
import com.san.my.viewobj.AccountsView;
import com.san.my.web.action.account.AccountForm;

public class AccountServiceImpl implements AccountService {

	public AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void saveAccount(AccountForm form) {
		AccountDO accountsDO = new AccountDO();
		accountsDO.setLoginName(form.getLoginName());
        /*
         * Have one default password.
         */
        accountsDO.setPassword("password");
		accountsDO.setName(form.getName());
        accountsDO.setAccountType(accountDAO.getAccountTypeDO(form.getAccountType()));
        accountsDO.setMobile(form.getMobile());
		accountsDO.setAddress(form.getAddress());
		accountsDO.setVillage(form.getVillage());
		accountsDO.setRegdate(Calendar.getInstance().getTime());
		
		accountDAO.saveAccount(accountsDO);
	}	
	
	public boolean isLoginNameExists(String loginName){
		return accountDAO.isLoginNameExists(loginName);
		
	}

	public List<AccountsView> listAllAccounts() {
		List<AccountDO> accounts = accountDAO.listAllAccounts();
		List accountsView = new ArrayList<AccountsView>();
		for(AccountDO account : accounts){
			AccountsView av = new AccountsView(account);
			accountsView.add(av);
		}
		return accountsView;
	}
	
	public List<String[]> listAccountIdsAndNames() {
		List<String[]> accountIdsAndNames=new ArrayList<String[]>();		
		List<AccountDO> accounts = accountDAO.listAllAccountsForSelection();
		for(AccountDO account : accounts){
			String[] accountNameToId = new String[2];
			accountNameToId[1]=account.getAccountId()+"";
			accountNameToId[0]=account.getLoginName();
			accountIdsAndNames.add(accountNameToId);
		}
		return accountIdsAndNames;
	}
	
    public List<String> listAllAccountTypes(){
        List<String> accountTypes = accountDAO.listAllAccountTypes();
        return accountTypes;
    }
}
