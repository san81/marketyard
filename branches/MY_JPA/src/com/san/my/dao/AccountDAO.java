package com.san.my.dao;

import java.util.List;

import com.san.my.dataobj.AccountTypesDO;
import com.san.my.dataobj.AccountDO;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.viewobj.AccountSummaryForm;

public interface AccountDAO{
	
	public void saveAccount(AccountDO accountsDO);
	
	public boolean isLoginNameExists(String loginName);
	
	public List<AccountDO> listAllAccounts();
	
	public List<AccountDO> listAllAccountsForSelection();
    
    public List<String> listAllAccountTypes();
    
    public AccountTypesDO getAccountTypeDO(String accountType);
    
    public AccountDO loadAccountDO(Long accountId);
    
    public AccountDO getAccountDO(Long accountId);
    
   public List<BussinessTransactionDO> getAccountBTransactionDO(AccountSummaryForm accountSummaryForm);
    
    public List getAccountStartingBalance(AccountSummaryForm accountSummaryForm);
}
