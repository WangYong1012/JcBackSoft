package com.brave.feature.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class PhotoReceiveServlet
        extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PhotoReceiveServlet.class);

    public void init()
            throws ServletException
    {
        super.init();
    }

    public void destroy()
    {
        super.destroy();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        super.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String result = "0";
        try
        {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");

            String photoObject = req.getParameter("photo");
            String username = req.getParameter("username");
            System.out.println("photo:" + photoObject + ":username:" + username);

            byte[] decodeStream = Base64.getDecoder().decode(photoObject);
            StringBuilder pathBuild = new StringBuilder();
            pathBuild.append("/image/").append(username).append(".jpg");

            File outPutFile = new File(req.getSession().getServletContext().getRealPath(pathBuild.toString()));
            OutputStream os = new FileOutputStream(outPutFile);
            os.write(decodeStream);
            if (!outPutFile.exists()) {
                outPutFile.createNewFile();
            }
            if (outPutFile.exists()) {
                result = "1";
            }
        }
        catch (IOException ie)
        {
            log.error("上传图片IO出现异常..", ie);

            ie.printStackTrace();
        }
        catch (Exception ex)
        {
            log.error("上传图片解码过程出现异常..", ex);
            ex.printStackTrace();
        }
        try
        {
            Map resultMap = new HashMap();
            resultMap.put("data", result);
            System.out.println("resultMap:" + resultMap);

            JSONObject jsonObject = JSONObject.fromObject(resultMap);
            resp.getWriter().write(jsonObject.toString());
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
            log.error("上传图片完成后返回值出现异常..", ie);
        }
    }
}
