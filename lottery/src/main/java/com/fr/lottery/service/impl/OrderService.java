package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrdersMapper;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.Orders;
import com.fr.lottery.entity.OrderDetail;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public List<Orders> getOrderList(String userId){
        return new ArrayList<Orders>();
//        GameTypeEnum.不中.getValue();
    }

    public boolean save(OrderDto orderDto) {
        User user = UserHelper.getCurrentUser();
        Orders order = new Orders();
        order.setId(StringUtil.getUUID());
       order.setOrderamount(orderDto.getOrder_allamount());
        order.setCreatedate(new Date());
        order.setHandicapid("1");
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
             detail.setOdds(Float.parseFloat(details[2]) );
             detail.setNo(Integer.parseInt(details[1]));
             detail.setRetreat(map.get(detail.getGametype()));
             detail.setGametype(details[0]);
             orderDetailMapper.insert(detail);
         }
        return true;
    }
}
