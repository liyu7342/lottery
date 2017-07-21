package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-6-23.
 */
@RequestMapping("/rule")
@Controller
public class RuleController {


    @RequestMapping("/notice")
    public ModelAndView notice(){
        ModelAndView modelAndView = new ModelAndView("rule/notice");
        return modelAndView;
    }

    @RequestMapping("/rules")
    public ModelAndView rules(){
        ModelAndView modelAndView = new ModelAndView("rule/rules");
        return modelAndView;
    }

    @RequestMapping("/noticehistory")
    public ModelAndView noticehistory(){
        ModelAndView modelAndView = new ModelAndView("rule/noticehistory");
        return  modelAndView;
    }

}
