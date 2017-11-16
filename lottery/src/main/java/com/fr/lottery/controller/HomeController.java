package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        userInfo.put("name",user.getName());
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
        mv.addObject("user",user);
        return mv;
    }

    /**
     * 会员首页
     * @return
     */
    @RequestMapping("/default")
    public ModelAndView getdefault() {
        ModelAndView mv = new ModelAndView("default");
        return mv;
    }

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
        userInfo.put("name",user.getName());
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
        userInfo.put("name",user.getName());
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
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/login1")
    public ModelAndView login1() {
        ModelAndView mv = new ModelAndView("login1");
        return mv;
    }

    @RequestMapping("/login2")
    public ModelAndView login2() {
        ModelAndView mv = new ModelAndView("login2");
        return mv;
    }

    /**
     * 会员登录
     * @param request
     * @param response
     * @param userAccount
     * @param userPwd
     * @param verifyCode
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultInfo<String> doLogin(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd,String verifyCode){

        ResultInfo<String> result = new ResultInfo<String>();
        try{
            if(StringUtils.isBlank(verifyCode)){
                result.setMsg("验证码不能为空");
                result.setSuccess(false);
                return result;
            }
            if(request.getSession().getAttribute("verCode") ==null || !verifyCode.equals(request.getSession().getAttribute("verCode"))){
                result.setMsg("验证码不正确");
                result.setSuccess(false);
                return result;
            }
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getByAccount(userAccount);

            if(user !=null && md5_pwd.equals( user.getPassword()) &&user.getUsertype() == UserTypeEnum.Member.ordinal()){
                result.setSuccess(true);

                UserHelper.setCurrentUser(user);

            }
            else{
                result.setSuccess(false);
                result.setMsg("账号或密码有误！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
        }
        return result;
    }
    @RequestMapping("/doLogin1")
    @ResponseBody
    public ResultInfo<String> doLogin1(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd,String verifyCode){

        ResultInfo<String> result = new ResultInfo<String>();
        try{
            if(StringUtils.isBlank(verifyCode)){
                result.setMsg("验证码不能为空");
                result.setSuccess(false);
                return result;
            }
            if(request.getSession().getAttribute("verCode") ==null || !verifyCode.equals(request.getSession().getAttribute("verCode"))){
                result.setMsg("验证码不正确");
                result.setSuccess(false);
                return result;
            }
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getByAccount(userAccount);

            if(user !=null && md5_pwd.equals( user.getPassword()) &&user.getUsertype() != UserTypeEnum.Admin.ordinal() &&user.getUsertype() != UserTypeEnum.Member.ordinal()){
                result.setSuccess(true);

                UserHelper.setCurrentUser(user);

            }
            else{
                result.setSuccess(false);
                result.setMsg("账号或密码有误！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
        }
        return result;
    }

    @RequestMapping("/doLogin2")
    @ResponseBody
    public ResultInfo<String> doLogin2(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd,String verifyCode){

        ResultInfo<String> result = new ResultInfo<String>();
        try{
            if(StringUtils.isBlank(verifyCode)){
                result.setMsg("验证码不能为空");
                result.setSuccess(false);
                return result;
            }
            if(request.getSession().getAttribute("verCode") ==null || !verifyCode.equals(request.getSession().getAttribute("verCode"))){
                result.setMsg("验证码不正确");
                result.setSuccess(false);
                return result;
            }
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getByAccount(userAccount);

            if(user !=null && md5_pwd.equals( user.getPassword()) &&user.getUsertype() == UserTypeEnum.Admin.ordinal()){
                result.setSuccess(true);

                UserHelper.setCurrentUser(user);

            }
            else{
                result.setSuccess(false);
                result.setMsg("账号或密码有误！");
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

    @RequestMapping(value = "getCodeInfo")
    public void getCodeInfo(HttpServletRequest request , HttpServletResponse response) throws IOException{
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 120, h = 32;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
}
