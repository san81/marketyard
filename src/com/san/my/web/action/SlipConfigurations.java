
package com.san.my.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;

import com.opensymphony.xwork2.ActionSupport;
import com.san.my.common.global.MessageKey;
import com.san.my.common.util.SlipConfigs;
import com.san.my.web.util.StringUtil;

public class SlipConfigurations extends ActionSupport implements ParameterAware
{
    private static final long serialVersionUID = 1L;

    private double hamaliRate;
    private double adthiRate;
    private double cashCommissionRate;


    private Map parameters;

    public String execute() throws Exception
    {
        String action = getParameterValue("action");
        
        if (StringUtil.isNotNullOrEmpty(action) && action.equals("load")) {
            setHamaliRate(Double.parseDouble(SlipConfigs.getSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE)));
            setAdthiRate(Double.parseDouble(SlipConfigs.getSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE)));
            setCashCommissionRate(Double.parseDouble(SlipConfigs.getSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE)));
        }
        else {
            SlipConfigs.setSlipConfig(MessageKey.SLIP_CONFIG_HAMALI_RATE, Double.toString(getHamaliRate()));
            SlipConfigs.setSlipConfig(MessageKey.SLIP_CONFIG_ADTHI_RATE, Double.toString(getAdthiRate()));
            SlipConfigs.setSlipConfig(MessageKey.SLIP_CONFIG_CASHCOMMISSION_RATE, Double.toString(getCashCommissionRate()));
            
            SlipConfigs.storeSlipConfigsToFile();
            
        }

        return SUCCESS;
    }

    private String getParameterValue(String param)
    {
        Object varr = getParameters().get(param);
        if (varr == null)
            return null;
        return ((String[]) varr)[0];
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

    public void setParameters(Map parameters)
    {
        this.parameters = parameters;
    }

    public Map getParameters()
    {
        return parameters;
    }
}
