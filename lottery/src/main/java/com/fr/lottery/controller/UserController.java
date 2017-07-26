package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Member;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IMemberService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Resource
    private IMemberService memberService;

    @RequestMapping("/index")
    public ModelAndView index(Integer pageId,Integer  keywordstatus,String keyword) {
        ModelAndView modelAndView = new ModelAndView("/user/index");
        String agentId = UserHelper.getCurrentUser().getId();
        List<Member> members = memberService.getMembersByAgentId(agentId,keyword,keywordstatus,pageId);
        modelAndView.addObject("user",members);
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
    /**
     *
     * @param account
     * @param name
     * @param index
     * @param size
     * @return
     */
    @RequestMapping("/paging")
    @ResponseBody
    public Page<User> Paging(String account,String name, Integer index, Integer size) {
        return userService.Paging(account,name,index,size);
    }

}
