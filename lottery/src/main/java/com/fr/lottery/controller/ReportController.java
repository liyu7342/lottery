package com.fr.lottery.controller;

import com.fr.lottery.dto.DailiReportDto;
import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.ZongdaiReportDto;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.entity.OrderDetail;
import com.fr.lottery.entity.Orders;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IReportService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Model;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    @Autowired
    private IUserService userService;

    @Autowired
    private IReportService reportService;
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
        //ModelAndView modelAndView = new ModelAndView("/report/user_report");
        User user = UserHelper.getCurrentUser();
        String reqUrl;
        if(user.getUsertype() == UserTypeEnum.Admin.ordinal()){
            reqUrl ="/report/z_admin?draw_date=" + draw_date + "&draw_date2=" + draw_date + "&type=1&p_level=0&__account=" + user.getAccount()+ " &__name=" + user.getUserName() + "&id=" + user.getId();
        }
        else if(user.getUsertype() == UserTypeEnum.DaGudong.ordinal()){
            reqUrl ="/report/z_dagudong?draw_date=" + draw_date + "&draw_date2=" + draw_date + "&type=1&p_level=0&__account=" + user.getAccount()+ " &__name=" + user.getUserName() + "&id=" + user.getId();
        }
        else if(user.getUsertype() == UserTypeEnum.XiaoGudong.ordinal()){
            reqUrl ="/report/z_gudong?draw_date=" + draw_date + "&draw_date2=" + draw_date + "&type=1&p_level=0&__account=" + user.getAccount()+ " &__name=" + user.getUserName() + "&id=" + user.getId();
        }
        else if(user.getUsertype() == UserTypeEnum.ZongDaili.ordinal()){
            reqUrl ="/report/z_zongdaili?draw_date=" + draw_date + "&draw_date2=" + draw_date + "&type=1&p_level=0&__account=" + user.getAccount()+ " &__name=" + user.getUserName() + "&id=" + user.getId();
        }
        else if(user.getUsertype() == UserTypeEnum.Daili.ordinal()){
            reqUrl ="/report/z_daili?draw_date=" + draw_date + "&draw_date2=" + draw_date + "&type=1&p_level=0&__account=" + user.getAccount()+ " &__name=" + user.getUserName() + "&id=" + user.getId();
        }
        else{
            reqUrl ="/report/z_member?draw_date=" + draw_date + "&draw_date2=" + draw_date + "&type=1&p_level=0&__account=" + user.getAccount()+ " &__name=" + user.getUserName() + "&id=" + user.getId();
        }
        reqUrl="redirect:"+reqUrl;
        ModelAndView modelAndView = new ModelAndView(reqUrl);
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
        String handicapId ="";
        handicapId = handicapService.getHandicapByRiqi(draw_date).getId();
        List<ZongdaiReportDto> reportDtos = reportService.getZongDaiReport(handicapId,id);
        ZongdaiReportDto reportTotal = new ZongdaiReportDto();
        for(ZongdaiReportDto reportDto : reportDtos){
            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
            reportTotal.setMemberCount(reportTotal.getMemberCount() +reportDto.getMemberCount());
            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
            reportTotal.setMemberActualAmt( reportTotal.getMemberActualAmt()+reportDto.getMemberActualAmt());
            reportTotal.setDailiToParentShareUp(reportTotal.getDailiToParentShareUp() + reportDto.getDailiToParentShareUp());
            reportTotal.setDailiToParentWinamt(reportTotal.getDailiToParentWinamt()+ reportDto.getDailiToParentWinamt());
            reportTotal.setZhancheng(reportTotal.getZhancheng() +reportDto.getZhancheng());
            reportTotal.setZongdaiRetreat(reportTotal.getZongdaiRetreat()+reportTotal.getZongdaiRetreat());
            reportTotal.setZongdaiWinamt(reportTotal.getZongdaiWinamt()+ reportDto.getZongdaiWinamt());
            reportTotal.setParentShareUp(reportTotal.getParentShareUp()+reportDto.getParentShareUp());
            reportTotal.setParentWinamt(reportTotal.getParentWinamt()+reportDto.getParentWinamt());
        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapId",handicapId);
        modelAndView.addObject("reportTotal",reportTotal);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
        return modelAndView;
    }

    @RequestMapping("/z_daili")
    public ModelAndView z_daili(String draw_date,String draw_date2,String handicapid,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_daili");
        if(StringUtils.isBlank(handicapid)){
            handicapid = handicapService.getHandicapByRiqi(draw_date).getId();
        }
        List<DailiReportDto> reportDtos = reportService.getDailiReport(handicapid,id);
        DailiReportDto reportTotal = new DailiReportDto();
        for(DailiReportDto reportDto : reportDtos){
            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
            reportTotal.setWinAmount(reportTotal.getWinAmount()+reportDto.getWinAmount());
            reportTotal.setRetreat(reportTotal.getRetreat()+reportDto.getRetreat());
            reportTotal.setMemberActualAmt(reportTotal.getMemberActualAmt()+reportDto.getMemberActualAmt());
            reportTotal.setZhancheng(reportTotal.getZhancheng()+reportDto.getZhancheng());
            reportTotal.setDailiretreat(reportTotal.getDailiretreat()+reportDto.getDailiretreat());
            reportTotal.setDailiwinamt(reportTotal.getDailiwinamt()+reportDto.getDailiwinamt());
            reportTotal.setParentShareUp(reportTotal.getParentShareUp()+reportDto.getParentShareUp());
            reportTotal.setParentWinAmt(reportTotal.getParentWinAmt()+reportDto.getParentWinAmt());
        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapid",handicapid);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
        modelAndView.addObject("reportTotal",reportTotal);
        return modelAndView;
    }

    @RequestMapping("/z_member")
    public ModelAndView z_member(String draw_date,String draw_date2,Integer type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_member");
        User user = UserHelper.getCurrentUser();
        List<String> banners = new ArrayList<String>();
        User member = userService.get(id);

        banners.add("下註明細--會員： "+member.getUserName()+"."+__account +" -- 日期範圍："+draw_date+" ~ "+draw_date2);
        banners.add(" -- 報表分類：總賬 -- ");
        if(user.getUsertype()==0){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            User dagudong = userService.get(member.getDagudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">管理員</a>");
            banners.add("<a href=\"/report/z_dagongdu?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a>");
            banners.add("<a href=\"/report/z_gongdu?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a>");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a>");
        }
        else if(user.getUsertype()==1){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">大股東</a>");
            banners.add("<a href=\"/report/z_gongdu?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a>");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a>");
        }
        else if(user.getUsertype()==2){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">股東</a>");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a>");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a>");
        }
        else if(user.getUsertype()==3){
            User daili  =userService.get(member.getDailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">總代</a>");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a>");
        }
        else if(user.getUsertype()==4){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">代理商</a>");
        }
        List<MemberReportDto> memberReportDtos =orderService.getOrderHistoryByRiqi(id,draw_date,draw_date2);
        modelAndView.addObject("banner", StringUtils.join(banners," "));
        modelAndView.addObject("id",id);
        modelAndView.addObject("page",new Page<MemberReportDto>(1,20,memberReportDtos.size()).toString());
        modelAndView.addObject("__account",__account);
        modelAndView.addObject("__name",member.getUserName());
        modelAndView.addObject("orders",memberReportDtos);
        Integer totalAmount = 0;
        Integer orderNum=0;
        Float winAmount =0F;
        for(MemberReportDto reportDto: memberReportDtos){
          totalAmount+=  reportDto.getAmount();
           winAmount += (reportDto.getWinAmount()==null?0:reportDto.getWinAmount());
            orderNum +=reportDto.getOrderNum();
        }

        //Orders orderDetail = orderService.getTotal(id,"",id);
        modelAndView.addObject("totalAmount",totalAmount);
        modelAndView.addObject("winAmount",winAmount);
        modelAndView.addObject("orderNum",orderNum);
//        modelAndView.addObject("winAmount",orderDetail==null?0:orderDetail.getWinAmount());
        return modelAndView;
    }

    @RequestMapping("/reportmingxi")
    public ModelAndView reportmingxi(String draw_date0,String draw_id,String type,String p_level,String __account,String __name,String id,Integer pageId) {
        ModelAndView modelAndView = new ModelAndView("/report/reportmingxi");
        User user = UserHelper.getCurrentUser();
        List<String> banners = new ArrayList<String>();
        User member = userService.get(id);

//        try{
//            __name = URLDecoder.decode(__name, "utf-8");
//        }
//        catch (UnsupportedEncodingException ex){
//            ex.printStackTrace();
//        }

        banners.add("下註明細--會員： "+member.getUserName()  +"."+__account +" -- 期数日期："+draw_date0+"&nbsp;&nbsp;");
        if(user.getUsertype()==0){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            User dagudong = userService.get(member.getDagudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">管理員</a> -> ");
            banners.add("<a href=\"/report/z_dagongdu?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gongdu?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a> -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==1){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">大股東</a>");
            banners.add("<a href=\"/report/z_gongdu?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a> -> " );
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==2){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">股東</a> -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==3){
            User daili  =userService.get(member.getDailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==4){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">代理商</a> -> ");
        }
        modelAndView.addObject("banner", StringUtils.join(banners," "));
        if(pageId==null) pageId=1;
        Page<Orders> page = orderService.getOrders(draw_id,pageId,"",id, Global.pageSize);
        modelAndView.addObject("page",page.toString());
        modelAndView.addObject("orderList",page.getList());
        Orders orderDetail = orderService.getTotal(draw_id,"",id);
        modelAndView.addObject("totalAmount",orderDetail==null?0:orderDetail.getTotalAmount());
        modelAndView.addObject("winAmount",orderDetail==null?0:orderDetail.getWinAmount()!=null?orderDetail.getWinAmount():orderDetail.getCanWinAmount());
        modelAndView.addObject("id",id);
        modelAndView.addObject("__account",__account);
        modelAndView.addObject("__name",member.getUserName());
        modelAndView.addObject("draw_date0",draw_date0);
        modelAndView.addObject("draw_id",draw_id);
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
