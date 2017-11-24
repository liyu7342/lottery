package com.fr.lottery.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/23.
 */
public class OrderDetailDto {
    private String id;
    /**
     *大股东账号
     */
    private String dagudongAccount;
    /**
     * 小股东账号
     */
    private String gudongAccount;
    /**
     * 总代理账号
     */
    private String zongdaiAccount;
    /**
     * 代理账号
     */
    private String dailiAccount;
    /**
     * 会员账号
     */
    private String memberAccount;
    /**
     * 玩法
     */
    private String gameType;
    /**
     * 球号
     */
    private String numbers;
    /**
     * 赔率
     */
    private Float odds;
    /**
     * 下注金额
     */
    private Integer amount;

    /**
     * 占成
     */
    private Float shareTotal;
    //
    /**
     * 占成总额
     */
    private String shareAmount;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 退水
     */
    private Float retreat;

    private String description;

    private String oddset;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDagudongAccount() {
        return dagudongAccount;
    }

    public void setDagudongAccount(String dagudongAccount) {
        this.dagudongAccount = dagudongAccount;
    }

    public String getGudongAccount() {
        return gudongAccount;
    }

    public void setGudongAccount(String gudongAccount) {
        this.gudongAccount = gudongAccount;
    }

    public String getZongdaiAccount() {
        return zongdaiAccount;
    }

    public void setZongdaiAccount(String zongdaiAccount) {
        this.zongdaiAccount = zongdaiAccount;
    }

    public String getDailiAccount() {
        return dailiAccount;
    }

    public void setDailiAccount(String dailiAccount) {
        this.dailiAccount = dailiAccount;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Float getOdds() {
        return odds;
    }

    public void setOdds(Float odds) {
        this.odds = odds;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getShareTotal() {
        return shareTotal;
    }

    public void setShareTotal(Float shareTotal) {
        this.shareTotal = shareTotal;
    }

    public String getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(String shareAmount) {
        this.shareAmount = shareAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Float getRetreat() {
        return retreat;
    }

    public void setRetreat(Float retreat) {
        this.retreat = retreat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOddset() {
        return oddset;
    }

    public void setOddset(String oddset) {
        this.oddset = oddset;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
