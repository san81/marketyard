package com.san.my.framework;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import com.san.my.common.exception.RegFatalException;
import com.san.my.common.global.MessageKey;
import com.san.my.web.util.StringUtil;
/**
 * An abstract Action class that all store front action classes should
 * extend.
 */
abstract public class RegBaseAction extends Action {

	Logger logger = Logger.getLogger(RegBaseAction.class);

	/**
	 * Retrieve a session object based on the request and the attribute name.
	 */
	protected Object getSessionObject(HttpServletRequest req, String attrName) {
		Object sessionObj = null;

		// do not create a session if one isn't already present
		HttpSession session = req.getSession(false);
		sessionObj = session.getAttribute(attrName);
		return sessionObj;
	}
	
	/**
	 * Retrieve an object from the application scope by its name. This is
	 * a convience method.
	 */
	protected Object getApplicationObject(String attrName) {
		return servlet.getServletContext().getAttribute(attrName);
	}

	public void removeFormFromScope(ActionMapping mapping,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (mapping.getAttribute() != null) {
			session.removeAttribute(mapping.getAttribute());
		}
	}
	
	public void saveFormToScope(ActionMapping mapping, ActionForm form,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (mapping.getAttribute() != null) {
			session.setAttribute(mapping.getAttribute(), form);
		}
	}	

	public String getMessage(String key, HttpServletRequest request) {
		MessageResources mr = ((MessageResources) request
				.getAttribute(Globals.MESSAGES_KEY));
		HttpSession session = request.getSession();
		Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
		String message = mr.getMessage(locale, key);
		return message;
	}	
	
	public MessageResources getResourceBundle(HttpServletRequest request){
		return ((MessageResources) request
				.getAttribute(Globals.MESSAGES_KEY));
	}

	
	/**
	 * checks for expired session - redirects to SSO logout page if true
	 * and saves timeout message to struts message attribute
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	protected void validateSession(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		boolean isSessionValid = request.isRequestedSessionIdValid();

		//boolean isSessionNull = (session == null);

		if (!session.isNew()) {
			if (!isSessionValid && request.getRemoteUser() != null) {
				logger.info("invalid session for user "
						+ request.getRemoteUser()
						+ " forwarding to logout page");

				ActionMessages msgs = new ActionMessages();
				msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						MessageKey.STRING_SESSION_EXPIRED));
				request.setAttribute(Globals.MESSAGE_KEY, msgs);
				try {
					request.getRequestDispatcher("/logout").forward(request,
							response);
					return;
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}
		//   logger.debug("checked session for " + request.getRemoteUser());
	}
		
	/**
	 * type check request parameters against expected user inputs
	 */
	protected Long validateRequestParamLong(String id)
	throws RegFatalException {
		Long result = null;
		// type check id to prevent SQLInjection hacks
		try {
			if (StringUtil.isNotNullOrEmpty(id)){
				result = Long.parseLong(id);
			}		
		} catch (NumberFormatException nfe) {
			logger.error("invalid request parameter value: "
					+ nfe.getMessage());
			throw new RegFatalException("error.application.message1","- Invalid request");
		}
		return result;
	}
	    
}

