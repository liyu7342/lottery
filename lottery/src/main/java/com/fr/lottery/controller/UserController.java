package com.fr.lottery.controller;

import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/index")
    public ModelAndView index(Integer pageId,Integer  keywordstatus,String keyword) {
        ModelAndView modelAndView = new ModelAndView("/user/index");
        String agentId = UserHelper.getCurrentUser().getId();
        List<User> user = userService.getUserByParentId(agentId,keyword,keywordstatus,pageId);
        modelAndView.addObject("user",user);
        return modelAndView;
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

    @RequestMapping("/info")
    public ModelAndView info() {
        ModelAndView mv = new ModelAndView("/user/info");
        return mv;
    }

    @RequestMapping("/changStatus")
    @ResponseBody
    public int changeStatus(Integer level,String pid,String id,Integer status){
       return userService.changeStatus(level,pid,id,status);
    }
}
