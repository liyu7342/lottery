package com.fr.lottery.entity;

import java.util.Date;

public class OrderDetail {
    private String id;

    private String orderid;

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

    private  String lianmatype;

    private String lianmadan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
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
}