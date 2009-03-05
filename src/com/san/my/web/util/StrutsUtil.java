package com.san.my.web.util;

import org.apache.struts.action.ActionForward;

public class StrutsUtil  {
  public StrutsUtil() {
  }

  /**
   * create a runtime ActionForward that includes a query string parameter
   * @param path  absolute or context relative actionforward path
   * @param parameter name of the query string parameter
   * @param value value of the the query string parameter
   * @return runtime ActionForward with querystring appended
   */
  public static ActionForward appendParameter(String path, String parameter, String value) {
      StringBuffer sb = new StringBuffer(path);

      if (path.indexOf("?") >= 0) {
          sb.append("&amp;");
      } else {
          sb.append("?");
      }
      sb.append(parameter);
      sb.append("=");
      sb.append(value);

      return new ActionForward(sb.toString());
  }  

  
}