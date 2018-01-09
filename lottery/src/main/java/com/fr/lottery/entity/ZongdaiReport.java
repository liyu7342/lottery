package com.fr.lottery.entity;

/**
 * Created by Liyu7342 on 2018-1-4.
 */
public class ZongdaiReport {

    public ZongdaiReport(){
        this.memberCount=0;
        this.amount =0f;
        this.orderNum=0;
        this.memberAmt=0f;
        this.dailiToZongdaiWinamt=0f;
        this.dailiToZongdai=0f;
        this.zongdaiAmt=0f;
        this.zongdaiRetreat=0f;
        this.zongdaiWinamt=0f;
        this.gudongAmt=0f;
        this.gudongWinamt=0f;
    }

    private String id;
    /**
     * 总代id
     */
    private String zongdaiId;
    /**
     * 盘口id
     */
    private String handicapId;
    /**
     * 盘口日期
     */
    private String riqi;
    /**
     *代理id
     */
    private String dailiId;
    /**
     *代理账号
     */
    private String dailiAccount;
    /**
     *代理名称
     */
    private String dailiName;
    /**
     *是否补仓
     */
    private Integer isBucang;
    /**
     *下单笔数
     */
    private Integer orderNum;
    /**
     *会员数
     */
    private Integer memberCount;
    /**
     *下注总额
     */
    private Float amount;
    /**
     * 会员奖金
     */
    private Float winAmount;
    /**
     *会员佣金
     */
    private Float retreatAmt;
    /**
     *会员盈亏
     */
    private Float memberAmt;
    /**
     *占成上缴
     */
    private Float dailiToZongdai;
    /**
     *代理盈亏
     */
    private Float dailiToZongdaiWinamt;
    /**
     *总代占成
     */
    private Float zongdaiAmt;
    /**
     * 总代佣金
     */
    private Float zongdaiRetreat;
    /**
     *总代盈亏
     */
    private Float zongdaiWinamt;
    /**
     * 股东占成
     */
    private Float gudongAmt;
    /**
     * 总代上缴
     */
    private Float gudongWinamt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZongdaiId() {
        return zongdaiId;
    }

    public void setZongdaiId(String zongdaiId) {
        this.zongdaiId = zongdaiId;
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

    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId;
    }

    public String getDailiAccount() {
        return dailiAccount;
    }

    public void setDailiAccount(String dailiAccount) {
        this.dailiAccount = dailiAccount;
    }

    public String getDailiName() {
        return dailiName;
    }

    public void setDailiName(String dailiName) {
        this.dailiName = dailiName;
    }

    public Integer getIsBucang() {
        return isBucang;
    }

    public void setIsBucang(Integer isBucang) {
        this.isBucang = isBucang;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Float winAmount) {
        this.winAmount = winAmount;
    }

    public Float getRetreatAmt() {
        return retreatAmt;
    }

    public void setRetreatAmt(Float retreatAmt) {
        this.retreatAmt = retreatAmt;
    }

    public Float getMemberAmt() {
        return memberAmt;
    }

    public void setMemberAmt(Float memberAmt) {
        this.memberAmt = memberAmt;
    }

    public Float getDailiToZongdaiWinamt() {
        return dailiToZongdaiWinamt;
    }

    public void setDailiToZongdaiWinamt(Float dailiToZongdaiWinamt) {
        this.dailiToZongdaiWinamt = dailiToZongdaiWinamt;
    }

    public Float getDailiToZongdai() {
        return dailiToZongdai;
    }

    public void setDailiToZongdai(Float dailiToZongdai) {
        this.dailiToZongdai = dailiToZongdai;
    }

    public Float getZongdaiAmt() {
        return zongdaiAmt;
    }

    public void setZongdaiAmt(Float zongdaiAmt) {
        this.zongdaiAmt = zongdaiAmt;
    }

    public Float getZongdaiRetreat() {
        return zongdaiRetreat;
    }

    public void setZongdaiRetreat(Float zongdaiRetreat) {
        this.zongdaiRetreat = zongdaiRetreat;
    }

    public Float getZongdaiWinamt() {
        return zongdaiWinamt;
    }

    public void setZongdaiWinamt(Float zongdaiWinamt) {
        this.zongdaiWinamt = zongdaiWinamt;
    }

    public Float getGudongAmt() {
        return gudongAmt;
    }

    public void setGudongAmt(Float gudongAmt) {
        this.gudongAmt = gudongAmt;
    }

    public Float getGudongWinamt() {
        return gudongWinamt;
    }

    public void setGudongWinamt(Float gudongWinamt) {
        this.gudongWinamt = gudongWinamt;
    }
}
