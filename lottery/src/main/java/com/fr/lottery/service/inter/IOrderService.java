package com.fr.lottery.service.inter;

import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.dto.UserHistoryDto;
import com.fr.lottery.entity.OrderDetail;
import com.fr.lottery.entity.Orders;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
public interface IOrderService {
    boolean save(OrderDto orderDto) ;

    List<Orders> getOrders(String handicapId,String userId);

    List<OrderDetail> getOrderDetails(String handicapId,String userId);

    List<Orders> getOrders(String handicapId);

    List<OrderDetail> getOrderDetails(String handicapId);
    List<OrderDetail> getOrderDetails();

    List<UserHistoryDto> getOrderHistory();

    List<StatisDto> getStatis(String gameType);
}
