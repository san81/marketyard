
package com.san.my.framework;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.san.my.common.global.Config;
import com.san.my.common.util.springs.BeanLocatorFactory;
import com.san.my.web.util.MyLogger;

public class StartUp
{
    static Logger logger = Logger.getLogger(StartUp.class);

    public static void init()
    {
        try {
            MyLogger.initLog4j(Config.LOG_CONFIGURATION_FILE);
        }
        catch (Exception e) {
            System.out.println("Exception in initializing log4j.\nReason: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        logger.debug("Starting MyGenSource Middle Tier..");        
        SpringConfigurationLoader.loadConfiguration();
        loadRefTablesWithinTransaction();
    }

    // This code is duplicated from TransactionFilter.

    private static void loadRefTablesWithinTransaction()
    {

        try {
            TransactionTemplate txTemplate = (TransactionTemplate) BeanLocatorFactory.getBean("transactionTemplate");

            txTemplate.execute(new TransactionCallbackWithoutResult() {
                public void doInTransactionWithoutResult(TransactionStatus status)
                {
                    try {
                        loadReftables();                        
                    }
                    catch (Exception ex) {
                        status.setRollbackOnly();
                        ex.printStackTrace();
                        logger.error("Exception: " + ex.getMessage());
                    }
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Exception: " + ex.getMessage());
        }
    }

    private static void loadReftables() throws Exception
    {
        //load application reftables
//    	Timezone.getInstance();
//        Locales.getInstance();
//        Language.getInstance();
//        Country.getInstance();
//        Currency.getInstance();        
//
//        Service.getInstance();
//        TrainingProduct.getInstance();
//        SecuredResource.getInstance();
//        DateFormats.getInstance();
//        NumberFormats.getInstance();
//        Role.getInstance();
//        Group.getInstance();
//        Attributes.getInstance();
    }
   
}
