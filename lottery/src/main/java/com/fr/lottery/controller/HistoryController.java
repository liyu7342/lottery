package com.fr.lottery.controller;

import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.service.inter.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
@RequestMapping("/history")
@Controller
public class HistoryController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/index")
    public ModelAndView history() {
        ModelAndView mv = new ModelAndView("/history/index");
        List<MemberReportDto> historyDtos= orderService.getOrderHistory();
        mv.addObject("histories",historyDtos);
        return mv;
    }


}
