package com.fr.lottery.entity;

/**
 * Created by Liyu7342 on 2018-1-20.
 */
public class GameReport {

    public GameReport(){
        this.orderNum=0;
        this.amount=0f;
        this.memberAmt=0f;
        this.zhanchengToMe=0f;
        this.totalToMe=0f;
        this.retreat=0f;
        this.retreatDiff=0f;
        this.zhancheng=0f;
        this.totalAmt=0f;
        this.totalToParent=0f;
        this.zhanchengToParent=0f;
    }
    private String id;
    private String handicapId;
    private String riqi;
    private String userId;
    private String userAccount;
    private String categoryId;
    private String gameDesc;
    private String categoryDesc;
    private String gameType;
    private String number;
    private Integer orderNum;
    private Float amount;
    private Float memberAmt;
    private Float zhanchengToMe;
    private Float totalToMe;
    private Float retreat;
    private Float retreatDiff;
    private Float zhancheng;
    private Float totalAmt;
    private Float zhanchengToParent;
    private Float totalToParent;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
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

    public Float getMemberAmt() {
        return memberAmt;
    }

    public void setMemberAmt(Float memberAmt) {
        this.memberAmt = memberAmt;
    }

    public Float getZhanchengToMe() {
        return zhanchengToMe;
    }

    public void setZhanchengToMe(Float zhanchengToMe) {
        this.zhanchengToMe = zhanchengToMe;
    }

    public Float getTotalToMe() {
        return totalToMe;
    }

    public void setTotalToMe(Float totalToMe) {
        this.totalToMe = totalToMe;
    }

    public Float getRetreatDiff() {
        return retreatDiff;
    }

    public void setRetreatDiff(Float retreatDiff) {
        this.retreatDiff = retreatDiff;
    }

    public Float getZhancheng() {
        return zhancheng;
    }

    public void setZhancheng(Float zhancheng) {
        this.zhancheng = zhancheng;
    }

    public Float getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Float totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Float getZhanchengToParent() {
        return zhanchengToParent;
    }

    public void setZhanchengToParent(Float zhanchengToParent) {
        this.zhanchengToParent = zhanchengToParent;
    }

    public Float getTotalToParent() {
        return totalToParent;
    }

    public void setTotalToParent(Float totalToParent) {
        this.totalToParent = totalToParent;
    }

    public Float getRetreat() {
        return retreat;
    }

    public void setRetreat(Float retreat) {
        this.retreat = retreat;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
