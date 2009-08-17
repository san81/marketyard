package com.san.my.service.impl;





import com.san.my.dao.AccountDAO;
import com.san.my.dao.BTransactionsDAO;
import com.san.my.dao.SeedsDAO;
import com.san.my.dao.SlipDAO;
import com.san.my.dataobj.AccountDO;
import com.san.my.dataobj.SeedDO;
import com.san.my.dataobj.SlipDO;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.BTransactionService;
import com.san.my.web.action.PurchaseSlip;

public class BTransactionServiceImpl implements BTransactionService{

	private BTransactionsDAO transactionsDAO;
	private SlipDAO slipDAO;
    private AccountDAO accountDAO;
    private SeedsDAO seedDAO;
	
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
        slipDO.setRate(purchaseSlip.getCost());
        
		slipDO.setFarmarName(purchaseSlip.getFname());
		slipDO.setFarmarVillage(purchaseSlip.getFcity());
		slipDO.setDescription(purchaseSlip.getDescription());
        
        AccountDO accountDO = accountDAO.loadAccountDO(1L);
        // TODO: seed id is hard coded
        SeedDO seedDO = seedDAO.loadSeed(1l);
        slipDO.setAccount(accountDO);
        slipDO.setSeed(seedDO);
		
		BussinessTransactionDO transactionDO = new BussinessTransactionDO();
        transactionDO.setDatetime(purchaseSlip.getPurchaseDate());
        //TODO: persist the derived value of amount.
        transactionDO.setAmount(purchaseSlip.getNetTotal());
        transactionDO.setAccount(accountDO);
        transactionDO.setSlip(slipDO);
        
        //TODO: flow has to be decided
		transactionDO.setTransFlow("DR");
        //TODO: type has to be decided
        transactionDO.setTransType(1);
        //TODO: remove the hard coding
        transactionDO.setTransMode("CASH");
        transactionDO.setDescription("default");
        
		transactionsDAO.saveBusinessTransaction(transactionDO);
	}

	public void setTransactionsDAO(BTransactionsDAO transactionsDAO) {
		this.transactionsDAO = transactionsDAO;
	}

	public void setSlipDAO(SlipDAO slipDAO) {
		this.slipDAO = slipDAO;
	}

    public void setAccountDAO(AccountDAO accountDAO)
    {
        this.accountDAO = accountDAO;
    }

    public void setSeedDAO(SeedsDAO seedDAO)
    {
        this.seedDAO = seedDAO;
    }

}
