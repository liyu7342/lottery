package com.fr.lottery.controller;

import com.fr.lottery.dto.OrderDetailDto;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.OrderDetail;
import com.fr.lottery.entity.Orders;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.UserHelper;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
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
    public ModelAndView list(String categoryId,Integer pageId,String id) {
        if(id==null) id="";
        ModelAndView mv = new ModelAndView("/order/list");
        Page<Orders> orderDetails = orderService.getOrders(id,pageId,categoryId);
        mv.addObject("orderList",orderDetails.getList());
        mv.addObject("page", orderDetails.toString());
        Integer subsum=0;
        Float subCanWinAmount =0F;
        Float subWinAmount =0F;
        for(Orders orderDetail : orderDetails.getList()){
            subsum +=orderDetail.getTotalAmount();
            subCanWinAmount+= (orderDetail.getCanWinAmount()==null?0:orderDetail.getCanWinAmount());
            subWinAmount += (orderDetail.getWinAmount()==null?0:orderDetail.getWinAmount());
        }
        Orders orderDetail = orderService.getTotal(id,categoryId);
        User user = UserHelper.getCurrentUser();

        Map<String,Object> map = new HashedMap();
        map.put("sum",user.getAmount());
        map.put("credit", user.getCredits());
        map.put("marquee","欢迎进入前台");
        map.put("draws","");

        map.put("calc_status",20);
        map.put("fail_count",0);
        List<List<String>> new_order = new ArrayList<List<String>>();
        Page<Orders> new_orders = orderService.getOrders(id,1,categoryId);
        for (Orders detail : new_orders.getList()) {
            List<String> detailArr = new ArrayList<String>();
            detailArr.add(detail.getDescription());
            detailArr.add(detail.getTotalAmount().toString());
            detailArr.add(detail.getOdds().toString());

            new_order.add(detailArr);
        }
        map.put("new_order",new_order);
        mv.addObject("headinfo", JsonUtil.toJson( map));
        mv.addObject("subSum",subsum);
        mv.addObject("totalAmount",orderDetail==null?0:orderDetail.getTotalAmount());
        mv.addObject("canWinAmount",orderDetail==null?0:orderDetail.getCanWinAmount());
        mv.addObject("winAmount",orderDetail==null?0:orderDetail.getWinAmount());
        mv.addObject("subCanWinAmount",subCanWinAmount);
        mv.addObject("subWinAmount",subWinAmount);
        mv.addObject("id",id);

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
        User user =UserHelper.getCurrentUser();
        Map<String,Object> map = new HashedMap();
        map.put("credit_error","3");
        map.put("return_str",isSuccess?"0|;1|1;2|;3|;4|;5|;6|;7|;8|;9|;10|;":"0|1;1|;2|;3|;4|;5|;6|;7|;8|;9|;10|;");
        map.put("item_error",new ArrayList<Integer>());
        map.put("limit","1");
        map.put("sum",user.getAmount());
        map.put("credit", user.getCredits());
        map.put("versionNumber",3);
        map.put("oddschg","");
        return map;
//        {"credit_error":"","return_str":"0|;1|1;2|;3|;4|;5|;6|;7|;8|;9|;10|;","item_error":[],"fail_count":0,"limit":"","sum":2,"credit":500,"versionNumber":3,"oddschg":""}

    }

    @RequestMapping("/xiazhumingxi")
    public  ModelAndView xiazhumingxi(String game_id,String number,String name,Integer pageId,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        ModelAndView modelAndView = new ModelAndView("/order/xiazhumingxi") ;
        name = URLDecoder.decode(name, "utf-8");
        if(pageId==null) pageId=1;
        Integer subAmount =0;
        Integer subShareTotal=0;
        Page<OrderDetailDto> page = orderService.getOrderDetailsByDaili(game_id,number,name,pageId);
        modelAndView.addObject("details",page.getList());
        modelAndView.addObject("page",page.toString());
        modelAndView.addObject("name",name);
        for(OrderDetailDto detailDto:page.getList()){
            subAmount+=detailDto.getAmount();
            subShareTotal+=detailDto.getShareTotal().intValue();
        }
        modelAndView.addObject("subAmount",subAmount);
        modelAndView.addObject("subShareTotal",subShareTotal);
        OrderDetailDto orderDetailDto = orderService.getStatsByDaili(game_id,number);
        modelAndView.addObject("totalAmount",orderDetailDto.getAmount());
        modelAndView.addObject("totalShareTotal",orderDetailDto.getShareTotal());
        return  modelAndView;
    }

    public static void main(String[] args) {

    }
}
