package com.san.my.dao.impl;



import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountsDO;

public class AccountDAOImpl extends ObjectDAOImpl implements AccountDAO {

	public void saveAccount(AccountsDO accountsDO) {
		save(accountsDO);
	}	
	
	public boolean isLoginNameExists(String loginName){
		Criteria criteria = getHibSession().createCriteria(AccountsDO.class);
		criteria.add(Restrictions.eq("loginName", loginName));
		int size = criteria.list().size();
		if(size==0)
			return false;
		else
			return true;
	}
}
