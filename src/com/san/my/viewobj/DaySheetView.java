
package com.san.my.viewobj;

import java.util.Date;
import java.util.Map;

import com.agentrics.mgs.web.util.NumberFormatUtil;
import com.san.my.common.global.Constants;

public class DaySheetView
{
    private Date date;
    
    private Map creditsMap;
    
    private Map debitsMap;
    
    private Double sumOfCredits;
    
    private Double sumOfDebits;
    
    private Double openingBalance;
    
    private Double closingBalance;

    public Map getCreditsMap()
    {
        return creditsMap;
    }

    public void setCreditsMap(Map creditsMap)
    {
        this.creditsMap = creditsMap;
    }

    public Map getDebitsMap()
    {
        return debitsMap;
    }

    public void setDebitsMap(Map debitsMap)
    {
        this.debitsMap = debitsMap;
    }

    public Double getSumOfCredits()
    {
        return sumOfCredits;
    }

    public void setSumOfCredits(Double sumOfCredits)
    {
        this.sumOfCredits = sumOfCredits;
    }

    public Double getSumOfDebits()
    {
        return sumOfDebits;
    }

    public void setSumOfDebits(Double sumOfDebits)
    {
        this.sumOfDebits = sumOfDebits;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public Double getOpeningBalance()
    {
        return openingBalance;
    }
    
    public void setOpeningBalance(Double openingBalance)
    {
        this.openingBalance = openingBalance;
    }
   
    public Double getClosingBalance()
    {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance)
    {
        this.closingBalance = closingBalance;
    }

    public String getSumOfCreditsFormatted()
    {
        return NumberFormatUtil.getFormattedNumber(Constants.NUMBER_FORMAT_US, sumOfCredits, 2);
    }
    
    public String getSumOfDebitsFormatted()
    {
        return NumberFormatUtil.getFormattedNumber(Constants.NUMBER_FORMAT_US, sumOfDebits, 2);
    }
    
    public String getOpeningBalanceFormatted()
    {
        return NumberFormatUtil.getFormattedNumber(Constants.NUMBER_FORMAT_US, openingBalance, 2);
    }
    
    public String getClosingBalanceFormatted()
    {
        return NumberFormatUtil.getFormattedNumber(Constants.NUMBER_FORMAT_US, closingBalance, 2);
    }
    
}
