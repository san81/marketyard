package com.san.my.common.exception;

public class BusinessServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2455799960531127407L;
	
	public BusinessServiceException(String message) {
        super(message);
    }

    public BusinessServiceException(Throwable cause) {
        super(cause);
    }

    public BusinessServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
