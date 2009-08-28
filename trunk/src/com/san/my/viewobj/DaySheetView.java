
package com.san.my.viewobj;

import java.util.Date;
import java.util.Map;

public class DaySheetView
{
    private Date date;
    
    private Map creditsMap;
    
    private Map debitsMap;
    
    private Double sumOfCredits;
    
    private Double sumOfDebits;
    
    private Double balance;

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

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance(Double balance)
    {
        this.balance = balance;
    }

}
