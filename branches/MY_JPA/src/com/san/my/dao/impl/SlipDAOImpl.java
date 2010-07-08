package com.san.my.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.san.my.dao.SlipDAO;
import com.san.my.dataobj.SlipDO;

public class SlipDAOImpl extends ObjectDAOImpl implements SlipDAO{

	public void createNewSlip(SlipDO slipDO) {		
		save(slipDO);
	}

    public SlipDO loadSlip(Long slipId)
    {
        return (SlipDO)get(SlipDO.class, slipId);
    }
}
