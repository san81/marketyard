package com.san.my.web.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.global.Constants;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.AccountService;
import com.san.my.viewobj.AccountSummaryForm;
import com.san.my.web.util.NumberFormatUtil;

public class Ledger extends ActionSupport implements ServletRequestAware
{
    private static final long serialVersionUID = -9035736526281385130L;

    HttpServletRequest request;
    
    AccountService accountService;
    AccountSummaryForm accountSummaryForm;
    
    public String execute(){  
    	accountService.listAccountBTransactions(accountSummaryForm);
        
        String ledgerJSON = getLedgerJSON();
        System.out.println("Ledger JSON: "+ledgerJSON);
        request.setAttribute("ledgerJSON", ledgerJSON);
        return SUCCESS;
    }
    
   
    private String getLedgerJSON(){
        StringBuilder builder = new StringBuilder();
        builder.append("{'transactions' : [");
        List<BussinessTransactionDO> transaction= accountSummaryForm.getAccountBTransactions();
        Double balance=accountSummaryForm.getOpeningBalance();
        for(BussinessTransactionDO payment : transaction){
            builder.append("{'transId':").append(payment.getTransId()).append(",");
            builder.append("'datetime':'").append(new SimpleDateFormat("dd-MM-yyyy").format(payment.getDatetime())).append("',");
            builder.append("'description':'").append(payment.getDescription()).append("',");            
            if(Constants.CREDIT.equals(payment.getTransFlow())){
	            builder.append("'"+Constants.DEBIT+"':'',");
	            builder.append("'"+Constants.CREDIT+"':'").append(payment.getAmountToDisplay()).append("',");
	            balance+=payment.getAmount();
            }else{
            	builder.append("'"+Constants.DEBIT+"':'").append(payment.getAmountToDisplay()).append("',");
	            builder.append("'"+Constants.CREDIT+"':'',");
	            balance-=payment.getAmount();
            }
            builder.append("'balance':'"+NumberFormatUtil.getFormattedNumber(balance)+"',");
            builder.append("'mode':'").append(payment.getPaymentMode()).append("',");
            builder.append("'slipId':").append(getSlipId(payment)).append("},");
        }
        
        if(transaction.size()!=0)
            builder.deleteCharAt(builder.length()-1);
        builder.append("],");
        builder.append("'totalCount':"+transaction.size()+"}");
        
        return builder.toString();
    }
    
    private Object getSlipId(BussinessTransactionDO payment){
        return payment.getSlip() == null? "''":payment.getSlip().getSlipId();
    }

    public void setServletRequest(HttpServletRequest request){
        this.request = request;
    }


	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


	public AccountSummaryForm getAccountSummaryForm() {
		return accountSummaryForm;
	}


	public void setAccountSummaryForm(AccountSummaryForm accountSummaryForm) {
		this.accountSummaryForm = accountSummaryForm;
	}

}
