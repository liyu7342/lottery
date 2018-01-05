package com.fr.lottery.dto;

/**
 * Created by Liyu7342 on 2018-1-5.
 */
public class GudongReportDto {
    public  GudongReportDto(){
        this.memberCount=0;
        this.amount =0f;
        this.orderNum=0;
        this.memberActualAmt=0f;
        this.zongdaiToParentShareUp=0f;
        this.zongdaiToParentWinamt=0f;
        this.zhancheng=0f;
        this.gudongRetreat=0f;
        this.gudongWinamt=0f;
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
    private Float zongdaiToParentShareUp;
    private Float zongdaiToParentWinamt;
    private Float zhancheng;
    private Float gudongWinamt;
    private Float gudongRetreat;
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

    public Float getZongdaiToParentShareUp() {
        return zongdaiToParentShareUp;
    }

    public void setZongdaiToParentShareUp(Float zongdaiToParentShareUp) {
        this.zongdaiToParentShareUp = zongdaiToParentShareUp;
    }

    public Float getZongdaiToParentWinamt() {
        return zongdaiToParentWinamt;
    }

    public void setZongdaiToParentWinamt(Float zongdaiToParentWinamt) {
        this.zongdaiToParentWinamt = zongdaiToParentWinamt;
    }

    public Float getGudongWinamt() {
        return gudongWinamt;
    }

    public void setGudongWinamt(Float gudongWinamt) {
        this.gudongWinamt = gudongWinamt;
    }

    public Float getGudongRetreat() {
        return gudongRetreat;
    }

    public void setGudongRetreat(Float gudongRetreat) {
        this.gudongRetreat = gudongRetreat;
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
