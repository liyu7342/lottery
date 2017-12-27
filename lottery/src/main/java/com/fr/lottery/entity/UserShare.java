package com.fr.lottery.entity;

/**
 * Created by Liyu7342 on 2017-12-24.
 * 占成
 */

public class UserShare {
    private String id;

    private String handicapId;

    private String userId;

    private String category;

    private String gameType;

    private String numbers;

    private Float shareTotal;

    private Float buhuo;

    private Float actualAmt;

    private Float baseAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHandicapId() {
        return handicapId;
    }

    public void setHandicapId(String handicapId) {
        this.handicapId = handicapId;
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

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Float getShareTotal() {
        return shareTotal;
    }

    public void setShareTotal(Float shareTotal) {
        this.shareTotal = shareTotal;
    }

    public Float getBuhuo() {
        return buhuo;
    }

    public void setBuhuo(Float buhuo) {
        this.buhuo = buhuo;
    }

    public Float getActualAmt() {
        return actualAmt;
    }

    public void setActualAmt(Float actualAmt) {
        this.actualAmt = actualAmt;
    }

    public Float getBaseAmt() {
        return baseAmt;
    }

    public void setBaseAmt(Float baseAmt) {
        this.baseAmt = baseAmt;
    }
}
