package com.san.my.dao.impl;

import com.san.my.dao.BTransactionsDAO;
import com.san.my.dataobj.BussinessTransactionDO;

public class BTransactionsDAOImpl extends ObjectDAOImpl implements BTransactionsDAO{

	public void saveBusinessTransaction(BussinessTransactionDO activity) {
		save(activity);
	}

}
