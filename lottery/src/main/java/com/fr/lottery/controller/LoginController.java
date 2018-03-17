package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.SessionContext;
import com.fr.lottery.utils.UserHelper;
import com.fr.lottery.utils.VerifyCodeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/11/22.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     * 会员首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/login/index");
        return mv;
    }


    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("/login/login");
        return mv;
    }

    @RequestMapping("/login1")
    public ModelAndView login1() {
        ModelAndView mv = new ModelAndView("/login/login1");
        return mv;
    }

    @RequestMapping("/login2")
    public ModelAndView login2() {
        ModelAndView mv = new ModelAndView("/login/login2");
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
    public ResultInfo<String> doLogin(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd, String verifyCode){
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
                if(user.getStatus() == StatusEnum.TingYong.ordinal()){
                    result.setSuccess(false);
                    result.setMsg("賬號已经被停用");
                }
                else {
                    User daili = userService.get(user.getDailiId());
                    User zongdai =userService.get(user.getZongdailiId());
                    User gudong =userService.get(user.getGudongId());
                    User dagudong =userService.get(user.getDagudongId());
                    if(daili.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else if(zongdai.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else if(gudong.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else  if(dagudong.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else{
                        result.setSuccess(true);
                        UserHelper.setCurrentUser(user);
                        userService.updateLoginStatus(user);
                    }

                }

            }
            else{
                result.setSuccess(false);
                result.setMsg("賬號或密碼有誤！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
            ex.printStackTrace();
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
                if(user.getStatus() == StatusEnum.TingYong.ordinal()){
                   result.setSuccess(false);
                   result.setMsg("賬號已经被停用");
               }
               else {
                   User zongdai =userService.get(user.getZongdailiId());
                   User gudong =userService.get(user.getGudongId());
                   User dagudong =userService.get(user.getDagudongId());

                  if(zongdai!=null && zongdai.getStatus() == StatusEnum.TingYong.ordinal()){
                       result.setSuccess(false);
                       result.setMsg("公司被停用了");
                   }
                   else if(gudong!=null && gudong.getStatus() == StatusEnum.TingYong.ordinal()){
                       result.setSuccess(false);
                       result.setMsg("公司被停用了");
                   }
                   else  if(dagudong!=null && dagudong.getStatus() == StatusEnum.TingYong.ordinal()){
                       result.setSuccess(false);
                       result.setMsg("公司被停用了");
                   }
                   else{
                       result.setSuccess(true);
                       UserHelper.setCurrentUser(user);
                      userService.updateLoginStatus(user);
                   }
               }
            }
            else{
                result.setSuccess(false);
                result.setMsg("賬號或密碼有誤！");
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
                userService.updateLoginStatus(user);
            }
            else{
                result.setSuccess(false);
                result.setMsg("賬號或密碼有誤！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
        }
        return result;
    }
    @RequestMapping(value = "getCodeInfo")
    public void getCodeInfo(HttpServletRequest request , HttpServletResponse response) throws IOException {
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
