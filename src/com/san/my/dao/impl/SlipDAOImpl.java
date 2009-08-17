package com.san.my.dao.impl;

import com.san.my.dao.SlipDAO;
import com.san.my.dataobj.SlipDO;

public class SlipDAOImpl extends ObjectDAOImpl implements SlipDAO{

	public void createNewSlip(SlipDO slipDO) {		
		save(slipDO);
	}

	
}
