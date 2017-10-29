package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrdersMapper;
import com.fr.lottery.dao.StatisMapper;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.dto.UserHistoryDto;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.HandicapStatusEnum;
import com.fr.lottery.enums.LianMaEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.ISysCodeService;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrdersMapper orderMapper;

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

    public List<Orders> getOrderList(String userId){
        return new ArrayList<Orders>();
//        GameTypeEnum.不中.getValue();
    }

    public boolean save(OrderDto orderDto) {
        Handicap handicap = handicapService.getCurrentHandicap();
        if(handicap==null || handicap.getStatus() != HandicapStatusEnum.Active.ordinal()){
            return false;
        }

        User user = UserHelper.getCurrentUser();
        user.setAmount(orderDto.getOrder_allamount()+user.getAmount());
        UserHelper.setCurrentUser(user);
//        Orders order = new Orders();
//        order.setId(StringUtil.getUUID());
//       order.setOrderamount(orderDto.getOrder_allamount());
//        order.setCreatedate(new Date());
//        order.setHandicapid(handicap.getId());
//        order.setUserid(user.getId());
//        order.setOrderdetail(orderDto.getOrderData());
//        orderMapper.insert(order);
        List<LimitSet> limitSetList =limitSetService.findAll(user.getId());
        Map<String,Float> map = new HashedMap();
        for(LimitSet limitSet :limitSetList){
            map.put(limitSet.getLimitType(),limitSet.getaRetreat());
        }
        String[] orderDetails=orderDto.getOrderData().split(";");
         for(String orderDetailStr : orderDetails){
             String[] details= orderDetailStr.split("\\|");
             OrderDetail detail  = new OrderDetail();
             detail.setOrderNo(sysCodeService.getAutoCode(handicap.getId()));
             //detail.setOrderid(order.getId());
             detail.setId(StringUtil.getUUID());
             detail.setCreatedate(new Date());
             detail.setUserid(user.getId());
             detail.setAmount(Integer.parseInt( details[3]));
             if(details.length==5){
                 detail.setTotalAmount(orderDto.getOrder_allamount());
                 if(!details[4].startsWith("3")){
                     detail.setLianmatype(details[4].substring(0,1));
                     detail.setLianmadan(details[4].substring(1));
                 }
                 else{
                     detail.setLianmatype("30");
                     detail.setLianmadan(details[4].substring(2,3));
                 }

             }
             else{
                 detail.setTotalAmount(detail.getAmount());
             }


             detail.setOdds(details[2]);
             detail.setNo(details[1]);
             String category= GameCfg.getGameCategory(details[0]);
             if(map.containsKey(category)){
                 detail.setRetreat(map.get(category));
             }

             if(details[1].contains(",")){
                 String[] nos = details[1].split(",");
                 detail.setDescription("");
                 int i=0;
                 for(String no :nos){
                     if(Global.lotConfigDic.containsKey(details[0]+no)){
                         if(i==0){

                             detail.setDescription(Global.lotConfigDic.get(details[0]+ no).getGameDesc());
                             if(!StringUtil.isNullOrEmpty( detail.getLianmatype())){
                                if(LianMaEnum.zhengchang.getValue().equals( detail.getLianmatype())){
                                    detail.setDescription(detail.getDescription() + "  正常");
                                }
                                else if(LianMaEnum.dantuo.getValue().equals(detail.getLianmatype())){
                                    detail.setDescription(detail.getDescription() + "  胆拖");
                                }
                                else if(LianMaEnum.shengxiaoduipeng.getValue().equals(detail.getLianmatype())){
                                    detail.setDescription(detail.getDescription() + "  生肖对碰");
                                }
                                else if(LianMaEnum.shengweiduipeng.getValue().equals(detail.getLianmatype())){
                                    detail.setDescription(detail.getDescription() + "  生尾对碰");
                                }
                                else if(LianMaEnum.weishuduipeng.getValue().equals(detail.getLianmatype())){
                                    detail.setDescription(detail.getDescription() + "  尾数对碰");
                                }
                                else if(LianMaEnum.suiyipeng.getValue().equals(detail.getLianmatype())){
                                    detail.setDescription(detail.getDescription() + "  随意对碰");
                                }
                             }
                             detail.setDescription( Global.lotConfigDic.get(details[0]+ no).getGameDesc());
                         }else{
                             detail.setDescription(detail.getDescription()+","+ Global.lotConfigDic.get(details[0]+no).getGameNumDesc());
                         }
                         i++;
                     }
                 }

             }else {
                 if(Global.lotConfigDic.containsKey(details[0]+details[1])){
                     detail.setDescription(Global.lotConfigDic.get(details[0]+details[1]).getGameDesc());
                 }
             }
             detail.setGametype(details[0]);
             detail.setHandicapId(handicap.getId());
             //Float getMinOdds(detail);
             orderDetailMapper.insert(detail);
         }
        return true;
    }

    @Override
    public List<Orders> getOrders(String handicapId, String userId) {
        return orderMapper.getOrders(handicapId,userId);
    }

    @Override
    public List<Orders> getOrders(String handicapId) {
        return orderMapper.getOrders(handicapId,"");
    }

    @Override
    public List<OrderDetail> getOrderDetails(String handicapId, String userId) {
        return orderDetailMapper.getOrderDetails(handicapId,userId,"");
    }

    @Override
    public List<OrderDetail> getOrderDetails(String handicapId) {
        return orderDetailMapper.getOrderDetails(handicapId,UserHelper.getCurrentUser().getId(),"");
    }

    @Override
    public List<OrderDetail>  getOrderDetails(){
       Handicap handicap= handicapService.getCurrentHandicap();
       if(handicap==null || handicap.getStatus()>= HandicapStatusEnum.Closed.ordinal())
           return new ArrayList<OrderDetail>();
       return orderDetailMapper.getOrderDetails(handicap.getId(),UserHelper.getCurrentUser().getId(),"");
    }

    @Override
    public List<UserHistoryDto> getOrderHistory() {
        String userId =UserHelper.getCurrentUser().getId();
        return orderDetailMapper.getOrderHistory("",userId);
    }

    @Override
    public List<StatisDto> getStatis(String gameType) {
        Handicap handicap = handicapService.getCurrentHandicap();
        return statisMapper.getStatis(gameType,handicap.getId());
    }

    @Override
    public Integer getOrderAmount(){
        Handicap handicap = handicapService.getCurrentHandicap();
        if(handicap==null) return 0;
        List<UserHistoryDto> list= orderDetailMapper.getOrderHistory(handicap.getId(),UserHelper.getCurrentUser().getId());
        if(list.size()>0){
            return list.get(0).getAmount();
        }
        return 0;
    }

    @Override
    public boolean settlement(String handicapId) {

        Handicap handicap= handicapService.selectByPrimaryKey(handicapId);
        List<OrderDetail> orderDetails= orderDetailMapper.getOrderDetails(handicapId,"","");

        for(OrderDetail orderDetail: orderDetails){

            if(orderDetail.getGametype().equals(OddsTypeEnum.tema.getValue())){
                if(handicap.getTema().equals(orderDetail.getNo())){
                    Float odds= getMinOdds(orderDetail);
                    orderDetail.setWinAmount(orderDetail.getAmount() * (odds+ (orderDetail.getRetreat()/100) -1));
                }
                else{
                    orderDetail.setWinAmount(0F-orderDetail.getAmount());
                }
            }
            else if(orderDetail.getGametype().equals(OddsTypeEnum.zhengma.getValue())){
                if(handicap.getNo1().equals(orderDetail.getNo()) ||handicap.getNo2().equals(orderDetail.getNo()) || handicap.getNo3().equals(orderDetail.getNo())
               || handicap.getNo4().equals(orderDetail.getNo())||handicap.getNo5().equals(orderDetail.getNo()) ||handicap.getNo6().equals(orderDetail.getNo())){
                    Float odds = getMinOdds(orderDetail);
                    orderDetail.setWinAmount(orderDetail.getAmount() * (odds+ (orderDetail.getRetreat()/100) -1));
                }
                else{
                    orderDetail.setWinAmount(0F-orderDetail.getAmount());
                }
            }
            else if(orderDetail.getGametype().equals(OddsTypeEnum.zhengmate1.getValue())){
              if(handicap.getNo1().equals(handicap.getTema()) &&  handicap.getNo1().equals(orderDetail.getNo()) )  {
                  Float odds= getMinOdds(orderDetail);
                  orderDetail.setWinAmount(orderDetail.getAmount() * (odds+ (orderDetail.getRetreat()/100) -1));
              }
              else{
                  orderDetail.setWinAmount(0F-orderDetail.getAmount());
              }
            }
            else if(orderDetail.getGametype().equals(OddsTypeEnum.erquanzh.getValue())){

            }
        }
        handicap.setIssettlement(true);
        return false;
    }

    /**
     * 特码结算
     * @param handicap
     * @return
     */
    private void temaSettlement(Handicap handicap){
        List<OrderDetail> orderDetails= orderDetailMapper.getOrderDetails(handicap.getId(),"",OddsTypeEnum.tema.getValue());
        for(OrderDetail orderDetail: orderDetails) {
            if (handicap.getTema().equals(orderDetail.getNo())) {
                Float odds = getMinOdds(orderDetail);
                orderDetail.setWinAmount(orderDetail.getAmount() * (odds + (orderDetail.getRetreat() / 100) - 1));
            } else {
                orderDetail.setWinAmount(0F - orderDetail.getAmount());
            }
            orderDetailMapper.updateWinAmountByPrimaryKey(orderDetail.getWinAmount(),orderDetail.getId());
        }
    }

    /**
     * 特码结算
     * @param handicap
     * @return
     */
    private void zhengmaSettlement(Handicap handicap){
        List<OrderDetail> orderDetails= orderDetailMapper.getOrderDetails(handicap.getId(),"",OddsTypeEnum.zhengma.getValue());
        for(OrderDetail orderDetail: orderDetails) {
            if (handicap.getTema().equals(orderDetail.getNo())) {
                Float odds = getMinOdds(orderDetail);
                orderDetail.setWinAmount(orderDetail.getAmount() * (odds + (orderDetail.getRetreat() / 100) - 1));
            } else {
                orderDetail.setWinAmount(0F - orderDetail.getAmount());
            }
            orderDetailMapper.updateWinAmountByPrimaryKey(orderDetail.getWinAmount(),orderDetail.getId());
        }
    }
    //获取最小赔率
    private Float getMinOdds(OrderDetail orderDetail){
        Float odds = 0f;
        //查找最小赔率
        if(orderDetail.getOdds().contains(",")){
            String oddsArr[]= orderDetail.getOdds().split(",");
            for (String tempOddsStr :oddsArr)
            {
                Float tempOdds=Float.parseFloat( tempOddsStr);
                if(odds==0 ||  tempOdds<odds){
                    odds=tempOdds;
                }
            }
        }else{
            odds=Float.parseFloat( orderDetail.getOdds());
        }
        return odds;
    }


}
