package com.san.my.web.action;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.service.BTransactionService;
import com.san.my.viewobj.DaySheetView;

public class DaySheet extends ActionSupport
{
    private static final long serialVersionUID = 8567568192499372871L;
    
    private Date date;
    
    DaySheetView daySheet;
    
    private BTransactionService transactionService;
    
    public String execute(){
        Calendar calendar = Calendar.getInstance();
        if(date != null)
            calendar.setTime(date);
        
       // calendar.set(Calendar.DATE, 21);
        
        daySheet = transactionService.getDayTransactionsSheet(calendar);
        
        return SUCCESS;
    }
    
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public void setTransactionService(BTransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    public DaySheetView getDaySheet()
    {
        return daySheet;
    }

    public void setDaySheet(DaySheetView daySheet)
    {
        this.daySheet = daySheet;
    }
}
