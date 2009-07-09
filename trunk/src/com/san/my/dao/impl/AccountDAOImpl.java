package com.san.my.dao.impl;



import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountTypesDO;
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

	public List<AccountsDO> listAllAccounts() {
		return findAll(AccountsDO.class);		
	}

    public List<String> listAllAccountTypes()
    {
        List<String> accoutTypes = find("select at.accountType from AccountTypesDO at");
        System.out.println("account types: "+accoutTypes.size());
        return accoutTypes;
    }

    public <T> List<T> findBySqlQuery(String query, Map<String, Type> scalars, List<Object> binds, Class<T> aliasClass)
    {
        return null;
    }

    public AccountTypesDO getAccountTypeDO(String accountType)
    {
        AccountTypesDO accountTypesDO = (AccountTypesDO)findOne("from AccountTypesDO at where at.accountType = '"+accountType+"'");
        return accountTypesDO;
    }
	
}
