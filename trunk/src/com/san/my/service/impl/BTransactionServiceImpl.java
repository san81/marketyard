package com.san.my.service.impl;





import com.san.my.dao.BTransactionsDAO;
import com.san.my.dao.SlipDAO;
import com.san.my.dataobj.SlipDO;
import com.san.my.dataobj.TransactionDO;
import com.san.my.service.BTransactionService;
import com.san.my.web.action.PurchaseSlip;

public class BTransactionServiceImpl implements BTransactionService{

	private BTransactionsDAO transactionsDAO;
	private SlipDAO slipDAO;
	
	public void savePurchase(PurchaseSlip purchaseSlip) {
		SlipDO slipDO = new SlipDO();
		slipDO.setAdthiRate(purchaseSlip.getAdthiRate());
		slipDO.setHamaliRate(purchaseSlip.getHamaliRate());
		slipDO.setCcRate(purchaseSlip.getCashCommissionRate());
		
		slipDO.setBags(purchaseSlip.getBags());		
		slipDO.setBarthi(purchaseSlip.getBagwt());
		slipDO.setDatetime(purchaseSlip.getPurchaseDate());
		
		slipDO.setQtls(purchaseSlip.getQtls());
		slipDO.setLooseBag(purchaseSlip.getSmallBag());		
		
		slipDO.setFarmarName(purchaseSlip.getFname());
		slipDO.setFarmarVillage(purchaseSlip.getFcity());
		slipDO.setDescription(purchaseSlip.getDescription());
		
		TransactionDO transactionDO = new TransactionDO();
		
		//transactionDO.se
		//transactionsDAO.saveBusinessTransaction(activity);
	}

	public void setTransactionsDAO(BTransactionsDAO transactionsDAO) {
		this.transactionsDAO = transactionsDAO;
	}

	public void setSlipDAO(SlipDAO slipDAO) {
		this.slipDAO = slipDAO;
	}

}
