package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/6/22.
 */
@RequestMapping("order")
@Controller
public class OrderControlller {
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/order/list");
        return mv;
    }
}
