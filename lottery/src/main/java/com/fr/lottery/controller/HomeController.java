package com.fr.lottery.controller;

import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private IOrderService orderService;

    @Autowired
    private ILimitSetService limitSetService;

    /**
     * 会员首页
      * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");
        User user= UserHelper.getCurrentUser();
        Map<String,Object> map = new HashedMap();
        Map<String,Object> userInfo=new HashedMap();
        Integer amount =orderService.getOrderAmount();
        amount =amount==null?0:amount;
        userInfo.put("memberId",user.getId());
        userInfo.put("credit",user.getCredits());
        userInfo.put("name",user.getUserName());
        userInfo.put("account",user.getAccount());
        userInfo.put("sum",amount);
        userInfo.put("odds_set",user.getHandicap());
        userInfo.put("status",1);
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
        userInfo.put("memberId",user.getId());
        userInfo.put("credits",user.getCredits());
        userInfo.put("name",user.getUserName());
        userInfo.put("account",user.getAccount());
        userInfo.put("sum",amount);
        userInfo.put("odds_set",user.getHandicap());
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

        ModelAndView mv = new ModelAndView("index1");

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
        Map<String,Object> map = new HashedMap();
        Map<String,Object> userInfo=new HashedMap();

        Integer amount =orderService.getOrderAmount();
        amount =amount==null?0:amount;
        userInfo.put("memberId",user.getId());
        userInfo.put("credits",user.getCredits());
        userInfo.put("name",user.getUserName());
        userInfo.put("account",user.getAccount());
        userInfo.put("sum",amount);
        userInfo.put("odds_set",user.getHandicap());
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
