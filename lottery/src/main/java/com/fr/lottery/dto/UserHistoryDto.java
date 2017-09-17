package com.fr.lottery.dto;

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
    private String amount;
    /**
     * 结果
     */
    private String winAmount;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(String winAmount) {
        this.winAmount = winAmount;
    }
}
