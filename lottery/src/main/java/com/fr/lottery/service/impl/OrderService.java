package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrderMapper;
import com.fr.lottery.dao.StatisMapper;
import com.fr.lottery.dto.*;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.GameTypeEnum;
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
        if(orderDto.getOrder_allamount()+user.getAmount()>user.getCredits())
            return false;
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


                    orders.setCanWinAmount(detail.getAmount() * (detail.getOdds() -1 + orders.getRetreat()/100 ));


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
                            || "035".equals(orders.getGametype()) || "036".equals(orders.getGametype()) || "041".equals(orders.getGametype()) || "042".equals(orders.getGametype())) {
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                    } else if (OddsTypeEnum.sanquanzh.getValue().equals(orders.getGametype()) || OddsTypeEnum.sanzher.getValue().equals(orders.getGametype())
                            || "037".equals(orders.getGametype()) || "038".equals(orders.getGametype() ) || "043".equals(orders.getGametype()) || "044".equals(orders.getGametype())) {//三全中、三中二
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                    }else if("039".equals(orders.getGametype()) || "040".equals(orders.getGametype()) || "045".equals(orders.getGametype()) || "046".equals(orders.getGametype())){
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                    }
                    else if ("047".equals(orders.getGametype()))// 五不中
                    {
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                    }else if("048".equals(orders.getGametype())){  //六不中
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);

                    }else if("049".equals(orders.getGametype())){  //七不中
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        detail.setNumber7(nos[6]);
                    }else if("050".equals(orders.getGametype())){  //八不中
                        String[] nos = detailArr[0].split(",");
                        detail.setNumber1(nos[0]);
                        detail.setNumber2(nos[1]);
                        detail.setNumber3(nos[2]);
                        detail.setNumber4(nos[3]);
                        detail.setNumber5(nos[4]);
                        detail.setNumber6(nos[5]);
                        detail.setNumber7(nos[6]);
                        detail.setNumber8(nos[7]);
                    }else if("051".equals(orders.getGametype())){  //九不中
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
                    }else if("052".equals(orders.getGametype())){  //⑩不中
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
                    orderDetailMapper.insert(detail);
                }
                orders.setCanWinAmount(orders.getCanWinAmount() +detailSum );
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
    public List<StatisDto> getStatis(String[] gameTypes) {
        Handicap handicap = handicapService.getCurrentHandicap();
        if(handicap == null)
            return  new ArrayList<StatisDto>();
        String userId = UserHelper.getCurrentUser().getId();
        return statisMapper.getStatis(gameTypes, handicap.getId(),UserHelper.getCurrentUser().getXpath()+"%");
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


    @Override
    public boolean settlement(String handicapId) {
            orderDetailMapper.settlement(handicapId);
        return true;
    }
}
