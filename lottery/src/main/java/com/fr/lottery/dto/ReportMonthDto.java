package com.fr.lottery.dto;

/**
 * Created by Liyu7342 on 2018-1-16.
 */
public class ReportMonthDto {

    public ReportMonthDto(){
        this.orderNum=0;
        this.amount=0f;
        this.memberWinamt=0f;
        this.zhancheng=0f;
        this.retreat=0f;
        this.retreatDiff=0f;
        this.userWinamt=0f;
        this.userTotalamt=0f;
    }
    private String id;
    private String handicapId;
    private String riqi;
    private String userid;
    private String account;
    /**
     * 筆數
     */
    private Integer orderNum;
    /**
     * 下注總額
     */
    private Float amount;
    /**
     * 會員盈虧
     */
    private Float memberWinamt;
    /**
     * 占成
     */
    private Float zhancheng;
    /**
     * 佣金
     */
    private Float retreat;
    /**
     * 佣金差
     */
    private Float retreatDiff;
    /**
     * 獎金
     */
    private Float userWinamt;
    /**
     * 盈虧
     */
    private Float userTotalamt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHandicapId() {
        return handicapId;
    }

    public void setHandicapId(String handicapId) {
        this.handicapId = handicapId;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getMemberWinamt() {
        return memberWinamt;
    }

    public void setMemberWinamt(Float memberWinamt) {
        this.memberWinamt = memberWinamt;
    }

    public Float getZhancheng() {
        return zhancheng;
    }

    public void setZhancheng(Float zhancheng) {
        this.zhancheng = zhancheng;
    }

    public Float getRetreat() {
        return retreat;
    }

    public void setRetreat(Float retreat) {
        this.retreat = retreat;
    }

    public Float getRetreatDiff() {
        return retreatDiff;
    }

    public void setRetreatDiff(Float retreatDiff) {
        this.retreatDiff = retreatDiff;
    }

    public Float getUserWinamt() {
        return userWinamt;
    }

    public void setUserWinamt(Float userWinamt) {
        this.userWinamt = userWinamt;
    }

    public Float getUserTotalamt() {
        return userTotalamt;
    }

    public void setUserTotalamt(Float userTotalamt) {
        this.userTotalamt = userTotalamt;
    }
}
