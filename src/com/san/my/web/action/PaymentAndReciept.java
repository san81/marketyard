
package com.san.my.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.service.BTransactionService;

public class PaymentAndReciept extends ActionSupport
{
    private static final long serialVersionUID = 6581876201676953166L;
    private Double amount;
    private String account;
    private Long accountKey;
    
    private String paymentMode;
    
    private String checkNumber;
    private String bankName;
    private String branchName;
    
    private Long slipId;
    
    private String action = "";
    
    private BTransactionService transactionService;
    
    public String execute()
    {
        System.out.println("in payments and receipts action class");
        return SUCCESS;
    }
    
    public String renderPaymentForm(){
        action = "Payment";
        return SUCCESS;
    }
    
    public String confirmTransaction()
    {
        return SUCCESS;
    }
    
    public String editTransaction()
    {
        return SUCCESS;
    }
    
    public String makePaymentEntry()
    {
        transactionService.makePayment(this);
        return SUCCESS;
    }
    
    public String renderReceiptForm(){
        action = "Receipt";
        return SUCCESS;
    }
    
    public String makeReceiptEntry(){
//        transactionService.makePayment(this);
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

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getPaymentMode()
    {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode)
    {
        this.paymentMode = paymentMode;
    }

    public BTransactionService getTransactionService()
    {
        return transactionService;
    }

    public void setTransactionService(BTransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getCheckNumber()
    {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber)
    {
        this.checkNumber = checkNumber;
    }

    public Long getSlipId()
    {
        return slipId;
    }

    public void setSlipId(Long slipId)
    {
        this.slipId = slipId;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }
}
