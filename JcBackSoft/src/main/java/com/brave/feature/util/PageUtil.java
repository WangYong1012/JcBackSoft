package com.brave.feature.util;

public class PageUtil
{
    public static String setTotalPageCountByRs(String pageindex, int pagesize)
    {
        int pageCount = 0;
        int count = Integer.parseInt(pageindex);
        if ((pagesize > 0) && (count > 0) && (count % pagesize == 0)) {
            pageCount = count / pagesize;
        } else if ((pagesize > 0) && (count > 0) && (count % pagesize > 0)) {
            pageCount = count / pagesize + 1;
        } else {
            pageCount = 0;
        }
        return pageCount + "";
    }

    public static Integer getStartRow(int index, int pagesize)
    {
        return Integer.valueOf((index - 1) * pagesize);
    }

    public String getEndRow(String index, int pagesize)
    {
        return Integer.parseInt(index) * pagesize + "";
    }
}
