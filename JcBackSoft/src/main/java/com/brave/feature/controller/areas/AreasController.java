/*  1:   */ package com.brave.feature.controller.areas;
/*  2:   */ 
/*  3:   */ import com.brave.feature.entity.JcAreas;
/*  4:   */ import com.brave.feature.entity.JcAreasExample;
/*  5:   */ import com.brave.feature.entity.JcAreasExample.Criteria;
/*  6:   */ import com.brave.feature.service.AreaService;
/*  7:   */ import java.io.PrintStream;
/*  8:   */ import java.util.ArrayList;
/*  9:   */ import java.util.Arrays;
/* 10:   */ import java.util.HashMap;
/* 11:   */ import java.util.List;
/* 12:   */ import java.util.Map;
/* 13:   */ import javax.servlet.http.HttpServletRequest;
/* 14:   */ import javax.servlet.http.HttpServletResponse;
/* 15:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 16:   */ import org.springframework.context.annotation.Scope;
/* 17:   */ import org.springframework.stereotype.Controller;
/* 18:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 19:   */ import org.springframework.web.servlet.ModelAndView;
/* 20:   */ 
/* 21:   */ @Controller
/* 22:   */ @Scope("prototype")
/* 23:   */ public class AreasController
/* 24:   */ {
/* 25:   */   @Autowired
/* 26:   */   private AreaService areaService;
/* 27:   */   
/* 28:   */   @RequestMapping(value={"/getAllAreas"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 29:   */   public ModelAndView getAllAreas(HttpServletRequest request, HttpServletResponse response)
/* 30:   */   {
/* 31:31 */     ModelAndView model = new ModelAndView();
/* 32:32 */     Map<String, Object> resultMap = new HashMap();
/* 33:33 */     List<Map<String, Object>> resultList = new ArrayList();
/* 34:   */     try
/* 35:   */     {
/* 36:36 */       JcAreasExample example = new JcAreasExample();
/* 37:37 */       JcAreasExample.Criteria criteria = example.createCriteria();
/* 38:   */       
/* 39:39 */       criteria.andAreapidEqualTo("0");
/* 40:40 */       example.setOrderByClause("id asc");
/* 41:   */       
/* 42:42 */       List<JcAreas> areasList = this.areaService.selectByExample(example);
/* 43:44 */       for (JcAreas jcArea : areasList)
/* 44:   */       {
/* 45:46 */         Map<String, Object> map = new HashMap();
/* 46:47 */         map.put("province", jcArea.getAreaname());
/* 47:   */         
/* 48:   */ 
/* 49:   */ 
/* 50:   */ 
/* 51:   */ 
/* 52:53 */         String cities = this.areaService.selectCityByProvinceId(jcArea.getAreaid());
/* 53:54 */         System.out.println(cities);
/* 54:55 */         if ((null != cities) && (cities.contains(",")))
/* 55:   */         {
/* 56:57 */           String[] city = cities.split(",");
/* 57:58 */           map.put("city", Arrays.asList(city));
/* 58:   */         }
/* 59:   */         else
/* 60:   */         {
/* 61:61 */           map.put("city", Arrays.asList(new String[] { jcArea.getAreaname() }));
/* 62:   */         }
/* 63:63 */         resultList.add(map);
/* 64:   */       }
/* 65:65 */       resultMap.put("data", resultList);
/* 66:66 */       model.addAllObjects(resultMap);
/* 67:67 */       return model;
/* 68:   */     }
/* 69:   */     catch (Exception ex)
/* 70:   */     {
/* 71:70 */       ex.printStackTrace();
/* 72:71 */       resultMap.put("error", ex.getMessage());
/* 73:72 */       model.addAllObjects(resultMap);
/* 74:   */     }
/* 75:73 */     return model;
/* 76:   */   }
/* 77:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.areas.AreasController

 * JD-Core Version:    0.7.0.1

 */