package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-7-12.
 */
@RequestMapping("report")
@Controller
public class ReportController {
    @RequestMapping("/report")
    public ModelAndView notice(){
        ModelAndView modelAndView = new ModelAndView("report/report");
        return modelAndView;
    }
}
