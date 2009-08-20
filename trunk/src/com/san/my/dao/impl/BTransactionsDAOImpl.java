package com.san.my.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.san.my.common.global.HbmConstants;
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

    public BussinessTransactionDO getTransactionGivenAccIdAndSlipIdAndFlow(Long accId, Long slipId, String transFlow)
    {
        String[] paramNames = {"accountId", "slipId", "transFlow"};
        Object[] values = {accId, slipId, transFlow};
        return (BussinessTransactionDO)this.findOneByNamedQueryAndNamedParam(HbmConstants.NAMED_QUERY_TRANSACTION_GIVEN_ACC_AND_SLIP, paramNames, values);
    }

}
