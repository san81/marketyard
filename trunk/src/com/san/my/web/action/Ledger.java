package com.san.my.web.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.dataobj.BussinessTransactionDO;
import com.san.my.service.BTransactionService;

public class Ledger extends ActionSupport implements ServletRequestAware
{
    private static final long serialVersionUID = -9035736526281385130L;

    HttpServletRequest request;
    
    private String account;
    private Long accountKey;
    private List<BussinessTransactionDO> transactions;
    private Double balance;
    
    private BTransactionService transactionService;
    
    public String execute(){        
        transactionService.getLedger(this);
        
        String ledgerJSON = getLedgerJSON();
        System.out.println("Ledger JSON: "+ledgerJSON);
        request.setAttribute("ledgerJSON", ledgerJSON);
        return SUCCESS;
    }
    
    public String getAccount()
    {
        return account;
    }
    public void setAccount(String account)
    {
        this.account = account;
    }
    public Long getAccountKey()
    {
        return accountKey;
    }
    public void setAccountKey(Long accountKey)
    {
        this.accountKey = accountKey;
    }
    public Double getBalance()
    {
        return balance;
    }
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }
    
    public BTransactionService getTransactionService()
    {
        return transactionService;
    }

    public void setTransactionService(BTransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    public List<BussinessTransactionDO> getTransactions()
    {
        return transactions;
    }

    public void setTransactions(List<BussinessTransactionDO> transactions)
    {
        this.transactions = transactions;
    }
    
    private String getLedgerJSON(){
        StringBuilder builder = new StringBuilder();
        builder.append("{'transactions' : [");
        List<BussinessTransactionDO> transaction= getTransactions();
        for(BussinessTransactionDO payment : transaction){
            builder.append("{'transId':").append(payment.getTransId()).append(",");
            builder.append("'datetime':'").append(new SimpleDateFormat("dd/MM/yyyy").format(payment.getDatetime())).append("',");
            builder.append("'accountName':'").append(payment.getAccount().getLoginName()).append("',");
            builder.append("'amount':").append(payment.getAmount()).append(",");
            builder.append("'flow':'").append(payment.getTransFlow()).append("',");
            builder.append("'mode':'").append(payment.getPaymentMode()).append("',");
            builder.append("'slipId':").append(getSlipId(payment)).append("},");
        }
        
        if(transaction.size()!=0)
            builder.deleteCharAt(builder.length()-1);
        builder.append("]}");
        
        return builder.toString();
    }
    
    private Object getSlipId(BussinessTransactionDO payment){
        return payment.getSlip() == null? "''":payment.getSlip().getSlipId();
    }

    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    }

}
