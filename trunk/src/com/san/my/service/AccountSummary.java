/**
 * 
 */
package com.san.my.service;

import java.util.List;

import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.viewobj.AccountSummaryForm;

/**
 * @author radhika
 *
 */
public interface AccountSummary {
    /**
     * get all the transactions associated with an account. 
     * @param accountId
     * @return
     */
    public List<BussinessTransactionDO> listAccountBTransactions(AccountSummaryForm accountSummaryForm);
}
