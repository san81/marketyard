package com.san.my.dao;

import java.util.List;

import com.san.my.dataobj.AccountTypesDO;
import com.san.my.dataobj.AccountDO;

public interface AccountDAO{
	
	public void saveAccount(AccountDO accountsDO);
	
	public boolean isLoginNameExists(String loginName);
	
	public List<AccountDO> listAllAccounts();
    
    public List<String> listAllAccountTypes();
    
    public AccountTypesDO getAccountTypeDO(String accountType);
    
    public AccountDO loadAccountDO(Long accountId);
}
