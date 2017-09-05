package com.brave.feature.util;

import com.fasterxml.jackson.databind.JsonNode;
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

public class EasemobChatGroups
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EasemobChatGroups.class);
    private static Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");

    public static void main(String[] args)
    {
        String chatgroupid = "1449017209351";
        ObjectNode getAllMemberssByGroupIdNode = getAllMemberssByGroupId(chatgroupid);
        System.out.println(getAllMemberssByGroupIdNode.toString());
    }

    private static JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final String APPKEY = "shandongjinchi#jinchijinronghui";

    public static ObjectNode getAllChatgroupids()
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
            objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.CHATGROUPS_URL, credential, null, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode getGroupDetailsByChatgroupid(String chatgroupIDs)
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
            URL groupDetailsByChatgroupidUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups/" + chatgroupIDs);

            objectNode = HTTPClientUtils.sendHTTPRequest(groupDetailsByChatgroupidUrl, credential, null, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode creatChatGroups(ObjectNode dataObjectNode)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");
            objectNode.put("message", "Bad format of Appkey");
            return objectNode;
        }
        if (!dataObjectNode.has("groupname"))
        {
            LOGGER.error("Property that named groupname must be provided .");
            objectNode.put("message", "Property that named groupname must be provided .");
            return objectNode;
        }
        if (!dataObjectNode.has("desc"))
        {
            LOGGER.error("Property that named desc must be provided .");
            objectNode.put("message", "Property that named desc must be provided .");
            return objectNode;
        }
        if (!dataObjectNode.has("public"))
        {
            LOGGER.error("Property that named public must be provided .");
            objectNode.put("message", "Property that named public must be provided .");
            return objectNode;
        }
        if (!dataObjectNode.has("approval"))
        {
            LOGGER.error("Property that named approval must be provided .");
            objectNode.put("message", "Property that named approval must be provided .");
            return objectNode;
        }
        if (!dataObjectNode.has("owner"))
        {
            LOGGER.error("Property that named owner must be provided .");
            objectNode.put("message", "Property that named owner must be provided .");
            return objectNode;
        }
        if ((!dataObjectNode.has("members")) || (!dataObjectNode.path("members").isArray()))
        {
            LOGGER.error("Property that named members must be provided .");
            objectNode.put("message", "Property that named members must be provided .");
            return objectNode;
        }
        try
        {
            objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.CHATGROUPS_URL, credential, dataObjectNode, "POST");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode deleteChatGroups(String chatgroupid)
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
            URL deleteChatGroupsUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups/" + chatgroupid);

            objectNode = HTTPClientUtils.sendHTTPRequest(deleteChatGroupsUrl, credential, null, "DELETE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode getAllMemberssByGroupId(String chatgroupid)
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
            URL allMemberssByGroupIdUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups/" + chatgroupid + "/users");

            objectNode = HTTPClientUtils.sendHTTPRequest(allMemberssByGroupIdUrl, credential, null, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode addUserToGroup(String chatgroupid, String userName)
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
            URL allMemberssByGroupIdUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups/" + chatgroupid + "/users/" + userName);

            ObjectNode dataobjectNode = factory.objectNode();
            objectNode = HTTPClientUtils.sendHTTPRequest(allMemberssByGroupIdUrl, credential, dataobjectNode, "POST");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode deleteUserFromGroup(String chatgroupid, String userName)
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
            URL allMemberssByGroupIdUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups/" + chatgroupid + "/users/" + userName);

            objectNode = HTTPClientUtils.sendHTTPRequest(allMemberssByGroupIdUrl, credential, null, "DELETE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    private static ObjectNode getJoinedChatgroupsForIMUser(String username)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");
            objectNode.put("message", "Bad format of Appkey");
            return objectNode;
        }
        if (StringUtils.isBlank(username.trim()))
        {
            LOGGER.error("Property that named username must be provided .");
            objectNode.put("message", "Property that named username must be provided .");
            return objectNode;
        }
        try
        {
            URL getJoinedChatgroupsForIMUserUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + username + "/joined_chatgroups");

            objectNode = HTTPClientUtils.sendHTTPRequest(getJoinedChatgroupsForIMUserUrl, credential, null, "GET");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    private static ObjectNode addUsersToGroupBatch(String toAddBacthChatgroupid, ObjectNode usernames)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");
            objectNode.put("message", "Bad format of Appkey");
            return objectNode;
        }
        if (StringUtils.isBlank(toAddBacthChatgroupid.trim()))
        {
            LOGGER.error("Property that named toAddBacthChatgroupid must be provided .");
            objectNode.put("message", "Property that named toAddBacthChatgroupid must be provided .");
            return objectNode;
        }
        if ((null != usernames) && (!usernames.has("usernames")))
        {
            LOGGER.error("Property that named usernames must be provided .");
            objectNode.put("message", "Property that named usernames must be provided .");
            return objectNode;
        }
        try
        {
            URL getJoinedChatgroupsForIMUserUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatgroups/" + toAddBacthChatgroupid + "/users");

            objectNode = HTTPClientUtils.sendHTTPRequest(getJoinedChatgroupsForIMUserUrl, credential, usernames, "POST");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }
}
