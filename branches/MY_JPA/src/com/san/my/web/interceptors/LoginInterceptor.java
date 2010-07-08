package com.san.my.web.interceptors;

import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.san.my.framework.SessionContainer;
import com.san.my.framework.SessionContainerHolder;



public class LoginInterceptor implements Interceptor {
	static Logger logger = Logger.getLogger(LoginInterceptor.class);

	FilterConfig filterConfig = null;

	public void init() {
        //Nothing to do as we made BeanLocatorFactory context aware.
		//StartUp.init();
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Login validation - exclude for image requests      
		final ActionContext context = invocation.getInvocationContext ();
	    HttpServletRequest request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
	    HttpSession session =  request.getSession (true);
	    SessionContainerHolder.setSessionContainerToThreadContext(new SessionContainer(session));

		return invocation.invoke();
	}

	public void destroy() {
		
	}

}