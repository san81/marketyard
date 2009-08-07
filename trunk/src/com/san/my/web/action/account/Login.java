package com.san.my.web.action.account;
import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.Roles;

import java.util.Date;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;


/**
 * <p> Validate a user login. </p>
 */
public  class Login  extends ActionSupport {


    public String execute() throws Exception {
        String returnStr;
         Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
         if(authentication!=null){
        	 GrantedAuthority[] ga= authentication.getAuthorities();
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

}
