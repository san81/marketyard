package com.san.my.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.san.my.dao.SeedsDAO;
import com.san.my.dataobj.SeedsDO;

public class SeedsDAOImpl extends ObjectDAOImpl implements SeedsDAO{

	public void saveSeed(SeedsDO seed) {
		save(seed);
	}
	
	public boolean isSeedNameExists(String seedName){
		long size = count("select count(*) from SeedsDO where name like '"+seedName+"'",true);
		if(size==0)
			return false;
		else
			return true;
	}

	public List listAllSeeds() {
		return findAll(SeedsDO.class);		
	}
	
}
