package com.brave.feature.util;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import java.io.PrintStream;

public class Push_ser
{
    public void push_ser(String channelId, String title, String neirong)
    {
        PushKeyPair pair = new PushKeyPair("iGxLHtoI52McAXvWp3pNXcoz", "CrXXXaXfT0QnQ3kLn0xzBe5HCGXARN86");

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
            PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(channelId).addMsgExpires(new Integer(3600)).addMessageType(Integer.valueOf(1)).addMessage("{\"title\":\"" + title + "\",\"description\":\"" + neirong + "\"}").addDeviceType(Integer.valueOf(3));



            PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);

            System.out.println("msgId: " + response.getMsgId() + ",sendTime:" + response
                    .getSendTime());
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
