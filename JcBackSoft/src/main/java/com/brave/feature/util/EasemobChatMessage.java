package com.brave.feature.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.brave.Easemobutils.ClientSecretCredential;
import com.brave.Easemobutils.Credential;
import com.brave.Easemobutils.HTTPClientUtils;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasemobChatMessage
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EasemobChatMessage.class);
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final String APPKEY = "shandongjinchi#jinchijinronghui";
    private static Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");

    public static void main(String[] args)
    {
        String currentTimestamp = String.valueOf(System.currentTimeMillis());
        String senvenDayAgo = String.valueOf(System.currentTimeMillis() - 604800000L);
        ObjectNode queryStrNode1 = factory.objectNode();
        queryStrNode1.put("ql", "select * where timestamp>" + senvenDayAgo + " and timestamp<" + currentTimestamp);
        ObjectNode messages1 = getChatMessages(queryStrNode1);
    }

    public static ObjectNode getChatMessages(ObjectNode queryStrNode)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }
        try
        {
            String rest = "";
            if ((null != queryStrNode) && (queryStrNode.get("ql") != null) && (!StringUtils.isEmpty(queryStrNode.get("ql").asText()))) {
                rest = "ql=" + URLEncoder.encode(queryStrNode.get("ql").asText(), "utf-8");
            }
            if ((null != queryStrNode) && (queryStrNode.get("limit") != null) && (!StringUtils.isEmpty(queryStrNode.get("limit").asText()))) {
                rest = rest + "&limit=" + queryStrNode.get("limit").asText();
            }
            if ((null != queryStrNode) && (queryStrNode.get("cursor") != null) && (!StringUtils.isEmpty(queryStrNode.get("cursor").asText()))) {
                rest = rest + "&cursor=" + queryStrNode.get("cursor").asText();
            }
            URL chatMessagesUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatmessages?" + rest);

            objectNode = HTTPClientUtils.sendHTTPRequest(chatMessagesUrl, credential, null, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }
}
