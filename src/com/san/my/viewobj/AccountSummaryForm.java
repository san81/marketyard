/**
 * 
 */
package com.san.my.viewobj;

import java.util.Date;
import java.util.List;

import com.san.my.dataobj.BussinessTransactionDO;

/**
 * @author radhika
 *
 */
public class AccountSummaryForm {
	
	private Long accountId;
	
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
	private int option;
	
	//for option 2 ,3,5 or 6.
	private int period;
	
	private List<BussinessTransactionDO> accountBTransactions;
	private Double drTotal;
	private Double crTotal;
	
	//starting balance
	private Double startDrBalance;
	private Double startCrBalance;
	
	
	public List<BussinessTransactionDO> getAccountBTransactions() {
		return accountBTransactions;
	}
	public void setAccountBTransactions(List<BussinessTransactionDO> accountBTransactions) {
		this.accountBTransactions = accountBTransactions;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
}
