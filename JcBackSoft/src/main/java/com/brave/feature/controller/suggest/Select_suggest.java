/*  1:   */ package com.brave.feature.controller.suggest;
/*  2:   */ 
/*  3:   */ import com.brave.feature.service.SuggestService;
/*  4:   */ import java.io.UnsupportedEncodingException;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Map;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.context.annotation.Scope;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 15:   */ import org.springframework.web.servlet.ModelAndView;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ @Scope("prototype")
/* 19:   */ public class Select_suggest
/* 20:   */ {
/* 21:   */   @Autowired
/* 22:   */   private SuggestService suggestService;
/* 23:   */   
/* 24:   */   @ResponseBody
/* 25:   */   @RequestMapping(value={"/select_suggest"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 26:   */   public ModelAndView select_suggest(HttpServletRequest req, HttpServletResponse resp)
/* 27:   */     throws UnsupportedEncodingException
/* 28:   */   {
/* 29:38 */     req.setCharacterEncoding("utf-8");
/* 30:39 */     resp.setCharacterEncoding("utf-8");
/* 31:40 */     List<Map<String, Object>> list = this.suggestService.selectSuggest();
/* 32:   */     
/* 33:42 */     ModelAndView modelView = new ModelAndView();
/* 34:43 */     Map<String, Object> map = new HashMap();
/* 35:44 */     map.put("data", list);
/* 36:45 */     modelView.addAllObjects(map);
/* 37:46 */     return modelView;
/* 38:   */   }
/* 39:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.suggest.Select_suggest

 * JD-Core Version:    0.7.0.1

 */