package com.fr.lottery.service.impl;

import com.fr.lottery.dao.BucangMapper;
import com.fr.lottery.dao.OrderDetailMapper;
import com.fr.lottery.dao.OrderMapper;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.enums.OrderTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.*;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-12-15.
 */
@Service
public class BucangService implements IBucangService {
    @Autowired
    private BucangMapper bucangMapper;
    @Autowired
    private ISysCodeService sysCodeService;
    @Autowired
    private IHandicapService handicapService;
    @Autowired
    private ILimitSetService limitSetService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private IUserService userService;

    @Override
    public int insert(Bucang bucang) {

        Handicap handicap = handicapService.getNotOpenHandicap();
        User user = UserHelper.getCurrentUser();
        User zongdai = null;
        User gudong = null;
        User dagudong = null;
        User daili = null;
        if (!StringUtil.isNullOrEmpty(user.getDailiId())) {
            daili = userService.getUserFromCache(user.getDailiId());
        }
        if (!StringUtil.isNullOrEmpty(user.getZongdailiId())) //代理{
        {
            zongdai = userService.getUserFromCache(user.getZongdailiId());
        }
        if (!StringUtil.isNullOrEmpty(user.getGudongId())) {
            gudong = userService.getUserFromCache(user.getGudongId());
        }
        if (!StringUtil.isNullOrEmpty(user.getDagudongId())) {
            dagudong = userService.getUserFromCache(user.getDagudongId());
        }

        Orders orders = new Orders();

        orders.setOrderNo(sysCodeService.getBuCangAutoCode(handicap.getId()));
        String category = GameCfg.getGameCategory(bucang.getGame_id());
        Float retreat = limitSetService.findRetreatFromCache(user.getId(), bucang.getOdds_set(), category, user.getHandicap());
        if (GameTypeEnum.連碼二.getValue().equals(category) || GameTypeEnum.尾數連.getValue().equals(category)
                || GameTypeEnum.連碼三.getValue().equals(category) || GameTypeEnum.生肖連.getValue() == category) {
            orders.setIsMuti(true);
        } else {
            orders.setIsMuti(false);
        }
        orders.setId(StringUtil.getUUID());
        orders.setCreatedate(new Date());
        orders.setUserid(user.getId());
        orders.setAmount(bucang.getOrder_amt());
        orders.setTotalAmount(bucang.getOrder_amt());
        orders.setOdds(bucang.getOdds());
        orders.setNo(bucang.getNumber());
        orders.setOddset(bucang.getOdds_set());
        orders.setGametype(bucang.getGame_id());
        orders.setRetreat(retreat);
        orders.setRetreatAmt(orders.getTotalAmount() * retreat/100);
        if (!StringUtil.isNullOrEmpty(user.getDailiId()) && daili != null) //代理{
        {orders.setDailiName(daili.getUserName());

            orders.setDailiId(user.getDailiId());
            orders.setDailiAccount(daili.getAccount());
            orders.setDailiAmt(user.getShareUp() * orders.getAmount() / 100F);
            Float dailiRetreat = limitSetService.findRetreatFromCache(daili.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orders.setDailiRetreat(dailiRetreat);
            orders.setDailiRetreatAmt(dailiRetreat * orders.getTotalAmount() / 100);
        }
        if (!StringUtil.isNullOrEmpty(user.getZongdailiId()) && zongdai != null) //代理{
        {
            orders.setZongdaiName(zongdai.getUserName());
            orders.setZongdaiId(user.getZongdailiId());
            orders.setZongdaiAccount(zongdai.getAccount());
            Integer shareUp = 0;
            if (daili == null) {
                shareUp = user.getShareUp();
            } else {
                shareUp = daili.getShareUp();
            }
            orders.setZongdaiAmt(shareUp * orders.getAmount() / 100F);
            Float zongdaiRetreat = limitSetService.findRetreatFromCache(zongdai.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orders.setZongdaiRetreat(zongdaiRetreat);
            orders.setZongdaiRetreatAmt(zongdaiRetreat * orders.getTotalAmount() / 100);
        }
        if (!StringUtil.isNullOrEmpty(user.getGudongId()) && gudong != null) {
            orders.setGudongId(user.getGudongId());
            orders.setGudongAccount(gudong.getAccount());

            orders.setGudongName(gudong.getUserName());
            Integer shareUp = 0;
            if (zongdai == null) {
                shareUp = user.getShareUp();
            } else
                shareUp = zongdai.getShareUp();
            orders.setGudongAmt(shareUp * orders.getAmount() / 100F);

            Float gudongRetreat = limitSetService.findRetreatFromCache(gudong.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orders.setGudongRetreat(gudongRetreat);
            orders.setGudongRetreatAmt(gudongRetreat * orders.getTotalAmount() /100);

        }
        if (!StringUtil.isNullOrEmpty(user.getGudongId()) && dagudong != null) {
            orders.setDagudongId(user.getDagudongId());
            orders.setDagudongAccount(dagudong.getAccount());
            orders.setDagudongName(dagudong.getUserName());
            Integer shareUp = 0;
            if (gudong == null) {
                shareUp = user.getShareUp();
            } else {
                shareUp = gudong.getShareUp();
            }
            orders.setDagudongAmt(shareUp * orders.getAmount() / 100F);
            Float dagudongRetreat = limitSetService.findRetreatFromCache(dagudong.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orders.setDagudongRetreat(dagudongRetreat);
            orders.setDagudongRetreatAmt(dagudongRetreat * orders.getTotalAmount() / 100);
        }
        orders.setAccount(user.getAccount());
        OrderDetail orderDetail = new OrderDetail();
        if (bucang.getNumber().contains(",")) {
            String[] numbers = bucang.getNumber().split(",");

            LotConfig lot = Global.lotConfigDic.get(orders.getGametype() + "01");
            orders.setDescription(lot.getGameTypeDesc() + " ");

            int i = 0;
            if ("017".equals(orders.getGametype()) || "018".equals(orders.getGametype()) || "035".equals(orders.getGametype()) || "036".equals(orders.getGametype()) || "037".equals(orders.getGametype())
                    || "038".equals(orders.getGametype()) || "039".equals(orders.getGametype()) || "040".equals(orders.getGametype())
                    || "054".equals(orders.getGametype()) || "055".equals(orders.getGametype())) {
                orderDetail.setNumbers(bucang.getNumber());
                for (String xiao : numbers) {
                    i++;
                    orders.setDescription(orders.getDescription() + Global.shengxiaoDic.get(xiao).getName() + ",");
                    if (i == 1) {
                        orderDetail.setNumber1(xiao);
                    } else if (i == 2) {
                        orderDetail.setNumber2(xiao);
                    } else if (i == 3) {
                        orderDetail.setNumber3(xiao);
                    } else if (i == 4) {
                        orderDetail.setNumber4(xiao);
                    } else if (i == 5) {
                        orderDetail.setNumber5(xiao);
                    } else if (i == 6) {
                        orderDetail.setNumber6(xiao);
                    } else if (i == 7) {
                        orderDetail.setNumber7(xiao);
                    } else if (i == 8) {
                        orderDetail.setNumber8(xiao);
                    } else if (i == 9) {
                        orderDetail.setNumber9(xiao);
                    } else if (i == 10) {
                        orderDetail.setNumber10(xiao);
                    }
                }
                orders.setDescription(orders.getDescription().substring(0, orders.getDescription().length() - 1));
            } else if ("041".equals(orders.getGametype()) || "042".equals(orders.getGametype()) || "043".equals(orders.getGametype())
                    || "044".equals(orders.getGametype()) || "045".equals(orders.getGametype()) || "046".equals(orders.getGametype())) {// 尾数连
                i = 0;
                for (String number : numbers) {
                    i++;
                    orders.setDescription(orders.getDescription() + Long.valueOf(number).toString() + "尾,");
                    if (i == 1) {
                        orderDetail.setNumber1(number);
                    } else if (i == 2) {
                        orderDetail.setNumber2(number);
                    } else if (i == 3) {
                        orderDetail.setNumber3(number);
                    } else if (i == 4) {
                        orderDetail.setNumber4(number);
                    } else if (i == 5) {
                        orderDetail.setNumber5(number);
                    } else if (i == 6) {
                        orderDetail.setNumber6(number);
                    } else if (i == 7) {
                        orderDetail.setNumber7(number);
                    } else if (i == 8) {
                        orderDetail.setNumber8(number);
                    } else if (i == 9) {
                        orderDetail.setNumber9(number);
                    } else if (i == 10) {
                        orderDetail.setNumber10(number);
                    }
                }
                orders.setDescription(orders.getDescription().substring(0, orders.getDescription().length() - 1));
            } else {
                orders.setDescription(lot.getGameTypeDesc() + " " + bucang.getNumber());
                i = 0;
                for (String number : numbers) {
                    i++;
                    if (i == 1) {
                        orderDetail.setNumber1(number);
                    } else if (i == 2) {
                        orderDetail.setNumber2(number);
                    } else if (i == 3) {
                        orderDetail.setNumber3(number);
                    } else if (i == 4) {
                        orderDetail.setNumber4(number);
                    } else if (i == 5) {
                        orderDetail.setNumber5(number);
                    } else if (i == 6) {
                        orderDetail.setNumber6(number);
                    } else if (i == 7) {
                        orderDetail.setNumber7(number);
                    } else if (i == 8) {
                        orderDetail.setNumber8(number);
                    } else if (i == 9) {
                        orderDetail.setNumber9(number);
                    } else if (i == 10) {
                        orderDetail.setNumber10(number);
                    }
                }
            }
        } else {
            orders.setDescription(Global.lotConfigDic.get(orders.getGametype() + orders.getNo()).getGameDesc());
            orderDetail.setNumber1(bucang.getNumber());
        }

        orderDetail.setId(StringUtil.getUUID());
        orderDetail.setOrderId(orders.getId());
        orderDetail.setNumbers(bucang.getNumber());
        orderDetail.setRetreat(orders.getRetreat());
        orderDetail.setUserId(user.getId());
        orderDetail.setGameDesc(orders.getDescription());
        orderDetail.setOdds(Float.parseFloat(bucang.getOdds()));
        //orderDetail.setOdds(bucang.getOdds());
        //orderDetail.setOdds(bucang.getDetailOdds());
        orderDetail.setCreateDate(new Date());
        orderDetail.setAmount(bucang.getOrder_amt());
        orderDetail.setGameType(bucang.getGame_id());
        orderDetail.setGameDesc(orders.getDescription());
        orderDetail.setId(StringUtil.getUUID());
        orderDetail.setHandicapId(handicap.getId());
        orderDetail.setOddset(orders.getOddset());
        orderDetail.setOrderType(OrderTypeEnum.补仓.getValue());
        if (!StringUtil.isNullOrEmpty(user.getDailiId()) && daili != null) //代理{
        {
            orderDetail.setDailiId(user.getDailiId());
            orderDetail.setDailiAccount(daili.getAccount());
            orderDetail.setDailiAmt(user.getShareUp() * orderDetail.getAmount() / 100F);
            Float dailiRetreat = limitSetService.findRetreatFromCache(daili.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orderDetail.setDailiRetreat(dailiRetreat);
        }
        if (!StringUtil.isNullOrEmpty(user.getZongdailiId()) && zongdai != null) //代理{
        {
            orderDetail.setZongdaiId(user.getZongdailiId());
            orderDetail.setZongdaiAccount(zongdai.getAccount());
            Integer shareUp = 0;
            if (daili == null) {
                shareUp = user.getShareUp();
            } else {
                shareUp = daili.getShareUp();
            }
            orderDetail.setZongdaiAmt(shareUp * orderDetail.getAmount() / 100F);
            Float zongdaiRetreat = limitSetService.findRetreatFromCache(zongdai.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orderDetail.setZongdaiRetreat(zongdaiRetreat);
        }
        if (!StringUtil.isNullOrEmpty(user.getGudongId()) && gudong != null) {
            orderDetail.setGudongId(user.getGudongId());
            orderDetail.setGudongAccount(gudong.getAccount());
            Integer shareUp = 0;
            if (zongdai == null) {
                shareUp = user.getShareUp();
            } else
                shareUp = zongdai.getShareUp();
            orderDetail.setGudongAmt(shareUp * orderDetail.getAmount() / 100F);

            Float zongdaiRetreat = limitSetService.findRetreatFromCache(gudong.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orderDetail.setZongdaiRetreat(zongdaiRetreat);
        }
        if (!StringUtil.isNullOrEmpty(user.getGudongId()) && dagudong != null) {
            orderDetail.setDagudongId(user.getDagudongId());
            orderDetail.setDagudongAccount(dagudong.getAccount());
            Integer shareUp = 0;
            if (gudong == null) {
                shareUp = user.getShareUp();
            } else {
                shareUp = gudong.getShareUp();
            }
            orderDetail.setDagudongAmt(shareUp * orderDetail.getAmount() / 100F);
            Float dagudongRetreat = limitSetService.findRetreatFromCache(dagudong.getId(), bucang.getOdds_set(), category, user.getHandicap());
            orderDetail.setDagudongRetreat(dagudongRetreat);
        }


        orders.setOrderType(OrderTypeEnum.补仓.getValue());
        orders.setHandicapId(handicap.getId());
        orders.setRiqi(handicap.getRiqi());
        orderMapper.insert(orders);
        orderDetailMapper.insert(orderDetail);
        return 1;
    }

    @Override
    public List<Bucang> getDatas(String handicapid, String userid) {
        Bucang bucang = new Bucang();
        bucang.setHandicapId(handicapid);
        bucang.setUserid(userid);
        //bucang.setXpath();
        //b
        return bucangMapper.getDatas(bucang);
    }
}
