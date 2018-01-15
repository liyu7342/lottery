package com.fr.lottery.entity;

/**
 * Created by Liyu7342 on 2018-1-10.
 */
public class DagudongReport {

    public DagudongReport(){
        this.orderNum=0;
        this.isBucang=0;
        this.memberCount=0;
        this.memberAmt=0f;
        this.amount=0f;
        this.winAmount=0f;
        this.retreatAmt =0f;
        this.gudongToParent=0f;
        this.gudongToParentWinamt=0f;
        this.dagudongAmt=0f;
        this.dagudongRetreat=0f;
        this.dagudongWinamt=0f;
        this.guanliyuanAmt=0f;
        this.guanliyuanWinAmt=0f;
    }
    private String id;
    private String dagudongId;
    private String handicapId;
    private String riqi;
    private Integer isBucang;
    private String gudongId;
    private String gudongAccount;
    private String gudongName;
    private Integer orderNum;
    private Integer memberCount;
    private Float amount;
    private Float winAmount;
    private Float retreatAmt;
    private Float memberAmt;
    private Float gudongToParentWinamt;
    private Float gudongToParent;
    private Float dagudongAmt;
    private Float dagudongRetreat;
    private Float dagudongWinamt;
    private Float guanliyuanAmt;
    private Float guanliyuanWinAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDagudongId() {
        return dagudongId;
    }

    public void setDagudongId(String dagudongId) {
        this.dagudongId = dagudongId;
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

    public Integer getIsBucang() {
        return isBucang;
    }

    public void setIsBucang(Integer isBucang) {
        this.isBucang = isBucang;
    }

    public String getGudongId() {
        return gudongId;
    }

    public void setGudongId(String gudongId) {
        this.gudongId = gudongId;
    }

    public String getGudongAccount() {
        return gudongAccount;
    }

    public void setGudongAccount(String gudongAccount) {
        this.gudongAccount = gudongAccount;
    }

    public String getGudongName() {
        return gudongName;
    }

    public void setGudongName(String gudongName) {
        this.gudongName = gudongName;
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

    public Float getGudongToParentWinamt() {
        return gudongToParentWinamt;
    }

    public void setGudongToParentWinamt(Float gudongToParentWinamt) {
        this.gudongToParentWinamt = gudongToParentWinamt;
    }

    public Float getGudongToParent() {
        return gudongToParent;
    }

    public void setGudongToParent(Float gudongToParent) {
        this.gudongToParent = gudongToParent;
    }

    public Float getDagudongAmt() {
        return dagudongAmt;
    }

    public void setDagudongAmt(Float dagudongAmt) {
        this.dagudongAmt = dagudongAmt;
    }

    public Float getDagudongRetreat() {
        return dagudongRetreat;
    }

    public void setDagudongRetreat(Float dagudongRetreat) {
        this.dagudongRetreat = dagudongRetreat;
    }

    public Float getDagudongWinamt() {
        return dagudongWinamt;
    }

    public void setDagudongWinamt(Float dagudongWinamt) {
        this.dagudongWinamt = dagudongWinamt;
    }

    public Float getGuanliyuanAmt() {
        return guanliyuanAmt;
    }

    public void setGuanliyuanAmt(Float guanliyuanAmt) {
        this.guanliyuanAmt = guanliyuanAmt;
    }

    public Float getGuanliyuanWinAmt() {
        return guanliyuanWinAmt;
    }

    public void setGuanliyuanWinAmt(Float guanliyuanWinAmt) {
        this.guanliyuanWinAmt = guanliyuanWinAmt;
    }
}
