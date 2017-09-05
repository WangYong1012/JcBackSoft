/*  1:   */ package com.brave.system.controller;
/*  2:   */ 
/*  3:   */ import org.springframework.context.annotation.Scope;
/*  4:   */ import org.springframework.stereotype.Controller;
/*  5:   */ import org.springframework.web.bind.annotation.RequestMapping;
/*  6:   */ 
/*  7:   */ @Controller
/*  8:   */ @Scope("prototype")
/*  9:   */ @RequestMapping({"/system/image"})
/* 10:   */ public class ImageController
/* 11:   */ {
/* 12:   */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 13:   */   public String index()
/* 14:   */   {
/* 15:   */     try
/* 16:   */     {
/* 17:26 */       return "system/image/index";
/* 18:   */     }
/* 19:   */     catch (Exception ex)
/* 20:   */     {
/* 21:29 */       ex.printStackTrace();
/* 22:   */     }
/* 23:30 */     return "system/image/index";
/* 24:   */   }
/* 25:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.ImageController

 * JD-Core Version:    0.7.0.1

 */