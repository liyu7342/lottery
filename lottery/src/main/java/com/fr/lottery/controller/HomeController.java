package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Member;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IMemberService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.CookieUtils;
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

    @RequestMapping("/index")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");
        User user= UserHelper.getCurrentUser();
        Member member = memberService.get(user.getId());
        Map<String,Object> map = new HashedMap();
        Map<String,Object> userInfo=new HashedMap();
        userInfo.put("memberId",member.getId());
        userInfo.put("credits",member.getCredits());
        userInfo.put("name",member.getName());
        userInfo.put("account",member.getAccount());
        userInfo.put("sum",0);
        userInfo.put("odds_set","B");
        userInfo.put("status",1);
        Map<String,Object> limitMap= new HashedMap();
        Map<String,List<Integer>>  listMap = new HashedMap();
        listMap.put("00", Arrays.asList(member.gettSinglemin(),member.gettSinglemax(),member.gettSinglehighest()));//特码
        listMap.put("01", Arrays.asList(member.getZSinglemin(),member.getBbSinglemax(),member.getBbSinglehighest()));//正码
        listMap.put("02", Arrays.asList(member.getzSinglemin(),member.getzSinglemax(),member.getzSinglehighest()));//连码二
        listMap.put("03", Arrays.asList(member.getZtSinglemin(),member.getZtSinglemax(),member.getZtSinglehighest()));//连码三
        listMap.put("04", Arrays.asList(member.getLmSinglemin(),member.gettSinglemax(),member.gettSinglehighest()));//过关
        listMap.put("05", Arrays.asList(member.getLmSinglemin(),member.getLmSinglemax(),member.getLmSinglehighest()));//生肖
        listMap.put("06", Arrays.asList(member.getGgSinglemin(),member.getGgSinglemax(),member.getGgSinglehighest()));//尾数
        listMap.put("07", Arrays.asList(member.getSxlSinglemin(),member.getSxlSinglemax(),member.getSxlSinglehighest()));//半波
        listMap.put("08", Arrays.asList(member.getWslSinglemin(),member.getWslSinglemax(),member.getWslSinglehighest()));//六肖
        listMap.put("09", Arrays.asList(member.getBbSinglemin(),member.getBbSinglemax(),member.getBbSinglehighest()));//两面
        listMap.put("10", Arrays.asList(member.getLxSinglemin(),member.getLxSinglemax(),member.getLxSinglehighest()));//色波
        listMap.put("11", Arrays.asList(member.getTxSinglemin(),member.getTxSinglemax(),member.getTxSinglehighest()));//特肖
        listMap.put("12", Arrays.asList(member.getSxlSinglemin(),member.getSxlSinglemax(),member.getSxlSinglehighest()));//生肖连
        listMap.put("13", Arrays.asList(member.getWslSinglemin(),member.getWslSinglemax(),member.getWslSinglehighest()));//尾数连
        listMap.put("14", Arrays.asList(member.getBSinglemin(),member.gettSinglemax(),member.gettSinglehighest()));//不中



        map.put("user_info",userInfo);
        map.put("limit",listMap);
        mv.addAllObjects(map);
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
