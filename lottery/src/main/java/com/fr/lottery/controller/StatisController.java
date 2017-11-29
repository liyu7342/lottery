package com.fr.lottery.controller;

import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.UserHelper;
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
    public ModelAndView statis(String category_id){
        ModelAndView modelAndView = new ModelAndView("statis/statis");

        String[] oddsTypes=GameCfg.getCategoryGame(category_id);
        List<StatisDto> statisDtoList= orderService.getStatis(oddsTypes);
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        return modelAndView;
    }
    @RequestMapping("/tjzhengma")
    public ModelAndView tjzhengma(String category_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengma");

        String[] oddsTypes=GameCfg.getCategoryGame(category_id);
        List<StatisDto> statisDtoList= orderService.getStatis(oddsTypes);
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        return modelAndView;
    }
    @RequestMapping("/tjzhengmate")
    public ModelAndView tjzhengmate(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengmate");

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/tjlianma")
    public ModelAndView tjlianma(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjlianma");

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/guoguan");

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiao");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishu");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/banbo");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }


    @RequestMapping("/texiao")
    public ModelAndView texiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/texiao");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/liuxiao");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/liangmian")
    public ModelAndView liangmian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/liangmian");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/sebo")
    public ModelAndView sebo(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/sebo");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiaolian");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishulian");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/wubuzhong")
    public ModelAndView wubuzhong(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/wubuzhong");


        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }


}
