/**
 * 
 */
package com.san.my.viewobj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.san.my.common.global.Constants;
import com.san.my.dataobj.BussinessTransactionDO;

/**
 * @author radhika
 *
 */
public class AccountSummaryForm {
	
	private Long accountIdKey;
	private String accountName;
	private String city;
	private String mobile;
	private String accountType;
	
	//dates between
	private Date startDate;
	private Date endDate;
	
	/*
	  this month = 1,
	  months =2 (last x month(s)),
	  month =3 (one of last 4 months of the year )
	  this year = 4
	  years = 5 (last x year(s))
	  year =6 (one of last 4 years)
	 */
	private int option=1;
	
	//for option 2 ,3,5 or 6.
	private int period;
	
	private List<BussinessTransactionDO> accountBTransactions;
	private Double drTotal=0.0;
	private Double crTotal=0.0;
	
	//starting balance
	private Double startDrBalance=0.0;
	private Double startCrBalance=0.0;
	//crBalance-DrBlanace. It may be negative.
	private Double openingBalance=0.0;	
	private Double closingBalance=0.0;
	
	
	public Double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public List<BussinessTransactionDO> getAccountBTransactions() {
		return accountBTransactions;
	}
	public void setAccountBTransactions(List<BussinessTransactionDO> accountBTransactions) {
		this.accountBTransactions = accountBTransactions;
	}
	public Double getCrTotal() {
		return crTotal;
	}
	public void setCrTotal(Double crTotal) {
		this.crTotal = crTotal;
	}
	public Double getDrTotal() {
		return drTotal;
	}
	public void setDrTotal(Double drTotal) {
		this.drTotal = drTotal;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getOption() {
		return option;
	}
	public void setOption(int option) {
		this.option = option;
	}
	public Double getStartCrBalance() {
		return startCrBalance;
	}
	public void setStartCrBalance(Double startCrTotal) {
		this.startCrBalance = startCrTotal;
	}
	public Double getStartDrBalance() {
		return startDrBalance;
	}
	public void setStartDrBalance(Double startDrTotal) {
		this.startDrBalance = startDrTotal;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public Long getAccountIdKey() {
		return accountIdKey;
	}
	public void setAccountIdKey(Long accountIdKey) {
		this.accountIdKey = accountIdKey;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getClosingBalance() {	
		return closingBalance;
	}	
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getEndDateToDisplay() {
		return new SimpleDateFormat(Constants.DATE_FORMAT).format(endDate);
		 
	}
	public String getStartDateToDisplay() {
		return new SimpleDateFormat(Constants.DATE_FORMAT).format(startDate);		
	}
}
