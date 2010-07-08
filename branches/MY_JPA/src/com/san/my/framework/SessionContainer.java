package com.san.my.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionContainer {
	private HttpSession session;    
    public SessionContainer(HttpServletRequest request) {
		session = request.getSession(false);
	}
	/**
	 * SessionContainer constructor comment.
	 */
	public SessionContainer(HttpSession session) {
		this.session = session;
	}
    
    public void setAttribute(String name, Object value) {
        session.setAttribute(name, value);
    }
    
    public Object getAttribute(String name){
        return session.getAttribute(name);
    }
    
    public void removeAttribute(String name) {
        session.removeAttribute(name);
    }

 }