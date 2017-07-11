package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/6/22.
 */
@RequestMapping("/history")
@Controller
public class HistoryController {
    @RequestMapping("/index")
    public ModelAndView history() {
        ModelAndView mv = new ModelAndView("/history/index");
        return mv;
    }
}
