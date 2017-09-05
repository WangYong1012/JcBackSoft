/*  1:   */ package com.brave.feature.controller.company;
/*  2:   */ 
/*  3:   */ import com.brave.feature.entity.JcAreas;
/*  4:   */ import com.brave.feature.entity.JcAreasExample;
/*  5:   */ import com.brave.feature.entity.JcAreasExample.Criteria;
/*  6:   */ import com.brave.feature.service.AreaService;
/*  7:   */ import com.brave.feature.service.CompanyService;
/*  8:   */ import java.io.PrintStream;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.Arrays;
/* 11:   */ import java.util.HashMap;
/* 12:   */ import java.util.List;
/* 13:   */ import java.util.Map;
/* 14:   */ import javax.servlet.http.HttpServletRequest;
/* 15:   */ import javax.servlet.http.HttpServletResponse;
/* 16:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 17:   */ import org.springframework.stereotype.Controller;
/* 18:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 19:   */ import org.springframework.web.bind.annotation.ResponseBody;
/* 20:   */ import org.springframework.web.servlet.ModelAndView;
/* 21:   */ 
/* 22:   */ @Controller
/* 23:   */ public class Select_company_city
/* 24:   */ {
/* 25:   */   @Autowired
/* 26:   */   private CompanyService companyService;
/* 27:   */   @Autowired
/* 28:   */   private AreaService areaService;
/* 29:   */   
/* 30:   */   @ResponseBody
/* 31:   */   @RequestMapping(value={"/Select_company_city"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 32:   */   public ModelAndView select_company_city(HttpServletRequest req, HttpServletResponse resp)
/* 33:   */   {
/* 34:44 */     ModelAndView model = new ModelAndView();
/* 35:45 */     Map<String, Object> resultMap = new HashMap();
/* 36:46 */     List<Map<String, Object>> resultList = new ArrayList();
/* 37:   */     try
/* 38:   */     {
/* 39:49 */       JcAreasExample example = new JcAreasExample();
/* 40:50 */       JcAreasExample.Criteria criteria = example.createCriteria();
/* 41:   */       
/* 42:52 */       criteria.andAreapidEqualTo("0");
/* 43:53 */       example.setOrderByClause("id asc ");
/* 44:   */       
/* 45:55 */       List<JcAreas> areasList = this.areaService.selectByExample(example);
/* 46:57 */       for (JcAreas jcArea : areasList)
/* 47:   */       {
/* 48:59 */         Map<String, Object> map = new HashMap();
/* 49:60 */         map.put("province", jcArea.getAreaname());
/* 50:   */         
/* 51:62 */         String cities = this.areaService.selectCityByProvinceId(jcArea.getAreaid());
/* 52:63 */         System.out.println(cities);
/* 53:64 */         if ((null != cities) && (cities.contains(",")))
/* 54:   */         {
/* 55:66 */           String[] city = cities.split(",");
/* 56:67 */           map.put("city", Arrays.asList(city));
/* 57:   */         }
/* 58:   */         else
/* 59:   */         {
/* 60:70 */           map.put("city", Arrays.asList(new String[] { jcArea.getAreaname() }));
/* 61:   */         }
/* 62:72 */         resultList.add(map);
/* 63:   */       }
/* 64:74 */       resultMap.put("data", resultList);
/* 65:75 */       model.addAllObjects(resultMap);
/* 66:76 */       return model;
/* 67:   */     }
/* 68:   */     catch (Exception ex)
/* 69:   */     {
/* 70:79 */       ex.printStackTrace();
/* 71:80 */       resultMap.put("error", ex.getMessage());
/* 72:81 */       model.addAllObjects(resultMap);
/* 73:   */     }
/* 74:82 */     return model;
/* 75:   */   }
/* 76:   */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.feature.controller.company.Select_company_city

 * JD-Core Version:    0.7.0.1

 */