/*  1:   */ package com.brave.system.controller;
/*  2:   */ 
/*  3:   */ import javax.servlet.http.HttpServletRequest;
/*  4:   */ import javax.servlet.http.HttpServletResponse;
/*  5:   */ import org.springframework.context.annotation.Scope;
/*  6:   */ import org.springframework.stereotype.Controller;
/*  7:   */ import org.springframework.web.bind.annotation.RequestMapping;
/*  8:   */ 
/*  9:   */ @Controller
/* 10:   */ @RequestMapping({"/system"})
/* 11:   */ @Scope("prototype")
/* 12:   */ public class LoginController
/* 13:   */ {
/* 14:   */   @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 15:   */   public String login(HttpServletRequest request, HttpServletResponse response)
/* 16:   */   {
/* 17:34 */     return "login";
/* 18:   */   }
/* 19:   */   
/* 20:   */   @RequestMapping(value={"/logout"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 21:   */   public String logout(HttpServletRequest request, HttpServletResponse response)
/* 22:   */   {
/* 23:42 */     return "redirect:login";
/* 24:   */   }
/* 25:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.controller.LoginController

 * JD-Core Version:    0.7.0.1

 */