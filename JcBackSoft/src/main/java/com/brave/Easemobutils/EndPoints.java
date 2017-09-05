package com.brave.Easemobutils;

import java.net.URL;

public abstract interface EndPoints
{
    public static final URL TOKEN_APP_URL = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/token");
    public static final URL USERS_URL = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users");
    public static final URL MESSAGES_URL = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/messages");
    public static final URL CHATGROUPS_URL = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups");
    public static final URL CHATFILES_URL = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatfiles");
}
