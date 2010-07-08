package com.san.my.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.util.springs.ServiceLocator;
import com.san.my.service.SeedsService;

public class Seeds extends ActionSupport{

	Long seedId;
	String seedName;
	SeedsService seedsService;
	
	public Long getSeedId() {
		return seedId;
	}
	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}
	public String getSeedName() {
		return seedName;
	}
	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}
	
	public String execute() throws Exception{		
		if(seedsService.isSeedNameExists(seedName)){
			addFieldError("seedName", "Seed name already exists");
			return INPUT;
		}
		seedsService.saveSeed(this);
		return SUCCESS;
	}
	public void setSeedsService(SeedsService service) {
		this.seedsService = service;
	}
}
