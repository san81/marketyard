package com.san.my.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.san.my.common.global.Constants;
import com.san.my.dao.AccountDAO;
import com.san.my.dataobj.AccountDO;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.AccountService;
import com.san.my.viewobj.AccountSummaryForm;
import com.san.my.viewobj.AccountsView;
import com.san.my.web.action.account.AccountForm;

public class AccountServiceImpl implements AccountService {

	public AccountDAO accountDAO;
	public static AccountSummaryUtil accountSummaryUtil;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void saveAccount(AccountForm form) {
		AccountDO accountsDO = new AccountDO();
		accountsDO.setLoginName(form.getLoginName());
        /*
         * Have one default password.
         */
        accountsDO.setPassword("password");
		accountsDO.setName(form.getName());
        accountsDO.setAccountType(accountDAO.getAccountTypeDO(form.getAccountType()));
        accountsDO.setMobile(form.getMobile());
		accountsDO.setAddress(form.getAddress());
		accountsDO.setVillage(form.getVillage());
		accountsDO.setRegdate(Calendar.getInstance().getTime());
		
		accountDAO.saveAccount(accountsDO);
	}	
	
	public boolean isLoginNameExists(String loginName){
		return accountDAO.isLoginNameExists(loginName);
		
	}

	public List<AccountsView> listAllAccounts() {
		List<AccountDO> accounts = accountDAO.listAllAccounts();
		List accountsView = new ArrayList<AccountsView>();
		for(AccountDO account : accounts){
			AccountsView av = new AccountsView(account);
			accountsView.add(av);
		}
		return accountsView;
	}
	
	public List<String[]> listAccountIdsAndNames() {
		List<String[]> accountIdsAndNames=new ArrayList<String[]>();		
		List<AccountDO> accounts = accountDAO.listAllAccountsForSelection();
		for(AccountDO account : accounts){
			String[] accountNameToId = new String[2];
			accountNameToId[1]=account.getAccountId()+"";
			accountNameToId[0]=account.getLoginName();
			accountIdsAndNames.add(accountNameToId);
		}
		return accountIdsAndNames;
	}
	
    public List<String> listAllAccountTypes(){
        List<String> accountTypes = accountDAO.listAllAccountTypes();
        return accountTypes;
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
    	option=2;
        period=2;
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
    	//load account info
    	AccountDO accountDO = accountDAO.getAccountDO(accountSummaryForm.getAccountIdKey());
    	accountSummaryForm.setAccountName(accountDO.getName());    	
    	accountSummaryForm.setMobile(accountDO.getMobile());
    	accountSummaryForm.setCity(accountDO.getVillage());
    	accountSummaryForm.setAccountType(accountDO.getAccountType().getAccountType());
    	
    	return accountBTransactions;
   }
    
    private void setDrCrTotalForAccountSummary(AccountSummaryForm accountSummaryForm){
    	Double drTotal=0.0;
    	Double crTotal=0.0;
    	
    	for(BussinessTransactionDO btransaction :accountSummaryForm.getAccountBTransactions() ){    	
    		if(Constants.DEBIT.equals(btransaction.getTransFlow()))
    			drTotal+=btransaction.getAmount();
    		else
    			crTotal+=btransaction.getAmount();
    		
    	}
    	
    	//add the starting balance to the existing figures.    	
    		drTotal+=accountSummaryForm.getStartDrBalance();    	
    		crTotal+=accountSummaryForm.getStartCrBalance();
    	
    	accountSummaryForm.setDrTotal(drTotal);
    	accountSummaryForm.setCrTotal(crTotal);
    	accountSummaryForm.setClosingBalance(crTotal-drTotal);
    	
    }
    
    
    private void getStartingBalance(AccountSummaryForm accountSummaryForm){
    	
    	List<Object[]>  tranFlowSummary =  (List<Object[]>)accountDAO.getAccountStartingBalance(accountSummaryForm);
    	Double drTotal = 0.0;
    	Double crTotal = 0.0;
    	
    	if(tranFlowSummary.size() == 2){    	
    			 drTotal= (Double) tranFlowSummary.get(0)[0];
    			 crTotal= (Double) tranFlowSummary.get(1)[0];
    			 
    			
    	}else if(tranFlowSummary.size() >0){
    		if(Constants.DEBIT.equals(tranFlowSummary.get(0)[1].toString())){
    			accountSummaryForm.setStartDrBalance((Double)tranFlowSummary.get(0)[0]);
    			drTotal=(Double)tranFlowSummary.get(0)[0];
    		}else{
    			accountSummaryForm.setStartCrBalance((Double)tranFlowSummary.get(0)[0]);
    			crTotal=(Double)tranFlowSummary.get(0)[0];
    		}
    	}
    	 accountSummaryForm.setStartDrBalance(drTotal);
		 accountSummaryForm.setStartCrBalance(crTotal);
    	 accountSummaryForm.setOpeningBalance(crTotal-drTotal);    	
   }
    
}
