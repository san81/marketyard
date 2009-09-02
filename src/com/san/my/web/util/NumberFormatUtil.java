/**
 * 
 */
package com.san.my.web.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.san.my.common.global.Constants;

public class NumberFormatUtil {

	static Logger logger = Logger.getLogger(NumberFormatUtil.class);
	
	private static String numberFormatString = Constants.NUMBER_FORMAT_US;
	
	//method which formats the number based on the locale specified by the user.
	public static String getFormattedNumber(String numberFormat,Double numberToBeFormatted, int precission){
		
		String returnString = null;
		DecimalFormatSymbols decimalFormatSymbols = getSeparatorSymbols(numberFormat);
		
		if(numberToBeFormatted == null){
			return "0"+decimalFormatSymbols.getDecimalSeparator()+"00";
		}
		DecimalFormat dateFormat = new DecimalFormat(numberFormatString,decimalFormatSymbols);
		dateFormat.setMinimumFractionDigits(precission);
		dateFormat.setMaximumFractionDigits(precission);
		returnString = dateFormat.format(numberToBeFormatted);
		return returnString;
	}
    
	/**
     * Default Number format method.. Locale is US, Precision is 2.
     * 
	 * @param numberToBeFormatted
	 * @return
	 */
	public static String getFormattedNumber(Double numberToBeFormatted){
        return getFormattedNumber(Constants.NUMBER_FORMAT_US, numberToBeFormatted, 2);
    }
	
	public static DecimalFormatSymbols getSeparatorSymbols(String numberFormat)
	{
		if(numberFormat != null && numberFormat.equals(Constants.NUMBER_FORMAT_GERMANY))
		{
			DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.GERMANY);
			return decimalFormatSymbols;
		}
		else if(numberFormat != null && numberFormat.equals(Constants.NUMBER_FORMAT_FRANCE))
		{
			DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.FRANCE);
			return decimalFormatSymbols;
		} 
		else
		{
			DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
			return decimalFormatSymbols;
		}
	}
}
