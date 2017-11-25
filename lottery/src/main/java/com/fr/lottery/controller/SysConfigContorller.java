package com.fr.lottery.controller;

import com.fr.lottery.entity.User;
import com.fr.lottery.utils.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-7-13.
 */
@Controller
@RequestMapping("/sysconfig")
public class SysConfigContorller {
    @RequestMapping("/buhuo")
    public ModelAndView buhuo() {
        ModelAndView mv = new ModelAndView("sysconfig/buhuo");

        return mv;
    }
}
