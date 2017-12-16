package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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

    @Autowired
    private IOrderService orderService;
    @RequestMapping("index")
    public ModelAndView index(Integer pageId){
        if(pageId== null) pageId =1;
        Page<Handicap> page = handicapService.getHandicaps(pageId);

        ModelAndView modelAndView = new ModelAndView("handicap/index");
        modelAndView.addObject("handicaps",page.getList());
        modelAndView.addObject("page",page.toString());
        return modelAndView;
    }

    @RequestMapping("openindex")
    public ModelAndView handicapOpenView(Integer pageId){
        ModelAndView modelAndView = new ModelAndView("handicap/openindex");
        Page<Handicap> page = handicapService.getHandicaps(pageId);
        modelAndView.addObject("handicaps",page.getList());
        modelAndView.addObject("page",page.toString());
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
        response.getWriter().write("<script type=\"text/javascript\"> alert(\"开奖成功！\");location.href =\"/handicap/openindex\";</script>");

    }

    @RequestMapping("/info")
    public ModelAndView info(String id){
        ModelAndView modelAndView = new ModelAndView("handicap/info");
         Handicap handicap =handicapService.selectByPrimaryKey(id);
         if(handicap==null){
             handicap = new Handicap();
             handicap.setRiqi(DateTimeUtils.Date2StringSimple(new Date()));
             handicap.setTemaclosetime(DateTimeUtils.getDate(21,30,0));
             handicap.setZhengmaclosetime(DateTimeUtils.getDate(21,32,0));
             handicap.setOpentime(DateTimeUtils.getDate(17,40,0));
         }


        modelAndView.addObject("entity",handicap);
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

    @ResponseBody
    @RequestMapping("settlement")
    public void settlement(String handicapId,HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isSuccess = orderService.settlement(handicapId);
        String referer = request.getHeader("Referer");
        if(isSuccess){
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\""+referer+"\"</script>");
        }
        else{
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }
    }

    @ResponseBody
    @RequestMapping("get6hbd")
    public String get6hbd(){
        String url="";
        return handicapService.get6hbd(url);
    }
}
