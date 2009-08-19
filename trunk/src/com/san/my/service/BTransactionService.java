package com.san.my.service;

import com.san.my.web.action.PurchaseSlip;

/**
 * Bussiness Transaction service to persist the slip and transaction entries.
 * @author sreenivas
 * @version $Id$ 
 */
public interface BTransactionService {

	/**
	 * Method to save one purchase slip action.
	 * For every purchase there will be:
     *      1. Five transaction entries are saved if simultaneous monetory transactions are not taking place.
     *         (credit to supplier account, credit to hamali acc, credit to commission acc, creidt to mf acc, debit from buyer acc)
     *      2. Six transaction entries are saved if supplier is paied simultaneously.
     *         (case:1 + debit from supplier account -- in this case supplier acc may be anonymous if he is not already registered)
     *      3. Seven transaction entries are saved if supplier is paied as well as buyer is paying to firm simultaneosly.
     *         (case:2 + credit to buyer account)
	 * 
	 * @param purchaseSlip
	 */
	public void savePurchase(PurchaseSlip purchaseSlip);
    
    /**
     * Purchase slip edition is allowed only if there are no payments done to the supplier.
     * So, there will be five transaction entries edited and one slip entry.
     * @param purchaseSlip
     */
    public void editPurchase(PurchaseSlip purchaseSlip);
	
}
