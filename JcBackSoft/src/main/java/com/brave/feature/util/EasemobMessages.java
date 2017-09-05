package com.brave.feature.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.brave.Easemobutils.ClientSecretCredential;
import com.brave.Easemobutils.Credential;
import com.brave.Easemobutils.HTTPClientUtils;
import java.io.PrintStream;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasemobMessages
{
    public static final Logger LOGGER = LoggerFactory.getLogger(EasemobMessages.class);
    private static final String APPKEY = "shandongjinchi#jinchijinronghui";
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");

    public static void main(String[] args)
    {
        String from = "kenshinnuser000";
        ObjectNode ext = factory.objectNode();
        ObjectNode txtmsg = factory.objectNode();
        txtmsg.put("msg", "群公告已更改，请查看!");
        txtmsg.put("type", "txt");
        String targetTypegr = "chatgroups";
        String groupid = "1451898797415";
        ArrayNode targetgroup = factory.arrayNode();
        targetgroup.add(groupid);
        ObjectNode sendTxtMessagegroupnode = sendMessages(targetTypegr, targetgroup, txtmsg, from, ext);
        if (null != sendTxtMessagegroupnode)
        {
            LOGGER.info("给一个群组发文本消息: " + sendTxtMessagegroupnode.toString());
            System.out.println("给一个群组发文本消息: " + sendTxtMessagegroupnode.toString());
        }
    }

    public static ObjectNode getUserStatus(String username)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");
            objectNode.put("message", "Bad format of Appkey");
            return objectNode;
        }
        if (StringUtils.isEmpty(username))
        {
            LOGGER.error("You must provided a targetUserName .");
            objectNode.put("message", "You must provided a targetUserName .");
            return objectNode;
        }
        try
        {
            URL userStatusUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + username + "/status");

            objectNode = HTTPClientUtils.sendHTTPRequest(userStatusUrl, credential, null, "GET");
            String userStatus = objectNode.get("data").path(username).asText();
            if ("online".equals(userStatus)) {
                LOGGER.error(String.format("The status of user[%s] is : [%s] .", new Object[] { username, userStatus }));
            } else if ("offline".equals(userStatus)) {
                LOGGER.error(String.format("The status of user[%s] is : [%s] .", new Object[] { username, userStatus }));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode sendMessages(String targetType, ArrayNode target, ObjectNode msg, String from, ObjectNode ext)
    {
        ObjectNode objectNode = factory.objectNode();

        ObjectNode dataNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }
        if ((!"users".equals(targetType)) && (!"chatgroups".equals(targetType)))
        {
            LOGGER.error("TargetType must be users or chatgroups .");

            objectNode.put("message", "TargetType must be users or chatgroups .");

            return objectNode;
        }
        try
        {
            dataNode.put("target_type", targetType);
            dataNode.put("target", target);
            dataNode.put("msg", msg);
            dataNode.put("from", from);
            dataNode.put("ext", ext);



            URL messageurl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/messages");
            String str = messageurl.toString();
            if (!str.contains("a1.easemob.com/"))
            {
                String url_1 = "/a1.easemob.com/" + str.substring(7);
                System.out.println(messageurl);
                messageurl = HTTPClientUtils.getURL(url_1);
            }
            System.out.println("111111:" + messageurl);

            objectNode = HTTPClientUtils.sendHTTPRequest(messageurl, credential, dataNode, "POST");


            objectNode = (ObjectNode)objectNode.get("data");
            for (int i = 0; i < target.size(); i++)
            {
                String resultStr = objectNode.path(target.path(i).asText()).asText();
                if ("success".equals(resultStr)) {
                    LOGGER.error(String.format("Message has been send to user[%s] successfully .", new Object[] {target.path(i)
                            .asText() }));
                } else if (!"success".equals(resultStr)) {
                    LOGGER.error(String.format("Message has been send to user[%s] failed .", new Object[] { target.path(i).asText() }));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }
}
