package com.fr.lottery.controller;

import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.Member;
import com.fr.lottery.entity.Odds;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IMemberService;
import com.fr.lottery.service.inter.IOddsService;
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
    @Autowired
    private IOddsService oddsService;
    @Autowired
    private ILimitSetService limitSetService;

    @RequestMapping("/index")
    public ModelAndView index(Integer pageId){
        ModelAndView modelAndView = new ModelAndView("/member/index");
        String agentId = UserHelper.getCurrentUser().getId();
        List<Member> members = memberService.getMembersByAgentId(agentId,"",1,pageId);
        modelAndView.addObject("user",members);
        return modelAndView;
    }
    @RequestMapping("/info")
    public ModelAndView info(String id){
        ModelAndView modelAndView = new ModelAndView("/member/info");
        //Odds odds =oddsService.selectByType();
        List<LimitSet> limitSets= limitSetService.findAll("member",id);
        if(limitSets.size()==0){
            limitSets = limitSetService.findAll("agent",UserHelper.getCurrentUser().getId());
        }
        modelAndView.addObject("limit",limitSets);
        return modelAndView;
    }
}
