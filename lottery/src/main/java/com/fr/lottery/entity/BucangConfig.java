package com.fr.lottery.entity;

/**
 * Created by Administrator on 2017/11/27.
 */
public class BucangConfig {

    public BucangConfig(){

    }
    public BucangConfig(String category,String gameType,Integer _flag){
         this.category = category;
         this.gameType = gameType;
         this.flagValue = _flag;
    }
    private String id;
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 类型
     */
    private String category;
    /**
     * 玩法
     */
    private String gameType;

    /**
     * 仓位类型
     */
    private String cangType;
    /**
     * 基准金额
     */
    private Integer baseAmount;

    /**
     * 1为自动，0为手动
     */
    private Integer flagValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getCangType() {
        return cangType;
    }

    public void setCangType(String cangType) {
        this.cangType = cangType;
    }

    public Integer getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Integer baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Integer getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(Integer flagValue) {
        this.flagValue = flagValue;
    }
}
