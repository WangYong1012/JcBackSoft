/*  1:   */ package com.brave.feature.controller.supporter;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.CollectService;
/*  4:   */ import com.brave.feature.service.SupporterService;
/*  5:   */ import com.brave.feature.service.UserService;
/*  6:   */ import java.util.HashMap;
/*  7:   */ import java.util.List;
/*  8:   */ import java.util.Map;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.context.annotation.Scope;
/* 13:   */ import org.springframework.stereotype.Controller;
/* 14:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 15:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @Scope("prototype")
/* 19:   */ public class Delete_supporters_id
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private UserService userService;
/* 23:   */   @Autowired
/* 24:   */   private CollectService collectService;
/* 25:   */   @Autowired
/* 26:   */   private SupporterService supporterService;
/* 27:   */   
/* 28:   */   @ResponseBody
/* 29:   */   @RequestMapping(value={"/delete_supporters_id"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 30:   */   public Map<String, Object> delete_supporters_id(HttpServletRequest req, HttpServletResponse resp)
/* 31:   */   {
/* 32:44 */     Map<String, Object> map = new HashMap();
/* 33:   */     try
/* 34:   */     {
/* 35:47 */       req.setCharacterEncoding("utf-8");
/* 36:48 */       resp.setCharacterEncoding("utf-8");
/* 37:49 */       String id = req.getParameter("ID");
/* 38:50 */       String localname = req.getParameter("username");
/* 39:   */       
/* 40:52 */       List<Map<String, Object>> list = this.userService.selectUserStateByusername(localname);
/* 41:53 */       String state = ((Map)list.get(0)).get("state").toString();
/* 42:54 */       int i = 0;
/* 43:55 */       int j = 0;
/* 44:56 */       if ("1".equals(state))
/* 45:   */       {
/* 46:57 */         Map<String, Object> supportersMap = new HashMap();
/* 47:58 */         supportersMap.put("SupportersId", id);
/* 48:59 */         i = this.supporterService.deleteSupportersById(supportersMap);
/* 49:60 */         j = this.collectService.deleteCollectById(supportersMap);
/* 50:   */       }
/* 51:62 */       map.put("data", i + "");
/* 52:63 */       map.put("collect", j + "");
/* 53:64 */       return map;
/* 54:   */     }
/* 55:   */     catch (Exception ex)
/* 56:   */     {
/* 57:67 */       ex.printStackTrace();
/* 58:68 */       map.put("error", ex.getMessage());
/* 59:   */     }
/* 60:69 */     return map;
/* 61:   */   }
/* 62:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.supporter.Delete_supporters_id

 * JD-Core Version:    0.7.0.1

 */