package com.brave.feature.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderUtil
{
    static Date today = new Date();
    static int orderIndex = 0;

    private static String getIndex()
    {
        Date n = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currTime = outFormat.format(n);
        if (orderIndex > 0)
        {
            if ((n.getYear() == today.getYear()) && (n.getMonth() == today.getMonth()) && (n.getDay() == today.getDay()))
            {
                orderIndex += 1;
            }
            else
            {
                today = n;
                orderIndex = 1;
            }
        }
        else
        {
            today = n;
            orderIndex = 1;
        }
        if (orderIndex > 999999) {
            orderIndex = 1;
        }
        String indexString = String.format("%s%06d", new Object[] { currTime, Integer.valueOf(orderIndex) });
        return indexString;
    }

    public static String GetOrderNumber(String preFixString)
    {
        String orderNumberString = preFixString + getIndex();
        return orderNumberString;
    }

    public static String GetTimestamp()
    {
        return Long.toString(new Date().getTime() / 1000L);
    }

    public static String CreateNoncestr()
    {
        Random random = new Random();
        return MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
    }
}
