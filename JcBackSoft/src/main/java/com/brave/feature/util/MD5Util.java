package com.brave.feature.util;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5Util
{
    private static String byteArrayToHexString(byte[] b)
    {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b)
    {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname)
    {
        String resultString = null;
        try
        {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if ((charsetname == null) || ("".equals(charsetname))) {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
        }
        catch (Exception localException) {}
        return resultString;
    }

    public static String md5(String data)
    {
        try
        {
            byte[] md5 = md5(data.getBytes("utf-8"));
            return toHexString(md5);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public static byte[] md5(byte[] data)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(data);
            return md.digest();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static String toHexString(byte[] md5)
    {
        StringBuilder buf = new StringBuilder();
        for (byte b : md5) {
            buf.append(leftPad(Integer.toHexString(b & 0xFF), '0', 2));
        }
        return buf.toString();
    }

    public static String leftPad(String hex, char c, int size)
    {
        char[] cs = new char[size];
        Arrays.fill(cs, c);
        System.arraycopy(hex.toCharArray(), 0, cs, cs.length - hex
                .length(), hex.length());
        return new String(cs);
    }

    private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static void main(String[] args)
    {
        String pwd = "024833";
        String pwd_new = md5(pwd);
        System.out.println("1111:" + pwd_new);
    }
}
