package com.san.my.common.exception;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.apache.struts.util.ModuleException;

public class RegBaseException extends ModuleException  {

  protected Exception rootCause;

  /**
   * default constructor
   * uses default resource key
   */
  public RegBaseException() {
      // use default resource key
      super("error.application.default.message");
  }

  /**
   * alternate constuctor with runtime resource key
   * @param key resource bundle key to display on error page
   */
  public RegBaseException(String key) {
      super(key);
  }

  /**
   * alternate constuctor with runtime resource key
   * and parameter for parametric replacement into key
   * @param key resource bundle key to display on error page
   * @param value1  parameter value to replace into the key
   */
  public RegBaseException(String key, Object value1) {
      super(key, value1);
  }

  /**
   * alternate constuctor with runtime resource key
   * and parameters for parametric replacement into key
   * @param key resource bundle key to display on error page
   * @param value1  parameter value to replace into the key
   * @param value2  parameter value to replace into the key
   */
  public RegBaseException(String key, Object value1, Object value2) {
      super(key, value1, value2);
  }  

  /**
   * alternate constructor for nested exception handling
   * @param rootCause parent exception
   */
  public RegBaseException(Exception rootCause) {
      super("error.application.default.message");
      this.rootCause = rootCause;
  }

  /**
   * alternate constructor for nested exception handling
   * and argument for runtime resource key
   * @param rootCause parent exception
   * @param key resource bundle key to display on error page
   */
  public RegBaseException(Exception rootCause, String key) {
      super(key);
      this.rootCause = rootCause;
  }


  public Exception getRootCause() {
    return rootCause;
  }

  public void setRootCause(Exception newRootCause) {
    rootCause = newRootCause;
  }

  /**
   * prints stacktrace of current exception and parent
   * exception(s), if any to standard.err
   */
  public void printStackTrace() {
      super.printStackTrace();
      if (rootCause != null) {
          getRootCause().printStackTrace();
      }    
  }

  /**
   * prints stacktrace of current exception and parent
   * exception(s), if any to print stream
   * @param outStream print stream
   */
  public void printStackTrace(PrintStream outStream) {
      super.printStackTrace(outStream);
      if (rootCause != null) {
          getRootCause().printStackTrace(outStream);
      }    
  }  

  /**
   * prints stacktrace of current exception and parent
   * exception(s), if any to print writer
   * @param outStream print writer
   */
  public void printStackTrace(PrintWriter writer) {
      super.printStackTrace(writer);
      if (rootCause != null) {
          getRootCause().printStackTrace(writer);
      }
      writer.flush();
  }   

}