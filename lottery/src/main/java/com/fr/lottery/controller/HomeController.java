package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.Member;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IMemberService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.CookieUtils;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.UserHelper;
import freemarker.ext.beans.HashAdapter;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/home")
public class HomeController  {
    @Autowired
    private IUserService userService;

    @Autowired
    private IMemberService memberService;

    @Autowired
    private ILimitSetService limitSetService;

    @RequestMapping("/index")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");
        User user= UserHelper.getCurrentUser();
        Member member = memberService.get(user.getId());
        Map<String,Object> map = new HashedMap();
        Map<String,Object> userInfo=new HashedMap();
        userInfo.put("memberId",member.getId());
        userInfo.put("credit",member.getCredits());
        userInfo.put("name",member.getName());
        userInfo.put("account",member.getAccount());
        userInfo.put("sum",0);
        userInfo.put("odds_set","B");
        userInfo.put("status",1);

        map.put("user_info",userInfo);
        List<LimitSet> limitSets = limitSetService.findAll("member",member.getId());

        Map<String,List<Integer>>listMap = new HashedMap();
        for(LimitSet set : limitSets){
            listMap.put(set.getLimitType(),Arrays.asList(set.getSinglemin(),set.getSinglemax(),set.getSinglehighest()));
        }
        map.put("limit",listMap);
        mv.addObject("info", JsonUtil.toJson( map));
        return mv;
    }
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultInfo<String> doLogin(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd){

        ResultInfo<String> result = new ResultInfo<String>();
        try{
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            Member user=  memberService.getByAccount(userAccount);
            if(user !=null && md5_pwd.equals( user.getPassword())){
                result.setSuccess(true);
                UserHelper.setCurrentUser(request,user);
            }
            else{
                result.setSuccess(false);
                result.setMsg("账号或者密码不正确！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
        }
        return result;
    }

    /**
     * 获取主题方案
     */
    @RequestMapping(value = "/theme/{theme}")
    public String getThemeInCookie(@PathVariable String theme, HttpServletRequest request, HttpServletResponse response){
        if (StringUtils.isNotBlank(theme)){
            CookieUtils.setCookie(response, "theme", theme);
        }else{
            theme = CookieUtils.getCookie(request, "theme");
        }
        return "redirect:"+request.getParameter("url");
    }
}
