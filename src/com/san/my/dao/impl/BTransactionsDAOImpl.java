package com.san.my.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.san.my.dao.BTransactionsDAO;
import com.san.my.dataobj.BussinessTransactionDO;

public class BTransactionsDAOImpl extends ObjectDAOImpl implements BTransactionsDAO{

	public void saveBusinessTransaction(BussinessTransactionDO bussinessTransactionDO) {
		save(bussinessTransactionDO);
	}

    public void saveBusinessTransactions(List<BussinessTransactionDO> businessTransactions)
    {
        for(BussinessTransactionDO transactionDO : businessTransactions){
            save(transactionDO);
        }
    }

}
