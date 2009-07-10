package com.san.my.web.interceptors;

import javax.servlet.FilterConfig;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;



public class LoginInterceptor implements Interceptor {
	static Logger logger = Logger.getLogger(LoginInterceptor.class);

	FilterConfig filterConfig = null;

	public void init() {
        //Nothing to do as we made BeanLocatorFactory context aware.
		//StartUp.init();
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Login validation - exclude for image requests        
		return invocation.invoke();
	}

	public void destroy() {
		
	}

}