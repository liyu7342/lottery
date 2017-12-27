package com.fr.lottery.service.impl;

import com.fr.lottery.dao.UserShareMapper;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.service.inter.*;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-24.
 */
@Service
public class UserShareService implements IUserShareService {
    @Autowired
    private UserShareMapper userShareMapper;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private  IBucangConfigService bucangConfigService;
    @Autowired
    private IBucangService bucangService;

    public  int save(UserShare entity){

        if(StringUtils.isBlank(entity.getId())){
            entity.setId(StringUtil.getUUID());
           return userShareMapper.insert(entity);
        }
        return userShareMapper.insert(entity);
    }

    public UserShare getData(String handicapId,String userId,String category,String gameType,String numbers){
        return userShareMapper.getData(handicapId,userId,category,gameType,numbers);
    }

    public List<UserShare>  getDatas(String handicapId,String userId){
        UserShare entity = new UserShare();
        entity.setHandicapId(handicapId);
        entity.setUserId(userId);
        return userShareMapper.getDatas(entity);
    }

    public int save(String orderId){
       List<OrderDetail> details= orderService.getOrderDetailsByOrderId(orderId);
       for(OrderDetail detail :details){
           User user =userService.get(detail.getUserId());
           User daili = userService.getUserFromCache(user.getDailiId());
           saveBu(detail,daili,user.getShareUp());
           User zongdaili = userService.getUserFromCache(user.getZongdailiId());
           saveBu(detail,zongdaili,daili.getShareUp());
           User gudong = userService.getUserFromCache(user.getGudongId());
           saveBu(detail,gudong,zongdaili.getShareUp());
           User dagudong = userService.getUserFromCache(user.getGudongId());
           saveBu(detail,dagudong,gudong.getShareUp());
       }
       return 1;
    }

    private int saveBu(OrderDetail detail,User user,Integer shareUp){
        String game_id = detail.getGameType();
        if(!(game_id.equals(OddsTypeEnum.sanquanzh.getValue()) ||game_id.equals(OddsTypeEnum.sanzher))){
            game_id="";
        }
        String category_id=GameCfg.getGameCategory(detail.getGameType());
        BucangConfig bucangConfig = bucangConfigService.get(user.getId(),category_id,game_id);
        if(bucangConfig==null ||  bucangConfig.getFlagValue() == 0){
            return 1;
        }
        UserShare share ;
        share=userShareMapper.getData(detail.getHandicapId(),user.getId(),category_id,game_id,detail.getNumbers());
        if(share==null){
            share = new UserShare();
            share.setActualAmt(0F);
            share.setShareTotal(0F);
            share.setBuhuo(0f);
        }

        share.setNumbers(detail.getNumbers());
        share.setGameType(detail.getGameType());
        share.setCategory(category_id);
        share.setHandicapId( detail.getHandicapId());
        share.setUserId(user.getId());
        share.setBaseAmt((float)bucangConfig.getBaseAmount());
        share.setShareTotal(share.getShareTotal ()+ detail.getAmount() * shareUp/100);
        if(share.getShareTotal()>bucangConfig.getBaseAmount()){
            share.setActualAmt((float)bucangConfig.getBaseAmount());
            Float oldBuhuo = share.getBuhuo();
            share.setBuhuo(share.getShareTotal() - bucangConfig.getBaseAmount());
            Float needTobuhuo = share.getBuhuo()-oldBuhuo;
            Bucang bucang = new Bucang();
            bucang.setNumber(detail.getNumbers());
            bucang.setDescription(detail.getGameDesc());
            bucang.setUserid(user.getId());
            bucang.setGame_id(detail.getGameType());
            bucang.setOrder_amt(needTobuhuo.intValue());
            bucang.setHandicapId(detail.getHandicapId());
            bucang.setOdds_set("A");
            bucangService.insert(bucang);
        }
        else{
            share.setBuhuo(0F);
            share.setActualAmt(share.getShareTotal());
        }
        share.setActualAmt(share.getShareTotal()+share.getBuhuo());
        save(share);
        return 1;
    }
}
