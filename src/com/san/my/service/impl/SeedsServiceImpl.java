package com.san.my.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<Integer,String> listAllSeeds() {
		List<SeedsDO> seedsDOs = seedsDAO.listAllSeeds();
		Map<Integer,String> seedsMapList = new HashMap<Integer,String>();
		for(SeedsDO seed:seedsDOs){
			HashMap seedIdToName = new HashMap<Integer, String>();
			seedIdToName.put(seed.getSeedId(), seed.getName());			
		}
		return seedsMapList;
	}
	
}
