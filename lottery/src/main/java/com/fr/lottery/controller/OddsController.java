package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Odds;
import com.fr.lottery.service.impl.OddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/7/11.
 * 赔率设置
 */
@Controller
@RequestMapping("/odds")
public class OddsController {
    @Autowired
    private OddsService oddsService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/odds/index");
        return modelAndView;
    }

    /**
     *@Date 2017/7/11
     * 获取赔率
     * * @param type
     */
    @ResponseBody
    @RequestMapping("/getOdds")
    public Odds getOdds(String type){
        return oddsService.selectByType(type);
    }

    /**
     *@Date 2017/7/11
     * 获取默认赔率
     * * @param type
     */
    @ResponseBody
    @RequestMapping("getDefaultOdds")
    public Odds getDefaultOdds(String type){
        return oddsService.selectDefault(type);
    }

    @ResponseBody
    @RequestMapping("save")
    public ResultInfo<String> save(Odds entity){
        ResultInfo<String> resultInfo = new ResultInfo<String>();
        boolean result =oddsService.update(entity);
        resultInfo.setSuccess(result);
        return resultInfo;

    }
}
