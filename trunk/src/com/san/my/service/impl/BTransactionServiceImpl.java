package com.san.my.service.impl;





import java.util.LinkedList;
import java.util.List;

import com.san.my.common.global.Constants;
import com.san.my.dao.AccountDAO;
import com.san.my.dao.BTransactionsDAO;
import com.san.my.dao.SeedsDAO;
import com.san.my.dao.SlipDAO;
import com.san.my.dataobj.AccountDO;
import com.san.my.dataobj.PaymentDetailsDO;
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
        
		
		slipDO.setDescription(purchaseSlip.getDescription());
        
        SeedDO seedDO = seedDAO.loadSeed(purchaseSlip.getSeedKey());
        slipDO.setSeed(seedDO);
		
        List<BussinessTransactionDO> transactionObjects = new LinkedList<BussinessTransactionDO>();
        
        //Debit from buyer transaction.
		BussinessTransactionDO buyerTransactionDO = new BussinessTransactionDO();
        buyerTransactionDO.setDatetime(purchaseSlip.getPurchaseDate());
        buyerTransactionDO.setAmount(purchaseSlip.getGrossTotal());
        
        AccountDO buyerAccountDO = accountDAO.loadAccountDO(purchaseSlip.getBuyerAccountIdKey());
        buyerTransactionDO.setAccount(buyerAccountDO);
        
        buyerTransactionDO.setSlip(slipDO);
        
        //flow is debit
        buyerTransactionDO.setTransFlow(Constants.DEBIT);
        buyerTransactionDO.setPaymentMode(Constants.PAYMENT_MODE_CASH);
        buyerTransactionDO.setDescription("Debited from firm to indicate that buyer has to pay to firm");
        
        transactionObjects.add(buyerTransactionDO);
        
        //Credit to supplier transaction.
        BussinessTransactionDO supplierTransactionDO = new BussinessTransactionDO();
        supplierTransactionDO.setDatetime(purchaseSlip.getPurchaseDate());
        supplierTransactionDO.setAmount(purchaseSlip.getNetTotal());
        
        AccountDO supplierAccountDO = accountDAO.loadAccountDO(purchaseSlip.getSupplierKey());
        supplierTransactionDO.setAccount(supplierAccountDO);
        
        supplierTransactionDO.setSlip(slipDO);
        
        supplierTransactionDO.setTransFlow(Constants.CREDIT);
        supplierTransactionDO.setPaymentMode(Constants.PAYMENT_MODE_CASH);
        supplierTransactionDO.setDescription("Credited to firm to indicate that firm has to pay to supplier");
        
        transactionObjects.add(supplierTransactionDO);
        
        //Credit to HAMALI transaction.
        BussinessTransactionDO hamaliTransactionDO = new BussinessTransactionDO();
        hamaliTransactionDO.setDatetime(purchaseSlip.getPurchaseDate());
        hamaliTransactionDO.setAmount(purchaseSlip.getTotalHamali());
        
        AccountDO hamaliAccountDO = accountDAO.loadAccountDO(2L);
        hamaliTransactionDO.setAccount(hamaliAccountDO);
        
        hamaliTransactionDO.setSlip(slipDO);
        
        hamaliTransactionDO.setTransFlow(Constants.CREDIT);
        hamaliTransactionDO.setPaymentMode(Constants.PAYMENT_MODE_CASH);
        hamaliTransactionDO.setDescription("Credited to firm to indicate that firm has to pay to Hamali");
        
        transactionObjects.add(hamaliTransactionDO);
        
        
        //Credit to CC transaction.
        BussinessTransactionDO ccTransactionDO = new BussinessTransactionDO();
        ccTransactionDO.setDatetime(purchaseSlip.getPurchaseDate());
        ccTransactionDO.setAmount(purchaseSlip.getTotalCc());
        
        AccountDO ccAccountDO = accountDAO.loadAccountDO(3L);
        ccTransactionDO.setAccount(ccAccountDO);
        
        ccTransactionDO.setSlip(slipDO);
        
        ccTransactionDO.setTransFlow(Constants.CREDIT);
        ccTransactionDO.setPaymentMode(Constants.PAYMENT_MODE_CASH);
        ccTransactionDO.setDescription("Credited to firm to indicate that firm has to pay to CC account");
        
        transactionObjects.add(ccTransactionDO);
        
        //Credit to MF transaction.
        BussinessTransactionDO mfTransactionDO = new BussinessTransactionDO();
        mfTransactionDO.setDatetime(purchaseSlip.getPurchaseDate());
        mfTransactionDO.setAmount(purchaseSlip.getTotalMf());
        
        AccountDO mfAccountDO = accountDAO.loadAccountDO(4L);
        mfTransactionDO.setAccount(mfAccountDO);
        
        mfTransactionDO.setSlip(slipDO);
        
        mfTransactionDO.setTransFlow(Constants.CREDIT);
        mfTransactionDO.setPaymentMode(Constants.PAYMENT_MODE_CASH);
        mfTransactionDO.setDescription("Credited to firm to indicate that firm has to pay to MF account");
        
        transactionObjects.add(mfTransactionDO);
        
        //If purchase status is closed, add debit to firm from supplier transaction too.
        if(!purchaseSlip.getStatus().equals("PENDING")){
            //supplier transaction.
            BussinessTransactionDO payment = new BussinessTransactionDO();
            payment.setDatetime(purchaseSlip.getPurchaseDate());
            payment.setAmount(purchaseSlip.getPaymentAmount());
            
            payment.setAccount(supplierAccountDO);
            
            payment.setSlip(slipDO);
            
            payment.setTransFlow(Constants.DEBIT);
            
            if(purchaseSlip.getPaymentMode().equals("CASH")){
                payment.setPaymentMode(Constants.PAYMENT_MODE_CASH);
            }else{
                PaymentDetailsDO paymentDetails = new PaymentDetailsDO();
                paymentDetails.setDatetime(purchaseSlip.getPurchaseDate());
                paymentDetails.setAmount(purchaseSlip.getPaymentAmount());
                paymentDetails.setCheckNumber(purchaseSlip.getCheckNumber());
                paymentDetails.setBankName(purchaseSlip.getBankName());
                paymentDetails.setBranchName(purchaseSlip.getBranchName());
                paymentDetails.setBusinessTransaction(payment);
                paymentDetails.setDescription("Firm has paid this amount towards this bill");
                
                payment.setPaymentMode(Constants.PAYMENT_MODE_CHECK);
                payment.setPaymentDetails(paymentDetails);
            }
            
            payment.setDescription("Firm has paid this amount to supplier");
            
            transactionObjects.add(payment);
        }
        
        
		transactionsDAO.saveBusinessTransactions(transactionObjects);
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

    public void editPurchase(PurchaseSlip purchaseSlip)
    {
    }

    public void loadSlip(PurchaseSlip purchaseSlip)
    {
        
    }

}
