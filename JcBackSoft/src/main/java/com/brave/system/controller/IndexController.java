/*  1:   */ package com.brave.system.controller;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import org.springframework.context.annotation.Scope;
/*  5:   */ import org.springframework.stereotype.Controller;
/*  6:   */ import org.springframework.web.bind.annotation.RequestMapping;
/*  7:   */ 
/*  8:   */ @RequestMapping({"/system/main"})
/*  9:   */ @Controller
/* 10:   */ @Scope("prototype")
/* 11:   */ public class IndexController
/* 12:   */ {
/* 13:   */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 14:   */   public String index()
/* 15:   */   {
/* 16:24 */     System.out.println("main - index - controller -->");
/* 17:   */     
/* 18:26 */     return "system/index";
/* 19:   */   }
/* 20:   */   
/* 21:   */   @RequestMapping(value={"/query"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 22:   */   public String query()
/* 23:   */   {
/* 24:32 */     System.out.println("main - index - controller -->");
/* 25:   */     
/* 26:34 */     return "system/query";
/* 27:   */   }
/* 28:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.IndexController

 * JD-Core Version:    0.7.0.1

 */