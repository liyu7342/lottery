package com.fr.lottery.controller;

import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.service.inter.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-12.
 */
@Controller
@RequestMapping("statis")
public class StatisController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/statis")
    public ModelAndView statis(){
        ModelAndView modelAndView = new ModelAndView("statis/statis");
        List<StatisDto> statisDtoList= orderService.getStatis(OddsTypeEnum.tema.getValue());
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/tjzhengma")
    public ModelAndView tjzhengma(){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengma");
        List<StatisDto> statisDtoList= orderService.getStatis(OddsTypeEnum.zhengma.getValue());
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/tjzhengmate")
    public ModelAndView tjzhengmate(){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengmate");
        List<StatisDto> statisDtoList= orderService.getStatis(OddsTypeEnum.zhengmate1.getValue());
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/tjlianma")
    public ModelAndView tjlianma(){
        ModelAndView modelAndView = new ModelAndView("statis/tjlianma");
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(){
        ModelAndView modelAndView = new ModelAndView("statis/guoguan");
        return modelAndView;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiao");
        return modelAndView;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu(){
        ModelAndView modelAndView = new ModelAndView("statis/weishu");
        return modelAndView;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo(){
        ModelAndView modelAndView = new ModelAndView("statis/banbo");
        return modelAndView;
    }


    @RequestMapping("/texiao")
    public ModelAndView texiao(){
        ModelAndView modelAndView = new ModelAndView("statis/texiao");
        return modelAndView;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(){
        ModelAndView modelAndView = new ModelAndView("statis/liuxiao");
        return modelAndView;
    }

    @RequestMapping("/liangmian")
    public ModelAndView liangmian(){
        ModelAndView modelAndView = new ModelAndView("statis/liangmian");
        return modelAndView;
    }

    @RequestMapping("/sebo")
    public ModelAndView sebo(){
        ModelAndView modelAndView = new ModelAndView("statis/sebo");
        return modelAndView;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiaolian");
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(){
        ModelAndView modelAndView = new ModelAndView("statis/weishulian");
        return modelAndView;
    }

    @RequestMapping("/wubuzhong")
    public ModelAndView wubuzhong(){
        ModelAndView modelAndView = new ModelAndView("statis/wubuzhong");
        return modelAndView;
    }


}
