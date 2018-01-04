package com.fr.lottery.entity;

import java.util.Date;

public class Orders {
    private String id;

    private String orderNo;

    private String userid;

    private String handicapId;

    private String gametype;

    private String no;

    private String description;

    private String  odds;

    private Integer amount;

    private Integer totalAmount;

    private Date createdate;

    private  Float retreat;

    private Float winAmount;

    private Float canWinAmount;

    private  String lianmatype;

    private String lianmadan;

    private String oddset;

    private String orderType;

    private Boolean isMuti;

    private Float retreatAmt;
    private String dailiId;
    private String gudongId;
    private String zongdaiId;
    private String dagudongId;
    private String account;
    private String dailiAccount;
    private String zongdaiAccount;
    private String gudongAccount;
    private String dagudongAccount;
    private String dagudongName;
    private String dailiName;
    private String zongdaiName;
    private String gudongName;
    private Float dailiAmt;
    private Float zongdaiAmt;
    private Float gudongAmt;
    private Float dagudongAmt;
    private Float dailiRetreat;
    private Float zongdaiRetreat;
    private Float gudongRetreat;
    private Float dagudongRetreat;
    private Float dailiRetreatAmt;
    private Float zongdaiRetreatAmt;
    private Float gudongRetreatAmt;
    private Float dagudongRetreatAmt;
    private Float dailiWinamt;
    private Float zongdaiWinamt;
    private Float gudongWinamt;
    private Float dagudongWinamt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Float getRetreat() {
        return retreat;
    }

    public void setRetreat(Float retreat) {
        this.retreat = retreat;
    }

    public String getHandicapId() {
        return handicapId;
    }

    public void setHandicapId(String handicapId) {
        this.handicapId = handicapId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Float winAmount) {
        this.winAmount = winAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getLianmatype() {
        return lianmatype;
    }

    public void setLianmatype(String lianmatype) {
        this.lianmatype = lianmatype;
    }

    public String getLianmadan() {
        return lianmadan;
    }

    public void setLianmadan(String lianmadan) {
        this.lianmadan = lianmadan;
    }

    public Float getCanWinAmount() {
        return canWinAmount;
    }

    public void setCanWinAmount(Float canWinAmount) {
        this.canWinAmount = canWinAmount;
    }

    public String getOddset() {
        return oddset;
    }

    public void setOddset(String oddset) {
        this.oddset = oddset;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Boolean getIsMuti() {
        return isMuti;
    }

    public void setIsMuti(Boolean isMuti) {
        this.isMuti = isMuti;
    }


    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId;
    }

    public String getZongdaiId() {
        return zongdaiId;
    }

    public void setZongdaiId(String zongdaiId) {
        this.zongdaiId = zongdaiId;
    }

    public String getGudongId() {
        return gudongId;
    }

    public void setGudongId(String gudongId) {
        this.gudongId = gudongId;
    }

    public String getDagudongId() {
        return dagudongId;
    }

    public void setDagudongId(String dagudongId) {
        this.dagudongId = dagudongId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String huiyuanAccount) {
        this.account = huiyuanAccount;
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

    public Float getDailiRetreatAmt() {
        return dailiRetreatAmt;
    }

    public void setDailiRetreatAmt(Float dailiRetreatAmt) {
        this.dailiRetreatAmt = dailiRetreatAmt;
    }

    public Float getZongdaiRetreatAmt() {
        return zongdaiRetreatAmt;
    }

    public void setZongdaiRetreatAmt(Float zongdaiRetreatAmt) {
        this.zongdaiRetreatAmt = zongdaiRetreatAmt;
    }

    public Float getGudongRetreatAmt() {
        return gudongRetreatAmt;
    }

    public void setGudongRetreatAmt(Float gudongRetreatAmt) {
        this.gudongRetreatAmt = gudongRetreatAmt;
    }

    public Float getDagudongRetreatAmt() {
        return dagudongRetreatAmt;
    }

    public void setDagudongRetreatAmt(Float dagudongRetreatAmt) {
        this.dagudongRetreatAmt = dagudongRetreatAmt;
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

    public String getDagudongName() {
        return dagudongName;
    }

    public void setDagudongName(String dagudongName) {
        this.dagudongName = dagudongName;
    }

    public String getDailiName() {
        return dailiName;
    }

    public void setDailiName(String dailiName) {
        this.dailiName = dailiName;
    }

    public String getZongdaiName() {
        return zongdaiName;
    }

    public void setZongdaiName(String zongdaiName) {
        this.zongdaiName = zongdaiName;
    }

    public String getGudongName() {
        return gudongName;
    }

    public void setGudongName(String gudongName) {
        this.gudongName = gudongName;
    }

    public Float getRetreatAmt() {
        return retreatAmt;
    }

    public void setRetreatAmt(Float retreatAmt) {
        this.retreatAmt = retreatAmt;
    }
}