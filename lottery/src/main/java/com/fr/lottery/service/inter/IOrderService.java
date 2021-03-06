package com.fr.lottery.service.inter;

import com.fr.lottery.dto.*;
import com.fr.lottery.entity.Orders;
import com.fr.lottery.entity.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
public interface IOrderService {

    Integer save(OrderDto orderDto) ;

   // List<Orders> getOrders(String handicapId, String userId);

    //List<OrderDetail> getOrderDetails(String handicapId,String userId);

   // List<Orders> getOrders(String handicapId);

    List<Orders> getOrders();
    Page<Orders> getOrders(String handicapId,Integer pageIndex, String categoryId,String userId);

    Page<Orders> getOrders(String handicapId,Integer pageIndex, String categoryId,String userId,Integer pageSize);

    Page<Orders> getOrdersByUp(String riqi,String riqi2,String userId,Integer userType ,String categoryid,String gameType,String numner,Integer pageIndex);
    Orders getTotalByUp(String riqi,String riqi2,String userId,Integer userType ,String categoryid,String gameType,String numner);
    Orders getTotal(String categoryId);
    Orders getTotal(String handicapId,String categoryId);
    Orders getTotal(String handicapId,String categoryId,String userId);
    List<MemberReportDto> getOrderHistory();
    List<MemberReportDto> getOrderHistoryByRiqi(String userId,String riqi,String riqi2);
    List<StatisDto> getStatis(String categoryId,String[] gameTypes);
    boolean settlement(String handicapId) ;
    Integer getOrderAmount();

    Page<OrderDetailDto> getOrderDetailsByDaili(String game_id, String number, String name, Integer pageId);

    OrderDetailDto getStatsByDaili(String game_id,String number);

    /**
     * 连码收付统计
     * @param categoryId
     * @param gameTypes
     * @param pageId
     * @return
     */
    Page<StatisDto>  getStatisLianma(String categoryId,String[] gameTypes,Integer pageId);

    List<Map> get_statics_data();

    List<OrderDetailDto> getBuhuo(String game_id,String userId);
    Page<Orders> getBuhuoesByUserId(String game_id,String userId,String handicapId,Integer pageId);

    List<OrderDetail> getOrderDetailsByOrderId(String orderId);

    Orders getOrdersByOrderNo(String order_id);
}
