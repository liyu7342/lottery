package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-7-13.
 */
@Controller
@RequestMapping("oper")
public class OperController {
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("oper/index");

        return mv;
    }
}
