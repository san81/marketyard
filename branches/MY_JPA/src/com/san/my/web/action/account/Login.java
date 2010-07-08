package com.san.my.web.action.account;
import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.Roles;
import com.san.my.common.global.SessionVars;

import java.util.Date;
import java.util.Map;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts2.interceptor.SessionAware;


/**
 * <p> Validate a user login. </p>
 */
public  class Login  extends ActionSupport implements SessionAware{

	private Map session;
    public String execute() throws Exception {
        String returnStr;
         Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
         if(authentication!=null){
        	 GrantedAuthority[] ga= authentication.getAuthorities();
        	 getSession().put(SessionVars.USER_ROLE, ga[0]);
        	 if(ga[0].equals(Roles.ADMIN.name()))
        		 returnStr = "adminLoggedIn";
        	 else if(ga[0].equals(Roles.BUYER.name()))
        		 returnStr = "buyerLoggedIn";
        	 else 
        		 returnStr = "userLoggedIn";
         }else
        	 return "welcome";
         
      return returnStr;
	}
    
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}

}
