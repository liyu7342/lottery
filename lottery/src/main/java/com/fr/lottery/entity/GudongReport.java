package com.fr.lottery.entity;

/**
 * Created by Liyu7342 on 2018-1-8.
 */
public class GudongReport {

    public  GudongReport(){
        this.orderNum=0;
        this.memberCount=0;
        this.amount=0f;
        this.winAmount=0f;
        this.retreatAmt=0f;
        this.memberAmt=0f;
        this.zongdaiToGudong=0f;
        this.dailiToZongdai=0f;
        this.gudongAmt=0f;
        this.gudongRetreat=0f;
        this.gudongWinamt=0f;
        this.dagudongAmt=0f;
        this.dagudongWinAmt=0f;


    }
    private String id;
    private String gudongId;
    private String handicapId;
    private String riqi;
    private String zongdaiId;
    private String zongdaiAccount;
    private String zongdaiName;
    private Integer isBucang;
    private Integer orderNum;
    private Integer memberCount;
    private Float amount;
    private Float winAmount;
    private Float retreatAmt;
    private Float memberAmt;
    private Float dailiToZongdai;
    private Float zongdaiToGudong;
    private Float gudongAmt;
    private Float gudongRetreat;
    private Float gudongWinamt;
    private Float dagudongAmt;
    private Float dagudongWinAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGudongId() {
        return gudongId;
    }

    public void setGudongId(String gudongId) {
        this.gudongId = gudongId;
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

    public String getZongdaiId() {
        return zongdaiId;
    }

    public void setZongdaiId(String zongdaiId) {
        this.zongdaiId = zongdaiId;
    }

    public String getZongdaiAccount() {
        return zongdaiAccount;
    }

    public void setZongdaiAccount(String zongdaiAccount) {
        this.zongdaiAccount = zongdaiAccount;
    }

    public String getZongdaiName() {
        return zongdaiName;
    }

    public void setZongdaiName(String zongdaiName) {
        this.zongdaiName = zongdaiName;
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

    public Float getDailiToZongdai() {
        return dailiToZongdai;
    }

    public void setDailiToZongdai(Float dailiToZongdai) {
        this.dailiToZongdai = dailiToZongdai;
    }

    public Float getZongdaiToGudong() {
        return zongdaiToGudong;
    }

    public void setZongdaiToGudong(Float zongdaiToGudong) {
        this.zongdaiToGudong = zongdaiToGudong;
    }

    public Float getGudongAmt() {
        return gudongAmt;
    }

    public void setGudongAmt(Float gudongAmt) {
        this.gudongAmt = gudongAmt;
    }

    public Float getGudongRetreat() {
        return gudongRetreat;
    }

    public void setGudongRetreat(Float gudongRetreat) {
        this.gudongRetreat = gudongRetreat;
    }

    public Float getGudongWinamt() {
        return gudongWinamt;
    }

    public void setGudongWinamt(Float gudongWinamt) {
        this.gudongWinamt = gudongWinamt;
    }

    public Float getDagudongAmt() {
        return dagudongAmt;
    }

    public void setDagudongAmt(Float dagudongAmt) {
        this.dagudongAmt = dagudongAmt;
    }

    public Float getDagudongWinAmt() {
        return dagudongWinAmt;
    }

    public void setDagudongWinAmt(Float dagudongWinAmt) {
        this.dagudongWinAmt = dagudongWinAmt;
    }
}
