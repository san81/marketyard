package com.san.my.dao;

import java.util.List;

import com.san.my.dataobj.SeedDO;

public interface SeedsDAO {
	
	/**
	 * @param seed
	 */
	public void saveSeed(SeedDO seed);
	/**
	 * @param seedName
	 * @return
	 */
	public boolean isSeedNameExists(String seedName);
	
	/**
	 * Return all the list of seeds exists
	 * 
	 * @return
	 */
	public List listAllSeeds();
    
    public SeedDO loadSeed(Long seedId);
}
