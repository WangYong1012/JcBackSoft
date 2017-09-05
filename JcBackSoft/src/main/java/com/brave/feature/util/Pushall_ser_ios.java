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
import net.sf.json.JSONObject;

public class Pushall_ser_ios
{
    public void pushall_ser_ios(String listchannel, String title, String s)
    {
        PushKeyPair pair = new PushKeyPair("Yr39xPKduwumu8asguweIgM0", "DNyoctfFwwZweuOPKGWwIs26DG9YQsUm");


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
            JSONObject js = new JSONObject();
            JSONObject js2 = new JSONObject();
            js.put("alert", title);
            js.put("sound", s);
            js.put("badge", "1");
            js2.put("aps", js);
            js2.put("key1", "key1");
            js2.put("key2", "key2");
            PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(listchannel).addMsgExpires(new Integer(3600)).addMessageType(Integer.valueOf(1)).addMessage(js2.toString()).addDeployStatus(Integer.valueOf(2)).addDeviceType(Integer.valueOf(4));
            PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);

            System.out.println(String.format("msgId: %s, sendTime: %d", new Object[] {response
                    .getMsgId(), Long.valueOf(response.getSendTime()) }));
        }
        catch (PushClientException e)
        {
            e.printStackTrace();
        }
        catch (PushServerException ex)
        {
            System.out.println(String.format("requestId: %d, errorCode: %d, errorMsg: %s", new Object[] {
                    Long.valueOf(ex
                            .getRequestId()), Integer.valueOf(ex.getErrorCode()), ex
                    .getErrorMsg() }));
        }
    }
}
