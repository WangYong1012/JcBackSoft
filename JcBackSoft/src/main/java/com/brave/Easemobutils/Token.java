package com.brave.Easemobutils;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;

public class Token
{
    private String accessToken;
    private Long expiredAt;

    public Token() {}

    public Token(String accessToken, Long expiredAt)
    {
        this.accessToken = accessToken;
        this.expiredAt = expiredAt;
    }

    public static void applyAuthentication(HttpEntityEnclosingRequestBase httpMethodEntity, Credential credentail)
    {
        applyAuthentication(httpMethodEntity, credentail.getToken());
    }

    public static void applyAuthentication(HttpEntityEnclosingRequestBase httpMethodEntity, Token token)
    {
        httpMethodEntity.addHeader("Authorization", "Bearer " + token.toString());
    }

    public static void applyAuthentication(HttpRequestBase httpMethodEntity, Credential credentail)
    {
        applyAuthentication(httpMethodEntity, credentail.getToken());
    }

    public static void applyAuthentication(HttpRequestBase httpMethodEntity, Token token)
    {
        httpMethodEntity.addHeader("Authorization", "Bearer " + token.toString());
    }

    public boolean isExpired()
    {
        return System.currentTimeMillis() > this.expiredAt.longValue();
    }

    public String toString()
    {
        return this.accessToken;
    }

    public int hashCode()
    {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.accessToken == null ? 0 : this.accessToken.hashCode());
        result = 31 * result + (this.expiredAt == null ? 0 : this.expiredAt.hashCode());
        return result;
    }

    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Token other = (Token)obj;
        if (this.accessToken == null)
        {
            if (other.accessToken != null) {
                return false;
            }
        }
        else if (!this.accessToken.equals(other.accessToken)) {
            return false;
        }
        if (this.expiredAt == null)
        {
            if (other.expiredAt != null) {
                return false;
            }
        }
        else if (!this.expiredAt.equals(other.expiredAt)) {
            return false;
        }
        return true;
    }
}
