package com.san.my.dao.impl;

import java.util.Calendar;
import java.util.Date;
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

    public List<BussinessTransactionDO> getLedger(Long accountId)
    {
        return this.findByNamedQueryAndNamedParam(HbmConstants.NAMED_QUERY_GET_LEDGER, "accountId", accountId);
    }
    
    public List<BussinessTransactionDO> getDayTransactionsSheet(Calendar calendar)
    {
        Calendar startTime = (Calendar)calendar.clone();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        
        Calendar endTime = calendar;
        endTime.set(Calendar.HOUR_OF_DAY, 23);
        endTime.set(Calendar.MINUTE, 59);
        endTime.set(Calendar.SECOND, 59);
        endTime.set(Calendar.MILLISECOND, 1000);
        
        String[] paramNames = {"startTime", "endTime"};
        Object[] values = {startTime.getTime(), endTime.getTime()};
        
        return this.findByNamedQueryAndNamedParam(HbmConstants.NAMED_QUERY_GET_TRANSACTIONS_IN_GIVEN_TIMERANGE, paramNames, values);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
