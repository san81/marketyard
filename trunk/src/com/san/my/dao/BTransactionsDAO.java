package com.san.my.dao;

import java.util.List;

import com.san.my.dataobj.BussinessTransactionDO;

public interface BTransactionsDAO {
	
	/**
	 * To Save one Business Transaction.
	 * @param seed
	 */
	public void saveBusinessTransaction(BussinessTransactionDO bussinessTransactionDO);
    
    public void saveBusinessTransactions(List<BussinessTransactionDO> businessTransactions);
    
    public BussinessTransactionDO getTransactionGivenAccIdAndSlipIdAndFlow(Long accId, Long slipId, String transFlow);
	
}
