/*  1:   */ package com.brave.feature.controller.userinfo;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SystemService;
/*  4:   */ import java.util.List;
/*  5:   */ import java.util.Map;
/*  6:   */ import net.sf.json.JSONObject;
/*  7:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  8:   */ import org.springframework.context.annotation.Scope;
/*  9:   */ import org.springframework.stereotype.Controller;
/* 10:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 11:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 12:   */ 
/* 13:   */ @Controller
/* 14:   */ @Scope("prototype")
/* 15:   */ public class Get_version
/* 16:   */ {
/* 17:   */   @Autowired
/* 18:   */   private SystemService systemService;
/* 19:   */   
/* 20:   */   @RequestMapping(value={"/get_version"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 21:   */   @ResponseBody
/* 22:   */   public String get_version()
/* 23:   */   {
/* 24:33 */     List<Map<String, Object>> list_rtn = this.systemService.selectSystem();
/* 25:34 */     JSONObject object = JSONObject.fromObject(list_rtn.get(0));
/* 26:   */     
/* 27:36 */     return object.toString();
/* 28:   */   }
/* 29:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.userinfo.Get_version

 * JD-Core Version:    0.7.0.1

 */