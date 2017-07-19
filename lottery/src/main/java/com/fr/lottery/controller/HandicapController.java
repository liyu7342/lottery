package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.service.inter.IHandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/11.
 * 盘口管理
 */
@RequestMapping("/handicap")
@Controller
public class HandicapController {
    @Autowired
    private IHandicapService handicapService;
    @RequestMapping("index")
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
    @ResponseBody
    @RequestMapping("getHandicap")
    public Handicap getHandicap(String id){
        return handicapService.selectByPrimaryKey(id);
    }

    @ResponseBody
    @RequestMapping("delete")
    public ResultInfo<String> delete(String id){
       boolean isTrue= handicapService.delete(id);
       ResultInfo<String> resultInfo =  new ResultInfo<String>();
        resultInfo.setSuccess(isTrue);
        return resultInfo;
    }
}
