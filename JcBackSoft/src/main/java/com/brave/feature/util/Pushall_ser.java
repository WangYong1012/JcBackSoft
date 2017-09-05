package com.brave.feature.util;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushBatchUniMsgResponse;
import java.io.PrintStream;
import java.util.List;

public class Pushall_ser
{
    public void push_ser(List<String> listchannel, String title, String neirong)
    {
        PushKeyPair pair = new PushKeyPair("464whmY3zWqeHxfmjV2WQ26umd4fC36n", "PpvQHmYtodbkGla08qbDSXoBbseRbVS9");

        BaiduPushClient pushClient = new BaiduPushClient(pair, "api.tuisong.baidu.com");


        pushClient.setChannelLogHandler(new YunLogHandler()
        {
            public void onHandle(YunLogEvent event)
            {
                System.out.println(event.getMessage());
            }
        });
        try
        {
            String[] channelIds = new String[listchannel.size()];
            for (int i = 0; i < listchannel.size(); i++) {
                channelIds[i] = ((String)listchannel.get(i));
            }
            PushBatchUniMsgRequest request = new PushBatchUniMsgRequest().addChannelIds(channelIds).addMsgExpires(new Integer(3600)).addMessageType(Integer.valueOf(1)).addMessage("{\"title\":\"" + title + "\",\"description\":\"" + neirong + "\"}").addDeviceType(Integer.valueOf(3)).addTopicId("BaiduPush");



            PushBatchUniMsgResponse response = pushClient.pushBatchUniMsg(request);

            System.out.println(String.format("msgId: %s, sendTime: %d", new Object[] {response
                    .getMsgId(), Long.valueOf(response.getSendTime()) }));
        }
        catch (PushClientException e)
        {
            e.printStackTrace();
        }
        catch (PushServerException e)
        {
            System.out.println(String.format("requestId: %d, errorCode: %d, errorMsg: %s", new Object[] {
                    Long.valueOf(e
                            .getRequestId()), Integer.valueOf(e.getErrorCode()), e
                    .getErrorMsg() }));
        }
    }
}
