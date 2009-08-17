package com.san.my.dao.impl;

import com.san.my.dao.BTransactionsDAO;
import com.san.my.dataobj.TransactionDO;

public class BTransactionsDAOImpl extends ObjectDAOImpl implements BTransactionsDAO{

	public void saveBusinessTransaction(TransactionDO activity) {
		save(activity);
	}

}
