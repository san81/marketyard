package com.san.my.service;

import com.san.my.web.action.PurchaseSlip;

public interface BTransactionService {

	/**
	 * Method to save one purchase slip action.
	 * It has to make an entry into Slip and transaction tables.
	 * 
	 * @param purchaseSlip
	 */
	public void savePurchase(PurchaseSlip purchaseSlip);
	
}
