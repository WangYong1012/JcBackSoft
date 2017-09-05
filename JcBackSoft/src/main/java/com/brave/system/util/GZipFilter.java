/*   1:    */ package com.brave.system.util;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.util.zip.GZIPOutputStream;
/*   5:    */ import javax.servlet.Filter;
/*   6:    */ import javax.servlet.FilterChain;
/*   7:    */ import javax.servlet.FilterConfig;
/*   8:    */ import javax.servlet.ServletException;
/*   9:    */ import javax.servlet.ServletOutputStream;
/*  10:    */ import javax.servlet.ServletRequest;
/*  11:    */ import javax.servlet.ServletResponse;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.apache.commons.io.output.ByteArrayOutputStream;
/*  15:    */ import org.apache.commons.lang.StringUtils;
/*  16:    */ import org.slf4j.Logger;
/*  17:    */ import org.slf4j.LoggerFactory;
/*  18:    */ 
/*  19:    */ public class GZipFilter
/*  20:    */   implements Filter
/*  21:    */ {
/*  22: 29 */   private static Logger logger = LoggerFactory.getLogger(GZipFilter.class);
/*  23:    */   private static final String INCLUDE_SUFFIXS_NAME = "includeSuffixs";
/*  24: 31 */   private static final String[] DEFAULT_INCLUDE_SUFFIXS = { ".js", ".css", ".jpg", ".gif" };
/*  25: 33 */   private static String[] includeSuffixs = null;
/*  26:    */   
/*  27:    */   public void destroy() {}
/*  28:    */   
/*  29:    */   public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
/*  30:    */     throws IOException, ServletException
/*  31:    */   {
/*  32: 47 */     logger.info("Data For Gzip compression start....... ");
/*  33: 48 */     if (shouldNotFilter((HttpServletRequest)servletrequest))
/*  34:    */     {
/*  35: 50 */       HttpServletResponse resp = (HttpServletResponse)servletresponse;
/*  36: 51 */       GZipWrapUtil wrapper = new GZipWrapUtil(resp);
/*  37: 52 */       filterchain.doFilter(servletrequest, wrapper);
/*  38: 53 */       byte[] gzipData = gzip(wrapper.getResponseData());
/*  39: 54 */       resp.addHeader("Content-Encoding", "gzip");
/*  40: 55 */       resp.setContentLength(gzipData.length);
/*  41: 56 */       ServletOutputStream output = servletresponse.getOutputStream();
/*  42: 57 */       output.write(gzipData);
/*  43: 58 */       output.flush();
/*  44: 59 */       logger.info("Data For Gzip compression end....... ");
/*  45:    */     }
/*  46:    */     else
/*  47:    */     {
/*  48: 62 */       filterchain.doFilter(servletrequest, servletresponse);
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void init(FilterConfig filterconfig)
/*  53:    */     throws ServletException
/*  54:    */   {
/*  55: 72 */     String includeSuffixStr = filterconfig.getInitParameter("includeSuffixs");
/*  56: 73 */     if (StringUtils.isNotBlank(includeSuffixStr))
/*  57:    */     {
/*  58: 75 */       includeSuffixs = includeSuffixStr.split(",");
/*  59: 77 */       for (int i = 0; i < includeSuffixs.length; i++) {
/*  60: 79 */         includeSuffixs[i] = ("." + includeSuffixs[i]);
/*  61:    */       }
/*  62:    */     }
/*  63:    */     else
/*  64:    */     {
/*  65: 83 */       includeSuffixs = DEFAULT_INCLUDE_SUFFIXS;
/*  66:    */     }
/*  67:    */   }
/*  68:    */   
/*  69:    */   private byte[] gzip(byte[] data)
/*  70:    */   {
/*  71: 95 */     ByteArrayOutputStream byteOutput = new ByteArrayOutputStream(10240);
/*  72: 96 */     GZIPOutputStream output = null;
/*  73:    */     try
/*  74:    */     {
/*  75: 99 */       output = new GZIPOutputStream(byteOutput);
/*  76:100 */       output.write(data);
/*  77:    */       
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:112 */       return byteOutput.toByteArray();
/*  89:    */     }
/*  90:    */     catch (IOException localIOException1) {}finally
/*  91:    */     {
/*  92:    */       try
/*  93:    */       {
/*  94:107 */         output.close();
/*  95:    */       }
/*  96:    */       catch (IOException localIOException3) {}
/*  97:    */     }
                    return null;
/*  98:    */   }
/*  99:    */   
/* 100:    */   protected boolean shouldNotFilter(HttpServletRequest request)
/* 101:    */     throws ServletException
/* 102:    */   {
/* 103:118 */     String path = request.getServletPath();
/* 104:119 */     boolean isCompression = false;
/* 105:120 */     for (String suffix : includeSuffixs) {
/* 106:122 */       if (path.endsWith(suffix))
/* 107:    */       {
/* 108:124 */         isCompression = true;
/* 109:125 */         break;
/* 110:    */       }
/* 111:    */     }
/* 112:128 */     return isCompression;
/* 113:    */   }
/* 114:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.GZipFilter

 * JD-Core Version:    0.7.0.1

 */