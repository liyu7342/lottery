package com.fr.lottery.controller;

import com.fr.lottery.dao.OrdersMapper;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.service.impl.OrderService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.RequestDataUtils;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/22.
 */
@RequestMapping("order")
@Controller
public class OrderControlller {
    @Autowired
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

    @ResponseBody
    @RequestMapping("/saveOrder")
    public Map<String,Object> saveOrder(OrderDto orderDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String referer = request.getHeader("Referer");
        response.setContentType("text/html;charset=UTF-8");
        boolean isSuccess=orderService.save(orderDto);
        Map<String,Object> map = new HashedMap();
        map.put("credit_error","3");
        map.put("return_str",isSuccess?"0|;1|1;2|;3|;4|;5|;6|;7|;8|;9|;10|;":"0|1;1|;2|;3|;4|;5|;6|;7|;8|;9|;10|;");
        map.put("item_error",new ArrayList<Integer>());
        map.put("limit","1");
        map.put("sum",orderDto.getOrder_allamount());
        map.put("credit", UserHelper.getCurrentUser().getCredits());
        map.put("versionNumber",3);
        map.put("oddschg","2");
        return map;
//        {"credit_error":"","return_str":"0|;1|1;2|;3|;4|;5|;6|;7|;8|;9|;10|;","item_error":[],"fail_count":0,"limit":"","sum":2,"credit":500,"versionNumber":3,"oddschg":""}

    }

    public static void main(String[] args) {

    }
}
