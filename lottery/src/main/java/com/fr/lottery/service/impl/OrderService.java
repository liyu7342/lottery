package com.fr.lottery.service.impl;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrderMapper;
import com.fr.lottery.dao.StatisMapper;
import com.fr.lottery.dto.*;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.*;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.*;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Service
public class OrderService implements IOrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ILimitSetService limitSetService;
    @Autowired
    private IHandicapService handicapService;

    @Autowired
    private StatisMapper statisMapper;

    @Autowired
    private ISysCodeService sysCodeService;

    @Autowired
    private IOddsService oddsService;

    @Autowired
    private IShengxiaoService shengxiaoService;

    public List<OrderDetail> getOrderList(String userId) {
        return new ArrayList<OrderDetail>();
//        GameTypeEnum.不中.getValue();
    }

    public Integer save(OrderDto orderDto) {
        boolean isOpen= handicapService.IsOpenHandicap();
        if (!isOpen) {
            return -1001;
        }
        Handicap handicap = handicapService.getCurrentHandicap();
        User user = UserHelper.getCurrentUser();
        if(orderDto.getOrder_allamount()+user.getAmount()>user.getCredits())
            return -1124;
        user.setAmount(orderDto.getOrder_allamount() + user.getAmount());
        UserHelper.setCurrentUser(user);
        List<LimitSet> limitSetList = limitSetService.findAll(user.getId());

        Map<String, Float> map = new HashedMap();
        for (LimitSet limitSet : limitSetList) {
            map.put( limitSet.getLimitType(), ("A".equals( user.getHandicap())? limitSet.getaRetreat():("B".equals(user.getHandicap())?limitSet.getbRetreat():limitSet.getcRetreat())));
        }


        String[] orderDatas = orderDto.getOrderData().split(";");
        for (String orderDataStr : orderDatas) {
            String[] orderStrs = orderDataStr.split("\\|");
            Orders orders = new Orders();
            orders.setOrderNo(sysCodeService.getAutoCode(handicap.getId()));

            orders.setId(StringUtil.getUUID());
            orders.setCreatedate(new Date());
            orders.setUserid(user.getId());
            orders.setAmount(Integer.parseInt(orderStrs[3]));
            orders.setOdds(orderStrs[2]);
            orders.setNo(orderStrs[1]);
            orders.setOddset(orderDto.getOdds_set());
            String category = GameCfg.getGameCategory(orderStrs[0]);
            orders.setGametype(orderStrs[0]);
            if(OddsTypeEnum.tema.getValue().equals( orders.getGametype())) {
                category = orderDto.getOdds_set().substring(1)+category;
            }
            if (map.containsKey(category)) {
                orders.setRetreat(map.get(category));
            }

            orders.setHandicapId(handicap.getId());
            if (orderStrs.length == 5) {//连码
                orders.setTotalAmount(orderDto.getOrder_allamount());
                if (!orderStrs[4].startsWith("3")) {
                    orders.setLianmatype(orderStrs[4].substring(0, 1));
                    orders.setLianmadan(orderStrs[4].substring(1));
                } else {
                    orders.setLianmatype("30");
                    orders.setLianmadan(orderStrs[4].substring(2, 3));
                }
            } else {
                orders.setTotalAmount(orders.getAmount());
            }
            if (orderStrs[1].contains(",")) {
                String[] nos = orderStrs[1].split(",");
                if (Global.lotConfigDic.containsKey(orderStrs[0] + nos[0])) {
                    LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                    if (!StringUtil.isNullOrEmpty(orders.getLianmatype())) {
                        if (LianMaEnum.zhengchang.getValue().equals(orders.getLianmatype())) {
                            if("035".equals( orders.getGametype()) ||"036".equals( orders.getGametype()) || "037".equals( orders.getGametype()) ||"038".equals( orders.getGametype())
                                    ||"039".equals( orders.getGametype())||"040".equals( orders.getGametype())){
                                String[] detailxiaoNos = orderStrs[1].split(",");
                                orders.setDescription(lot.getGameTypeDesc() + " " );
                                for(String xiao : detailxiaoNos){
                                    orders.setDescription(orders.getDescription()+ Global.shengxiaoDic.get(xiao).getName()+" ");
                                }
                            }
                            else{
                                orders.setDescription(lot.getGameTypeDesc() + " " + orderStrs[1]);
                            }
                        } else if (LianMaEnum.dantuo.getValue().equals(orders.getLianmatype())) {
                            orders.setDescription(lot.getGameTypeDesc() + " " + orders.getLianmadan() + " [拖] " + orderStrs[1].substring(nos[0].length() + 1));
                        } else if (LianMaEnum.shengxiaoduipeng.getValue().equals(orders.getLianmatype())) {
                            String[] xiaonos = orderStrs[1].split("#");
                            String[] detailxiaoNos = xiaonos[0].split(",");
                            orders.setDescription(lot.getGameTypeDesc() + " " + Global.shengxiaoDic.get(detailxiaoNos[0]).getName() + " [碰] " + Global.shengxiaoDic.get(detailxiaoNos[1]).getName());
                        } else if (LianMaEnum.shengweiduipeng.getValue().equals(orders.getLianmatype())) {

                            String[] xiaonos = orderStrs[1].split("#");
                            String[] detailxiaoNos = xiaonos[0].split(",");
                            orders.setDescription(lot.getGameTypeDesc() + " " + Global.shengxiaoDic.get(detailxiaoNos[0]).getName() + " [碰] " + Long.valueOf(detailxiaoNos[1]).toString() + "尾");
                        } else if (LianMaEnum.weishuduipeng.getValue().equals(orders.getLianmatype())) {
                            String[] xiaonos = orderStrs[1].split("#");
                            String[] detailxiaoNos = xiaonos[0].split(",");
                            orders.setDescription(lot.getGameTypeDesc() + " " + Long.valueOf(detailxiaoNos[0]).toString() + "尾" + " [碰] " + Long.valueOf(detailxiaoNos[1]).toString() + "尾");
                        } else if (LianMaEnum.suiyipeng.getValue().equals(orders.getLianmatype())) {
                            orders.setDescription(lot.getGameTypeDesc() + " " + orders.getLianmadan() + "  [碰] " + orderStrs[1].substring(orders.getLianmadan().length() + 1));
                        }
                    }
                    else if("017".equals(orders.getGametype()) || "018".equals(orders.getGametype())){
                        String[] detailxiaoNos = orderStrs[1].split(",");
                        orders.setDescription(lot.getGameTypeDesc() + " " );
                        for(String xiao : detailxiaoNos){
                            orders.setDescription(orders.getDescription()+ Global.shengxiaoDic.get(xiao).getName()+" ");
                        }
                    }
                }

            } else {
                if (Global.lotConfigDic.containsKey(orderStrs[0] + orderStrs[1])) {
                    orders.setDescription(Global.lotConfigDic.get(orderStrs[0] + orderStrs[1]).getGameDesc());
                }
            }

            if (StringUtil.isNullOrEmpty(orderDto.getDetailOdds())) {
                OrderDetail detail = new OrderDetail();
                detail.setAmount(orders.getAmount());
                detail.setId(StringUtil.getUUID());
                detail.setCreateDate(new Date());
                detail.setGameType(orders.getGametype());
                detail.setHandicapId(orders.getHandicapId());
                if("017".equals(orders.getGametype()) ||"018".equals(orders.getGametype())){
                   String[] xiaoNos=orders.getNo().split(",");
                    detail.setNumber1(xiaoNos[0]);
                    detail.setNumber2(xiaoNos[1]);
                    detail.setNumber3(xiaoNos[2]);
                    detail.setNumber4(xiaoNos[3]);
                    detail.setNumber5(xiaoNos[4]);
                    detail.setNumber6(xiaoNos[5]);
                }
                else
                    detail.setNumber1(orders.getNo());
                detail.setOdds(Float.parseFloat(orders.getOdds()));
                detail.setOddsNumber(orders.getNo());
                detail.setOrderId(orders.getId());
                detail.setRetreat(orders.getRetreat());
                detail.setUserId(orders.getUserid());
                orders.setCanWinAmount(detail.getAmount() * (detail.getOdds() -1 + orders.getRetreat()/100 ));
                detail.setOddset(orders.getOddset());
                detail.setGameDesc(orders.getDescription());
                detail.setNumbers(orders.getNo());
                detail.setOrderType(OrderTypeEnum.下注.getValue());
                orderDetailMapper.insert(detail);

            } else {
                String[] detailOdds = orderDto.getDetailOdds().split(";");
                orders.setCanWinAmount(0F);
                float detailSum = 0f;
                for (String detailOdd : detailOdds) {
                    String[] detailArr = detailOdd.split("\\|");
                    OrderDetail detail = new OrderDetail();
                    detail.setAmount(orders.getAmount());
                    detail.setId(StringUtil.getUUID());
                    detail.setCreateDate(new Date());
                    detail.setGameType(orders.getGametype());
                    detail.setHandicapId(orders.getHandicapId());
                    if (OddsTypeEnum.erquanzh.getValue().equals(orders.getGametype()) || OddsTypeEnum.erzhongte.getValue().equals(orders.getGametype()) || OddsTypeEnum.techuan.getValue().equals(orders.getGametype() )
                            || "035".equals(orders.getGametype()) || "036".equals(orders.getGametype()) || "041".equals(orders.getGametype()) || "042".equals(orders.getGametype()) ) {

                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumbers(detailArr[0]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        if("035".equals(orders.getGametype()) || "036".equals(orders.getGametype())){ //生肖连
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + Global.shengxiaoDic.get(nos[0]).getName()+","+Global.shengxiaoDic.get(nos[1]).getName());
                        }
                        else if("041".equals(orders.getGametype()) || "042".equals(orders.getGametype())){// 尾数连
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + Long.valueOf(nos[0]).toString()+"尾,"+ Long.valueOf(nos[1]).toString()+"尾");
                        }
                        else{
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                        }

                    } else if (OddsTypeEnum.sanquanzh.getValue().equals(orders.getGametype()) || OddsTypeEnum.sanzher.getValue().equals(orders.getGametype())
                            || "037".equals(orders.getGametype()) || "038".equals(orders.getGametype() ) || "043".equals(orders.getGametype()) || "044".equals(orders.getGametype())) {//三全中、三中二
                        String[] nos = detailArr[0].split(",");
                        detail.setNumbers(detailArr[0]);
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        if("037".equals(orders.getGametype()) || "038".equals(orders.getGametype()) ){//三肖连
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + Global.shengxiaoDic.get(nos[0]).getName()+","+Global.shengxiaoDic.get(nos[1]).getName()+","+Global.shengxiaoDic.get(nos[2]).getName());
                        }
                        else if("043".equals(orders.getGametype()) || "044".equals(orders.getGametype())){//三尾连
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + Long.valueOf(nos[0]).toString()+"尾,"+ Long.valueOf(nos[1]).toString()+"尾, "+ Long.valueOf(nos[2]).toString()+"尾");
                        }
                        else{//
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                        }
                    }else if("039".equals(orders.getGametype()) || "040".equals(orders.getGametype()) || "045".equals(orders.getGametype()) || "046".equals(orders.getGametype())){
                        String[] nos = detailArr[0].split(",");
                        detail.setNumbers(detailArr[0]);
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        if("039".equals(orders.getGametype()) || "040".equals(orders.getGametype()) ){//四肖连
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + Global.shengxiaoDic.get(nos[0]).getName()+","+Global.shengxiaoDic.get(nos[1]).getName()+","+Global.shengxiaoDic.get(nos[2]).getName()+","+Global.shengxiaoDic.get(nos[3]).getName());
                        }
                        else{//四尾连
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + Long.valueOf(nos[0]).toString()+"尾,"+ Long.valueOf(nos[1]).toString()+"尾,"+ Long.valueOf(nos[2]).toString()+"尾,"+ Long.valueOf(nos[3]).toString()+"尾");
                        }
                    }
                    else if ("047".equals(orders.getGametype()))// 五不中
                    {

                        String[] nos = detailArr[0].split(",");
                        detail.setNumbers(detailArr[0]);
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                    }else if("048".equals(orders.getGametype()) ||"017".equals(orders.getGametype()) ||"018".equals(orders.getGametype())){  //六不中
                        String[] nos = detailArr[0].split(",");
                        detail.setNumbers(detailArr[0]);
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        if("048".equals(orders.getGametype())){
                            LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                            detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                        }
                        else {
                            detail.setGameDesc(orders.getDescription());
                        }

                    }else if("049".equals(orders.getGametype())){  //七不中
                        String[] nos = detailArr[0].split(",");
                        detail.setNumbers(detailArr[0]);
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        detail.setNumber7(nos[6]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                    }else if("050".equals(orders.getGametype())){  //八不中
                        detail.setNumbers(detailArr[0]);
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        detail.setNumber7(nos[6]);
                        detail.setNumber8(nos[7]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                    }else if("051".equals(orders.getGametype())){  //九不中
                        detail.setNumbers(detailArr[0]);
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        detail.setNumber7(nos[6]);
                        detail.setNumber8(nos[7]);
                        detail.setNumber9(nos[8]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                    }else if("052".equals(orders.getGametype())){  //⑩不中
                        detail.setNumbers(detailArr[0]);
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        detail.setNumber7(nos[6]);
                        detail.setNumber8(nos[7]);
                        detail.setNumber9(nos[8]);
                        detail.setNumber10(nos[9]);
                        LotConfig lot = Global.lotConfigDic.get(orderStrs[0] + "01");
                        detail.setGameDesc(lot.getGameTypeDesc() + " " + detailArr[0]);
                    }

                    if (OddsTypeEnum.erzhongte.getValue().equals(orders.getGametype()) || OddsTypeEnum.sanzher.getValue().equals(orders.getGametype())) {//两个赔率
                        String[] oddsArr = detailArr[1].split("/");
                        detail.setOdds(Float.parseFloat(oddsArr[0]));
                        detail.setOdds1(Float.parseFloat(oddsArr[1]));
                    } else {
                        detail.setOdds(Float.parseFloat(detailArr[1]));
                    }
                    detail.setOddsNumber(detailArr[2]);
                    detail.setOrderId(orders.getId());
                    detail.setRetreat(orders.getRetreat());
                    detail.setUserId(orders.getUserid());
                    detailSum+= detail.getAmount()  *(detail.getOdds() -1 + orders.getRetreat()/100 ) ;
                    detail.setOddset(orders.getOddset());
                    detail.setOrderType(OrderTypeEnum.下注.getValue());
                    orderDetailMapper.insert(detail);
                }
                orders.setCanWinAmount(orders.getCanWinAmount() +detailSum );
            }
            orders.setOrderType(OrderTypeEnum.下注.getValue());
            orderMapper.insert(orders);
        }
        return 1;
    }

//    @Override
//    public List<OrderDetail> getOrderDetails(String handicapId, String userId) {
//        return null;
//        //return orderMapper.getOrderDetails(handicapId, userId);
//    }

//    @Override
//    public List<OrderDetail> getOrderDetails(String handicapId) {
//        return null;
//    }

//    @Override
//    public List<OrderDetail> getOrderDetails(String handicapId, String userId) {
//        return orderDetailMapper.getOrderDetails(handicapId,userId,"",0,pageSize);
//    }

    @Override
    public List<Orders> getOrders() {
        Handicap handicap = handicapService.getCurrentHandicap();
        if (handicap == null || handicap.getStatus() >= HandicapStatusEnum.Closed.ordinal())
            return new ArrayList<Orders>();
        return orderMapper.getOrderDetails(handicap.getId(), UserHelper.getCurrentUser().getId(), "", null, null);
    }

    @Override
    public Page<Orders> getOrders(String handicapId,Integer pageIndex, String categoryId) {
         return getOrders(handicapId,pageIndex,categoryId,Global.pageSize);
    }

    @Override
    public Page<Orders> getOrders(String handicapId,Integer pageIndex, String categoryId,Integer pageSize) {
        if (pageIndex == null) pageIndex = 1;
        if(StringUtils.isBlank(handicapId)){
            Handicap handicap = handicapService.getCurrentHandicap();

            if (handicap == null || handicap.getStatus() >= HandicapStatusEnum.Closed.ordinal())
                return new Page<Orders>();
            handicapId = handicap.getId();
        }

        List<Orders> details = orderMapper.getOrderDetails(handicapId, UserHelper.getCurrentUser().getId(), "", (pageIndex - 1) * pageSize, pageSize);
        Long total = orderMapper.countByUserId(handicapId, UserHelper.getCurrentUser().getId(), "");

        return new Page<Orders>(pageIndex, pageSize, total, details);
    }

    @Override
    public Orders getTotal(String categoryId) {
        throw new NotImplementedException("");
//        Handicap handicap = handicapService.getCurrentHandicap();
//        if (handicap == null || handicap.getStatus() >= HandicapStatusEnum.Closed.ordinal()) {
//            Orders orderDetail = new Orders();
//            orderDetail.setTotalAmount(0);
//            orderDetail.setWinAmount(0F);
//            return orderDetail;
//        }
//        Orders orderDetail = orderMapper.getTotal(handicap.getId(), UserHelper.getCurrentUser().getId(), "");
//        return orderDetail;
    }

    public Orders getTotal(String handicapId,String categoryId){
        if(StringUtils.isBlank(handicapId)){
            Handicap handicap = handicapService.getCurrentHandicap();
            if (handicap == null || handicap.getStatus() >= HandicapStatusEnum.Closed.ordinal())
            {

            }
            else{
                handicapId =handicap.getId();
            }
        }

        if(StringUtils.isBlank(handicapId))
        {
            Orders orderDetail = new Orders();
            orderDetail.setTotalAmount(0);
            orderDetail.setWinAmount(0F);
            orderDetail.setCanWinAmount(0F);
            return orderDetail;
        }
        Orders orderDetail = orderMapper.getTotal(handicapId,UserHelper.getCurrentUser().getId(),"");
        return orderDetail;
    }

    @Override
    public List<UserHistoryDto> getOrderHistory() {
        String userId = UserHelper.getCurrentUser().getId();
        return orderMapper.getOrderHistory("", userId);
    }

    @Override
    public List<StatisDto> getStatis(String categoryId,String[] gameTypes) {
        Handicap handicap = handicapService.getCurrentHandicap();
        if(handicap == null)
            return  new ArrayList<StatisDto>();
        User user = UserHelper.getCurrentUser();
        StatisCondition condition = new StatisCondition();
        condition.setP_gameType(StringUtils.join( gameTypes,","));
        condition.setP_userId(user.getId());
        condition.setP_xpath(user.getXpath());
        condition.setP_handicapId(handicap.getId());
        condition.setP_categoryId(categoryId);
        List<StatisDto> statisDtos;
        if( GameTypeEnum.特码.getValue().equals(categoryId )){
            statisDtos= statisMapper.getStatisByCallable( condition);
        }
        else{
            statisDtos= statisMapper.getStatisZhengmaByCallable( condition);
        }
        //实时赔率
        List<Odds> oddsList = oddsService.getOddsList("",gameTypes);
        for (StatisDto statisDto: statisDtos){
            for(Odds odds : oddsList){

                if((statisDto.getGameType()+statisDto.getNo()).equals(odds.getNumkey())){
                    if("AA".equals(odds.getOddSet()) || "A".equals(odds.getOddSet())){
                        statisDto.setAaOdds(odds.getNumvalue().toString());
                    }
                    else if("AB".equals(odds.getOddSet())){
                        statisDto.setAbOdds(odds.getNumvalue().toString());
                    }
                    else if("BA".equals(odds.getOddSet()) ||"B".equals(odds.getOddSet())){
                        statisDto.setBaOdds(odds.getNumvalue().toString());
                    }
                    else if("BB".equals(odds.getOddSet())){
                        statisDto.setBbOdds(odds.getNumvalue().toString());
                    }
                    else if("CA".equals(odds.getOddSet()) || "C".equals(odds.getOddSet())){
                        statisDto.setCaOdds(odds.getNumvalue().toString());
                    }
                    else if("CB".equals(odds.getOddSet())){
                        statisDto.setCbOdds(odds.getNumvalue().toString());
                    }

                }
            }
        }
        return  statisDtos;
    }

    @Override
    public Integer getOrderAmount() {
        Handicap handicap = handicapService.getCurrentHandicap();
        if (handicap == null) return 0;
        List<UserHistoryDto> list = orderMapper.getOrderHistory(handicap.getId(), UserHelper.getCurrentUser().getId());
        if (list.size() > 0) {
            return list.get(0).getAmount();
        }
        return 0;
    }

    @Override
    public Page<OrderDetailDto> getOrderDetailsByDaili(String game_id, String number, String name, Integer pageId) {
        User user = UserHelper.getCurrentUser();
        String xpath =user.getXpath()+"%";
        Handicap handicap = handicapService.getCurrentHandicap();
        if(game_id.equals(OddsTypeEnum.erquanzh.getValue()) || game_id.equals(OddsTypeEnum.erzhongte.getValue()) || game_id.equals(OddsTypeEnum.sanquanzh.getValue())
            ||game_id.equals(OddsTypeEnum.sanzher.getValue()) || game_id.equals(OddsTypeEnum.techuan.getValue())){


        }
        List<OrderDetailDto> detailDtos= orderDetailMapper.getOrderDetailsByDaili(handicap.getId(),user.getId(),xpath,game_id,number,(pageId-1)*10,10);

        long total = orderDetailMapper.getDetailsTotalByDaili(handicap.getId(),xpath,game_id,number);
        Page<OrderDetailDto> page = new Page<OrderDetailDto>(pageId,10,total);
        page.setList(detailDtos);
        return  page;
    }

    /**
     * 获取下注明细统计
     * @param game_id
     * @param number
     * @return
     */
    @Override
    public OrderDetailDto getStatsByDaili(String game_id,String number){
        User user = UserHelper.getCurrentUser();
        String xpath =user.getXpath()+"%";
        Handicap handicap = handicapService.getCurrentHandicap();
        OrderDetailDto detailDto= orderDetailMapper.getStatsByDaili(handicap.getId(),user.getId(),xpath,game_id,number);
        return detailDto;
    }

    /**
     * 连码收付统计
     * @param categoryId
     * @param gameTypes
     * @param pageId
     * @return
     */
    public Page<StatisDto>  getStatisLianma(String categoryId,String[] gameTypes,Integer pageId){
        if(pageId==null) pageId=1;
        Handicap handicap = handicapService.getCurrentHandicap();
        if(handicap == null)
            return  new Page<StatisDto>();
        User user = UserHelper.getCurrentUser();
        StatisCondition condition = new StatisCondition();
        condition.setP_gameType(StringUtils.join( gameTypes,","));
        condition.setP_userId(user.getId());
        condition.setP_xpath(user.getXpath());
        condition.setP_handicapId(handicap.getId());
        condition.setP_categoryId(categoryId);

        condition.setP_start((pageId-1)*Global.pageSizeOfTh);
        condition.setP_pageSize(Global.pageSizeOfTh);
        List<StatisDto> statisDtos;

        statisDtos= statisMapper.getStatisLianma( condition);
        Long total =0L;
        StatisDto statisDto =statisMapper.getStatisLianmaCount(condition);
        Page<StatisDto> page =new Page<StatisDto>(pageId,Global.pageSizeOfTh,total,statisDtos);
        Map<String,Integer> map = new HashMap<String, Integer>();
        total = (long)statisDto.getOrderNum();
        map.put("shareTotal", statisDto.getAmount()==null ?0:statisDto.getAmount().intValue());
        map.put("buhuo",statisDto.getBuhuo()==null ?0:statisDto.getBuhuo().intValue());
        page.setOtherInfo(map);
        return page;
    }

    /**
     * 各玩法占成統計
     * 返回 map 包含category,zhancheng 兩個Key
     * @return
     */
    @Override
    public List<Map> get_statics_data() {
        User user = UserHelper.getCurrentUser();
        Handicap handicap = handicapService.getCurrentHandicap();
        StatisCondition condition = new StatisCondition();
        condition.setP_handicapId(handicap.getId());
        condition.setP_xpath(user.getXpath());
        condition.setP_userId(user.getId());
        return statisMapper.get_statics_data(condition);
    }

    @Override
    public boolean settlement(String handicapId) {
            orderDetailMapper.settlement(handicapId);
        return true;
    }

    @Override
    public List<OrderDetailDto> getBuhuo(String game_id, String userId) {
        Handicap handicap = handicapService.getCurrentHandicap();
        return orderDetailMapper.getBuhuoes(handicap.getId(),game_id,userId);
    }
}
