package com.san.my.service;

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
}
