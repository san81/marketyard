package com.san.my.web.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.global.MessageKey;
import com.san.my.common.util.SlipConfigs;



public class PurchaseSlip extends ActionSupport {
	
	private Long qtls;
	
	private Double hamali;
	private Double cc;
	private Double mf;
	
	private Double grossTotal;
	private Double netTotal;
	
	private String seed;
	private Date purchaseDate;
	private Double bagwt;
	private Long bags;
	private Double cost;
	
	public String execute(){
		
		SlipConfigs slipConfig = SlipConfigs.getInstance();		
		cc=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE));
		mf=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE));
		hamali=Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE));
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
	public Double getCc() {
		return cc;
	}
	public void setCc(Double cc) {
		this.cc = cc;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public Double getHamali() {
		return hamali;
	}
	public void setHamali(Double hamali) {
		this.hamali = hamali;
	}
	public Double getMf() {
		return mf;
	}
	public void setMf(Double mf) {
		this.mf = mf;
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
	
	
}
