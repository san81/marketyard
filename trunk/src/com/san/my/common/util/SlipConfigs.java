package com.san.my.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.san.my.common.global.AppConstants;

public class SlipConfigs
{
    private Properties slipProperties;
    
    private static SlipConfigs instance;
    
    private static final String CLASSPATH = (Thread.currentThread().getContextClassLoader()).getResource(AppConstants.APP_SLIP_CONFIG_FILE).getPath();
    
    private SlipConfigs(){
        loadSlipConfigs();
    }
    
    public static SlipConfigs getInstance() {
        if(instance == null){
            synchronized (SlipConfigs.class) {
                if(instance == null)
                    instance = new SlipConfigs();
            }
        }
        return instance;
    }
    
    private void loadSlipConfigs(){
        try {
            slipProperties = new Properties();
            slipProperties.load(new FileInputStream(new File(CLASSPATH)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getSlipConfig(String key){
        return slipProperties.getProperty(key);
    }
    
    public void setSlipConfig(String key, String value){
        slipProperties.setProperty(key, value);
    }
    
    public void storeSlipConfigsToFile(){
        try {
            slipProperties.store(new FileOutputStream(new File(CLASSPATH)), "Slip Attributes Configuration");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
