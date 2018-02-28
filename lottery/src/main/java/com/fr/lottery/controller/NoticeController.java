package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Notice;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2018-1-28.
 */
@RequestMapping("/notice")
@Controller
public class NoticeController {
    @Autowired
    private INoticeService noticeService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/notice/index");
        return modelAndView;
    }

    @RequestMapping("/history")
    public ModelAndView noticehistory(){
        ModelAndView modelAndView = new ModelAndView("/notice/history");
        Page<Notice>  noticePage =noticeService.getDailyNotices(1, Global.pageSize);
        modelAndView.addObject("noticeList",noticePage.getList());
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView create(String id){
        ModelAndView modelAndView = new ModelAndView("/notice/create");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Integer save(Notice notice){
        Integer b= noticeService.save(notice);
        return b;
    }


}
