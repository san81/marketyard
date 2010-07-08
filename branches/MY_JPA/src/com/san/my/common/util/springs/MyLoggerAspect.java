package com.san.my.common.util.springs;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Spring Aop - Aspect for logging.
 *
 */
public class MyLoggerAspect {

	public Object log(ProceedingJoinPoint call) throws Throwable {

		Logger logger = Logger.getLogger(call.getTarget().getClass());		
		logger.debug("begin logging aspect: begin method ["
				+ call.toShortString() + "] with param:");

		for (int i = 0; i < call.getArgs().length; i++) 
			logger.debug(call.getArgs()[i] + ",");		

		Object point = call.proceed();
		
		logger.debug("end logging aspect: exiting method ["
				+ call.toShortString() + " with return as: " + point);

		return point;
	}
}
