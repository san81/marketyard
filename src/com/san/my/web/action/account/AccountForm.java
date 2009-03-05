package com.san.my.web.action.account;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.util.springs.ServiceLocator;
import com.san.my.service.AccountService;

public class AccountForm extends ActionSupport{

	private String loginName;
	private String name;
	private String mobile;
	private String address;
	private String village;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	
	public String execute() throws Exception{
		AccountService accountService = ServiceLocator.getAccountService();
      	accountService.saveAccount(this);
      	return ActionSupport.SUCCESS;
	}
}
