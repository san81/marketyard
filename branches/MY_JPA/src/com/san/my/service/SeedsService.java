package com.san.my.service;

import java.util.List;
import java.util.Map;

import com.san.my.web.action.Seeds;

public interface SeedsService {

	/**
	 * @param seed
	 */
	public void saveSeed(Seeds seed);
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
	public List<String[]> listAllSeeds();
}
