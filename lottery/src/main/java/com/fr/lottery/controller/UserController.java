package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.UserHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Autowired
    private ILimitSetService limitSetService;

    @RequestMapping("/index")
    public ModelAndView index(Integer pageId, Integer keywordstatus, String keyword) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();

        Page<User> users = userService.getUsers(userId, UserTypeEnum.Member.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        
        return modelAndView;
    }


    @RequestMapping("/index1")
    public ModelAndView index1(Integer pageId, Integer keywordstatus, String keyword) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_1");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();
        Page<User> users = userService.getDagudongs(UserTypeEnum.DaGudong.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        
        return modelAndView;
    }

    @RequestMapping("/index2")
    public ModelAndView index2(Integer pageId, Integer keywordstatus, String keyword) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_2");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();

        Page<User> users = userService.getUsers(userId, UserTypeEnum.XiaoGudong.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        
        return modelAndView;
    }

    @RequestMapping("/index3")
    public ModelAndView index3(Integer pageId, Integer keywordstatus, String keyword) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_3");

        User user = UserHelper.getCurrentUser();
        String userId = user.getId();
        Page<User> users = userService.getUsers(userId, UserTypeEnum.ZongDaili.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        
        return modelAndView;
    }

    @RequestMapping("/index4")
    public ModelAndView index4(Integer pageId, Integer keywordstatus, String keyword) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_4");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();

        Page<User> users = userService.getUsers(userId, UserTypeEnum.Daili.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        
        return modelAndView;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = UserHelper.getCurrentUser();

        UserHelper.logout(request);
        if (UserTypeEnum.Member.ordinal() == user.getUsertype())
            response.sendRedirect("/login/login");
        else if (UserTypeEnum.Daili.ordinal() == user.getUsertype() || UserTypeEnum.ZongDaili.ordinal() == user.getUsertype()
                || UserTypeEnum.XiaoGudong.ordinal() == user.getUsertype() || UserTypeEnum.DaGudong.ordinal() == user.getUsertype())
            response.sendRedirect("/login/login1");
        else if (UserTypeEnum.Admin.ordinal() == user.getUsertype()) {
            response.sendRedirect("/login/login2");
        } else {
            response.sendRedirect("/login/index");
        }
    }

    @RequestMapping("/changepwd")
    public void changepwd(String oldpwd, String newpwd1, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = UserHelper.getCurrentUser();
        MD5Util md5Util = new MD5Util();
        boolean result = false;
        if (user.getPassword().equals(md5Util.getMD5ofStr(oldpwd))) {
            userService.updatePassword(user.getId(), md5Util.getMD5ofStr(newpwd1));
            result = true;
        }
        response.setContentType("text/html;charset=UTF-8");
        if(result){
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");parent.location.href =\"/user/logout\";</script>");
        }
        else
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
    }


    @RequestMapping("/history")
    public ModelAndView history() {
        ModelAndView mv = new ModelAndView("/history/index");
        return mv;
    }

    @RequestMapping("/repassword")

    public ModelAndView repassword() {
        ModelAndView mv = new ModelAndView("/user/password");

        
        return mv;
    }

    @RequestMapping("password1")
    public ModelAndView password1(){
        ModelAndView mv = new ModelAndView("/user/password1");

        return mv;
    }

    @RequestMapping("/info")
    public ModelAndView info() {
        ModelAndView mv = new ModelAndView("/user/info");
        User currentUser = UserHelper.getCurrentUser();
        Map<String, Object> map = new HashMap<String, Object>();
        List<LimitSet> limitSets = limitSetService.findAll(currentUser.getId());

        for (LimitSet limitset : limitSets) {
            if("B".equals(currentUser.getHandicap())){
                limitset.setaRetreat(limitset.getbRetreat());
            }
            else if("C".equals(currentUser.getHandicap())){
                limitset.setaRetreat(limitset.getcRetreat());
            }
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        mv.addObject("limitSets", map);
        return mv;
    }

    @RequestMapping("/info1")
    public ModelAndView info1() {
        ModelAndView mv = new ModelAndView("/user/info1");
        User currentUser = UserHelper.getCurrentUser();
        Map<String, Object> map = new HashMap<String, Object>();
        List<LimitSet> limitSets = limitSetService.findAll(currentUser.getId());

        for (LimitSet limitset : limitSets) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        mv.addObject("limitSets", map);

        return mv;
    }

    @RequestMapping("/changStatus")
    @ResponseBody
    public int changeStatus(Integer level, String pid, String id, Integer status) {
        return userService.changeStatus(level, pid, id, status);
    }

    @RequestMapping("/checkAccount")
    @ResponseBody
    public int checkAccount(String account) {
        User user = userService.getByAccount(account);
        int result = user == null ? 0 : 1;
        return result;
    }
}
