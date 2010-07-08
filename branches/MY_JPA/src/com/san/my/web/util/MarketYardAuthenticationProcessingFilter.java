package com.san.my.web.util;

/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import java.util.Locale;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

/**
* Processes an authentication form.<p>Login forms must present two parameters to this filter: a username and
* password. The parameter names to use are contained in the static fields {@link #ACEGI_SECURITY_FORM_USERNAME_KEY}
* and {@link #ACEGI_SECURITY_FORM_PASSWORD_KEY}.</p>
*  <P><B>Do not use this class directly.</B> Instead configure <code>web.xml</code> to use the {@link
* org.acegisecurity.util.FilterToBeanProxy}.</p>
*
* @author Ben Alex
* @author Colin Sampaleanu
* @version $Id: AuthenticationProcessingFilter.java 1496 2006-05-23 13:38:33 +0000 (Tue, 23 May 2006) benalex $
*/
public class MarketYardAuthenticationProcessingFilter extends AuthenticationProcessingFilter
{
    //~ Static fields/initializers =====================================================================================

    private static final Log log = LogFactory.getLog(MarketYardAuthenticationProcessingFilter.class);

    public static final String EZMARKET_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String EZMARKET_SECURITY_FORM_PASSWORD_KEY = "j_password";
    public static final String ACEGI_SECURITY_LAST_USERNAME_KEY = "ACEGI_SECURITY_LAST_USERNAME";
    public static final String ACEGI_SECURITY_LAST_PASSWORD_KEY = "ACEGI_SECURITY_LAST_PASSWORD";
    public static final String ACEGI_SECURITY_ERRORMESSAGE_KEY = "errorMessage";
    private UserDetailsService userDetailsService;

    //~ Methods ========================================================================================================

    public UserDetailsService getUserDetailsService()
    {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }

    public Authentication attemptAuthentication(HttpServletRequest request) throws AuthenticationException
    {   
        
        String username = obtainUsername(request);
        if (StringUtil.isNotNullOrEmpty(username)) {
            username = username.trim();
        }
        String password = obtainPassword(request);
        String errorMessage = "";
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        if (StringUtil.isNullOrEmpty(username)) {
            errorMessage = "loginErrorMessage1.Label";
        }
        else if (StringUtil.isNullOrEmpty(password)) {
            errorMessage = "loginErrorMessage2.Label";
        }

        // Place the last username attempted into HttpSession for views
        request.getSession().setAttribute(ACEGI_SECURITY_LAST_USERNAME_KEY, username);
        request.getSession().setAttribute(ACEGI_SECURITY_LAST_PASSWORD_KEY, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        if (errorMessage.equals("")) {
            try {

                UserDetails userdetails = userDetailsService.loadUserByUsername(username);
                if (userdetails == null)
                    errorMessage = "loginErrorMessage3.Label";
                else if (!password.equals(userdetails.getPassword()))
                        errorMessage = "loginErrorMessage4.Label";
            }
            catch(UsernameNotFoundException usere)
            {
                log.error("Exception occured in Login!",usere);
                errorMessage="loginErrorMessage2.Label";               
            }catch(Exception e)
            {              
                log.error("Exception occured in Login!", e);
                errorMessage="unknownExceptionMessage.Label";
            }
        }

        if (!errorMessage.equals("")) {
            setAuthenticationFailureUrl("/login.jsp?loginfail=" + errorMessage);
        }

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * This filter by default responds to <code>/j_acegi_security_check</code>.
     *
     * @return the default
     */
    public String getDefaultFilterProcessesUrl()
    {
        return "/j_acegi_security_check";
    }

    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    /**
     * Enables subclasses to override the composition of the password, such as by including additional values
     * and a separator.<p>This might be used for example if a postcode/zipcode was required in addition to the
     * password. A delimiter such as a pipe (|) should be used to separate the password and extended value(s). The
     * <code>AuthenticationDao</code> will need to generate the expected password in a corresponding manner.</p>
     *
     * @param request so that request attributes can be retrieved
     *
     * @return the password that will be presented in the <code>Authentication</code> request token to the
     *         <code>AuthenticationManager</code>
     */
    protected String obtainPassword(HttpServletRequest request)
    {
        return request.getParameter(EZMARKET_SECURITY_FORM_PASSWORD_KEY);
    }

    /**
     * Enables subclasses to override the composition of the username, such as by including additional values
     * and a separator.
     *
     * @param request so that request attributes can be retrieved
     *
     * @return the username that will be presented in the <code>Authentication</code> request token to the
     *         <code>AuthenticationManager</code>
     */
    protected String obtainUsername(HttpServletRequest request)
    {
        return request.getParameter(EZMARKET_SECURITY_FORM_USERNAME_KEY);
    }

    /**
     * Provided so that subclasses may configure what is put into the authentication request's details
     * property.
     *
     * @param request that an authentication request is being created for
     * @param authRequest the authentication request object that should have its details set
     */
    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest)
    {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
