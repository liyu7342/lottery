package com.fr.lottery.controller;

import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.Notice;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.INoticeService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/home")
public class HomeController  {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ILimitSetService limitSetService;
    @Autowired
    private INoticeService noticeService;
    @Autowired
    private IUserService userService;

    /**
     * 会员首页
      * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        if(request.getSession().getAttribute("needToChangPwd") !=null){
            ModelAndView modelAndView = new ModelAndView("redirect:changepwdindex");
            return modelAndView;
        }
        ModelAndView mv = new ModelAndView("index");
        User user= UserHelper.getCurrentUser();
        User currentUser =userService.get(user.getRealId());
        Map<String,Object> map = new HashedMap();
        Map<String,Object> userInfo=new HashedMap();
        Integer amount =orderService.getOrderAmount();
        amount =amount==null?0:amount;
        userInfo.put("memberId",user.getId());
        userInfo.put("credit",currentUser.getCredits());
        userInfo.put("name",currentUser.getUserName());
        userInfo.put("account",currentUser.getAccount());
        userInfo.put("sum",amount);
        userInfo.put("odds_set",currentUser.getHandicap());
        userInfo.put("status", user.getStatus());
        if(amount !=user.getAmount()){
            user.setAmount(amount);
            UserHelper.setCurrentUser(user);

        }
        map.put("user_info",userInfo);

        List<LimitSet> limitSets = limitSetService.findAll(user.getId());

        Map<String,List<Integer>>listMap = new HashedMap();
        for(LimitSet set : limitSets){
            listMap.put(set.getLimitType().length()>2?set.getLimitType().substring(1):set.getLimitType(),Arrays.asList(set.getSinglemin(),set.getSinglemax(),set.getSinglehighest()));
        }
        map.put("limit",listMap);
        mv.addObject("info",  JsonUtil.toJson(map));
       Object first_login= request.getSession().getAttribute("first_login");

        if(first_login!=null){
            request.getSession().removeAttribute("first_login");
            mv.addObject("show_ip","<div class=\"show_ip\" id=\"show_ip\" popup=\"1\" style=\"display: none;\"></div>");
        }
        mv.addObject("user",user);
        return mv;
    }

//    /**
//     * 会员首页
//     * @return
//     */
//    @RequestMapping("/default")
//    public ModelAndView getdefault() {
//        ModelAndView mv = new ModelAndView("default");
//        return mv;
//    }

    /**
     * 会员首页
     * @return
     */
    @RequestMapping("/index3")
    public ModelAndView index3() {

        ModelAndView mv = new ModelAndView("index1");
        User user= UserHelper.getCurrentUser();
        Integer amount =orderService.getOrderAmount();
        amount =amount==null?0:amount;
        Map<String,Object> map = new HashedMap();
        Map<String,Object> userInfo=new HashedMap();
        User currentUser = userService.get(user.getId());
        userInfo.put("memberId",user.getId());
        userInfo.put("credits",currentUser.getCredits());
        userInfo.put("name",currentUser.getUserName());
        userInfo.put("account",currentUser.getAccount());
        userInfo.put("sum",amount);
        userInfo.put("odds_set",currentUser.getHandicap());
        userInfo.put("status",1);
        if(amount !=user.getAmount()){
            user.setAmount(amount);
            UserHelper.setCurrentUser(user);

        }
        map.put("user_info",userInfo);
        List<LimitSet> limitSets = limitSetService.findAll(user.getId());

        Map<String,List<Integer>>listMap = new HashedMap();
        for(LimitSet set : limitSets){
            listMap.put(set.getLimitType(),Arrays.asList(set.getSinglemin(),set.getSinglemax(),set.getSinglehighest()));
        }
        map.put("limit",listMap);
        mv.addObject("info", JsonUtil.toJson( map));
        return mv;
    }

    /**
     * 代理首页
     * @return
     */
    @RequestMapping("/index1")
    public ModelAndView index1() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getSession().getAttribute("needToChangPwd") !=null){
            ModelAndView modelAndView = new ModelAndView("redirect:changepwdindex");
            return modelAndView;
        }
        ModelAndView mv = new ModelAndView("index1");
        //{"status":2,"calc_status":-1,"marquee":"欢迎进入A28 ! 2017年香港六合彩第080期開獎時間為：2017年7月11日（星期2）21:30，本公司於開獎日17:00至17:40開盤，21:30開獎前收盤。如有異動以香港馬會公佈為準!! 敬告：投注後請查看下注明細，確認注單是否交易成功，以免重複下注，所有注單恕不更改，本公司對開獎後的投注均視無效,不便之處敬請諒解","lines":["http:\/\/pm10.x.mmm33.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.mmm11.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.a.mmm55.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.x.mmm44.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.mmm22.us\/msdid63242a_8955\/lines.htm"],"time_stamp":"20170712084830"};
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("status",2);
        map.put("calc_status",-1);
        Notice notice = noticeService.getLatestDailyNotice();
        map.put("marquee",notice.getContent());
        map.put("lines",new ArrayList<String>());
        mv.addObject("header_info",JsonUtil.toJson(map));

        Object first_login= request.getSession().getAttribute("first_login");
        if(first_login!=null){
            request.getSession().removeAttribute("first_login");
            mv.addObject("show_ip","<div class=\"show_ip\" id=\"show_ip\" popup=\"1\" style=\"display: none;\"></div>");
        }
        User user =UserHelper.getCurrentUser();

        mv.addObject("user",user);
        return mv;
    }

    /**
     * 管理员首页
     * @return
     */
    @RequestMapping("/index2")
    public ModelAndView index2() {

        ModelAndView mv = new ModelAndView("/index2");
        User user= UserHelper.getCurrentUser();

        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("status",2);
        map.put("calc_status",-1);
        Notice notice = noticeService.getLatestDailyNotice();
        map.put("marquee",notice.getContent());
        map.put("lines",new ArrayList<String>());
        mv.addObject("header_info",JsonUtil.toJson(map));
        mv.addObject("user",user);
        return mv;
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

    @RequestMapping(value="changepwdindex")
    public ModelAndView changepwdindex ()
    {
        ModelAndView modelAndView = new ModelAndView("changepwdindex");
        User user = UserHelper.getCurrentUser();
        modelAndView.addObject("user",user);
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("status",2);
        map.put("calc_status",-1);
        Notice notice = noticeService.getLatestDailyNotice();
        map.put("marquee",notice.getContent());
        map.put("lines",new ArrayList<String>());
        modelAndView.addObject("header_info",JsonUtil.toJson(map));
        return modelAndView;
    }
}
