package com.fr.lottery.entity;

import java.util.Date;

/**
 * Created by Liyu7342 on 2017-7-27.
 */
public  class Order {
    private String id;

    private String handicapid;

    private String orderno;

    private String handciap;

    private String userid;

    private String ordername;

    private String gametype;

    private Integer num;

    private Integer amount;

    private Float odds;

    private Float reteat;

    private Float winamount;

    private Integer status;

    private Date createdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHandicapid() {
        return handicapid;
    }

    public void setHandicapid(String handicapid) {
        this.handicapid = handicapid == null ? null : handicapid.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getHandciap() {
        return handciap;
    }

    public void setHandciap(String handciap) {
        this.handciap = handciap == null ? null : handciap.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getOdds() {
        return odds;
    }

    public void setOdds(Float odds) {
        this.odds = odds;
    }

    public Float getReteat() {
        return reteat;
    }

    public void setReteat(Float reteat) {
        this.reteat = reteat;
    }

    public Float getWinamount() {
        return winamount;
    }

    public void setWinamount(Float winamount) {
        this.winamount = winamount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
