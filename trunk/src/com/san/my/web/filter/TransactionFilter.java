package com.san.my.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.san.my.common.util.springs.BeanLocatorFactory;
import com.san.my.framework.RegBaseAction;

public class TransactionFilter extends RegBaseAction implements Filter 
{
	static Logger logger = Logger.getLogger(TransactionFilter.class);
	
	public void doFilter(final ServletRequest request,final ServletResponse response,final FilterChain filterChain) throws IOException, ServletException
	{
        
        //Important : This code duplicated in the StartUp.java. Reftables being loaded within the transaction.
		try
		{			
			TransactionTemplate txTemplate =(TransactionTemplate) BeanLocatorFactory.getBean("transactionTemplate");
			
			txTemplate.execute(new TransactionCallbackWithoutResult(){
				public void doInTransactionWithoutResult(TransactionStatus status) {
					try {
                        //logger.debug("Begin transaction filter");
						filterChain.doFilter(request, response);
                        //logger.debug("End transaction filter");
					} 
					catch(Throwable ex)
					{
						status.setRollbackOnly();
						ex.printStackTrace();
						logger.error("Exception: " + ex.getMessage()  );
                        //rethrowing exception to be handled by web.xml error-page entry
                        throw new RuntimeException(ex);
					}
				}				
			});
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			logger.error("Exception: " + ex.getMessage() );
            throw new RuntimeException(ex);
		}
			
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
