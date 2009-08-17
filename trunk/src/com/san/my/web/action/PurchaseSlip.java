package com.san.my.web.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.global.MessageKey;
import com.san.my.common.util.SlipConfigs;



public class PurchaseSlip extends ActionSupport {
	
	private Long qtls;
	
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
	private Date purchaseDate;
	private Double bagwt;
	private Long bags;
	private Double cost;
	
	
	public String execute(){	
		
		SlipConfigs slipConfig = SlipConfigs.getInstance();		
		cashCommissionRate=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE));
		adthiRate=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE));
		hamaliRate=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE));
		return SUCCESS;
	}
	
	public Long getBags() {
		return bags;
	}
	public void setBags(Long bags) {
		this.bags = bags;
	}
	public Double getBagwt() {
		return bagwt;
	}
	public void setBagwt(Double bagwt) {
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
	public Long getQtls() {
		return qtls;
	}
	public void setQtls(Long qtls) {
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
	
	
}
