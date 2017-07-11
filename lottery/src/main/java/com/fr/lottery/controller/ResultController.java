package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-7-9.
 */
@Controller
public class ResultController {
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/result/index");
        return modelAndView;
    }
}
