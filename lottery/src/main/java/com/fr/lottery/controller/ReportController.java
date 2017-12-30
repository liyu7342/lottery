package com.fr.lottery.controller;

import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.entity.OrderDetail;
import com.fr.lottery.entity.Orders;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IReportService;
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
    @Autowired
    private IOrderService orderService;

//    @Autowired
//    private IReportService reportService;
    @RequestMapping("/report")
    public ModelAndView report(){
        ModelAndView modelAndView = new ModelAndView("/report/report");
        List<String>  datelist = new ArrayList<String>();
        Page<Handicap>  page= handicapService.getHandicaps(1,3);
        for(Handicap handicap : page.getList()){
            datelist.add(handicap.getRiqi());
        }
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

    @RequestMapping("z_dagudong")
    public ModelAndView z_dagudong(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_gudong");

        return modelAndView;
    }

    @RequestMapping("z_gudong")
    public ModelAndView z_gudong(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
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
    public ModelAndView z_member(String draw_date,String draw_date2,Integer type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_member");
       // List<MemberReportDto> reportDtos =reportService.getMemberReportDto(id,__account,__name,p_level,type,draw_date,draw_date2);
        modelAndView.addObject("account",__account);
        modelAndView.addObject("name",__name);
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @RequestMapping("/reportmingxi")
    public ModelAndView reportmingxi(String draw_date0,String type,String p_level,String __account,String __name,String id) {
        ModelAndView modelAndView = new ModelAndView("/report/reportmingxi");
        User user = UserHelper.getCurrentUser();
        List<String> banners = new ArrayList<String>();
        banners.add("下註明細--會員： "+__name+"."+__account +" -- 期数日期："+draw_date0+"&nbsp;&nbsp;");
        if(user.getUsertype()>-1){
            banners.add("<a href=\"/report/z_dagongdu?draw_date="+draw_date0+"&draw_date2="+draw_date0+"\">大股東</a>");
        }
        if(user.getUsertype()>0){
            banners.add("href=\"/report/z_gudong?draw_date=${draw_date}&draw_date2=${draw_date}&type=1&p_level=${p_level}&__account=${zongdaiAccount} &__name=${zongdaiName}&id=${zongdaiId}\">總代</a>");
        }
        if(user.getUsertype()>1){
            banners.add("href=\"/report/z_zongdaili?draw_date=${draw_date}&draw_date2=${draw_date}&type=1&p_level=${p_level}&__account=${zongdaiAccount} &__name=${zongdaiName}&id=${zongdaiId}\">總代</a>");
        }
        if(user.getUsertype()>2){
            banners.add("href=\"/report/z_daili?draw_date=${draw_date}&draw_date2=${draw_date}&type=1&p_level=${p_level}&__account=${zongdaiAccount} &__name=${zongdaiName}&id=${zongdaiId}\">總代</a>");
        }
        if(user.getUsertype()>2){
            banners.add("href=\"/report/z_daili?draw_date=${draw_date}&draw_date2=${draw_date}&type=1&p_level=${p_level}&__account=${zongdaiAccount} &__name=${zongdaiName}&id=${zongdaiId}\">總代</a>");
        }
//         <a href="/report/user_report?draw_date=${draw_date}&draw_date2=${draw_date}">股東</a>-><a
//                href="/report/z_zongdaili?draw_date=${draw_date}&draw_date2=${draw_date}&type=1&p_level=${p_level}&__account=${zongdaiAccount} &__name=${zongdaiName}&id=${zongdaiId}">總代</a>-><a
//                href="/reports/z_daili?draw_date=${draw_date}&draw_date2=${draw_date}&type=1&p_level=${p_level}&__account=${dailiAccount}&__name=${dailiName}&id=${dailiId}">代理</a>->
        modelAndView.addObject("");
        modelAndView.addObject("");
        modelAndView.addObject("");
        modelAndView.addObject("");
        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(String sub,String draw_date,String order_id){
        ModelAndView modelAndView = new ModelAndView("report/detail");
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
                    bodyList.add("<td width=\"20%\">"+orderDetails.get(index).getGameDesc()+"</td>");
                }
                else{
                    bodyList.add("<td width=\"20%\">&nbsp;</td>");
                }
                index++;
            }
            bodyList.add("</tr>");
        }
        modelAndView.addObject("orders",orders);
        modelAndView.addObject("bodyStr", org.apache.commons.lang3.StringUtils.join(bodyList, "\r\n"));
        modelAndView.addObject("size",orderDetails.size());
        return modelAndView;
    }
}
