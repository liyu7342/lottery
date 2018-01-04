package com.fr.lottery.dto;


/**
 * Created by Liyu7342 on 2017-9-17.
 */
public class MemberReportDto {
    private String id;
    private String userId;
    /***
     * 注单日期
     */
    private String riqi;
    /***
     * 注单数量
     */
    private Integer orderNum;
    /***
     * 注单金额
     */
    private Integer amount;
    /**
     * 结果
     */
    private Float winAmount;

    private String canWinAmount;

    private Integer totalAmount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Float winAmount) {
        this.winAmount = winAmount;
    }

    public String getCanWinAmount() {
        return canWinAmount;
    }

    public void setCanWinAmount(String canWinAmount) {
        this.canWinAmount = canWinAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
