package com.san.my.common.exception;

public class RegFatalException extends RegBaseException {

  /**
   * default constructor
   * uses default resource key
   */
    public RegFatalException() {
      super();  
    }
    
  /**
   * alternate constuctor with runtime resource key
   * @param key resource bundle key to display on error page
   */
    public RegFatalException(String key) {
      super(key);
    }

  /**
   * alternate constuctor with runtime resource key
   * and parameter for parametric replacement into key
   * @param key resource bundle key to display on error page
   * @param value1  parameter value to replace into the key
   */
    public RegFatalException(String key, Object value1) {
      super(key, value1);
    }

  /**
   * alternate constuctor with runtime resource key
   * and parameters for parametric replacement into key
   * @param key resource bundle key to display on error page
   * @param value1  parameter value to replace into the key
   * @param value2  parameter value to replace into the key
   */
    public RegFatalException(String key, Object value1, Object value2) {
      super(key, value1, value2);
    }    

  /**
   * alternate constructor for nested exception handling
   * @param rootCause parent exception
   */
    public RegFatalException(Exception rootCause) {
      super(rootCause);
    }

  /**
   * alternate constructor for nested exception handling
   * and argument for runtime resource key
   * @param rootCause parent exception
   * @param key resource bundle key to display on error page
   */
    public RegFatalException(Exception rootCause, String key) {
      super(rootCause, key);
    }

}
