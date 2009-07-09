package com.san.my.web.interceptors;

import javax.servlet.FilterConfig;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.san.my.common.util.springs.BeanLocatorFactory;
import com.san.my.framework.StartUp;



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