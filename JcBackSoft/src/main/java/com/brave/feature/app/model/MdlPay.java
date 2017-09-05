package com.brave.feature.app.model;

public class MdlPay
{
    private String appId;
    private String partnerId;
    private String partnerKey;

    public String getAppId()
    {
        return this.appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getPartnerId()
    {
        return this.partnerId;
    }

    public void setPartnerId(String partnerId)
    {
        this.partnerId = partnerId;
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
