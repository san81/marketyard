package com.san.my.framework;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import com.san.my.web.util.DateUtil;
import com.san.my.web.util.StringUtil;

/**
 * <strong>RegBaseActionForm</strong> extends the behaviour of the
 * standard Struts ActionForm.
 * 
 *  * 
 * <p>Title: Registration</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: GNX</p>
 * @author Mike Sprague
 * @version 1.0
 */

public class RegBaseForm extends ActionForm {
   
    protected final static String COUNTRY_CODE_US = "US";  
  
  /**
   * iterates thru all string properties of a form bean and validates
   * if properties contain non-latin characters (e.g. multibyte)
   * @param clazz Class of the form bean
   * @param allowLatinProperites  list of bean propertyNames that are allowed to contain
   * non-latin characters.  These bean properties are ignored during the validation.
   * @param errors  Struts ActionMessages object
   */
  public void validateLatinFields(Class clazz, ArrayList allowLatinProperties, ActionMessages errors,HttpServletRequest request) {
      try {
          BeanInfo bi = Introspector.getBeanInfo(clazz);
          PropertyDescriptor[] props = bi.getPropertyDescriptors();
          for (int i = 0; i < props.length; i++) {
              PropertyDescriptor p = props[i];
              if (!allowLatinProperties.contains(p.getName()) &&  p.getPropertyType() == String.class ) {
                  Method m = p.getReadMethod();
                  String propValue = (String)m.invoke(this, null);
                  if (propValue != null && !StringUtil.isLatinCharSet(propValue)) {
                      //String key = "label." + p.getName();
                      //String message = getMessage(key,request);
                      errors.add(p.getName(), new ActionMessage("valid.invalidCharSet"));           
                  }
              }    
          }

      } catch (Exception ex) {
          // bean introspection failure or method reflection failure
          ex.printStackTrace();
      }      
  }

  /**
   * alternate constructor used in event that there are no
   * latin field exceptions
   */
  public void validateLatinFields(Class clazz, ActionMessages errors,HttpServletRequest request) {  
      ArrayList allowLatinProperties = new ArrayList();
      this.validateLatinFields(clazz, allowLatinProperties, errors,request);
  }  

  public String getMessage(String key, HttpServletRequest request){
      MessageResources mr=((MessageResources) request.getAttribute(Globals.MESSAGES_KEY));
      HttpSession session = request.getSession();
      Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
      
      String message = mr.getMessage(locale,key);
      return message;
  }
  
  protected boolean isNumber(String text){
	  boolean result = false;
	  if (StringUtil.isNotNullOrEmpty(text)){
		  for (int i=0; i<text.length(); i++){
			  char c = text.charAt(i);
			 if (!Character.isDigit(c)){
				 break;
			 }
			 result = true;
		  }
	  }
	  return result;
  }
  
  protected boolean isValidDate(String date, String javaDateFormat, Locale locale){
	  	return DateUtil.isValidDate(date, javaDateFormat, locale);
  }
  
}