/*  1:   */ package com.brave.feature.controller.huanxin;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SendNoteServce;
/*  4:   */ import com.brave.feature.service.UserService;
/*  5:   */ import java.io.PrintStream;
/*  6:   */ import java.text.SimpleDateFormat;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.HashMap;
/*  9:   */ import java.util.List;
/* 10:   */ import java.util.Map;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 14:   */ import org.springframework.context.annotation.Scope;
/* 15:   */ import org.springframework.stereotype.Controller;
/* 16:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 17:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 18:   */ 
/* 19:   */ @Controller
/* 20:   */ @Scope("prototype")
/* 21:   */ public class SendNote
/* 22:   */ {
/* 23:   */   @Autowired
/* 24:   */   private SendNoteServce sendNoteServce;
/* 25:   */   @Autowired
/* 26:   */   private UserService userService;
/* 27:   */   
/* 28:   */   @ResponseBody
/* 29:   */   @RequestMapping(value={"/sendmessage_note"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 30:   */   public Map<String, Object> sendmessage(HttpServletRequest req, HttpServletResponse resp)
/* 31:   */   {
/* 32:39 */     Map<String, Object> map = new HashMap();
/* 33:   */     try
/* 34:   */     {
/* 35:42 */       req.setCharacterEncoding("utf-8");
/* 36:43 */       resp.setCharacterEncoding("utf-8");
/* 37:44 */       String phone = req.getParameter("phone");
/* 38:45 */       String name = req.getParameter("name");
/* 39:46 */       String message = "您的朋友" + name + "邀请您使用《金池金融汇》手机汇票软件。下载请点http://t.cn/RGBmvcd 回复TD退订";
/* 40:   */       
/* 41:48 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 42:49 */       String sendtime = df.format(new Date());
/* 43:50 */       Map<String, Object> userMap = new HashMap();
/* 44:51 */       Map<String, Object> noteMap = new HashMap();
/* 45:52 */       noteMap.put("Phone", phone);
/* 46:53 */       noteMap.put("Username", name);
/* 47:54 */       noteMap.put("Sendtime", sendtime);
/* 48:55 */       int i = 0;
/* 49:56 */       List<Map<String, Object>> list = this.sendNoteServce.selectSendNote(noteMap);
/* 50:57 */       if (list.size() < 1) {
/* 51:58 */         i = this.sendNoteServce.insertSendnote(noteMap);
/* 52:   */       }
/* 53:61 */       if (i > 0)
/* 54:   */       {
/* 55:62 */         String result = HttpSender.batchSend(phone, message);
/* 56:63 */         System.out.println("result:" + result);
/* 57:64 */         String[] arr = result.split(",");
/* 58:65 */         map.put("note", "1");
/* 59:66 */         if (arr[1].startsWith("0"))
/* 60:   */         {
/* 61:67 */           List list_rtn = this.userService.selectUserScoreByTrueName(name);
/* 62:68 */           int score = Integer.parseInt(((Map)list_rtn.get(0)).get("score").toString());
/* 63:69 */           score += 3;
/* 64:70 */           userMap.put("Score", Integer.valueOf(score));
/* 65:71 */           userMap.put("Trueusername", name);
/* 66:72 */           this.userService.updateUserinfoScoreByGroupTrueusername(userMap);
/* 67:73 */           map.put("data", "1");
/* 68:   */         }
/* 69:   */         else
/* 70:   */         {
/* 71:75 */           map.put("data", "0");
/* 72:   */         }
/* 73:   */       }
/* 74:   */       else
/* 75:   */       {
/* 76:78 */         map.put("note", "0");
/* 77:79 */         map.put("data", "0");
/* 78:   */       }
/* 79:81 */       return map;
/* 80:   */     }
/* 81:   */     catch (Exception ex)
/* 82:   */     {
/* 83:84 */       ex.printStackTrace();
/* 84:85 */       map.put("error", ex.getMessage());
/* 85:   */     }
/* 86:86 */     return map;
/* 87:   */   }
/* 88:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.huanxin.SendNote

 * JD-Core Version:    0.7.0.1

 */