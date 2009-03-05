package com.san.my.dao;

import com.san.my.dataobj.AccountsDO;

public interface AccountDAO{
	
	public void saveAccount(AccountsDO accountsDO);
	
	public boolean isLoginNameExists(String loginName);
}
