package com.fr.lottery.dto;

/**
 * Created by Liyu7342 on 2017-9-17.
 */
public class StatisDto {
    private String gameType;
    private String no;
    private String description;

    private Integer orderNum;

    private Float amount;

    private Float aveOdds;

    private Float buhuo;

    private Float odds;

    private Float winAmount;

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Float getAveOdds() {
        return aveOdds;
    }

    public void setAveOdds(Float aveOdds) {
        this.aveOdds = aveOdds;
    }

    public Float getBuhuo() {
        return buhuo;
    }

    public void setBuhuo(Float buhuo) {
        this.buhuo = buhuo;
    }

    public Float getOdds() {
        return odds;
    }

    public void setOdds(Float odds) {
        this.odds = odds;
    }

    public Float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Float winAmount) {
        this.winAmount = winAmount;
    }
}
