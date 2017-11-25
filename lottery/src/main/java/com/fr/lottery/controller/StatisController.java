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
        User user = UserHelper.getCurrentUser();

        String[] oddsTypes=GameCfg.getCategoryGame(category_id);
        List<StatisDto> statisDtoList= orderService.getStatis(oddsTypes);
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/tjzhengma")
    public ModelAndView tjzhengma(String category_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengma");
        User user = UserHelper.getCurrentUser();

        String[] gameTypes =GameCfg.getCategoryGame(category_id);
        List<StatisDto> statisDtoList= orderService.getStatis(gameTypes);
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/tjzhengmate")
    public ModelAndView tjzhengmate(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengmate");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/tjlianma")
    public ModelAndView tjlianma(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjlianma");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/guoguan");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiao");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishu");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/banbo");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }


    @RequestMapping("/texiao")
    public ModelAndView texiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/texiao");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/liuxiao");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/liangmian")
    public ModelAndView liangmian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/liangmian");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/sebo")
    public ModelAndView sebo(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/sebo");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiaolian");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishulian");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/wubuzhong")
    public ModelAndView wubuzhong(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/wubuzhong");
        User user = UserHelper.getCurrentUser();

        List<StatisDto> statisDtoList= orderService.getStatis(new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }


}
