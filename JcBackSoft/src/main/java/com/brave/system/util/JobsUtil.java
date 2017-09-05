/*  1:   */ package com.brave.system.util;
/*  2:   */ 
/*  3:   */ import com.brave.feature.mapper.userinfo.UserinfoMapper;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.List;
/*  6:   */ import java.util.Map;
/*  7:   */ import javax.annotation.Resource;
/*  8:   */ import org.apache.ibatis.session.SqlSession;
/*  9:   */ import org.slf4j.Logger;
/* 10:   */ import org.slf4j.LoggerFactory;
/* 11:   */ import org.springframework.stereotype.Component;
/* 12:   */ 
/* 13:   */ @Component
/* 14:   */ public class JobsUtil
/* 15:   */ {
/* 16:   */   private UserinfoMapper writeMapper;
/* 17:   */   private UserinfoMapper readMapper;
/* 18:   */   
/* 19:   */   @Resource(name="sqlSessionMaster")
/* 20:   */   public void setWriteMapper(SqlSession sqlSession)
/* 21:   */   {
/* 22:24 */     this.writeMapper = ((UserinfoMapper)sqlSession.getMapper(UserinfoMapper.class));
/* 23:   */   }
/* 24:   */   
/* 25:   */   @Resource(name="sqlSessionSlave")
/* 26:   */   public void setReadMapper(SqlSession sqlSession)
/* 27:   */   {
/* 28:29 */     this.readMapper = ((UserinfoMapper)sqlSession.getMapper(UserinfoMapper.class));
/* 29:   */   }
/* 30:   */   
/* 31:32 */   private static final Logger log = LoggerFactory.getLogger(JobsUtil.class);
/* 32:   */   
/* 33:   */   public void doResetDays()
/* 34:   */   {
/* 35:   */     try
/* 36:   */     {
/* 37:38 */       log.error("开始清空连续活跃天数..");
/* 38:39 */       List<Map<String, Object>> SignLiST = this.readMapper.selectSignLiST();
/* 39:41 */       if ((null != SignLiST) && (0 < SignLiST.size()))
/* 40:   */       {
/* 41:43 */         Map<String, Object> param = new HashMap();
/* 42:44 */         param.put("Days", Integer.valueOf(1));
/* 43:45 */         for (int slen = 0; slen < SignLiST.size(); slen++)
/* 44:   */         {
/* 45:47 */           Map<String, Object> useMap = (Map)SignLiST.get(slen);
/* 46:48 */           param.put("Username", useMap.get("username"));
/* 47:49 */           this.writeMapper.updateUserinfoDays(param);
/* 48:   */         }
/* 49:   */       }
/* 50:53 */       log.error("清空连续活跃天数完成..");
/* 51:   */     }
/* 52:   */     catch (Exception e)
/* 53:   */     {
/* 54:56 */       log.error("执行定时任务出现异常.", e);
/* 55:   */     }
/* 56:   */   }
/* 57:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.JobsUtil

 * JD-Core Version:    0.7.0.1

 */