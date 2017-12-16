package com.fr.lottery.entity;

import java.util.Date;

/**
 * Created by Liyu7342 on 2017-12-15.
 */
public class Bucang {
    private String id;
    private String handicapId;
    private String orderNo;
    private String description;
    private String userid;
    private String number;
    private String odds_set;
    private String game_id;
    private String odds;
    private String detailOdds;
    private Integer amt;
    private Integer order_amt;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOdds_set() {
        return odds_set;
    }

    public void setOdds_set(String odds_set) {
        this.odds_set = odds_set;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public String getDetailOdds() {
        return detailOdds;
    }

    public void setDetailOdds(String detailOdds) {
        this.detailOdds = detailOdds;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public Integer getOrder_amt() {
        return order_amt;
    }

    public void setOrder_amt(Integer order_amt) {
        this.order_amt = order_amt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createdate) {
        this.createDate = createdate;
    }

    public String getHandicapId() {
        return handicapId;
    }

    public void setHandicapId(String handicapId) {
        this.handicapId = handicapId;
    }
}
