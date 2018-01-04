package com.fr.lottery.dto;

/**
 * Created by Liyu7342 on 2018-1-4.
 */
public class ZongdaiReportDto {

    public  ZongdaiReportDto(){
        this.memberCount=0;
        this.amount =0f;
        this.orderNum=0;
        this.memberActualAmt=0f;
        this.dailiToParentShareUp=0f;
        this.dailiToParentWinamt=0f;
        this.zhancheng=0f;
        this.zongdaiRetreat=0f;
        this.zongdaiWinamt=0f;
        this.parentShareUp=0f;
        this.parentWinamt=0f;
    }

    private String id;
    private String account;
    private String userName;
    private Integer isBucang;
    private Integer orderNum;
    private Integer memberCount;
    private Float amount;
    private Float memberActualAmt;
    private Float dailiToParentShareUp;
    private Float dailiToParentWinamt;
    private Float zhancheng;
    private Float zongdaiWinamt;
    private Float zongdaiRetreat;
    private Float parentShareUp;
    private Float parentWinamt;

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

    public Float getMemberActualAmt() {
        return memberActualAmt;
    }

    public void setMemberActualAmt(Float memberActualAmt) {
        this.memberActualAmt = memberActualAmt;
    }

    public Float getDailiToParentShareUp() {
        return dailiToParentShareUp;
    }

    public void setDailiToParentShareUp(Float dailiToParentShareUp) {
        this.dailiToParentShareUp = dailiToParentShareUp;
    }

    public Float getDailiToParentWinamt() {
        return dailiToParentWinamt;
    }

    public void setDailiToParentWinamt(Float dailiToParentWinamt) {
        this.dailiToParentWinamt = dailiToParentWinamt;
    }

    public Float getZongdaiWinamt() {
        return zongdaiWinamt;
    }

    public void setZongdaiWinamt(Float zongdaiWinamt) {
        this.zongdaiWinamt = zongdaiWinamt;
    }

    public Float getZongdaiRetreat() {
        return zongdaiRetreat;
    }

    public void setZongdaiRetreat(Float zongdaiRetreat) {
        this.zongdaiRetreat = zongdaiRetreat;
    }

    public Float getParentShareUp() {
        return parentShareUp;
    }

    public void setParentShareUp(Float parentShareUp) {
        this.parentShareUp = parentShareUp;
    }

    public Float getParentWinamt() {
        return parentWinamt;
    }

    public void setParentWinamt(Float parentWinamt) {
        this.parentWinamt = parentWinamt;
    }

    public Float getZhancheng() {
        return zhancheng;
    }

    public void setZhancheng(Float zhancheng) {
        this.zhancheng = zhancheng;
    }
}
