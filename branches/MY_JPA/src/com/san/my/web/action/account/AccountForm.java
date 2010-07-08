package com.san.my.web.action.account;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.util.springs.ServiceLocator;
import com.san.my.service.AccountService;

//@Validation
public class AccountForm extends ActionSupport{

	private String loginName;
	private String name;
	private String mobile;
	private String address;
	private String village;
    private String accountType;
    AccountService accountService;
	
	
	public String getAccountType()
    {
        return accountType;
    }
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginName() {
		return loginName;
	}
	
	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "Login name Required")
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMobile() {
		return mobile;
	}
	
	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "Login name Required")
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
		if(accountService.isLoginNameExists(loginName)){
			addFieldError("loginName", "login name already exists");
			return INPUT;
		}
      	accountService.saveAccount(this);
      	return SUCCESS;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
