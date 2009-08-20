package com.san.my.web.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.global.MessageKey;
import com.san.my.common.util.SlipConfigs;
import com.san.my.service.BTransactionService;



public class PurchaseSlip extends ActionSupport {
	
	private Double qtls;
	
	//values from config
	private Double hamaliRate;
	private Double adthiRate;
	private Double cashCommissionRate;
	
	//drived values
	private Double grossTotal;
	private Double netTotal;
	private Double totalHamali;
	private Double totalCc;
	private Double totalMf;
	
	
	private String seed;
	private Long seedKey;
	private Date purchaseDate;
	private Long bagwt;
	private Long bags;
	private Long smallBag;
	private Double cost;
	
	private String supplier;
	private Long supplierKey;
	private String supplierCity;
	private String description;
	
	private String buyerAccountId;
	private Long buyerAccountIdKey;
	private String status;
	
	private String paymentMode;
	private String bankName;
	private String branchName;
	private String checkNumber;
	private Double paymentAmount;
    
    private Long slipId;
    
    //Flag to represent the action
    private String action = "";
	
	
	private BTransactionService transactionService;
	
	public String input(){		
		SlipConfigs slipConfig = SlipConfigs.getInstance();		
		cashCommissionRate=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE));
		adthiRate=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE));
		hamaliRate=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE));
		return SUCCESS;
	}
	
	public String conformSlip(){
        action = "confirm";
		return SUCCESS;
	}
	
	public String back(){		
		return SUCCESS;
	}
	
	public String savePurchaseSlip(){
        action = "save";
		transactionService.savePurchase(this);
		return SUCCESS;
	}
    
    public String cancel(){
        action = "load";
        transactionService.loadSlip(this);
        return SUCCESS;
    }
	
	public Long getBags() {
		return bags;
	}
	public void setBags(Long bags) {
		this.bags = bags;
	}
	public Long getBagwt() {
		return bagwt;
	}
	public void setBagwt(Long bagwt) {
		this.bagwt = bagwt;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getSeed() {
		return seed;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}
	public Double getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(Double netTotal) {
		this.netTotal = netTotal;
	}
	public Double getQtls() {
		return qtls;
	}
	public void setQtls(Double qtls) {
		this.qtls = qtls;
	}

	public Double getTotalCc() {
		return totalCc;
	}

	public void setTotalCc(Double totalCc) {
		this.totalCc = totalCc;
	}

	public Double getTotalHamali() {
		return totalHamali;
	}

	public void setTotalHamali(Double totalHamali) {
		this.totalHamali = totalHamali;
	}

	public Double getTotalMf() {
		return totalMf;
	}

	public void setTotalMf(Double totalMf) {
		this.totalMf = totalMf;
	}

	public Double getAdthiRate() {
		return adthiRate;
	}

	public void setAdthiRate(Double adthiRate) {
		this.adthiRate = adthiRate;
	}

	public Double getCashCommissionRate() {
		return cashCommissionRate;
	}

	public void setCashCommissionRate(Double cashCommissionRate) {
		this.cashCommissionRate = cashCommissionRate;
	}

	public Double getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}

	public Double getHamaliRate() {
		return hamaliRate;
	}

	public void setHamaliRate(Double hamaliRate) {
		this.hamaliRate = hamaliRate;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBuyerAccountId()
    {
        return buyerAccountId;
    }

    public void setBuyerAccountId(String buyerAccountId)
    {
        this.buyerAccountId = buyerAccountId;
    }

    public Long getSmallBag() {
		return smallBag;
	}

	public void setSmallBag(Long smallBag) {
		this.smallBag = smallBag;
	}

	public void setTransactionService(BTransactionService transactionService) {
		this.transactionService = transactionService;
	}

	public Long getSeedKey() {
		return seedKey;
	}

	public void setSeedKey(Long seedKey) {
		this.seedKey = seedKey;
	}

	public Long getBuyerAccountIdKey() {
		return buyerAccountIdKey;
	}

	public void setBuyerAccountIdKey(Long buyerAccountIdKey) {
		this.buyerAccountIdKey = buyerAccountIdKey;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public Long getSupplierKey() {
		return supplierKey;
	}

	public void setSupplierKey(Long supplierKey) {
		this.supplierKey = supplierKey;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public Long getSlipId()
    {
        return slipId;
    }

    public void setSlipId(Long slipId)
    {
        this.slipId = slipId;
    }

	
}
