package com.brave.feature.app.service;

import com.brave.feature.util.MD5;
import com.brave.feature.util.MD5Util;
import com.brave.feature.util.OrderUtil;
import java.io.PrintStream;
import java.util.*;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

public class WXPay
{
    public static String createPackageValue(String appid, String appKey, String prepay_id)
    {
        SortedMap<String, String> nativeObj = new TreeMap();
        nativeObj.put("appId", appid);
        nativeObj.put("timeStamp", OrderUtil.GetTimestamp());
        Random random = new Random();
        String randomStr = MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
        nativeObj.put("nonceStr", MD5Util.MD5Encode(randomStr, "utf-8").toLowerCase());
        nativeObj.put("package", "prepay_id=" + prepay_id);
        nativeObj.put("signType", "MD5");
        nativeObj.put("paySign", createSign(nativeObj, appKey));
        System.out.println(JSONObject.fromObject(nativeObj).toString());
        return JSONObject.fromObject(nativeObj).toString();
    }

    public static String createSign(SortedMap<String, String> packageParams, String AppKey)
    {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext())
        {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if ((null != v) && (!"".equals(v)) && (!"sign".equals(k)) && (!"key".equals(k))) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + AppKey);
        String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }
}
