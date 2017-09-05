/*   1:    */ package com.brave.system.util;
/*   2:    */ 
/*   3:    */ import java.io.ByteArrayOutputStream;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.OutputStreamWriter;
/*   6:    */ import java.io.PrintWriter;
/*   7:    */ import javax.servlet.ServletOutputStream;
/*   8:    */ import javax.servlet.http.HttpServletResponse;
/*   9:    */ import javax.servlet.http.HttpServletResponseWrapper;
/*  10:    */ 
/*  11:    */ public class GZipWrapUtil
/*  12:    */   extends HttpServletResponseWrapper
/*  13:    */ {
/*  14:    */   public static final int OUT_NONE = 0;
/*  15:    */   public static final int OUT_WRITER = 1;
/*  16:    */   public static final int OUT_STREAM = 2;
/*  17: 23 */   private int outputType = 0;
/*  18: 25 */   private ServletOutputStream output = null;
/*  19: 27 */   private PrintWriter writer = null;
/*  20: 29 */   private ByteArrayOutputStream buffer = null;
/*  21:    */   
/*  22:    */   public GZipWrapUtil(HttpServletResponse response)
/*  23:    */   {
/*  24: 33 */     super(response);
/*  25:    */     
/*  26: 35 */     this.buffer = new ByteArrayOutputStream();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public PrintWriter getWriter()
/*  30:    */     throws IOException
/*  31:    */   {
/*  32: 44 */     if (this.outputType == 2) {
/*  33: 46 */       throw new IllegalStateException();
/*  34:    */     }
/*  35: 47 */     if (this.outputType == 1) {
/*  36: 49 */       return this.writer;
/*  37:    */     }
/*  38: 52 */     this.outputType = 1;
/*  39:    */     
/*  40: 54 */     this.writer = new PrintWriter(new OutputStreamWriter(this.buffer, getCharacterEncoding()));
/*  41: 55 */     return this.writer;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public ServletOutputStream getOutputStream()
/*  45:    */     throws IOException
/*  46:    */   {
/*  47: 61 */     if (this.outputType == 1) {
/*  48: 63 */       throw new IllegalStateException();
/*  49:    */     }
/*  50: 64 */     if (this.outputType == 2) {
/*  51: 66 */       return this.output;
/*  52:    */     }
/*  53: 69 */     this.outputType = 2;
/*  54: 70 */     this.output = new DatasWrappedOutputStream(this.buffer);
/*  55: 71 */     return this.output;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void flushBuffer()
/*  59:    */     throws IOException
/*  60:    */   {
/*  61: 77 */     if (this.outputType == 1) {
/*  62: 78 */       this.writer.flush();
/*  63:    */     }
/*  64: 79 */     if (this.outputType == 2) {
/*  65: 80 */       this.output.flush();
/*  66:    */     }
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void reset()
/*  70:    */   {
/*  71: 85 */     this.outputType = 0;
/*  72: 86 */     this.buffer.reset();
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void finalize()
/*  76:    */     throws Throwable
/*  77:    */   {
/*  78: 91 */     super.finalize();
/*  79: 92 */     this.output.close();
/*  80: 93 */     this.writer.close();
/*  81:    */   }
/*  82:    */   
/*  83:    */   public byte[] getResponseData()
/*  84:    */     throws IOException
/*  85:    */   {
/*  86: 98 */     flushBuffer();
/*  87: 99 */     return this.buffer.toByteArray();
/*  88:    */   }
/*  89:    */   
/*  90:    */   class DatasWrappedOutputStream
/*  91:    */     extends ServletOutputStream
/*  92:    */   {
/*  93:    */     private ByteArrayOutputStream buffer;
/*  94:    */     
/*  95:    */     public DatasWrappedOutputStream(ByteArrayOutputStream buffer)
/*  96:    */     {
/*  97:108 */       this.buffer = buffer;
/*  98:    */     }
/*  99:    */     
/* 100:    */     public void write(int b)
/* 101:    */       throws IOException
/* 102:    */     {
/* 103:113 */       this.buffer.write(b);
/* 104:    */     }
/* 105:    */     
/* 106:    */     public byte[] toByteArray()
/* 107:    */     {
/* 108:118 */       return this.buffer.toByteArray();
/* 109:    */     }
/* 110:    */   }
/* 111:    */ }



/* Location:           E:\金池需要的启动文件\ROOT\WEB-INF\classes\

 * Qualified Name:     com.jcsoft.system.util.GZipWrapUtil

 * JD-Core Version:    0.7.0.1

 */