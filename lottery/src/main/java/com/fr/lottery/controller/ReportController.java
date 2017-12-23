package com.fr.lottery.controller;

import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-12.
 */
@RequestMapping("report")
@Controller
public class ReportController {
    @Autowired
    private IHandicapService handicapService;
    @RequestMapping("/report")
    public ModelAndView report(){
        ModelAndView modelAndView = new ModelAndView("/report/report");
        List<String>  datelist = new ArrayList<String>();

        datelist.add("2017-12-05");
        datelist.add("2017-12-07");
        datelist.add("2017-12-09");
        modelAndView.addObject("datelist",datelist);
        return modelAndView;
    }

    @RequestMapping("/reportmonth")
    public ModelAndView reportmonth(){
        ModelAndView modelAndView = new ModelAndView("/report/reportmonth");
        return modelAndView;
    }
    @RequestMapping("/user_report")
    public ModelAndView user_report(String gameType,String draw_date,String draw_date2,String kind){
        ModelAndView modelAndView = new ModelAndView("/report/user_report");
        return modelAndView;
    }

    @RequestMapping("/game_report")
    public ModelAndView game_report(String draw_date,String draw_date2,String category_id,String game_id,String type,String tn){
        ModelAndView modelAndView = new ModelAndView("/report/game_report");
        return modelAndView;
    }

    @RequestMapping("/reportwanfa")
    //draw_date=2017-11-23&draw_date2=2017-11-23&game_id=000&number=01&type=1&category_id=00&tn=1
    public  ModelAndView reportwanfa(String draw_date,String draw_date2,String category_id,String game_id,String type,String tn,String number){
        ModelAndView modelAndView = new ModelAndView("/report/game_report");
        return modelAndView;
    }

    @RequestMapping("z_gudong")
    public ModelAndView z_dagudong(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_gudong");

        return modelAndView;
    }
    @RequestMapping("/z_zongdaili")
    public ModelAndView z_zongdaili(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_zongdaili");

        return modelAndView;
    }

    @RequestMapping("/z_daili")
    public ModelAndView z_daili(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_daili");

        return modelAndView;
    }

    @RequestMapping("/z_member")
    public ModelAndView z_member(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_member");

        return modelAndView;
    }

    @RequestMapping("/reportmingxi")
    public ModelAndView reportmingxi(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id) {
        ModelAndView modelAndView = new ModelAndView("/report/z_member");

        return modelAndView;
    }
}
