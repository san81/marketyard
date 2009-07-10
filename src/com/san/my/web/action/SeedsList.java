package com.san.my.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.util.springs.ServiceLocator;
import com.san.my.service.SeedsService;

public class SeedsList extends ActionSupport{
	List seeds=new ArrayList<String[]>();
	SeedsService seedsService;
		
	public List getSeeds() {
		return seeds;
	}

	public void setSeeds(List seeds) {
		this.seeds = seeds;
	}

	public String execute() throws Exception{	
		seeds = seedsService.listAllSeeds();
		return SUCCESS;
	}

	public void setSeedsService(SeedsService service) {
		this.seedsService = service;
	}
}
