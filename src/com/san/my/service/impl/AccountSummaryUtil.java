/**
 * 
 */
package com.san.my.service.impl;

import java.util.Calendar;
import java.util.Date;

/**
 * @author radhika
 *
 */

public class AccountSummaryUtil {
	
//	TODO:how to avoide creating calendar instance every time
	/**
	 * todays date
	 */
	public static Date getTodaysDate(){
		Calendar cal =Calendar.getInstance();
		//todays date
		Date date  = cal.getTime();
		System.out.println(cal.getTime());
		return date;
	}
	
	/**
	 * First date of current month
	 *
	 */
	public static Date getFirstDateOfCurrentMonth(){
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		System.out.println(cal.getTime());
		return cal.getTime();
	}
	
	/**
	 * For last x months from the current date
	 * @param months
	 * @return
	 */
	public static Date getLastXmonthDate(int months){
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.MONTH,(cal.get(Calendar.MONTH)-months) );
		
		return cal.getTime();
		
	}
	
	/**
	 * for a given month , get the 1st and the 
	 * last date of any of the last x months from 
	 * the current date. 
	 *
	 */
	public static Date[] getXMonthDates(int period){
		Date startDate = null;
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.MONTH,(cal.get(Calendar.MONTH)-period) );
		cal.set(Calendar.DATE,1);
		startDate = cal.getTime();
		System.out.println("First date of period month = "+cal.getTime());
		
		
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		
		System.out.println(" last date of last month = "+cal.getTime());
		Date[] dts = {startDate, cal.getTime()};
		return dts;
	}
	
	/**
	 * get first date of current year
	 * @return
	 */
	public static Date getFirstDayofCurrentYear(){
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.MONTH,1 );
		cal.set(Calendar.DATE,1);
		cal.set(Calendar.DATE,cal.get(Calendar.DATE)-1);
		
		return cal.getTime();
		
	}
	
	public static Date getSummaryCalculationDate(Date date){
		Calendar cal =Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE,cal.get(Calendar.DATE)-1);
		
		return cal.getTime();
		
	}
	
	/**
	 * get the past x year date from the current date.
	 * @return
	 */
	public static Date getLastXyearDate(int period){
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)-period);
		
		return cal.getTime();
		
	}
	
	/**
	 * get the 1st and last date of a year 
	 * corresponding to last x yr from current year.
	 * @param period
	 * @return
	 */
	public static Date[] getLastXYearDates(int period){
		Calendar cal = Calendar.getInstance();
		cal.set((cal.get(Calendar.YEAR)-period),0,1);
		Date stDate = cal.getTime();
		System.out.println(cal.getTime());
		
		cal.set((cal.get(Calendar.YEAR)-period),11,31);
		System.out.println(cal.getTime());
		
		Date[] dts = {stDate,cal.getTime() };
		
		return dts;
	}

}
