package com.fr.lottery.dto;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Liyu7342 on 2017-9-17.
 */
public class UserHistoryDto {
    private String userId;
    /***
     * 注单日期
     */
    private String historyDate;
    /***
     * 注单数量
     */
    private String orderNum;
    /***
     * 注单金额
     */
    private Integer amount;
    /**
     * 结果
     */
    private String winAmount;

    private Integer totalAmount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(String historyDate) {
        this.historyDate = historyDate;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(String winAmount) {
        this.winAmount = winAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
