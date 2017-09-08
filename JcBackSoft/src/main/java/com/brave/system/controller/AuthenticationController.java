package com.brave.system.controller;

import com.brave.feature.entity.JcAuthentication;
import com.brave.feature.service.AuthenticationService;
import com.brave.system.entity.UserInfo;
import com.brave.system.entity.UserInfoExample;
import com.brave.system.service.IUserInfoService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping({"/system/authentication"})
@Controller
@Scope("prototype")
public class AuthenticationController
{
    
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private IUserInfoService userInfoService;
    
    @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "system/authentication/index";
    }

    @RequestMapping(value={"/chechStatus"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public void checkStatus(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, Object> resultMap = new HashMap();
        try
        {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            resultMap.put("resultMsg", "已经存在该条信息.");
            resultMap.put("resultCode", "FAIL");
            response.getWriter().print("FAIL");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @ResponseBody
    @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public void saveAuthentication(String username, String beginDate, String endDate, String region, String type, String payType)
    {
        try
        {
            Calendar calendar = Calendar.getInstance();
            calendar.add(2, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat format = DateFormat.getDateInstance();
            JcAuthentication jcAuthentication = new JcAuthentication();
            jcAuthentication.setUsername(username);
            Date date = new Date();
            jcAuthentication.setStartdate(format.parse(sdf.format(date)));
            jcAuthentication.setDuedate(calendar.getTime());
            jcAuthentication.setPaytype(payType);
            jcAuthentication.setRegion(region);
            jcAuthentication.setType(type);
            jcAuthentication.setId(null);
            this.authenticationService.insertSelective(jcAuthentication);
            UserInfoExample example = new UserInfoExample();
            UserInfoExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            UserInfo userInfo = new UserInfo();
            userInfo.setAuthenticationstatus("1");
            this.userInfoService.updateByExampleSelective(userInfo, example);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}