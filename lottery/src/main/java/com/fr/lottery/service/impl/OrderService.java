package com.fr.lottery.service.impl;

import com.fr.lottery.entity.Order;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.service.inter.IOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Service
public class OrderService implements IOrderService {
    public List<Order> getOrderList(String userId){
        return new ArrayList<Order>();
//        GameTypeEnum.不中.getValue();
    }
}
