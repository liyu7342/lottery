package com.fr.lottery.controller;

import com.fr.lottery.dto.*;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IReportService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
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
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
         cal.set(Calendar.DAY_OF_MONTH,1);
        String riqi = DateTimeUtils.Date2StringSimple(cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String riqi2 =DateTimeUtils.Date2StringSimple(cal.getTime());
        User user = UserHelper.getCurrentUser();
        List<ReportMonthDto> reportMonthDtos;
        if(UserTypeEnum.Daili.ordinal()== user.getUsertype()){
            reportMonthDtos= reportService.getDailiReportMonth(riqi,riqi2,user.getId());
        }
        else if(UserTypeEnum.ZongDaili.ordinal()== user.getUsertype()){
            reportMonthDtos= reportService.getZongdaiReportMonth(riqi,riqi2,user.getId());
        }
        else if( UserTypeEnum.XiaoGudong.ordinal()== user.getUsertype()){
            reportMonthDtos= reportService.getGudongReportMonth(riqi,riqi2,user.getId());
        }else if(UserTypeEnum.DaGudong.ordinal()== user.getUsertype()){
            reportMonthDtos= reportService.getDagudongReportMonth(riqi,riqi2,user.getId());
        }
        else {
            reportMonthDtos= new ArrayList<ReportMonthDto>();
        }
        modelAndView.addObject("currentMonth",month);
        modelAndView.addObject("reportList",reportMonthDtos);
        ReportMonthDto reportTotal =new ReportMonthDto();
        for(ReportMonthDto reportMonthDto : reportMonthDtos){
            reportTotal.setOrderNum(reportMonthDto.getOrderNum()+reportTotal.getOrderNum());
            reportTotal.setAmount(reportMonthDto.getAmount()+ reportTotal.getAmount());
            reportTotal.setMemberWinamt(reportMonthDto.getMemberWinamt()+reportTotal.getMemberWinamt());
            reportTotal.setRetreat(reportMonthDto.getRetreat()+reportTotal.getRetreat());
            reportTotal.setRetreatDiff(reportMonthDto.getRetreatDiff()+reportTotal.getRetreatDiff());
            reportTotal.setZhancheng(reportMonthDto.getZhancheng()+reportTotal.getZhancheng());
            reportTotal.setUserWinamt(reportMonthDto.getUserWinamt()+reportTotal.getUserWinamt());
            reportTotal.setUserTotalamt(reportMonthDto.getUserTotalamt()+reportTotal.getUserTotalamt());
        }
        modelAndView.addObject("reportTotal",reportTotal);
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

    @RequestMapping("/z_admin")
    public ModelAndView z_admin(String draw_date,String draw_date2){
           ModelAndView modelAndView = new ModelAndView("/report/z_admin") ;
           String handicapId = handicapService.getHandicapByRiqi(draw_date).getId();
        List<GudongReport> reportDtos = reportService.getAdminReport(handicapId);
        GudongReport reportTotal = new GudongReport();
//        for(GudongReport reportDto : reportDtos){
//            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
//            reportTotal.setMemberCount(reportTotal.getMemberCount() +reportDto.getMemberCount());
//            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
//            reportTotal.setMemberActualAmt( reportTotal.getMemberActualAmt()+reportDto.getMemberActualAmt());
//            reportTotal.setZongdaiToParentShareUp(reportTotal.getZongdaiToParentShareUp() + reportDto.getZongdaiToParentShareUp());
//            reportTotal.setZongdaiToParentWinamt(reportTotal.getZongdaiToParentWinamt()+ reportDto.getZongdaiToParentWinamt());
//            reportTotal.setZhancheng(reportTotal.getZhancheng() +reportDto.getZhancheng());
//            reportTotal.setGudongRetreat(reportTotal.getGudongRetreat()+reportDto.getGudongRetreat());
//            reportTotal.setGudongWinamt(reportTotal.getGudongWinamt()+ reportDto.getGudongWinamt());
//            reportTotal.setParentShareUp(reportTotal.getParentShareUp()+reportDto.getParentShareUp());
//            reportTotal.setParentWinamt(reportTotal.getParentWinamt()+reportDto.getParentWinamt());
//        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapId",handicapId);
        modelAndView.addObject("reportTotal",reportTotal);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
           return modelAndView;
    }

    @RequestMapping("z_dagudong")
    public ModelAndView z_dagudong(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_dagudong");
        String handicapId ="";
        handicapId = handicapService.getHandicapByRiqi(draw_date).getId();
        List<DagudongReport> reportDtos = reportService.getDagudongReport(handicapId,id);
        DagudongReport reportTotal = new DagudongReport();
        for(DagudongReport reportDto : reportDtos){
            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
            reportTotal.setMemberCount(reportTotal.getMemberCount() +reportDto.getMemberCount());
            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
            reportTotal.setMemberAmt( reportTotal.getMemberAmt()+reportDto.getMemberAmt());
            reportTotal.setGudongToParent(reportTotal.getGudongToParent()+ reportDto.getGudongToParent());
            reportTotal.setGudongToParentWinamt(reportTotal.getGudongToParentWinamt()+ reportDto.getGudongToParentWinamt());

            reportTotal.setDagudongAmt(reportTotal.getDagudongAmt() +reportDto.getDagudongAmt());
            reportTotal.setDagudongRetreat(reportTotal.getDagudongRetreat()+reportDto.getDagudongRetreat());
            reportTotal.setDagudongRetreatDiff(reportTotal.getDagudongRetreatDiff()+reportDto.getDagudongRetreatDiff());
            reportTotal.setDagudongWinamt(reportTotal.getDagudongWinamt()+ reportDto.getDagudongWinamt());
            reportTotal.setDagudongTotalamt(reportTotal.getDagudongTotalamt()+ reportDto.getDagudongTotalamt());
            reportTotal.setGuanliyuanAmt(reportTotal.getGuanliyuanAmt()+reportDto.getGuanliyuanAmt());
            reportTotal.setGuanliyuanWinAmt(reportTotal.getGuanliyuanWinAmt()+reportDto.getGuanliyuanWinAmt());
        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapId",handicapId);
        modelAndView.addObject("reportTotal",reportTotal);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
        List<String> banners = new ArrayList<String>();
        User user = UserHelper.getCurrentUser();
        User dagudong  = userService.get(id);
        banners.add("大股東[<span class=\"greenrpt\">"+dagudong.getUserName()+"</span>]"+dagudong.getAccount() +" -- 日期範圍："+draw_date+" ~ "+draw_date2);
        banners.add(" -- 報表分類：總賬 -- ");
        if(user.getUsertype()==0){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">管理員</a> -> ");
        }
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
        }
        modelAndView.addObject("banners",StringUtils.join(banners,""));
        return modelAndView;
    }

    @RequestMapping("z_gudong")
    public ModelAndView z_gudong(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_gudong");
        String handicapId ="";
        handicapId = handicapService.getHandicapByRiqi(draw_date).getId();
        List<GudongReport> reportDtos = reportService.getGudongReport(handicapId,id);
        GudongReport reportTotal = new GudongReport();
        for(GudongReport reportDto : reportDtos){
            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
            reportTotal.setMemberCount(reportTotal.getMemberCount() +reportDto.getMemberCount());
            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
            reportTotal.setMemberAmt( reportTotal.getMemberAmt()+reportDto.getMemberAmt());
            reportTotal.setZongdaiToGudong(reportTotal.getZongdaiToGudong() + reportDto.getZongdaiToGudong());
            reportTotal.setDailiToZongdai(reportTotal.getDailiToZongdai()+ reportDto.getDailiToZongdai());
            reportTotal.setGudongAmt(reportTotal.getGudongAmt() +reportDto.getGudongAmt());
            reportTotal.setGudongRetreat(reportTotal.getGudongRetreat()+reportDto.getGudongRetreat());
            reportTotal.setGudongRetreatDiff(reportTotal.getGudongRetreatDiff()+reportDto.getGudongRetreatDiff());
            reportTotal.setGudongWinamt(reportTotal.getGudongWinamt()+ reportDto.getGudongWinamt());
            reportTotal.setGudongTotalamt(reportTotal.getGudongTotalamt()+reportDto.getGudongTotalamt());
            reportTotal.setDagudongAmt(reportTotal.getDagudongAmt()+reportDto.getDagudongAmt());
            reportTotal.setDagudongWinAmt(reportTotal.getDagudongWinAmt()+reportDto.getDagudongWinAmt());
        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapId",handicapId);
        modelAndView.addObject("reportTotal",reportTotal);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
        List<String> banners = new ArrayList<String>();

        User user = UserHelper.getCurrentUser();
        User gudong = userService.get(id);
        banners.add("股東[<span class=\"greenrpt\">"+gudong.getUserName()+"</span>]"+gudong.getAccount() +" -- 日期範圍："+draw_date+" ~ "+draw_date2);
        banners.add(" -- 報表分類：總賬 -- ");
        if(user.getUsertype()==0){
            User dagudong = userService.get(gudong.getDagudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">管理員</a> -> ");
            banners.add("<a href=\"/report/z_dagudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a>  -> ");

        }
        else if(user.getUsertype()==1){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">大股東</a> -> " );
        }
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
        }
        modelAndView.addObject("banners",StringUtils.join(banners,""));
        return modelAndView;
    }
    @RequestMapping("/z_zongdaili")
    public ModelAndView z_zongdaili(String draw_date,String draw_date2,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_zongdaili");
        String handicapId ="";
        handicapId = handicapService.getHandicapByRiqi(draw_date).getId();
        List<ZongdaiReport> reportDtos = reportService.getZongDaiReport(handicapId,id);
        ZongdaiReport reportTotal = new ZongdaiReport();
        for(ZongdaiReport reportDto : reportDtos){
            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
            reportTotal.setMemberCount(reportTotal.getMemberCount() +reportDto.getMemberCount());
            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
            reportTotal.setMemberAmt( reportTotal.getMemberAmt()+reportDto.getMemberAmt());
            reportTotal.setDailiToZongdai(reportTotal.getDailiToZongdai() + reportDto.getDailiToZongdai());
            reportTotal.setDailiToZongdaiWinamt(reportTotal.getDailiToZongdaiWinamt()+ reportDto.getDailiToZongdaiWinamt());
            reportTotal.setZongdaiAmt(reportTotal.getZongdaiAmt() +reportDto.getZongdaiAmt());
            reportTotal.setZongdaiRetreat(reportTotal.getZongdaiRetreat()+reportTotal.getZongdaiRetreat());
            reportTotal.setZongdaiRetreatDiff(reportTotal.getZongdaiRetreatDiff()+reportTotal.getZongdaiRetreatDiff());
            reportTotal.setZongdaiWinamt(reportTotal.getZongdaiWinamt()+ reportDto.getZongdaiWinamt());
            reportTotal.setZongdaiTotalamt(reportTotal.getZongdaiTotalamt()+reportDto.getZongdaiTotalamt());
            reportTotal.setGudongAmt(reportTotal.getGudongAmt()+reportDto.getGudongAmt());
            reportTotal.setGudongWinamt(reportTotal.getGudongWinamt()+reportDto.getGudongWinamt());
        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapId",handicapId);
        modelAndView.addObject("reportTotal",reportTotal);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
        List<String> banners = new ArrayList<String>();
        User user = UserHelper.getCurrentUser();
        User zongdai = userService.get(id);
        banners.add("總代[<span class=\"greenrpt\">"+zongdai.getUserName()+"</span>]"+zongdai.getAccount() +" -- 日期範圍："+draw_date+" ~ "+draw_date2);
        banners.add(" -- 報表分類：總賬 -- ");
        if(user.getUsertype()==0){
            User gudong = userService.get(zongdai.getGudongId());
            User dagudong = userService.get(zongdai.getDagudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">管理員</a> -> ");
            banners.add("<a href=\"/report/z_dagudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a>  -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>  -> ");

        }
        else if(user.getUsertype()==1){
            User gudong = userService.get(zongdai.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">大股東</a> ->");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>  -> ");
        }
        else if(user.getUsertype()==2){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">代理商</a> -> " );
        }
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
        }
        modelAndView.addObject("banners",StringUtils.join(banners,""));
        return modelAndView;
    }

    @RequestMapping("/z_daili")
    public ModelAndView z_daili(String draw_date,String draw_date2,String handicapid,String type,String p_level,String __account,String __name,String id){
        ModelAndView modelAndView = new ModelAndView("/report/z_daili");
        if(StringUtils.isBlank(handicapid)){
            handicapid = handicapService.getHandicapByRiqi(draw_date).getId();
        }
        List<DailiReport> reportDtos = reportService.getDailiReport(handicapid,id);
        DailiReport reportTotal = new DailiReport();
        for(DailiReport reportDto : reportDtos){
            reportTotal.setOrderNum(reportTotal.getOrderNum()+reportDto.getOrderNum());
            reportTotal.setAmount(reportTotal.getAmount()+reportDto.getAmount());
            reportTotal.setMemberWinamt(reportTotal.getMemberWinamt()+reportDto.getMemberWinamt());
            reportTotal.setMemberAmt(reportTotal.getMemberAmt()+reportDto.getMemberAmt());
            reportTotal.setDailiAmt(reportTotal.getDailiAmt()+reportDto.getDailiAmt());
            reportTotal.setDailiRetreat(reportTotal.getDailiRetreat()+reportDto.getDailiRetreat());
            reportTotal.setDailiRetreatDiff(reportTotal.getDailiRetreatDiff() + reportDto.getDailiRetreatDiff());
            reportTotal.setDailiWinamt(reportTotal.getDailiWinamt()+reportDto.getDailiWinamt());
            reportTotal.setDailiTotalamt(reportTotal.getDailiTotalamt()+ reportDto.getDailiTotalamt());
            reportTotal.setToZongdaiAmt(reportTotal.getToZongdaiAmt()+reportDto.getToZongdaiAmt());
            reportTotal.setToZongdaiWinamt(reportTotal.getToZongdaiWinamt()+reportDto.getToZongdaiWinamt());
            reportTotal.setMemberRetreat(reportTotal.getMemberRetreat()+reportDto.getMemberRetreat());
        }
        modelAndView.addObject("reportDtos",reportDtos);
        modelAndView.addObject("handicapid",handicapid);
        modelAndView.addObject("draw_date",draw_date);
        modelAndView.addObject("draw_date2",draw_date2);
        modelAndView.addObject("reportTotal",reportTotal);
        List<String> banners = new ArrayList<String>();
        User daili = userService.get(id);
        banners.add("代理[<span class=\"greenrpt\">"+daili.getUserName()+"</span>]"+daili.getAccount() +" -- 日期範圍："+draw_date+" ~ "+draw_date2);
        banners.add(" -- 報表分類：總賬 -- ");
        User user = UserHelper.getCurrentUser();

        if(user.getUsertype()==0){
            User zongdai = userService.get(daili.getZongdailiId());
            User gudong = userService.get(daili.getGudongId());
            User dagudong = userService.get(daili.getDagudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">管理員</a> -> ");
            banners.add("<a href=\"/report/z_dagudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a>  -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>  -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");

        }
        else if(user.getUsertype()==1){
            User zongdai = userService.get(daili.getZongdailiId());
            User gudong = userService.get(daili.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>  -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a>  -> ");
        }
        else if(user.getUsertype()==2){
            User zongdai = userService.get(daili.getZongdailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">股東</a>  -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
        }
        else if(user.getUsertype()==3){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">代理商</a> -> " );
        }
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
        }
        modelAndView.addObject("banners",StringUtils.join(banners,""));
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
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">管理員</a> -> ");
            banners.add("<a href=\"/report/z_dagudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a>  -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>  -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==1){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a>  -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a>  -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==2){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">股東</a>  -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==3){
            User daili  =userService.get(member.getDailiId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date+"&draw_date2="+draw_date2+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==4){
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date+"&draw_date2="+draw_date2+"&kind=user_report\">代理商</a> -> " );
        }
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
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
            banners.add("<a href=\"/report/z_dagudong?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a> -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==1){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a> -> " );
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
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
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

    @RequestMapping("z_buhuo")
    public ModelAndView z_buhuo(String draw_date0,String draw_id,String type,String p_level,String __account,String __name,String id,Integer pageId){
        ModelAndView modelAndView = new ModelAndView("/report/z_buhuo");
        User user = UserHelper.getCurrentUser();
        if(StringUtils.isBlank(draw_id));
            draw_id = handicapService.getHandicapByRiqi(draw_date0).getId();
        Page<Orders> orderDetails =orderService.getBuhuoesByUserId("",id,draw_id,pageId);
        User member = userService.get(id);
        List<String> banners = new ArrayList<String>();

        banners.add("補貨 -- 賬號：[<span class=\"greenrpt\">"+member.getUserName()  +"</span>"+member.getAccount() +" -- 期数日期："+draw_date0+" ~ " +draw_date0);
        if(user.getUsertype()==0){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            User dagudong = userService.get(member.getDagudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">管理員</a> -> ");
            banners.add("<a href=\"/report/z_dagudong?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=1&__account="+dagudong.getAccount()+" &__name="+dagudong.getUserName()+"&id="+dagudong.getId()+"\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a> -> ");
            banners.add("<a href=\"/report/z_zongdaili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=3&__account="+zongdai.getAccount()+" &__name="+zongdai.getUserName()+"&id="+zongdai.getId()+"\">總代</a> -> ");
            banners.add("<a href=\"/report/z_daili?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=4&__account="+daili.getAccount()+" &__name="+daili.getUserName()+"&id="+daili.getId()+"\">代理商</a> -> ");
        }
        else if(user.getUsertype()==1){
            User daili  =userService.get(member.getDailiId());
            User zongdai = userService.get(member.getZongdailiId());
            User gudong = userService.get(member.getGudongId());
            banners.add("<a href=\"/report/user_report?gameType=1&draw_date="+draw_date0+"&draw_date2="+draw_date0+"&kind=user_report\">大股東</a> -> ");
            banners.add("<a href=\"/report/z_gudong?draw_date="+draw_date0+"&draw_date2="+draw_date0+"&type=1&p_level=2&__account="+gudong.getAccount()+" &__name="+gudong.getUserName()+"&id="+gudong.getId()+"\">股東</a> -> " );
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
        else{
            banners.add("<a href=\"/report/report\">上一頁</a>");
        }
        modelAndView.addObject("banners", StringUtils.join(banners," "));
        modelAndView.addObject("orderDetails",orderDetails);
        return modelAndView;
    }
}
