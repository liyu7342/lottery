package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-7-12.
 */
@Controller
@RequestMapping("statis")
public class StatisController {
    @RequestMapping("/statis")
    public ModelAndView statis(){
        ModelAndView modelAndView = new ModelAndView("statis/statis");
        return modelAndView;
    }
}
