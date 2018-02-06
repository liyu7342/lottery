package com.fr.lottery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2018-1-28.
 */
@RequestMapping("notice")
public class NoticeController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/notice/indeex");
        return modelAndView;
    }

    @RequestMapping("/history")
    public ModelAndView noticehistory(){
        ModelAndView modelAndView = new ModelAndView("/notice/history");
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView create(String id){
        ModelAndView modelAndView = new ModelAndView("/notice/create");
        return modelAndView;
    }

}
