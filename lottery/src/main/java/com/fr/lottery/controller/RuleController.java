package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Notice;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.impl.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Liyu7342 on 2017-6-23.
 */
@RequestMapping("/rule")
@Controller
public class RuleController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice")
    public ModelAndView notice(){
        ModelAndView modelAndView = new ModelAndView("rule/notice");
        return modelAndView;
    }

    @RequestMapping("/rules")
    public ModelAndView rules(){
        ModelAndView modelAndView = new ModelAndView("rule/rules");
        return modelAndView;
    }

    @RequestMapping("/noticehistory")
    public ModelAndView noticehistory(String act){
        ModelAndView modelAndView = new ModelAndView("rule/noticehistory");
        Integer pageSize=Global.pageSize;
        if(StringUtils.isBlank(act)){
            pageSize=1;
        }
        Page<Notice> noticePage =noticeService.getDailyNotices(1, pageSize);
        modelAndView.addObject("noticeList",noticePage.getList());
        return  modelAndView;
    }

    @RequestMapping("/protocol")
    public ModelAndView protocol(){
        ModelAndView modelAndView = new ModelAndView("rule/protocol");
        return  modelAndView;
    }
}
