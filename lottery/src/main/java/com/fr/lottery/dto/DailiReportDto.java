package com.fr.lottery.dto;


/**
 * Created by Liyu7342 on 2018-1-3.
 */
public class DailiReportDto {

    public DailiReportDto(){
        this.orderNum=0;
        this.amount=0f;
        this.winAmount=0f;
        this.retreat=0f;
        this.memberActualAmt=0f;
        this.zhancheng=0f;
        this.dailiretreat=0f;
        this.dailiwinamt=0f;
        this.parentShareUp=0f;
        this.parentWinAmt=0f;
    }
    /**
     * 代理id
     */
    private String id;

    /**
     * 代理账号
     */
    private String account;
    /**
     * 代理名称
     */
    private String userName;

    private Integer isBucang;
    /**
     * 笔数
     */
    private Integer orderNum;

    /**
     * 下注金额
     */
    private Float amount;

    /**
     * 会员獎金
     */
    private Float winAmount;
    /**
     * 會員佣金
     */
    private Float retreat;
    /**
     * 會員盈虧
     */
    private Float memberActualAmt;
    /**
     * 代理占成
     */
    private Float zhancheng;
    /**
     * 佣金差 （代理佣金-會員佣金）
     */
    private Float dailiretreat;
    /**
     * 代理盈虧
     */
    private Float dailiwinamt;
    /**
     * 上級占成
     */
    private Float parentShareUp;
    /**
     * 上繳總代
     */
    private Float parentWinAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Float winAmount) {
        this.winAmount = winAmount;
    }

    public Float getRetreat() {
        return retreat;
    }

    public void setRetreat(Float retreat) {
        this.retreat = retreat;
    }

    public Float getMemberActualAmt() {
        return memberActualAmt;
    }

    public void setMemberActualAmt(Float memberActualAmt) {
        this.memberActualAmt = memberActualAmt;
    }

    public Float getZhancheng() {
        return zhancheng;
    }

    public void setZhancheng(Float zhancheng) {
        this.zhancheng = zhancheng;
    }

    public Float getDailiretreat() {
        return dailiretreat;
    }

    public void setDailiretreat(Float dailiretreat) {
        this.dailiretreat = dailiretreat;
    }

    public Float getDailiwinamt() {
        return dailiwinamt;
    }

    public void setDailiwinamt(Float dailiwinamt) {
        this.dailiwinamt = dailiwinamt;
    }

    public Float getParentShareUp() {
        return parentShareUp;
    }

    public void setParentShareUp(Float parentShareUp) {
        this.parentShareUp = parentShareUp;
    }

    public Float getParentWinAmt() {
        return parentWinAmt;
    }

    public void setParentWinAmt(Float parentWinAmt) {
        this.parentWinAmt = parentWinAmt;
    }

    public Integer getIsBucang() {
        return isBucang;
    }

    public void setIsBucang(Integer isBucang) {
        this.isBucang = isBucang;
    }
}
