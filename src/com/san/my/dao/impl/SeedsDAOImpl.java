package com.san.my.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.san.my.dao.SeedsDAO;
import com.san.my.dataobj.SeedDO;

public class SeedsDAOImpl extends ObjectDAOImpl implements SeedsDAO{

	public void saveSeed(SeedDO seed) {
		save(seed);
	}
	
	public boolean isSeedNameExists(String seedName){
		long size = count("select count(*) from SeedDO where name like '"+seedName+"'",true);
		if(size==0)
			return false;
		else
			return true;
	}

	public List listAllSeeds() {
		return findAll(SeedDO.class);		
	}

    public SeedDO loadSeed(Long seedId)
    {
        return (SeedDO)load(SeedDO.class, seedId);
    }
}
