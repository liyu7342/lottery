package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrdersMapper;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.HandicapStatusEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOrderService;
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
        Orders order = new Orders();
        order.setId(StringUtil.getUUID());
       order.setOrderamount(orderDto.getOrder_allamount());
        order.setCreatedate(new Date());
        order.setHandicapid(handicap.getId());
        order.setUserid(user.getId());
        order.setOrderdetail(orderDto.getOrderData());
        orderMapper.insert(order);
        List<LimitSet> limitSetList =limitSetService.findAll(user.getId());
        Map<String,Float> map = new HashedMap();
        for(LimitSet limitSet :limitSetList){
            map.put(limitSet.getLimitType(),limitSet.getaRetreat());
        }
        String[] orderDetails=orderDto.getOrderData().split(";");
         for(String orderDetailStr : orderDetails){
             String[] details= orderDetailStr.split("\\|");
             OrderDetail detail  = new OrderDetail();
             detail.setOrderid(order.getId());
             detail.setId(StringUtil.getUUID());
             detail.setCreatedate(new Date());
             detail.setUserid(user.getId());
             detail.setAmout(Long.parseLong( details[3]));
             detail.setOdds(details[2]);
             detail.setNo(details[1]);
             detail.setWinAmount(2f);
             detail.setRetreat(1f);
             detail.setDescription(Global.lotConfigDic.get(details[0]+details[1]).getGameDesc());
             detail.setRetreat(map.get(detail.getGametype()));
             detail.setGametype(details[0]);
             detail.setHandicapId(handicap.getId());
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
        return orderDetailMapper.getOrderDetails(handicapId,userId);
    }

    @Override
    public List<OrderDetail> getOrderDetails(String handicapId) {
        return orderDetailMapper.getOrderDetails(handicapId,UserHelper.getCurrentUser().getId());
    }

    @Override
    public List<OrderDetail>  getOrderDetails(){
       Handicap handicap= handicapService.getCurrentHandicap();
       if(handicap==null || handicap.getStatus()>= HandicapStatusEnum.Closed.ordinal())
           return new ArrayList<OrderDetail>();
       return orderDetailMapper.getOrderDetails(handicap.getId(),UserHelper.getCurrentUser().getId());
    }
}
