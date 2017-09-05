package com.brave.feature.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.brave.Easemobutils.ClientSecretCredential;
import com.brave.Easemobutils.Credential;
import com.brave.Easemobutils.EndPoints;
import com.brave.Easemobutils.HTTPClientUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasemobFiles
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EasemobFiles.class);
    private static final String APPKEY = "shandongjinchi#jinchijinronghui";
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");

    public static void main(String[] args)
    {
        File uploadImgFile = new File("/home/lynch/Pictures/24849.jpg");
        ObjectNode imgDataNode = mediaUpload(uploadImgFile);
        if (null != imgDataNode) {
            LOGGER.info("上传图片文件: " + imgDataNode.toString());
        }
        try
        {
            Thread.sleep(1000L);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String imgFileUUID = imgDataNode.path("entities").get(0).path("uuid").asText();
        String shareSecret = imgDataNode.path("entities").get(0).path("share-secret").asText();
        File downloadedImgFileLocalPath = new File(uploadImgFile.getPath().substring(0, uploadImgFile.getPath().lastIndexOf(".")) + "-1.jpg");
        boolean isThumbnail = false;
        ObjectNode downloadImgDataNode = mediaDownload(imgFileUUID, shareSecret, downloadedImgFileLocalPath, Boolean.valueOf(isThumbnail));
        if (null != downloadImgDataNode) {
            LOGGER.info("下载图片文件: " + downloadImgDataNode.toString());
        }
        try
        {
            Thread.sleep(1000L);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        File downloadedLocalPathThumnailImg = new File(uploadImgFile.getPath().substring(0, uploadImgFile.getPath().lastIndexOf(".")) + "-2.jpg");
        isThumbnail = true;
        ObjectNode downloadThumnailImgDataNode = mediaDownload(imgFileUUID, shareSecret, downloadedLocalPathThumnailImg, Boolean.valueOf(isThumbnail));
        if (null != downloadThumnailImgDataNode) {
            LOGGER.info("下载缩略图: " + downloadThumnailImgDataNode.toString());
        }
        File uploadAudioFile = new File("/home/lynch/Music/music.MP3");
        ObjectNode audioDataNode = mediaUpload(uploadAudioFile);
        if (null != audioDataNode) {
            LOGGER.info("上传语音文件: " + audioDataNode.toString());
        }
        try
        {
            Thread.sleep(1000L);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String audioFileUUID = audioDataNode.path("entities").get(0).path("uuid").asText();
        String audioFileShareSecret = audioDataNode.path("entities").get(0).path("share-secret").asText();
        File audioFileLocalPath = new File(uploadAudioFile.getPath().substring(0, uploadAudioFile.getPath().lastIndexOf(".")) + "-1.MP3");
        ObjectNode downloadAudioDataNode = mediaDownload(audioFileUUID, audioFileShareSecret, audioFileLocalPath, null);
        if (null != downloadAudioDataNode) {
            LOGGER.info("下载语音文件: " + downloadAudioDataNode.toString());
        }
    }

    public static ObjectNode mediaUpload(File uploadFile)
    {
        ObjectNode objectNode = factory.objectNode();
        if (!uploadFile.exists())
        {
            LOGGER.error("file: " + uploadFile.toString() + " is not exist!");

            objectNode.put("message", "File or directory not found");

            return objectNode;
        }
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }
        try
        {
            List<NameValuePair> headers = new ArrayList();
            headers.add(new BasicNameValuePair("restrict-access", "true"));

            objectNode = HTTPClientUtils.uploadFile(EndPoints.CHATFILES_URL, uploadFile, credential, headers);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return objectNode;
    }

    public static ObjectNode mediaDownload(String fileUUID, String shareSecret, File localPath, Boolean isThumbnail)
    {
        ObjectNode objectNode = factory.objectNode();

        File downLoadedFile = null;
        if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", "shandongjinchi#jinchijinronghui"))
        {
            LOGGER.error("Bad format of Appkey: shandongjinchi#jinchijinronghui");

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }
        try
        {
            List<NameValuePair> headers = new ArrayList();
            if (!StringUtils.isEmpty(shareSecret)) {
                headers.add(new BasicNameValuePair("share-secret", shareSecret));
            }
            headers.add(new BasicNameValuePair("Accept", "application/octet-stream"));
            if ((isThumbnail != null) && (isThumbnail.booleanValue())) {
                headers.add(new BasicNameValuePair("thumbnail", String.valueOf(isThumbnail)));
            }
            URL mediaDownloadUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/chatfiles/" + fileUUID);
            downLoadedFile = HTTPClientUtils.downLoadFile(mediaDownloadUrl, credential, headers, localPath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        LOGGER.error("File download successfully，file path : " + downLoadedFile.getAbsolutePath() + ".");

        objectNode.put("message", "File download successfully .");

        return objectNode;
    }
}
