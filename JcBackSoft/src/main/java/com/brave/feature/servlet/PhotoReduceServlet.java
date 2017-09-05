package com.brave.feature.servlet;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
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
import sun.misc.BASE64Encoder;

@Scope("prototype")
public class PhotoReduceServlet
        extends HttpServlet
{
    private int outputWidth = 500;
    private int outputHeight = 500;
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
    {
        Map<String, Object> map = new HashMap();
        try
        {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html");
            String photo = req.getParameter("photo");
            String username = req.getParameter("username");
            String s = "0";
            String x = "0";

            byte[] decode = Base64.decode(photo);

            File file = new File(req.getSession().getServletContext().getRealPath("/image/" + username + ".jpg"));
            System.out.println("原图路径：" + file);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file);
            out.write(decode);
            out.flush();
            out.close();
            if (file.exists())
            {
                s = "1";

                String uploadPath = req.getSession().getServletContext().getRealPath("/image/" + username + ".jpg");

                String filePath = req.getSession().getServletContext().getRealPath("/reduceimage/" + username + ".jpg");
                UploadThread upload = new UploadThread(uploadPath, filePath);
                Thread thread = new Thread(upload);
                thread.start();
                try
                {
                    thread.join();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                File file_path = new File(filePath);
                if (file_path.exists()) {
                    x = "1";
                } else {
                    x = "0";
                }
                map.put("reduce", x);
            }
            else
            {
                s = "0";
            }
            Map resultMap = new HashMap();
            resultMap.put("data", s);
            JSONObject jsonObject = JSONObject.fromObject(resultMap);
            resp.getWriter().write(jsonObject.toString());
        }
        catch (Exception ie)
        {
            try
            {
                req.setCharacterEncoding("utf-8");
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html");
                ie.printStackTrace();
                Map<String, Object> resultMap = new HashMap();
                resultMap.put("error", ie.getMessage());
                JSONObject jsonObject = JSONObject.fromObject(resultMap);
                resp.getWriter().write(jsonObject.toString());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public boolean reduce(String uploadPath, String filePath)
    {
        String filePath_new = uploadPath;
        File f = new File(filePath_new);
        File newfile = new File(filePath);
        FileOutputStream out = null;
        boolean flag = true;
        try
        {
            Image img = ImageIO.read(f);

            double rate1 = img.getWidth(null) / this.outputWidth + 0.1D;

            double rate2 = img.getHeight(null) / this.outputHeight + 0.1D;


            double rate = rate1 > rate2 ? rate1 : rate2;
            int newwidth = (int)(img.getWidth(null) / rate);
            int newheigh = (int)(img.getHeight(null) / rate);
            BufferedImage tag = new BufferedImage(newwidth, newheigh, 1);

            tag.getGraphics().drawImage(img
                    .getScaledInstance(newwidth, newheigh, 4), 0, 0, null);
            if (!newfile.exists()) {
                newfile.createNewFile();
            }
            out = new FileOutputStream(newfile);


            String formatName = filePath_new.substring(filePath_new.lastIndexOf(".") + 1);
            ImageIO.write(tag, formatName, new File(filePath));



            tag.flush();
            out.flush();
            out.close();
            if (!newfile.exists()) {
                flag = false;
            }
            if (out != null) {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            f = new File(filePath_new);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            if (out != null) {
                try
                {
                    out.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        finally
        {
            if (out != null) {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static String call(String url, String param)
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);

            URLConnection conn = realUrl.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());

            out.print(param);

            out.flush();


            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result = result + line;
            }
            return result;
        }
        catch (Exception e)
        {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
            try
            {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        finally
        {
            try
            {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                return ex.getMessage();
            }
        }
        return "";
    }

    public static String GetImageStr(String imgFilePath)
    {
        byte[] data = (byte[])null;
        try
        {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
