package com.san.my.dao;

import com.san.my.dataobj.BussinessTransactionDO;

public interface BTransactionsDAO {
	
	/**
	 * To Save one Business Transaction.
	 * @param seed
	 */
	public void saveBusinessTransaction(BussinessTransactionDO activity);
	
}
