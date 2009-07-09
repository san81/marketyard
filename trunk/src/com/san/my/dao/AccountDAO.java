package com.san.my.dao;

import java.util.List;

import com.san.my.dataobj.AccountTypesDO;
import com.san.my.dataobj.AccountsDO;

public interface AccountDAO{
	
	public void saveAccount(AccountsDO accountsDO);
	
	public boolean isLoginNameExists(String loginName);
	
	public List<AccountsDO> listAllAccounts();
    
    public List<String> listAllAccountTypes();
    
    public AccountTypesDO getAccountTypeDO(String accountType);
}
