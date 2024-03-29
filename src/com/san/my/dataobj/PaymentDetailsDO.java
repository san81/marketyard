
package com.san.my.dataobj;

import java.util.Date;

/**
 * PaymentDetailsDO generated by MyEclipse Persistence Tools
 */

public class PaymentDetailsDO implements java.io.Serializable
{

    // Fields

    private Long paymentDetailsId;
    private BussinessTransactionDO businessTransaction;
    private Date datetime;
    private String bankName;
    private String branchName;
    private String checkNumber;
    private Double amount;
    private String description;

    // Constructors

    /** default constructor */
    public PaymentDetailsDO()
    {
    }

    /** minimal constructor */
    public PaymentDetailsDO(
        Long paymentDetailsId,
        BussinessTransactionDO businessTransaction,
        Date datetime,
        String bankName,
        String checkNumber,
        Double amount)
    {
        this.paymentDetailsId = paymentDetailsId;
        this.businessTransaction = businessTransaction;
        this.datetime = datetime;
        this.bankName = bankName;
        this.checkNumber = checkNumber;
        this.amount = amount;
    }

    /** full constructor */
    public PaymentDetailsDO(
        Long paymentDetailsId,
        BussinessTransactionDO businessTransaction,
        Date datetime,
        String bankName,
        String branchName,
        String checkNumber,
        Double amount,
        String description)
    {
        this.paymentDetailsId = paymentDetailsId;
        this.businessTransaction = businessTransaction;
        this.datetime = datetime;
        this.bankName = bankName;
        this.branchName = branchName;
        this.checkNumber = checkNumber;
        this.amount = amount;
        this.description = description;
    }

    // Property accessors

    public BussinessTransactionDO getBusinessTransaction()
    {
        return businessTransaction;
    }

    public void setBusinessTransaction(BussinessTransactionDO businessTransaction)
    {
        this.businessTransaction = businessTransaction;
    }

    public Date getDatetime()
    {
        return this.datetime;
    }

    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
    }

    public String getBankName()
    {
        return this.bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getBranchName()
    {
        return this.branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getCheckNumber()
    {
        return this.checkNumber;
    }

    public void setCheckNumber(String checkNumber)
    {
        this.checkNumber = checkNumber;
    }

    public Double getAmount()
    {
        return this.amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Long getPaymentDetailsId()
    {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(Long paymentDetailsId)
    {
        this.paymentDetailsId = paymentDetailsId;
    }

}
