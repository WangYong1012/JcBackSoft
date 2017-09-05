package com.brave.Easemobutils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientSecretCredential
        extends Credential
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSecretCredential.class);
    private static URL CLIENTSECRETCREDENTAIL_TOKEN_URL = null;

    protected URL getUrl()
    {
        return CLIENTSECRETCREDENTAIL_TOKEN_URL;
    }

    public ClientSecretCredential(String clientID, String clientSecret, String role)
    {
        super(clientID, clientSecret);
        if (role.equals("appAdmin"))
        {
            CLIENTSECRETCREDENTAIL_TOKEN_URL = EndPoints.TOKEN_APP_URL;
            System.out.println(CLIENTSECRETCREDENTAIL_TOKEN_URL);
        }
    }

    protected Credential.GrantType getGrantType()
    {
        return Credential.GrantType.CLIENT_CREDENTIALS;
    }

    public Token getToken()
    {
        if ((null == this.token) || (this.token.isExpired())) {
            try
            {
                ObjectNode objectNode = this.factory.objectNode();
                objectNode.put("grant_type", "client_credentials");
                objectNode.put("client_id", this.tokenKey1);
                objectNode.put("client_secret", this.tokenKey2);
                List<NameValuePair> headers = new ArrayList();
                headers.add(new BasicNameValuePair("Content-Type", "application/json"));
                System.out.println(objectNode);
                HttpPost httpPost = new HttpPost();

                int i = 7;
                String str = CLIENTSECRETCREDENTAIL_TOKEN_URL.toString();
                String url;
                if (!str.contains("a1.easemob.com/"))
                {
                    url = "/a1.easemob.com/" + str.substring(i);
                    System.out.println(url);
                    CLIENTSECRETCREDENTAIL_TOKEN_URL = HTTPClientUtils.getURL(url);
                }
                System.out.println(CLIENTSECRETCREDENTAIL_TOKEN_URL);
                httpPost.setURI(CLIENTSECRETCREDENTAIL_TOKEN_URL.toURI());
                for (NameValuePair nameValuePair : headers) {
                    httpPost.addHeader(nameValuePair.getName(), nameValuePair.getValue());
                }
                httpPost.setEntity(new StringEntity(objectNode.toString(), "UTF-8"));

                HttpResponse tokenResponse = this.client.execute(httpPost);
                HttpEntity entity = tokenResponse.getEntity();

                String results = EntityUtils.toString(entity, "UTF-8");

                LOGGER.info("-----------------------------返回结果-------------------------------statuscode:" + tokenResponse
                        .getStatusLine().toString());
                if (tokenResponse.getStatusLine().getStatusCode() == 200)
                {
                    ObjectMapper mapper = new ObjectMapper();

                    JsonFactory factory = mapper.getJsonFactory();
                    JsonParser jp = factory.createJsonParser(results);
                    JsonNode json = (JsonNode)mapper.readTree(jp);

                    String accessToken = json.get("access_token").asText();
                    Long expiredAt = Long.valueOf(System.currentTimeMillis() + json.get("expires_in").asLong() * 1000L);

                    this.token = new Token(accessToken, expiredAt);
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException("Some errors occurred while fetching a token by username and password .");
            }
        }
        return this.token;
    }
}