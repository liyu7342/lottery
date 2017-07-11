package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.service.inter.IHandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/7/11.
 * 盘口管理
 */
@RequestMapping("/handicap")
@Controller
public class HandicapController {
    @Autowired
    private IHandicapService handicapService;
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("handicap/index");
        return modelAndView;
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResultInfo<String> save(Handicap handicap){
        ResultInfo<String> resultInfo = new ResultInfo<String>();
        boolean result = handicapService.save(handicap);
        resultInfo.setSuccess(result);
        return resultInfo;
    }
}
