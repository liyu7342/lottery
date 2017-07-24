package com.fr.lottery.controller;

import com.fr.lottery.entity.Member;
import com.fr.lottery.service.inter.IMemberService;
import com.fr.lottery.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/index")
    public ModelAndView index(Integer pageId){
        ModelAndView modelAndView = new ModelAndView("/index");
        String agentId = UserHelper.getCurrentUser().getId();
        List<Member> members = memberService.getMembersByAgentId(agentId,pageId);
        modelAndView.addObject("user",members);
        return modelAndView;
    }


}
