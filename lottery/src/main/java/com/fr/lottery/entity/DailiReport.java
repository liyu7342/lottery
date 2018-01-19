package com.fr.lottery.entity;


/**
 * Created by Liyu7342 on 2018-1-3.
 */
public class DailiReport {

    public DailiReport() {
        this.orderNum = 0;
        this.amount = 0f;
        this.memberRetreat = 0f;
        this.memberWinamt = 0f;
        this.memberAmt = 0f;
        this.dailiAmt = 0f;
        this.dailiRetreat = 0f;
        this.dailiRetreatDiff=0f;
        this.dailiWinamt = 0f;
        this.dailiTotalamt=0f;
        this.toZongdaiAmt = 0f;
        this.toZongdaiWinamt = 0f;
    }

    private String id;
    /**
     * 代理id
     */
    private String dailiId;
    /**
     * 盘口
     */
    private String handicapId;
    /**
     *盘口日期
     */
    private String riqi;
    /**
     *会员id
     */
    private String memberId;
    /**
     *会员账号
     */
    private String memberAccount;
    /**
     *会员名称
     */
    private String memberName;
    /**
     *是否补仓 0为下单，1为补仓
     */
    private Integer isBucang;
    /**
     *下单数量
     */
    private Integer orderNum;
    /**
     *下单总额
     */
    private Float amount;
    /**
     *会员獎金
     */
    private Float memberWinamt;
    /**
     *会员佣金
     */
    private Float memberRetreat;
    /**
     *会员盈亏
     */
    private Float memberAmt;
    /**
     *代理占成
     */
    private Float dailiAmt;
    /**
     *佣金
     */
    private Float dailiRetreat;
    /**
     *佣金差
     */
    private Float dailiRetreatDiff;
    /**
     *代理奖金
     */
    private Float dailiWinamt;
    /**
     *代理盈亏
     */
    private Float dailiTotalamt;
    /**
     *上级占成
     */
    private Float toZongdaiAmt;
    /**
     *上缴总代
     */
    private Float toZongdaiWinamt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public Float getMemberRetreat() {
        return memberRetreat;
    }

    public void setMemberRetreat(Float memberRetreat) {
        this.memberRetreat = memberRetreat;
    }

    public Float getMemberAmt() {
        return memberAmt;
    }

    public void setMemberAmt(Float memberAmt) {
        this.memberAmt = memberAmt;
    }

    public Float getDailiAmt() {
        return dailiAmt;
    }

    public void setDailiAmt(Float dailiAmt) {
        this.dailiAmt = dailiAmt;
    }

    public Float getDailiRetreat() {
        return dailiRetreat;
    }

    public void setDailiRetreat(Float dailiRetreat) {
        this.dailiRetreat = dailiRetreat;
    }

    public Float getDailiWinamt() {
        return dailiWinamt;
    }

    public void setDailiWinamt(Float dailiWinamt) {
        this.dailiWinamt = dailiWinamt;
    }

    public Float getToZongdaiAmt() {
        return toZongdaiAmt;
    }

    public void setToZongdaiAmt(Float toZongdaiAmt) {
        this.toZongdaiAmt = toZongdaiAmt;
    }

    public Float getToZongdaiWinamt() {
        return toZongdaiWinamt;
    }

    public void setToZongdaiWinamt(Float toZongdaiWinamt) {
        this.toZongdaiWinamt = toZongdaiWinamt;
    }

    public Float getDailiRetreatDiff() {
        return dailiRetreatDiff;
    }

    public void setDailiRetreatDiff(Float dailiRetreatDiff) {
        this.dailiRetreatDiff = dailiRetreatDiff;
    }

    public Float getDailiTotalamt() {
        return dailiTotalamt;
    }

    public void setDailiTotalamt(Float dailiTotalamt) {
        this.dailiTotalamt = dailiTotalamt;
    }
}
