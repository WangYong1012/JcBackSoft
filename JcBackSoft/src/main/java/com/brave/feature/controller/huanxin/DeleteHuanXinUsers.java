/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.fasterxml.jackson.databind.node.JsonNodeFactory;
/*  4:   */ import com.fasterxml.jackson.databind.node.ObjectNode;
/*  5:   */ import com.brave.Easemobutils.ClientSecretCredential;
/*  6:   */ import com.brave.Easemobutils.Credential;
/*  7:   */ import com.brave.Easemobutils.HTTPClientUtils;
/*  8:   */ import com.brave.feature.util.EasemobChatMessage;
/*  9:   */ import com.brave.system.entity.UserInfo;
/* 10:   */ import com.brave.system.entity.UserInfoExample;
/* 11:   */ import com.brave.system.entity.UserInfoExample.Criteria;
/* 12:   */ import com.brave.system.service.IUserInfoService;
/* 13:   */ import java.io.PrintStream;
/* 14:   */ import java.net.URL;
/* 15:   */ import java.util.HashMap;
/* 16:   */ import java.util.List;
/* 17:   */ import java.util.Map;
/* 18:   */ import javax.servlet.http.HttpServletRequest;
/* 19:   */ import javax.servlet.http.HttpServletResponse;
/* 20:   */ import org.slf4j.Logger;
/* 21:   */ import org.slf4j.LoggerFactory;
/* 22:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 23:   */ import org.springframework.context.annotation.Scope;
/* 24:   */ import org.springframework.stereotype.Controller;
/* 25:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 26:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 27:   */ import org.springframework.web.servlet.ModelAndView;
/* 28:   */ 
/* 29:   */ @Controller
/* 30:   */ @Scope("prototype")
/* 31:   */ public class DeleteHuanXinUsers
/* 32:   */ {
/* 33:37 */   private static final Logger LOGGER = LoggerFactory.getLogger(EasemobChatMessage.class);
/* 34:38 */   private static final JsonNodeFactory factory = new JsonNodeFactory(false);
/* 35:   */   private static final String APPKEY = "shandongjinchi#jinchijinronghui";
/* 36:42 */   private static Credential credential = new ClientSecretCredential("YXA6VPsUMIdcEeWjjCdRi_Yu8g", "YXA6xBcknIfd_2eVXHWxm0UtC-kmFig", "appAdmin");
/* 37:   */   @Autowired
/* 38:   */   private IUserInfoService userService;
/* 39:   */   
/* 40:   */   @ResponseBody
/* 41:   */   @RequestMapping(value={"/deleteHuanXinUsers"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 42:   */   public Map<String, Object> deleteHuanXinUsers(HttpServletRequest request, HttpServletResponse response)
/* 43:   */   {
/* 44:52 */     Map<String, Object> resultMap = new HashMap();
/* 45:53 */     ModelAndView model = new ModelAndView();
/* 46:   */     try
/* 47:   */     {
/* 48:56 */       ObjectNode objectNode = factory.objectNode();
/* 49:   */       
/* 50:58 */       UserInfoExample example = new UserInfoExample();
/* 51:59 */       UserInfoExample.Criteria criteria = example.createCriteria();
/* 52:   */       
/* 53:61 */       List<UserInfo> userInfoList = this.userService.selectByExample(example);
/* 54:   */       
/* 55:63 */       int i = 0;
/* 56:64 */       for (UserInfo userInfo : userInfoList)
/* 57:   */       {
/* 58:70 */         URL chatMessagesUrl = HTTPClientUtils.getURL("shandongjinchi#jinchijinronghui".replace("#", "/") + "/users/" + userInfo.getUsername());
/* 59:71 */         objectNode = HTTPClientUtils.sendHTTPRequest(chatMessagesUrl, credential, null, "DELETE");
/* 60:72 */         System.out.println(objectNode);
/* 61:73 */         i++;
/* 62:   */       }
/* 63:75 */       return resultMap;
/* 64:   */     }
/* 65:   */     catch (Exception ex)
/* 66:   */     {
/* 67:78 */       ex.printStackTrace();
/* 68:79 */       resultMap.put("error", ex.getMessage());
/* 69:   */     }
/* 70:80 */     return resultMap;
/* 71:   */   }
/* 72:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.DeleteHuanXinUsers

 * JD-Core Version:    0.7.0.1

 */