package com.brave.feature.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.brave.Easemobutils.ClientSecretCredential;
import com.brave.Easemobutils.Credential;
import com.brave.Easemobutils.EndPoints;
import com.brave.Easemobutils.HTTPClientUtils;
import java.io.PrintStream;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasemobIMUsers
{
    public static final Logger LOGGER = LoggerFactory.getLogger(EasemobIMUsers.class);
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");

    public static void main(String[] args)
    {
        ObjectNode updatenicknameNode = select_block("15064035367");
        System.out.println(updatenicknameNode);
    }

    public static ObjectNode createNewIMUserSingle(ObjectNode dataNode)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        objectNode.removeAll();
        if ((null != dataNode) && (!dataNode.has("username")))
        {
            LOGGER.error("Property that named username must be provided .");

            objectNode.put("message", "Property that named username must be provided .");

            return objectNode;
        }
        if ((null != dataNode) && (!dataNode.has("password")))
        {
            LOGGER.error("Property that named password must be provided .");

            objectNode.put("message", "Property that named password must be provided .");

            return objectNode;
        }
        try
        {
            URL userurl = EndPoints.USERS_URL;
            String str = userurl.toString();
            if (!str.contains("a1.easemob.com/"))
            {
                String url = "/a1.easemob.com/" + str.substring(7);
                System.out.println(url);
                userurl = HTTPClientUtils.getURL(url);
            }
            objectNode = HTTPClientUtils.sendHTTPRequest(userurl, credential, dataNode, "POST");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode createNewIMUserBatch(ArrayNode dataArrayNode)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        if (dataArrayNode.isArray()) {
            for (JsonNode jsonNode : dataArrayNode)
            {
                if ((null != jsonNode) && (!jsonNode.has("username")))
                {
                    LOGGER.error("Property that named username must be provided .");

                    objectNode.put("message", "Property that named username must be provided .");

                    return objectNode;
                }
                if ((null != jsonNode) && (!jsonNode.has("password")))
                {
                    LOGGER.error("Property that named password must be provided .");

                    objectNode.put("message", "Property that named password must be provided .");

                    return objectNode;
                }
            }
        }
        try
        {
            objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, dataArrayNode, "POST");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode createNewIMUserBatchGen(String usernamePrefix, Long perNumber, Long totalNumber)
    {
        ObjectNode objectNode = factory.objectNode();
        if ((totalNumber.longValue() == 0L) || (perNumber.longValue() == 0L)) {
            return objectNode;
        }
        System.out.println("你即将注册" + totalNumber + "个用户，如果大于" + perNumber + "了,会分批注册,每次注册" + perNumber + "个");
        ArrayNode genericArrayNode = genericArrayNode(usernamePrefix, totalNumber);
        if (totalNumber.longValue() <= perNumber.longValue())
        {
            objectNode = createNewIMUserBatch(genericArrayNode);
        }
        else
        {
            ArrayNode tmpArrayNode = factory.arrayNode();
            for (int i = 0; i < genericArrayNode.size(); i++)
            {
                tmpArrayNode.add(genericArrayNode.get(i));
                if ((i + 1) % perNumber.longValue() == 0L)
                {
                    objectNode = createNewIMUserBatch(tmpArrayNode);
                    if (objectNode != null) {
                        LOGGER.info("注册IM用户[批量]: " + objectNode.toString());
                    }
                    tmpArrayNode.removeAll();
                }
                else if (i > genericArrayNode.size() / perNumber.longValue() * perNumber.longValue() - 1L)
                {
                    objectNode = createNewIMUserBatch(tmpArrayNode);
                    if (objectNode != null) {
                        LOGGER.info("注册IM用户[批量]: " + objectNode.toString());
                    }
                    tmpArrayNode.removeAll();
                }
            }
        }
        return objectNode;
    }

    public static ObjectNode getIMUsersByUserName(String userName)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        if (StringUtils.isEmpty(userName))
        {
            LOGGER.error("The userName that will be used to query must be provided .");

            objectNode.put("message", "The userName that will be used to query must be provided .");

            return objectNode;
        }
        try
        {
            URL userPrimaryUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + userName);
            objectNode = HTTPClientUtils.sendHTTPRequest(userPrimaryUrl, credential, null, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode deleteIMUserByuserName(String userName)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        try
        {
            URL deleteUserPrimaryUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + userName);

            objectNode = HTTPClientUtils.sendHTTPRequest(deleteUserPrimaryUrl, credential, null, "DELETE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode deleteIMUserByUsernameBatch(Long limit)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        try
        {
            URL deleteIMUserByUsernameBatchUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users" + "?limit=" + limit);

            objectNode = HTTPClientUtils.sendHTTPRequest(deleteIMUserByUsernameBatchUrl, credential, null, "DELETE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode modifyIMUserPasswordWithAdminToken(String userName, ObjectNode dataObjectNode)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        if (StringUtils.isEmpty(userName))
        {
            LOGGER.error("Property that named userName must be provided，the value is username of imuser.");

            objectNode.put("message", "Property that named userName must be provided，the value is username or imuser.");


            return objectNode;
        }
        if ((null != dataObjectNode) && (!dataObjectNode.has("newpassword")))
        {
            LOGGER.error("Property that named newpassword must be provided .");

            objectNode.put("message", "Property that named newpassword must be provided .");

            return objectNode;
        }
        try
        {
            URL modifyIMUserPasswordWithAdminTokenUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + userName + "/password");

            objectNode = HTTPClientUtils.sendHTTPRequest(modifyIMUserPasswordWithAdminTokenUrl, credential, dataObjectNode, "PUT");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode addFriendSingle(String ownerUserName, String friendUserName)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        if (StringUtils.isEmpty(ownerUserName))
        {
            LOGGER.error("Your userName must be provided，the value is username of imuser.");

            objectNode.put("message", "Your userName must be provided，the value is username of imuser.");

            return objectNode;
        }
        if (StringUtils.isEmpty(friendUserName))
        {
            LOGGER.error("The userName of friend must be provided，the value is username of imuser.");

            objectNode.put("message", "The userName of friend must be provided，the value is username of imuser.");


            return objectNode;
        }
        try
        {
            URL addFriendSingleUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + ownerUserName + "/contacts/users/" + friendUserName);


            ObjectNode body = factory.objectNode();
            objectNode = HTTPClientUtils.sendHTTPRequest(addFriendSingleUrl, credential, body, "POST");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode deleteFriendSingle(String ownerUserName, String friendUserName)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        if (StringUtils.isEmpty(ownerUserName))
        {
            LOGGER.error("Your userName must be provided，the value is username of imuser.");

            objectNode.put("message", "Your userName must be provided，the value is username of imuser.");

            return objectNode;
        }
        if (StringUtils.isEmpty(friendUserName))
        {
            LOGGER.error("The userName of friend must be provided，the value is username of imuser.");

            objectNode.put("message", "The userName of friend must be provided，the value is username of imuser.");


            return objectNode;
        }
        try
        {
            URL addFriendSingleUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + ownerUserName + "/contacts/users/" + friendUserName);


            ObjectNode body = factory.objectNode();
            objectNode = HTTPClientUtils.sendHTTPRequest(addFriendSingleUrl, credential, body, "DELETE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode getFriends(String ownerUserName)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Constants.APPKEY: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Constants.APPKEY");

            return objectNode;
        }
        if (StringUtils.isEmpty(ownerUserName))
        {
            LOGGER.error("Your userName must be provided，the value is username of imuser.");

            objectNode.put("message", "Your userName must be provided，the value is username of imuser.");

            return objectNode;
        }
        try
        {
            URL addFriendSingleUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + ownerUserName + "/contacts/users");


            ObjectNode body = factory.objectNode();
            objectNode = HTTPClientUtils.sendHTTPRequest(addFriendSingleUrl, credential, body, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode imUserLogin(String username, String password)
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
            LOGGER.error("Your username must be provided，the value is username of imuser.");

            objectNode.put("message", "Your username must be provided，the value is username of imuser.");

            return objectNode;
        }
        if (StringUtils.isEmpty(password))
        {
            LOGGER.error("Your password must be provided，the value is username of imuser.");

            objectNode.put("message", "Your password must be provided，the value is username of imuser.");

            return objectNode;
        }
        try
        {
            ObjectNode dataNode = factory.objectNode();
            dataNode.put("grant_type", "password");
            dataNode.put("username", username);
            dataNode.put("password", password);

            objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.TOKEN_APP_URL, null, dataNode, "POST");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Some errors occurred while fetching a token by username and password .");
        }
        return objectNode;
    }

    public static ObjectNode update_nickname(String username, String nickname)
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
            LOGGER.error("Your username must be provided，the value is username of imuser.");

            objectNode.put("message", "Your username must be provided，the value is username of imuser.");

            return objectNode;
        }
        if (StringUtils.isEmpty(nickname))
        {
            LOGGER.error("Your nickname must be provided，the value is username of imuser.");

            objectNode.put("message", "Your nickname must be provided，the value is username of imuser.");

            return objectNode;
        }
        try
        {
            ObjectNode body = factory.objectNode();
            body.put("nickname", nickname);
            URL userurl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + username);
            String str = userurl.toString();
            if (!str.contains("a1.easemob.com/"))
            {
                String url = "/a1.easemob.com/" + str.substring(7);
                System.out.println(url);
                userurl = HTTPClientUtils.getURL(url);
            }
            objectNode = HTTPClientUtils.sendHTTPRequest(userurl, credential, body, "PUT");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Some errors occurred while fetching a token by username and password .");
        }
        return objectNode;
    }

    public static ObjectNode select_block(String username)
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
            LOGGER.error("Your username must be provided，the value is username of imuser.");

            objectNode.put("message", "Your username must be provided，the value is username of imuser.");

            return objectNode;
        }
        try
        {
            ObjectNode body = factory.objectNode();
            URL userurl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + username + "/blocks/users");
            String str = userurl.toString();
            if (!str.contains("a1.easemob.com/"))
            {
                String url = "/a1.easemob.com/" + str.substring(7);
                System.out.println(url);
                userurl = HTTPClientUtils.getURL(url);
            }
            objectNode = HTTPClientUtils.sendHTTPRequest(userurl, credential, body, "GET");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Some errors occurred while fetching a token by username and password .");
        }
        return objectNode;
    }

    public static ArrayNode genericArrayNode(String usernamePrefix, Long number)
    {
        ArrayNode arrayNode = factory.arrayNode();
        for (int i = 0; i < number.longValue(); i++)
        {
            ObjectNode userNode = factory.objectNode();
            userNode.put("username", usernamePrefix + "_" + i);
            userNode.put("password", "password");
            arrayNode.add(userNode);
        }
        return arrayNode;
    }
}
