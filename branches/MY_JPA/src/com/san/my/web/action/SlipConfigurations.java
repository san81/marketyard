
package com.san.my.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.global.MessageKey;
import com.san.my.common.util.SlipConfigs;

public class SlipConfigurations extends ActionSupport
{
    private static final long serialVersionUID = 1L;

    private double hamaliRate;
    private double adthiRate;
    private double cashCommissionRate;
    
    SlipConfigs slipConfig = SlipConfigs.getInstance();
    
    public String load() throws Exception
    {   
        setHamaliRate(Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE)));
        setAdthiRate(Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE)));
        setCashCommissionRate(Double.parseDouble(slipConfig.getSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE)));
        
        return SUCCESS;
    }
    
    public String store() throws Exception
    {   
        slipConfig.setSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE, Double.toString(getHamaliRate()));
        slipConfig.setSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE, Double.toString(getAdthiRate()));
        slipConfig.setSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE, Double.toString(getCashCommissionRate()));
        
        slipConfig.storeSlipConfigsToFile();
        
        return SUCCESS;
    }
    
    public double getAdthiRate()
    {
        return adthiRate;
    }

    public void setAdthiRate(double adthiRate)
    {
        this.adthiRate = adthiRate;
    }

    public double getCashCommissionRate()
    {
        return cashCommissionRate;
    }

    public void setCashCommissionRate(double cashCommissionRate)
    {
        this.cashCommissionRate = cashCommissionRate;
    }

    public double getHamaliRate()
    {
        return hamaliRate;
    }

    public void setHamaliRate(double hamaliRate)
    {
        this.hamaliRate = hamaliRate;
    }
}
