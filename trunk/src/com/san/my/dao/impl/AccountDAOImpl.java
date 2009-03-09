package com.san.my.dao.impl;



import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountsDO;

public class AccountDAOImpl extends ObjectDAOImpl implements AccountDAO {

	public void saveAccount(AccountsDO accountsDO) {
		save(accountsDO);
	}	
	
	public boolean isLoginNameExists(String loginName){
		long size = count("select count(*) from AccountsDO where loginName like '"+loginName+"'",true);
		if(size==0)
			return false;
		else
			return true;
	}
}
