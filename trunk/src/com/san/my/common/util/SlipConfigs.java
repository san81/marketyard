package com.san.my.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SlipConfigs
{
    private static Properties slipProperties;
    
    private static final String CLASSPATH = (Thread.currentThread().getContextClassLoader()).getResource("slip_configs.properties").getPath();
    
    private SlipConfigs(){};
    
    private static void loadSlipConfigs(){
        try {
            slipProperties = new Properties();
            slipProperties.load(new FileInputStream(new File(CLASSPATH)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getSlipConfig(String key){
        if(slipProperties == null)
            loadSlipConfigs();
        return slipProperties.getProperty(key);
    }
    
    public static void setSlipConfig(String key, String value){
        if(slipProperties == null)
            loadSlipConfigs();
        slipProperties.setProperty(key, value);
    }
    
    public static void storeSlipConfigsToFile(){
        if(slipProperties == null)
            loadSlipConfigs();
        
        try {
            slipProperties.store(new FileOutputStream(new File(CLASSPATH)), "Configuration Attributes");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
