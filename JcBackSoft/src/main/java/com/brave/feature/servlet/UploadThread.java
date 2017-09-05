package com.brave.feature.servlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

public class UploadThread
        implements Runnable
{
    private String sourceFilePath;
    private String goalFilePath;
    private int outputWidth = 500;
    private int outputHeight = 500;

    public UploadThread(String sourcePath, String goalPath)
    {
        this.goalFilePath = goalPath;
        this.sourceFilePath = sourcePath;
    }

    public void run()
    {
        try
        {
            String filePath_new = this.sourceFilePath;
            File f = new File(filePath_new);
            File newfile = new File(this.goalFilePath);
            FileOutputStream out = null;
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
                ImageIO.write(tag, formatName, new File(this.goalFilePath));



                tag.flush();
                out.flush();
                out.close();
                if (out != null) {
//                    try
//                    {
                        out.close();
//                    }
//                    catch (IOException e)
//                    {
//                        e.printStackTrace();
//                    }
                }
//                try
//                {
                    out.close();
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                if (out == null) {
                    return;
                }
//                try
//                {
                    out.close();
//                }
//                catch (IOException ex)
//                {
//                    ex.printStackTrace();
//                }
            }
            finally
            {
                if (out != null) {
//                    try
//                    {
                        out.close();
//                    }
//                    catch (IOException e)
//                    {
//                        e.printStackTrace();
//                    }
                }
            }
        }
        catch (Exception e)
        {
            FileOutputStream out;
            e.printStackTrace();
        }
    }

    public String getSourceFilePath()
    {
        return this.sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath)
    {
        this.sourceFilePath = sourceFilePath;
    }

    public String getGoalFilePath()
    {
        return this.goalFilePath;
    }

    public void setGoalFilePath(String goalFilePath)
    {
        this.goalFilePath = goalFilePath;
    }
}
