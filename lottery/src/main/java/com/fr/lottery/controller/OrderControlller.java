package com.fr.lottery.controller;

import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.service.impl.OrderService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.RequestDataUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/22.
 */
@RequestMapping("order")
@Controller
public class OrderControlller {
    private IOrderService orderService;
    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/order/list");
        return mv;
    }

    @RequestMapping("/order")
    public ModelAndView order() {
        ModelAndView mv = new ModelAndView("/order/order");
        return mv;
    }

    @RequestMapping("/saveOrder")
    public void saveOrder(OrderDto orderDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");
        response.setContentType("text/html;charset=UTF-8");
        boolean isSuccess=orderService.save(orderDto);
        if(isSuccess){
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\""+referer+"\"</script>");
        }
        else{
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }

    }
}
