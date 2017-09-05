/*   1:    */ package com.brave.feature.controller.homepage;
/*   2:    */ 
/*   3:    */ import com.brave.feature.service.FirsthandResourcesService;
/*   4:    */ import com.brave.feature.service.FriendService;
/*   5:    */ import com.brave.system.util.DistanceUtil;
/*   6:    */ import com.brave.system.util.PageUtil;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.text.SimpleDateFormat;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.Collection;
/*  11:    */ import java.util.Date;
/*  12:    */ import java.util.HashMap;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.Map;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.context.annotation.Scope;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  21:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ @Scope("prototype")
/*  25:    */ public class Select_firsthand_resources
/*  26:    */ {
/*  27: 38 */   private int pagesize = 10;
/*  28:    */   @Autowired
/*  29:    */   private FirsthandResourcesService service;
/*  30:    */   @Autowired
/*  31:    */   private FriendService friendService;
/*  32:    */   
/*  33:    */   @ResponseBody
/*  34:    */   @RequestMapping(value={"/select_firsthand_resources"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  35:    */   public Map<String, Object> select_supporters_type(HttpServletRequest req, HttpServletResponse resp)
/*  36:    */   {
/*  37: 48 */     Map<String, Object> map = new HashMap();
/*  38:    */     try
/*  39:    */     {
/*  40: 51 */       req.setCharacterEncoding("utf-8");
/*  41: 52 */       resp.setCharacterEncoding("utf-8");
/*  42: 53 */       int pageindex = Integer.parseInt(req.getParameter("pageindex"));
/*  43: 54 */       String latitude = req.getParameter("latitude");
/*  44: 55 */       String longitude = req.getParameter("longitude");
/*  45: 56 */       String region = req.getParameter("region");
/*  46: 57 */       if ("不限".equals(region)) {
/*  47: 58 */         region = "";
/*  48:    */       }
/*  49: 60 */       String username = req.getParameter("username");
/*  50: 61 */       String type = req.getParameter("type");
/*  51: 62 */       if ("不限".equals(type)) {
/*  52: 63 */         type = "";
/*  53:    */       }
/*  54: 66 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  55: 67 */       String now = df.format(new Date());
/*  56: 68 */       Map<String, Object> resourcesMap = new HashMap();
/*  57: 69 */       resourcesMap.put("Pageindex", PageUtil.getStartRow(pageindex, this.pagesize));
/*  58: 70 */       resourcesMap.put("Pagesize", Integer.valueOf(this.pagesize));
/*  59: 71 */       resourcesMap.put("Latitude", latitude);
/*  60: 72 */       resourcesMap.put("Longitude", longitude);
/*  61: 73 */       resourcesMap.put("Region", "%" + region + "%");
/*  62: 74 */       resourcesMap.put("Type", type);
/*  63: 75 */       resourcesMap.put("Now", now);
/*  64: 76 */       System.out.println("now:" + now);
/*  65: 77 */       System.out.println("0:" + System.currentTimeMillis());
/*  66: 78 */       List<Map<String, Object>> list = this.service.selectFirsthandResourcesList(resourcesMap);
/*  67: 79 */       System.out.println("listSize:" + list.size());
/*  68: 80 */       System.out.println("1:" + System.currentTimeMillis());
/*  69:    */       
/*  70: 82 */       List<Map<String, Object>> friendList = this.friendService.selectFriendByUsername(username);
/*  71: 83 */       Collection<String> friendCollection = new ArrayList();
/*  72: 84 */       for (int i = 0; i < friendList.size(); i++) {
/*  73: 85 */         friendCollection.add(((Map)friendList.get(i)).get("friendusername").toString());
/*  74:    */       }
/*  75: 87 */       System.out.println("2:" + System.currentTimeMillis());
/*  76: 88 */       for (int i = 0; i < list.size(); i++)
/*  77:    */       {
/*  78: 89 */         String str = ((Map)list.get(i)).get("juli").toString();
/*  79: 90 */         String distance = DistanceUtil.convertDistance(str);
/*  80: 91 */         System.out.println("distance:" + distance);
/*  81: 93 */         if (friendCollection.contains(((Map)list.get(i)).get("username").toString())) {
/*  82: 94 */           ((Map)list.get(i)).put("friendStatus", "1");
/*  83:    */         } else {
/*  84: 96 */           ((Map)list.get(i)).put("friendStatus", "0");
/*  85:    */         }
/*  86: 98 */         ((Map)list.get(i)).put("juli", distance);
/*  87:101 */         if (("0.0".equals(latitude)) || ("0.0".equals(longitude))) {
/*  88:102 */           ((Map)list.get(i)).put("juli", "您未定位");
/*  89:103 */         } else if (("0.0".equals(((Map)list.get(i)).get("longitude").toString())) || ("0.0".equals(((Map)list.get(i)).get("latitude").toString()))) {
/*  90:105 */           ((Map)list.get(i)).put("juli", " ");
/*  91:    */         }
/*  92:    */       }
/*  93:108 */       map.put("data", list);
/*  94:109 */       return map;
/*  95:    */     }
/*  96:    */     catch (Exception ex)
/*  97:    */     {
/*  98:112 */       ex.printStackTrace();
/*  99:113 */       map.put("error", ex.getMessage());
/* 100:    */     }
/* 101:114 */     return map;
/* 102:    */   }
/* 103:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.homepage.Select_firsthand_resources

 * JD-Core Version:    0.7.0.1

 */