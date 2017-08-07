package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.service.impl.HandicapService;
import com.fr.lottery.service.inter.IHandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 * 盘口管理
 */
@RequestMapping("/handicap")
@Controller
public class HandicapController extends BaseController {
    @Autowired
    private IHandicapService handicapService;
    @RequestMapping("index")
    public ModelAndView index(Integer pageId){
        if(pageId== null) pageId =1;
        List<Handicap> handicaps = handicapService.getHandicaps(pageId);

        ModelAndView modelAndView = new ModelAndView("handicap/index");
        modelAndView.addObject("handicaps",handicaps);
        return modelAndView;
    }

    @RequestMapping("openindex")
    public ModelAndView handicapOpenView(Integer pageId){
        ModelAndView modelAndView = new ModelAndView("handicap/openindex");
        List<Handicap> handicaps = handicapService.getHandicaps(pageId);
        modelAndView.addObject("handicaps",handicaps);
        return modelAndView;
    }

    @RequestMapping("openform")
    public ModelAndView handicapOpenFormView(String id){
        ModelAndView modelAndView = new ModelAndView("handicap/openform");
        Handicap handicap = handicapService.selectByPrimaryKey(id);
        modelAndView.addObject("entity",handicap);
        return modelAndView;
    }

    @RequestMapping("open")
    public  void open(Handicap handicap,HttpServletRequest request, HttpServletResponse response) throws IOException{
        handicapService.openHandicap(handicap);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script type=\"text/javascript\"> alert(\"开奖成功！\");location.href =\"/handicap/handicapopen\";</script>");

    }

    @RequestMapping("/info")
    public ModelAndView info(String id){
        ModelAndView modelAndView = new ModelAndView("handicap/info");
        modelAndView.addObject("entity",handicapService.selectByPrimaryKey(id));
        return modelAndView;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(Handicap handicap, HttpServletRequest request, HttpServletResponse response) throws IOException{

        boolean result = handicapService.save(handicap);
        response.setContentType("text/html;charset=UTF-8");
        if(result){
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/handicap/index\";</script>");
        }
        else {
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }
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
