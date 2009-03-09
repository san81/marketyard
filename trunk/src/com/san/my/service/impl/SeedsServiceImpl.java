package com.san.my.service.impl;

import com.san.my.dao.SeedsDAO;
import com.san.my.dataobj.SeedsDO;
import com.san.my.service.SeedsService;
import com.san.my.web.action.Seeds;

public class SeedsServiceImpl implements SeedsService{

	private SeedsDAO seedsDAO;	
	
	public void setSeedsDAO(SeedsDAO seedsDAO) {
		this.seedsDAO = seedsDAO;
	}
	
	public void saveSeed(Seeds seed) {
		SeedsDO seedDO = new SeedsDO();
		seedDO.setName(seed.getSeedName());
		seedsDAO.saveSeed(seedDO);
	}

	public boolean isSeedNameExists(String seedName) {
		return seedsDAO.isSeedNameExists(seedName);
	}

}
