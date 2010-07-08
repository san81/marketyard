package com.san.my.web.util;

import java.math.BigDecimal;

public class MathUtil
{
    public static double getDoubleValue(Double _double)
    {
        return  (_double == null) ? 0.0  : _double.doubleValue();
    }

    public static Double addDoubles(Double _addend, Double _augend)
    {
        double addend = getDoubleValue(_addend);
        double augend = getDoubleValue(_augend);

        double sum = addend + augend;

        return new Double(sum);
    }

    public static Double subtractDoubles(Double _minuend, Double _subtrahend)
    {
        double minuend = getDoubleValue(_minuend);
        double subtrahend = getDoubleValue(_subtrahend);

        double difference = minuend - subtrahend;

        return new Double(difference);
    }
    
    public static Double multiplyDoubles(Double _multiplicand, Double _multiplier, double decimalPlaces)
    {       
        double shift = Math.pow(10, decimalPlaces);

        double multiplicand = getDoubleValue(_multiplicand) * shift;
        double multiplier = getDoubleValue(_multiplier) * shift;

        double result = (multiplicand * multiplier) / (shift * shift);
        
        return new Double(result);
    }

    public static Double divideDoubles(Double _dividend, Double _divisor)
    {
        double quotient = 0.0;
        double dividend = getDoubleValue(_dividend);
        double divisor = getDoubleValue(_divisor);

        if (divisor == 0.0 && dividend != 0.0)
        {
            throw new RuntimeException("Cannot divide dividend: " + dividend + " by zero.");
        }
        else if (divisor != 0.0 && dividend != 0.0)
        {
            quotient = dividend/divisor;
        }

        return new Double(quotient);
    }
    
    public static Double round(Double d, int decimalPlace){
        //String in the constructor is used to avoid unpredictability of double value.
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace,BigDecimal.ROUND_HALF_UP);
        return new Double(bd.doubleValue());
      }

}
