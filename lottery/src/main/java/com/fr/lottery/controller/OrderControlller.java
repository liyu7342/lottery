package com.fr.lottery.controller;

import com.fr.lottery.dto.OrderDetailDto;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.OrderDetail;
import com.fr.lottery.entity.Orders;
import com.fr.lottery.entity.User;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
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
        User user = UserHelper.getCurrentUser();
        Page<Orders> orderDetails = orderService.getOrders(id,pageId,categoryId,user.getId());
        mv.addObject("orderList",orderDetails.getList());
        mv.addObject("page", orderDetails.toString());
        Integer subsum=0;
        Float subCanWinAmount =0F;
        Float subWinAmount =0F;
        for(Orders orderDetail : orderDetails.getList()){
            if(StringUtils.isNotBlank(orderDetail.getOddset()) && orderDetail.getOddset().length()>1){
                char oddset[] =orderDetail.getOddset().toCharArray();
                orderDetail.setOddset(oddset[0]+ "(特"+oddset[1]+")" );
            }
            subsum +=orderDetail.getTotalAmount();
            subCanWinAmount+= (orderDetail.getCanWinAmount()==null?0:orderDetail.getCanWinAmount()+orderDetail.getRetreatAmt());
            subWinAmount += (orderDetail.getWinAmount()==null?0:orderDetail.getWinAmount() )+orderDetail.getRetreatAmt();
        }
        Orders orderDetail = orderService.getTotal(id,categoryId);

        Map<String,Object> map = new HashedMap();

        map.put("credit", user.getCredits());
        map.put("marquee","欢迎进入前台");
        map.put("draws","");
        map.put("calc_status",0);
        map.put("fail_count",0);
        List<List<String>> new_order = new ArrayList<List<String>>();
        if(StringUtils.isNotBlank(id)){
            map.put("sum",0);
            map.put("new_order",new_order);
        }else{
            Page<Orders> new_orders = orderService.getOrders(id,1,categoryId,user.getId(), Global.pageSizeOfTen);
            for (Orders detail : new_orders.getList()) {
                List<String> detailArr = new ArrayList<String>();
                detailArr.add(detail.getDescription());
                detailArr.add(detail.getTotalAmount().toString());
                detailArr.add(detail.getOdds().toString());

                new_order.add(detailArr);
            }
            map.put("new_order",new_order);
            map.put("sum",user.getAmount());

        }
        mv.addObject("headinfo", JsonUtil.toJson( map));


        mv.addObject("subSum",subsum);
        mv.addObject("totalAmount",orderDetail==null?0:orderDetail.getTotalAmount());
        mv.addObject("canWinAmount",orderDetail==null?0:orderDetail.getCanWinAmount());
        mv.addObject("winAmount",orderDetail==null?0:orderDetail.getWinAmount());
        mv.addObject("subCanWinAmount",subCanWinAmount);
        mv.addObject("subWinAmount",subWinAmount);
        mv.addObject("id",id);
        mv.addObject("user",user);
        if(categoryId == null){
            categoryId="";
        }
        mv.addObject("categoryId",categoryId);
        return mv;
    }

    @RequestMapping("/fail_list")
    public ModelAndView faillist(String categoryId,Integer pageId,String id) {
        if(id==null) id="";
        ModelAndView mv = new ModelAndView("/order/fail_list");
        User user = UserHelper.getCurrentUser();
        Page<Orders> orderDetails =  new Page<Orders>();//orderService.getOrders(id,pageId,categoryId,user.getId());
        orderDetails.setList( new ArrayList<Orders>());
        mv.addObject("orderList",orderDetails.getList());
        mv.addObject("page", orderDetails.toString());
        Integer subsum=0;
        Float subCanWinAmount =0F;
        Float subWinAmount =0F;
        for(Orders orderDetail : orderDetails.getList()){
            if(StringUtils.isNotBlank(orderDetail.getOddset()) && orderDetail.getOddset().length()>1){
                char oddset[] =orderDetail.getOddset().toCharArray();
                orderDetail.setOddset(oddset[0]+ "(特"+oddset[1]+")" );
            }
            subsum +=orderDetail.getTotalAmount();
            subCanWinAmount+= (orderDetail.getCanWinAmount()==null?0:orderDetail.getCanWinAmount()+orderDetail.getRetreatAmt());
            subWinAmount += (orderDetail.getWinAmount()==null?0:orderDetail.getWinAmount() )+orderDetail.getRetreatAmt();
        }
       // Orders orderDetail = orderService.getTotal(id,categoryId);

        Map<String,Object> map = new HashedMap();

        map.put("credit", user.getCredits());
        map.put("marquee","欢迎进入前台");
        map.put("draws","");
        map.put("calc_status",0);
        map.put("fail_count",0);
        List<List<String>> new_order = new ArrayList<List<String>>();
        if(StringUtils.isNotBlank(id)){
            map.put("sum",0);
            map.put("new_order",new_order);
        }else{
            Page<Orders> new_orders = orderService.getOrders(id,1,categoryId,user.getId(), Global.pageSizeOfTen);
            for (Orders detail : new_orders.getList()) {
                List<String> detailArr = new ArrayList<String>();
                detailArr.add(detail.getDescription());
                detailArr.add(detail.getTotalAmount().toString());
                detailArr.add(detail.getOdds().toString());

                new_order.add(detailArr);
            }
            map.put("new_order",new_order);
            map.put("sum",user.getAmount());

        }
        mv.addObject("headinfo", JsonUtil.toJson( map));


        mv.addObject("subSum",subsum);
        mv.addObject("totalAmount",0);
        mv.addObject("canWinAmount",0);
        mv.addObject("winAmount",0);
        mv.addObject("subCanWinAmount",subCanWinAmount);
        mv.addObject("subWinAmount",subWinAmount);
        mv.addObject("id",id);
        if(categoryId == null){
            categoryId="";
        }
        mv.addObject("categoryId",categoryId);
        return mv;
    }



    @RequestMapping("/order")
    public ModelAndView order() {
        ModelAndView mv = new ModelAndView("/order/order");
        return mv;
    }

    /**
     * -1000 5秒内重复单据
     * -9999 重复数据，询问是否继续
     * -999 不是開盤時間
     * -1124 信用额度不足
     * 小于-1000
     * @param orderDto
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveOrder")
    public Map<String,Object> saveOrder(OrderDto orderDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String referer = request.getHeader("Referer");
        response.setContentType("text/html;charset=UTF-8");
        Integer result=orderService.save(orderDto);

        User user =UserHelper.getCurrentUser();
        Map<String,Object> map = new HashedMap();

        map.put("credit_error",result== -1124?"信用額度不足":result==-1001?"尚未開盤":"");
        map.put("return_str", result==1?"0|;1|1;2|;3|;4|;5|;6|;7|;8|;9|;10|;" : result+"|1;1|;2|;3|;4|;5|;6|;7|;8|;9|;10|;");
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
        Float subShareTotal=0F;
        Page<OrderDetailDto> page = orderService.getOrderDetailsByDaili(game_id,number,name,pageId);
        modelAndView.addObject("details",page.getList());
        modelAndView.addObject("page",page.toString());
        modelAndView.addObject("name",name);
        for(OrderDetailDto detailDto:page.getList()){
            subAmount+=detailDto.getAmount();
            if (detailDto.getShareTotal()==null){
                detailDto.setShareTotal(0F);
            }
            else{
                subShareTotal+=detailDto.getShareTotal();
            }
        }
        modelAndView.addObject("subAmount",subAmount);
        modelAndView.addObject("subShareTotal",subShareTotal);
        OrderDetailDto orderDetailDto = orderService.getStatsByDaili(game_id,number);
        if(orderDetailDto==null){
            orderDetailDto = new OrderDetailDto();
            orderDetailDto.setShareTotal(0f);
            orderDetailDto.setAmount(0);
        }
        modelAndView.addObject("totalAmount",orderDetailDto.getAmount());
        modelAndView.addObject("totalShareTotal",orderDetailDto.getShareTotal()==null?0F:orderDetailDto.getShareTotal());
        return  modelAndView;
    }

    @RequestMapping("/detail")
    public  ModelAndView detail(String order_id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        ModelAndView modelAndView = new ModelAndView("/order/detail") ;
        Orders orders = orderService.getOrdersByOrderNo(order_id );
        List<OrderDetail> orderDetails= orderService.getOrderDetailsByOrderId(orders.getId());
        Integer index=0;
        List<String> bodyList = new ArrayList<String>();
        Integer size= orderDetails.size() /5 ;
        if(orderDetails.size()%5!=0){
            size++;
        }
        for(Integer i=0;i<size;i++){
            bodyList.add("<tr>");
            for(Integer j=0;j<5;j++){
                if(index<orderDetails.size()){
                    bodyList.add("<td width=\"20%\"><em>"+orderDetails.get(index).getGameDesc()+"</em>("+orderDetails.get(index).getOdds()+")</td>");
                }
                else{
                    bodyList.add("<td width=\"20%\">&nbsp;</td>");
                }
                index++;
            }
            bodyList.add("</tr>");
        }
        modelAndView.addObject("orders",orders);
        modelAndView.addObject("size",orderDetails.size());
        modelAndView.addObject("bodyStr", org.apache.commons.lang3.StringUtils.join(bodyList, "\r\n"));
        return  modelAndView;
    }



    public static void main(String[] args) {

    }


}
