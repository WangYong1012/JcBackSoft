package com.brave.feature.util;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.brave.Easemobutils.ClientSecretCredential;
import com.brave.Easemobutils.Credential;
import com.brave.Easemobutils.HTTPClientUtils;
import java.io.PrintStream;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasemobDeleteUsers
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EasemobChatMessage.class);
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final String APPKEY = "shandongjinchi#jinchijinronghui";
    private static Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");

    public static void main(String[] args)
    {
        try
        {
            ObjectNode objectNode = factory.objectNode();

            String rest = "limit=5";
            URL chatMessagesUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users?" + rest);

            objectNode = HTTPClientUtils.sendHTTPRequest(chatMessagesUrl, credential, null, "DELETE");

            System.out.println(objectNode);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
