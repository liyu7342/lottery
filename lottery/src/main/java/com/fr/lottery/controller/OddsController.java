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
    @RequestMapping("/banbo")
    public ModelAndView banbo(){
        ModelAndView modelAndView = new ModelAndView("/odds/banbo");
        return modelAndView;
    }
    @RequestMapping("/buzhong")
    public ModelAndView buzhong(){
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong");
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(){
        ModelAndView modelAndView = new ModelAndView("/odds/guoguan");
        return modelAndView;
    }
    @RequestMapping("/lianma")
    public ModelAndView lianma(){
        ModelAndView modelAndView = new ModelAndView("/odds/lianma");
        return modelAndView;
    }
    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(){
        ModelAndView modelAndView = new ModelAndView("/odds/liuxiao");
        return modelAndView;
    }
    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(){
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiao");
        return modelAndView;
    }
    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(){
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiaolian");
        return modelAndView;
    }
    @RequestMapping("/texiao")
    public ModelAndView texiao(){
        ModelAndView modelAndView = new ModelAndView("/odds/texiao");
        return modelAndView;
    }
    @RequestMapping("/weishu")
    public ModelAndView weishu(){
        ModelAndView modelAndView = new ModelAndView("/odds/weishu");
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(){
        ModelAndView modelAndView = new ModelAndView("/odds/weishulian");
        return modelAndView;
    }
    @RequestMapping("/zheng16")
    public ModelAndView zheng16(){
        ModelAndView modelAndView = new ModelAndView("/odds/zheng16");
        return modelAndView;
    }
    @RequestMapping("/zhengma")
    public ModelAndView zhengma(){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengma");
        return modelAndView;
    }

    @RequestMapping("/zhengmate")
    public ModelAndView zhengmate(){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate");
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
