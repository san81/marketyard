package com.san.my.dao.impl;



import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountTypesDO;
import com.san.my.dataobj.AccountDO;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.viewobj.AccountSummaryForm;

public class AccountDAOImpl extends ObjectDAOImpl implements AccountDAO {

	public void saveAccount(AccountDO accountsDO) {
		save(accountsDO);
	}	
	
	public boolean isLoginNameExists(String loginName){
		long size = count("select count(*) from AccountDO where loginName like '"+loginName+"'",true);
		if(size==0)
			return false;
		else
			return true;
	}

	public List<AccountDO> listAllAccounts() {
		return findAll(AccountDO.class);		
	}
	
	public List<AccountDO> listAllAccountsForSelection() {
		Criteria criteria = getSession().createCriteria(AccountDO.class);
		criteria.add(Restrictions.ne("accountType", new AccountTypesDO(1L)))
				.add(Restrictions.ne("accountType", new AccountTypesDO(2L)))
				.add(Restrictions.ne("accountType", new AccountTypesDO(5L)));
				
		return criteria.list();		
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

    public AccountDO loadAccountDO(Long accountId)
    {
        return (AccountDO)load(AccountDO.class, accountId);
    }

    public AccountDO getAccountDO(Long accountId)
    {
        return (AccountDO)get(AccountDO.class, accountId);
    }
    public List<BussinessTransactionDO> getAccountBTransactionDO(AccountSummaryForm accountSummaryForm)
    {
    	String[] paramNames = {"account","startDate","endDate"};
    	Object[] paramValues = {loadAccountDO(accountSummaryForm.getAccountId()),accountSummaryForm.getStartDate()};
    	
    	List tranFlowSummary = findByNamedQueryAndNamedParam("getStartingBalanceForAccount", paramNames, paramValues);
    	return tranFlowSummary;
  
    }
    
    public List getAccountStartingBalance(AccountSummaryForm accountSummaryForm)
    {
    	String[] paramNames = {"account","uptoDate"};
    	Object[] paramValues = {loadAccountDO(accountSummaryForm.getAccountId()),accountSummaryForm.getStartDate()};
    	
    	List tranFlowSummary = findByNamedQueryAndNamedParam("getStartingBalanceForAccount", paramNames, paramValues);
    	return tranFlowSummary;
    }
}
