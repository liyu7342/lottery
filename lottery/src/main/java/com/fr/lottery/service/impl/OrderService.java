package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrderMapper;
import com.fr.lottery.dao.StatisMapper;
import com.fr.lottery.dto.OrderDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.dto.UserHistoryDto;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.HandicapStatusEnum;
import com.fr.lottery.enums.LianMaEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.*;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.fr.lottery.init.Global.pageSize;

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
    private IShengxiaoService shengxiaoService;

    public List<OrderDetail> getOrderList(String userId) {
        return new ArrayList<OrderDetail>();
//        GameTypeEnum.不中.getValue();
    }

    public boolean save(OrderDto orderDto) {
        Handicap handicap = handicapService.getCurrentHandicap();
        if (handicap == null || handicap.getStatus() != HandicapStatusEnum.Active.ordinal()) {
            return false;
        }

        User user = UserHelper.getCurrentUser();
        user.setAmount(orderDto.getOrder_allamount() + user.getAmount());
        UserHelper.setCurrentUser(user);
        List<LimitSet> limitSetList = limitSetService.findAll(user.getId());

        Map<String, Float> map = new HashedMap();
        for (LimitSet limitSet : limitSetList) {
            map.put(limitSet.getLimitType(), limitSet.getaRetreat());
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
            String category = GameCfg.getGameCategory(orderStrs[0]);
            if (map.containsKey(category)) {
                orders.setRetreat(map.get(category));
            }
            orders.setGametype(orderStrs[0]);
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
                            orders.setDescription(lot.getGameTypeDesc() + " " + orderStrs[1]);
                        } else if (LianMaEnum.dantuo.getValue().equals(orders.getLianmatype())) {
                            orders.setDescription(lot.getGameTypeDesc() + " " + orders.getLianmadan() + " [拖] " + orderStrs[1].substring(nos[0].length() + 1));
                        } else if (LianMaEnum.shengxiaoduipeng.getValue().equals(orders.getLianmatype())) {
                            Map<String, ShengXiao> shengxiaomap = shengxiaoService.findMapByYear1();
                            String[] xiaonos = orderStrs[1].split("#");
                            String[] detailxiaoNos = xiaonos[0].split(",");
                            orders.setDescription(lot.getGameTypeDesc() + " " + shengxiaomap.get(detailxiaoNos[0]).getName() + " [碰] " + shengxiaomap.get(detailxiaoNos[1]).getName());
                        } else if (LianMaEnum.shengweiduipeng.getValue().equals(orders.getLianmatype())) {
                            Map<String, ShengXiao> shengxiaomap = shengxiaoService.findMapByYear1();
                            String[] xiaonos = orderStrs[1].split("#");
                            String[] detailxiaoNos = xiaonos[0].split(",");
                            orders.setDescription(lot.getGameTypeDesc() + " " + shengxiaomap.get(detailxiaoNos[0]).getName() + " [碰] " + Long.valueOf(detailxiaoNos[1]).toString() + "尾");
                        } else if (LianMaEnum.weishuduipeng.getValue().equals(orders.getLianmatype())) {
                            String[] xiaonos = orderStrs[1].split("#");
                            String[] detailxiaoNos = xiaonos[0].split(",");
                            orders.setDescription(lot.getGameTypeDesc() + " " + Long.valueOf(detailxiaoNos[0]).toString() + "尾" + " [碰] " + Long.valueOf(detailxiaoNos[1]).toString() + "尾");
                        } else if (LianMaEnum.suiyipeng.getValue().equals(orders.getLianmatype())) {
                            orders.setDescription(lot.getGameTypeDesc() + " " + orders.getLianmadan() + "  [碰] " + orderStrs[1].substring(orders.getLianmadan().length() + 1));
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
                detail.setNumber1(orders.getNo());
                detail.setOdds(Float.parseFloat(orders.getOdds()));
                detail.setOddsNumber(orders.getNo());
                detail.setOrderId(orders.getId());
                detail.setRetreat(orders.getRetreat());
                detail.setUserId(orders.getUserid());
                orders.setCanWinAmount(detail.getOdds()* detail.getAmount());
                orderDetailMapper.insert(detail);
            } else {
                String[] detailOdds = orderDto.getDetailOdds().split(";");
                orders.setCanWinAmount(0F);
                for (String detailOdd : detailOdds) {
                    String[] detailArr = detailOdd.split("\\|");
                    OrderDetail detail = new OrderDetail();
                    detail.setAmount(orders.getAmount());
                    detail.setId(StringUtil.getUUID());
                    detail.setCreateDate(new Date());
                    detail.setGameType(orders.getGametype());
                    detail.setHandicapId(orders.getHandicapId());
                    if (OddsTypeEnum.erquanzh.getValue().equals(orders.getGametype()) || OddsTypeEnum.erzhongte.getValue().equals(orders.getGametype()) || OddsTypeEnum.techuan.getValue().equals(orders.getGametype())) {
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                    } else if (OddsTypeEnum.sanquanzh.getValue().equals(orders.getGametype()) || OddsTypeEnum.sanzher.getValue().equals(orders.getGametype())) {//三全中、三中二
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
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
                    orders.setCanWinAmount(orders.getCanWinAmount()+detail.getOdds() * detail.getAmount());
                    orderDetailMapper.insert(detail);
                }
            }
            orderMapper.insert(orders);


        }
        return true;
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
    public Page<Orders> getOrders(Integer pageIndex, String categoryId) {
        if (pageIndex == null) pageIndex = 1;
        Handicap handicap = handicapService.getCurrentHandicap();
        if (handicap == null || handicap.getStatus() >= HandicapStatusEnum.Closed.ordinal())
            return new Page<Orders>();
        List<Orders> details = orderMapper.getOrderDetails(handicap.getId(), UserHelper.getCurrentUser().getId(), "", (pageIndex - 1) * pageSize, pageSize);
        Long total = orderMapper.countByUserId(handicap.getId(), UserHelper.getCurrentUser().getId(), "");

        return new Page<Orders>(pageIndex, pageSize, total, details);
    }

    @Override
    public Orders getTotal(String categoryId) {
        Handicap handicap = handicapService.getCurrentHandicap();
        if (handicap == null || handicap.getStatus() >= HandicapStatusEnum.Closed.ordinal()) {
            Orders orderDetail = new Orders();
            orderDetail.setTotalAmount(0);
            orderDetail.setWinAmount(0F);
            return orderDetail;
        }
        Orders orderDetail = orderMapper.getTotal(handicap.getId(), UserHelper.getCurrentUser().getId(), "");
        return orderDetail;
    }

    @Override
    public List<UserHistoryDto> getOrderHistory() {
        String userId = UserHelper.getCurrentUser().getId();
        return orderMapper.getOrderHistory("", userId);
    }

    @Override
    public List<StatisDto> getStatis(String gameType) {
        Handicap handicap = handicapService.getCurrentHandicap();
        return statisMapper.getStatis(gameType, handicap.getId());
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

    /**
     * 取两数组交集
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] intersect(String[] arr1, String[] arr2) {
        List<String> l = new LinkedList<String>();
        Set<String> common = new HashSet<String>();
        for (String str : arr1) {
            if (!l.contains(str)) {
                l.add(str);
            }
        }
        for (String str : arr2) {
            if (l.contains(str)) {
                common.add(str);
            }
        }
        String[] result = {};
        return common.toArray(result);
    }

    @Override
    public boolean settlement(String handicapId) {

        Handicap handicap = handicapService.selectByPrimaryKey(handicapId);
        //List<OrderDetail> orderDetails= orderDetailMapper.getOrderDetails(handicapId,"","");
        List<Orders> orderDetails1 = orderMapper.getOrderDetails(handicapId, "", OddsTypeEnum.erquanzh.getValue(), null, null);
        String[] mas = {handicap.getNo1(), handicap.getNo2(), handicap.getNo3(), handicap.getNo4(), handicap.getNo5(), handicap.getNo6(), handicap.getTema()};

        for (Orders orderDetail : orderDetails1) {
            //正常连码
            if (LianMaEnum.zhengchang.getValue().equals(orderDetail.getLianmatype())) {
                String[] detailnos = orderDetail.getNo().split(",");
                String[] winNoArray = intersect(mas, detailnos);

                if (winNoArray.length >= 2) {
                    String[] oddsArray = orderDetail.getOdds().split(",");
                    String[] winOdds = new String[winNoArray.length];
                    int _t = 0;
                    for (String winNo : winNoArray) { //获取中奖赔率
                        int index = Arrays.binarySearch(detailnos, winNo);
                        winOdds[_t] = oddsArray[index];
                        _t++;
                    }
                    Arrays.sort(winOdds);

                    //取最小赔率
                    Float totalAmount = 0f;
                    for (int index = 0, len = winOdds.length; index < winOdds.length - 1; index++) {
                        len--;
                        totalAmount += (Float.parseFloat(winOdds[index]) + (orderDetail.getRetreat() / 100)) * len * orderDetail.getAmount();
                    }
                    orderDetail.setWinAmount(totalAmount - orderDetail.getTotalAmount());

                } else {
                    orderDetail.setWinAmount(0f - orderDetail.getTotalAmount());
                }
            } else if (LianMaEnum.dantuo.getValue().equals(orderDetail.getLianmatype())) {
                //胆不中，则全不中
                int _index = Arrays.asList(mas).indexOf(orderDetail.getLianmadan());
                if (_index < 0) {
                    orderDetail.setWinAmount(0f - orderDetail.getTotalAmount());
                } else {//胆中
                    //移除胆，然后分割数组
                    String[] detailnos = orderDetail.getNo().substring(orderDetail.getNo().indexOf(",")).split(",");
                    String[] winNoArray = intersect(mas, detailnos);
                    if (winNoArray.length >= 1) {
                        String[] oddsArray = orderDetail.getOdds().split(",");
                        String[] winOdds = new String[winNoArray.length + 1];//胆包含里面计算
                        int _t = 0;
                        winOdds[0] = oddsArray[0];//胆
                        for (String winNo : winNoArray) { //获取中奖赔率
                            int index = Arrays.binarySearch(detailnos, winNo);
                            winOdds[_t] = oddsArray[index];
                            _t++;
                        }
                        //与胆赔率比较，取小赔率计算
                        Float totalAmount = 0f;
                        for (int index = 1, len = winOdds.length; index < len; index++) {
                            String oddsValue = winOdds[0].compareTo(winOdds[index]) < 0 ? winOdds[0] : winOdds[index];
                            totalAmount += (Float.parseFloat(oddsValue) + (orderDetail.getRetreat() / 100)) * len * orderDetail.getAmount();
                        }
                        orderDetail.setWinAmount(totalAmount - orderDetail.getTotalAmount());
                    } else {
                        orderDetail.setWinAmount(0f - orderDetail.getTotalAmount());
                    }

                }
            } else if (LianMaEnum.shengxiaoduipeng.getValue().equals(orderDetail.getLianmatype())) {

            }
            orderMapper.updateWinAmountByPrimaryKey(orderDetail.getWinAmount(), orderDetail.getId());
        }
        handicap.setIssettlement(true);
        return false;
    }
}
