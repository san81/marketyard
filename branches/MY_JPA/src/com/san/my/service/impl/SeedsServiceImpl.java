package com.san.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.san.my.dao.SeedsDAO;
import com.san.my.dataobj.SeedDO;
import com.san.my.service.SeedsService;
import com.san.my.web.action.Seeds;

public class SeedsServiceImpl implements SeedsService{

	private SeedsDAO seedsDAO;	
	
	public void setSeedsDAO(SeedsDAO seedsDAO) {
		this.seedsDAO = seedsDAO;
	}
	
	public void saveSeed(Seeds seed) {
		SeedDO seedDO = new SeedDO();
		seedDO.setName(seed.getSeedName());
		seedsDAO.saveSeed(seedDO);
	}

	public boolean isSeedNameExists(String seedName) {
		return seedsDAO.isSeedNameExists(seedName);
	}

	public List<String[]> listAllSeeds() {
		List<SeedDO> seedsDOs = seedsDAO.listAllSeeds();
		List<String[]> seeds=new ArrayList<String[]>();
		for(SeedDO seed:seedsDOs){
			String[] seedNameToId = new String[2];
			seedNameToId[1]= seed.getSeedId()+"";
			seedNameToId[0] = seed.getName();
			seeds.add(seedNameToId);			
		}
		return seeds;
	}
	
}
