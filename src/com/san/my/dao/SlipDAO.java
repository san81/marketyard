package com.san.my.dao;

import com.san.my.dataobj.SlipDO;

/**
 * All Slip operations are grouped here.
 * 
 * @author santosh
 *
 */
public interface SlipDAO {

	/**
	 * Method to create a new slip table entry.
	 * 
	 * @param slipDO
	 */
	public void createNewSlip(SlipDO slipDO);
}
