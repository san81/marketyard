/**
 * 
 */
package com.san.my.service.impl;

import java.util.Date;
import java.util.List;

import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.AccountSummary;
import com.san.my.viewobj.AccountSummaryForm;

/**
 * @author radhika
 *
 */
public class AccountSummaryImpl  implements AccountSummary{
	
	public AccountDAO accountDAO;
	public AccountSummaryUtil accountSummaryUtil;
	
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setAccountSummaryUtil(AccountSummaryUtil accountSummaryUtil) {
		this.accountSummaryUtil = accountSummaryUtil;
	}
	
	
	 public List<BussinessTransactionDO> listAccountBTransactions(AccountSummaryForm accountSummaryForm){
	    	int option  = accountSummaryForm.getOption();
	    	int period = accountSummaryForm.getPeriod();
	    	/*
			  this month = 1,
			  months =2 (last x month(s)),
			  month =3 (one of last 4 months of the year )
			  this year = 4
			  years = 5 (last x year(s))
			  year =6 (one of last 4 years)
			  private int option;
			
			  //for option 2 ,3,5 or 6.
			  private int period;
			*/
	    	
	    	if(option > 0){
	    		if(option == 1){
	    			accountSummaryForm.setStartDate(accountSummaryUtil.getFirstDateOfCurrentMonth());
	    			accountSummaryForm.setEndDate(accountSummaryUtil.getTodaysDate());
	    		}else if(option ==2){
	    			accountSummaryForm.setStartDate(accountSummaryUtil.getLastXmonthDate(period));
	    			accountSummaryForm.setEndDate(accountSummaryUtil.getTodaysDate());
	    		}else if(option == 3){
	    			//period should contain values like -1,-2,-3 ... for the last month ,last before month ....
	    			Date[] dt = accountSummaryUtil.getXMonthDates(period);
	    			accountSummaryForm.setStartDate(dt[0]);
	    			accountSummaryForm.setEndDate(dt[1]);
	    		}else if(option == 4){
	    			accountSummaryForm.setStartDate(accountSummaryUtil.getFirstDayofCurrentYear());
	    			accountSummaryForm.setEndDate(accountSummaryUtil.getTodaysDate());
	    		}else if(option == 5){
	    			accountSummaryForm.setStartDate(accountSummaryUtil.getLastXyearDate(period));
	    			accountSummaryForm.setEndDate(accountSummaryUtil.getTodaysDate());
	    		}else if(option ==6){
	    			Date[] dt = accountSummaryUtil.getLastXYearDates(period);
	    			accountSummaryForm.setStartDate(dt[0]);
	    			accountSummaryForm.setEndDate(dt[1]);
	    		}
	    	}
	    	
	    	List<BussinessTransactionDO> accountBTransactions = accountDAO.getAccountBTransactionDO(accountSummaryForm);
	    	accountSummaryForm.setAccountBTransactions(accountBTransactions);
	    	
	    	//get the starting balance
	    	getStartingBalance(accountSummaryForm);
	    	//set the dr cr totals
	    	setDrCrTotalForAccountSummary(accountSummaryForm);
	    	return accountBTransactions;
	   }
	    
	    private void setDrCrTotalForAccountSummary(AccountSummaryForm accountSummaryForm){
	    	Double drTotal=0.0;
	    	Double crTotal=0.0;
	    	
	    	for(BussinessTransactionDO btransaction :accountSummaryForm.getAccountBTransactions() ){
	    		//TODO:move DR and CR to constants
	    		if("DR".equals(btransaction.getTransFlow())){
	    			drTotal+=btransaction.getAmount();
	    		}else{
	    			crTotal+=btransaction.getAmount();
	    		}
	    	}
	    	
	    	//add the starting balance to the existing figures.
	    	if(accountSummaryForm.getStartDrBalance()>0){
	    		drTotal+=accountSummaryForm.getStartDrBalance();
	    	}else{
	    		crTotal+=accountSummaryForm.getStartCrBalance();
	    	}
	    	
	    	accountSummaryForm.setDrTotal(drTotal);
	    	accountSummaryForm.setCrTotal(crTotal);
	    	
	    }
	    
	    
	    private void getStartingBalance(AccountSummaryForm accountSummaryForm){
	    	
	    	List<Object[]>  tranFlowSummary =  (List<Object[]>)accountDAO.getAccountStartingBalance(accountSummaryForm);
	    	Double strBalance =null; 
	    	if(tranFlowSummary.size() == 2){
	    		 //DR-CR balance
	    		 strBalance =(Double)tranFlowSummary.get(0)[0] - (Double)tranFlowSummary.get(0)[0];
	    		 if(strBalance >0){
	    			 accountSummaryForm.setStartDrBalance(strBalance); 
	    		 }else{
	    			 accountSummaryForm.setStartCrBalance(strBalance);
	    		 }
	    	}else if(tranFlowSummary.size() >0){
	    		if("DR".equals(tranFlowSummary.get(0)[1].toString())){
	    			accountSummaryForm.setStartDrBalance(strBalance); 
	    		}else{
	    			accountSummaryForm.setStartCrBalance(strBalance);
	    		}
	    	}
	   }

}
