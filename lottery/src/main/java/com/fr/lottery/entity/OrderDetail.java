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
    private String number4;
    private String number5;
    private String number6;
    private String number7;
    private String number8;
    private String number9;
    private String number10;
    private Float odds;

    private Float odds1;
    private Integer amount;
    private String oddsNumber;
    private Float canWinAmount;
    private Float winAmount;

    private Float retreat;
    private Date createDate;
    private String oddset;
    private String gameDesc;
    private String numbers;
    private String orderType;
    private String dailiId;
    private String gudongId;
    private String zongdaiId;
    private String dagudongId;
    private String huiyuanAccount;
    private String dailiAccount;
    private String zongdaiAccount;
    private String gudongAccount;
    private String dagudongAccount;
    private Float dailiAmt;
    private Float zongdaiAmt;
    private Float gudongAmt;
    private Float dagudongAmt;
    private Float dailiRetreat;
    private Float zongdaiRetreat;
    private Float gudongRetreat;
    private Float dagudongRetreat;
    private Float dailiWinamt;
    private Float zongdaiWinamt;
    private Float gudongWinamt;
    private Float dagudongWinamt;

    private String account;

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

    public String getNumber4() {
        return number4;
    }

    public void setNumber4(String number4) {
        this.number4 = number4;
    }

    public String getNumber5() {
        return number5;
    }

    public void setNumber5(String number5) {
        this.number5 = number5;
    }

    public String getNumber6() {
        return number6;
    }

    public void setNumber6(String number6) {
        this.number6 = number6;
    }

    public String getNumber7() {
        return number7;
    }

    public void setNumber7(String number7) {
        this.number7 = number7;
    }

    public String getNumber8() {
        return number8;
    }

    public void setNumber8(String number8) {
        this.number8 = number8;
    }

    public String getNumber9() {
        return number9;
    }

    public void setNumber9(String number9) {
        this.number9 = number9;
    }

    public String getNumber10() {
        return number10;
    }

    public void setNumber10(String number10) {
        this.number10 = number10;
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

    public String getOddset() {
        return oddset;
    }

    public void setOddset(String oddset) {
        this.oddset = oddset;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Float getDailiAmt() {
        return dailiAmt;
    }

    public void setDailiAmt(Float dailiAmt) {
        this.dailiAmt = dailiAmt;
    }

    public Float getZongdaiAmt() {
        return zongdaiAmt;
    }

    public void setZongdaiAmt(Float zongdaiAmt) {
        this.zongdaiAmt = zongdaiAmt;
    }

    public Float getGudongAmt() {
        return gudongAmt;
    }

    public void setGudongAmt(Float gudongAmt) {
        this.gudongAmt = gudongAmt;
    }

    public Float getDagudongAmt() {
        return dagudongAmt;
    }

    public void setDagudongAmt(Float dagudongAmt) {
        this.dagudongAmt = dagudongAmt;
    }

    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId;
    }

    public String getGudongId() {
        return gudongId;
    }

    public void setGudongId(String gudongId) {
        this.gudongId = gudongId;
    }

    public String getZongdaiId() {
        return zongdaiId;
    }

    public void setZongdaiId(String zongdaiId) {
        this.zongdaiId = zongdaiId;
    }

    public String getDagudongId() {
        return dagudongId;
    }

    public void setDagudongId(String dagudongId) {
        this.dagudongId = dagudongId;
    }

    public Float getDailiRetreat() {
        return dailiRetreat;
    }

    public void setDailiRetreat(Float dailiRetreat) {
        this.dailiRetreat = dailiRetreat;
    }

    public Float getZongdaiRetreat() {
        return zongdaiRetreat;
    }

    public void setZongdaiRetreat(Float zongdaiRetreat) {
        this.zongdaiRetreat = zongdaiRetreat;
    }

    public Float getGudongRetreat() {
        return gudongRetreat;
    }

    public void setGudongRetreat(Float gudongRetreat) {
        this.gudongRetreat = gudongRetreat;
    }

    public Float getDagudongRetreat() {
        return dagudongRetreat;
    }

    public void setDagudongRetreat(Float dagudongRetreat) {
        this.dagudongRetreat = dagudongRetreat;
    }

    public Float getDailiWinamt() {
        return dailiWinamt;
    }

    public void setDailiWinamt(Float dailiWinamt) {
        this.dailiWinamt = dailiWinamt;
    }

    public Float getZongdaiWinamt() {
        return zongdaiWinamt;
    }

    public void setZongdaiWinamt(Float zongdaiWinamt) {
        this.zongdaiWinamt = zongdaiWinamt;
    }

    public Float getGudongWinamt() {
        return gudongWinamt;
    }

    public void setGudongWinamt(Float gudongWinamt) {
        this.gudongWinamt = gudongWinamt;
    }

    public Float getDagudongWinamt() {
        return dagudongWinamt;
    }

    public void setDagudongWinamt(Float dagudongWinamt) {
        this.dagudongWinamt = dagudongWinamt;
    }

    public String getHuiyuanAccount() {
        return huiyuanAccount;
    }

    public void setHuiyuanAccount(String huiyuanAccount) {
        this.huiyuanAccount = huiyuanAccount;
    }

    public String getDailiAccount() {
        return dailiAccount;
    }

    public void setDailiAccount(String dailiAccount) {
        this.dailiAccount = dailiAccount;
    }

    public String getZongdaiAccount() {
        return zongdaiAccount;
    }

    public void setZongdaiAccount(String zongdaiAccount) {
        this.zongdaiAccount = zongdaiAccount;
    }

    public String getGudongAccount() {
        return gudongAccount;
    }

    public void setGudongAccount(String gudongAccount) {
        this.gudongAccount = gudongAccount;
    }

    public String getDagudongAccount() {
        return dagudongAccount;
    }

    public void setDagudongAccount(String dagudongAccount) {
        this.dagudongAccount = dagudongAccount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

