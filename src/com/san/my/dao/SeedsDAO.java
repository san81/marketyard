package com.san.my.dao;

import com.san.my.dataobj.SeedsDO;

public interface SeedsDAO {
	
	/**
	 * @param seed
	 */
	public void saveSeed(SeedsDO seed);
	/**
	 * @param seedName
	 * @return
	 */
	public boolean isSeedNameExists(String seedName);
}
