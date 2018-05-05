package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
                        request.getSession().setAttribute("first_login","1");
                        request.getSession().removeAttribute("verCode");
                        userService.updateLoginStatus(user);
                        if(user.getNeedToChangePwd() || (user.getLastChangeDate()!=null && new Date().compareTo(DateTimeUtils.addMonths( user.getLastChangeDate(),3))>0)){
                            request.getSession().setAttribute("needToChangPwd","1");
                        }
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
                       if(user.getUsertype()==UserTypeEnum.UserAdmin.ordinal()){
                           User parentUser = userService.get(user.getParentid());
                           UserHelper.setCurrentUser(user,parentUser);
                       }else{
                           UserHelper.setCurrentUser(user);
                       }

                      request.getSession().removeAttribute("verCode");
                      request.getSession().setAttribute("first_login","1");
                      if(user.getNeedToChangePwd() || (user.getLastChangeDate()!=null && new Date().compareTo(DateTimeUtils.addMonths( user.getLastChangeDate(),3))>0)){
                          request.getSession().setAttribute("needToChangPwd","1");
                      }
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
                request.getSession().removeAttribute("verCode");
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


    @Autowired
    IHandicapService handicapService;
    @RequestMapping("/calc")
    public void calc(HttpServletRequest request,HttpServletResponse response){
        Page<Handicap> page = handicapService.getHandicaps(1,10000);

        int totalMoney=0;
        for( int i=0, len =page.getList().size();i<(len-1);i++){
            Handicap prev = page.getList().get(i);
            Handicap next = page.getList().get(i+1);
            int total =0;
            int currentMoney=0;
            if( (prev.getNo1().equals(next.getNo1() )|| prev.getNo1().equals(next.getNo2() )|| prev.getNo1().equals(next.getNo3()
                    )|| prev.getNo1().equals(next.getNo4())|| prev.getNo1().equals(next.getNo5())|| prev.getNo1().equals(next.getNo6()
                        )|| prev.getNo1().equals(next.getTema()))){
                total++;
            }
            if(prev.getNo2().equals(next.getNo1() )|| prev.getNo2().equals(next.getNo2() )|| prev.getNo2().equals(next.getNo3()
                    )|| prev.getNo2().equals(next.getNo4())|| prev.getNo2().equals(next.getNo5())|| prev.getNo2().equals(next.getNo6()
                    )|| prev.getNo2().equals(next.getTema())){
                total++;
            }
            if(prev.getNo3().equals(next.getNo1() )|| prev.getNo3().equals(next.getNo2() )|| prev.getNo3().equals(next.getNo3()
                    )|| prev.getNo3().equals(next.getNo4())|| prev.getNo3().equals(next.getNo5())|| prev.getNo3().equals(next.getNo6()
                    )|| prev.getNo3().equals(next.getTema())){
                total++;
            }
            if(prev.getNo4().equals(next.getNo1() )|| prev.getNo4().equals(next.getNo2() )|| prev.getNo4().equals(next.getNo3()
                    )|| prev.getNo4().equals(next.getNo4())|| prev.getNo4().equals(next.getNo5())|| prev.getNo4().equals(next.getNo6()
                    )|| prev.getNo4().equals(next.getTema())){
                total++;
            }
            if(prev.getNo5().equals(next.getNo1() )|| prev.getNo5().equals(next.getNo2() )|| prev.getNo5().equals(next.getNo3()
                    )|| prev.getNo5().equals(next.getNo4())|| prev.getNo5().equals(next.getNo5())|| prev.getNo5().equals(next.getNo6()
                    )|| prev.getNo5().equals(next.getTema())){
                total++;
            }
            if(prev.getNo6().equals(next.getNo1() )|| prev.getNo6().equals(next.getNo2() )|| prev.getNo6().equals(next.getNo3()
                    )|| prev.getNo6().equals(next.getNo4())|| prev.getNo6().equals(next.getNo5())|| prev.getNo6().equals(next.getNo6()
                    )|| prev.getNo6().equals(next.getTema())){
                total++;
            }
//            if(prev.getTema().equals(next.getNo1() )|| prev.getTema().equals(next.getNo2() )|| prev.getTema().equals(next.getNo3()
//                    )|| prev.getTema().equals(next.getNo4())|| prev.getTema().equals(next.getNo5())|| prev.getTema().equals(next.getNo6()
//                    )|| prev.getTema().equals(next.getTema())){
//                total++;
//            }

            currentMoney=(total==0?700:total==1?-765:total==2?-1877:-2100);
            Integer liuMoney =(total ==0);
            totalMoney+=currentMoney;
            System.out.println( i+"、"+next.getRiqi()+":出了"+total+"个数，"+"输赢："+currentMoney+",累计输赢："+totalMoney);
            System.out.println( i+"、"+next.getRiqi()+":出了"+total+"个数，"+"输赢："+currentMoney+",累计输赢："+totalMoney);
        }
    }

}
