package com.fr.lottery.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liyu7342 on 2017-7-27.
 */
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String handicapId;

    private String orderId;

    private String userId;

    private String gameType;
    private String number1;
    private String number2;
    private String number3;
    private Float odds;

    private Float odds1;
    private Integer amount;
    private String oddsNumber;
    private Float canWinAmount;
    private Float winAmount;

    private Float retreat;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHandicapId() {
        return handicapId;
    }

    public void setHandicapId(String handicapId) {
        this.handicapId = handicapId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public Float getOdds() {
        return odds;
    }

    public void setOdds(Float odds) {
        this.odds = odds;
    }

    public Float getOdds1() {
        return odds1;
    }

    public void setOdds1(Float odds1) {
        this.odds1 = odds1;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOddsNumber() {
        return oddsNumber;
    }

    public Float getCanWinAmount() {
        return canWinAmount;
    }

    public void setCanWinAmount(Float canWinAmount) {
        this.canWinAmount = canWinAmount;
    }

    public Float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Float winAmount) {
        this.winAmount = winAmount;
    }

    public void setOddsNumber(String oddsNumber) {
        this.oddsNumber = oddsNumber;
    }

    public Float getRetreat() {
        return retreat;
    }

    public void setRetreat(Float reteat) {
        this.retreat = reteat;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

