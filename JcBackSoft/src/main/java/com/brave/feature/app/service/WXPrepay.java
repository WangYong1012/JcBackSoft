package com.brave.feature.app.service;

import com.brave.feature.util.MD5Util;
import com.brave.feature.util.OrderUtil;
import com.brave.feature.util.XMLUtil;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jdom.JDOMException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WXPrepay
{
    private static String unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private static String orderquery = "https://api.mch.weixin.qq.com/pay/orderquery";
    private String appid;
    private String mch_id;
    private String nonce_str = OrderUtil.CreateNoncestr();
    private String body;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private String trade_type;
    private String notify_url;
    private String sign;
    private String partnerKey;
    private String prepay_id;

    public String submitXmlGetPrepayId()
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(unifiedorder);
        String xml = getPackage();
        try
        {
            StringEntity entity = new StringEntity(xml, "utf-8");
            httpPost.setEntity(entity);


            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null)
            {
                String result = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println(result);

                result = result.replaceAll("<![CDATA[|]]>", "");
                String prepay_id = Jsoup.parse(result).select("prepay_id").html();
                this.prepay_id = prepay_id;
                if (prepay_id != null) {
                    return prepay_id;
                }
            }
            closeableHttpClient.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return this.prepay_id;
    }

    public Map<String, String> reqOrderquery()
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(orderquery);
        String xml = getPackage();

        Map<String, String> map = null;
        try
        {
            StringEntity entity = new StringEntity(xml, "utf-8");
            httpPost.setEntity(entity);


            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);

            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null)
            {
                String result = EntityUtils.toString(httpEntity, "UTF-8");

                result = result.replaceAll("<![CDATA[|]]>", "");
                try
                {
                    map = XMLUtil.doXMLParse(result);
                }
                catch (JDOMException e)
                {
                    e.printStackTrace();
                }
            }
            closeableHttpClient.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }

    public String getPackage()
    {
        TreeMap<String, String> treeMap = new TreeMap();
        treeMap.put("appid", this.appid);
        treeMap.put("mch_id", this.mch_id);
        treeMap.put("nonce_str", this.nonce_str);
        treeMap.put("body", this.body);
        treeMap.put("out_trade_no", this.out_trade_no);
        treeMap.put("total_fee", this.total_fee);
        treeMap.put("spbill_create_ip", this.spbill_create_ip);
        treeMap.put("trade_type", this.trade_type);
        treeMap.put("notify_url", this.notify_url);
        StringBuilder sb = new StringBuilder();
        for (Iterator localIterator = treeMap.keySet().iterator(); localIterator.hasNext();)
        {
            String key = (String)localIterator.next();
            sb.append(key).append("=").append((String)treeMap.get(key)).append("&");
        }
        String key;
        sb.append("key=" + this.partnerKey);
        this.sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
        treeMap.put("sign", this.sign);
        StringBuilder xml = new StringBuilder();
        xml.append("<xml>\n");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            if (("body".equals(entry.getKey())) || ("sign".equals(entry.getKey()))) {
                xml.append("<" + (String)entry.getKey() + "><![CDATA[").append((String)entry.getValue()).append("]]></" + (String)entry.getKey() + ">\n");
            } else {
                xml.append("<" + (String)entry.getKey() + ">").append((String)entry.getValue()).append("</" + (String)entry.getKey() + ">\n");
            }
        }
        xml.append("</xml>");
        System.out.println(xml.toString());
        return xml.toString();
    }

    public String getAppid()
    {
        return this.appid;
    }

    public void setAppid(String appid)
    {
        this.appid = appid;
    }

    public String getMch_id()
    {
        return this.mch_id;
    }

    public void setMch_id(String mch_id)
    {
        this.mch_id = mch_id;
    }

    public String getBody()
    {
        return this.body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public String getOut_trade_no()
    {
        return this.out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no)
    {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee()
    {
        return this.total_fee;
    }

    public void setTotal_fee(String total_fee)
    {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip()
    {
        return this.spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip)
    {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTrade_type()
    {
        return this.trade_type;
    }

    public void setTrade_type(String trade_type)
    {
        this.trade_type = trade_type;
    }

    public String getNotify_url()
    {
        return this.notify_url;
    }

    public void setNotify_url(String notify_url)
    {
        this.notify_url = notify_url;
    }

    public String getPartnerKey()
    {
        return this.partnerKey;
    }

    public void setPartnerKey(String partnerKey)
    {
        this.partnerKey = partnerKey;
    }
}
