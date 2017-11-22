package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.service.inter.IHandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-7-9.
 */
@Controller
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private IHandicapService handicapService;
    @RequestMapping("/index")
    public ModelAndView index(Integer pageId){
        ModelAndView modelAndView = new ModelAndView("/result/index");
        Page<Handicap> page= handicapService.getHandicaps(pageId);
        modelAndView.addObject("handicaps",page.getList());
        modelAndView.addObject("page",page.toString());
        return modelAndView;
    }
}
