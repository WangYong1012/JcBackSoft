/*  1:   */ package com.brave.security.controller;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.util.Collection;
/*  5:   */ import javax.servlet.ServletException;
/*  6:   */ import javax.servlet.http.HttpServletRequest;
/*  7:   */ import javax.servlet.http.HttpServletResponse;
/*  8:   */ import javax.servlet.http.HttpSession;
/*  9:   */ import org.apache.commons.logging.Log;
/* 10:   */ import org.apache.commons.logging.LogFactory;
/* 11:   */ import org.springframework.security.core.Authentication;
/* 12:   */ import org.springframework.security.core.GrantedAuthority;
/* 13:   */ import org.springframework.security.web.DefaultRedirectStrategy;
/* 14:   */ import org.springframework.security.web.RedirectStrategy;
/* 15:   */ import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/* 16:   */ import org.springframework.stereotype.Component;
/* 17:   */ 
/* 18:   */ @Component("simpleSuccessHandler")
/* 19:   */ public class SimpleAuthenticationSuccessHandler
/* 20:   */   implements AuthenticationSuccessHandler
/* 21:   */ {
/* 22:34 */   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
/* 23:36 */   protected Log logger = LogFactory.getLog(getClass());
/* 24:   */   
/* 25:   */   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
/* 26:   */     throws IOException, ServletException
/* 27:   */   {
/* 28:42 */     handle(request, response, authentication);
/* 29:43 */     clearAuthenticationAttributes(request);
/* 30:   */   }
/* 31:   */   
/* 32:   */   protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
/* 33:   */     throws IOException
/* 34:   */   {
/* 35:49 */     String targetUrl = determineTargetUrl(authentication);
/* 36:50 */     if (response.isCommitted())
/* 37:   */     {
/* 38:51 */       this.logger.debug("错误信息:Response has already been committed. Unable to redirect to " + targetUrl);
/* 39:   */       
/* 40:53 */       return;
/* 41:   */     }
/* 42:55 */     this.redirectStrategy.sendRedirect(request, response, targetUrl);
/* 43:   */   }
/* 44:   */   
/* 45:   */   protected String determineTargetUrl(Authentication authentication)
/* 46:   */   {
/* 47:60 */     boolean isUser = false;
/* 48:   */     
/* 49:62 */     Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
/* 50:63 */     for (GrantedAuthority grantedAuthority : authorities) {
/* 51:64 */       if (grantedAuthority.getAuthority().equals("ROLE_ADMIN"))
/* 52:   */       {
/* 53:65 */         isUser = true;
/* 54:66 */         break;
/* 55:   */       }
/* 56:   */     }
/* 57:69 */     if (isUser) {
/* 58:70 */       return "/system/main/index.html";
/* 59:   */     }
/* 60:72 */     this.logger.error("security错误信息:");
/* 61:73 */     throw new IllegalStateException();
/* 62:   */   }
/* 63:   */   
/* 64:   */   protected void clearAuthenticationAttributes(HttpServletRequest request)
/* 65:   */   {
/* 66:78 */     HttpSession session = request.getSession(false);
/* 67:79 */     if (session == null) {
/* 68:80 */       return;
/* 69:   */     }
/* 70:82 */     session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setRedirectStrategy(RedirectStrategy redirectStrategy)
/* 74:   */   {
/* 75:86 */     this.redirectStrategy = redirectStrategy;
/* 76:   */   }
/* 77:   */   
/* 78:   */   protected RedirectStrategy getRedirectStrategy()
/* 79:   */   {
/* 80:90 */     return this.redirectStrategy;
/* 81:   */   }
/* 82:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.security.controller.SimpleAuthenticationSuccessHandler

 * JD-Core Version:    0.7.0.1

 */