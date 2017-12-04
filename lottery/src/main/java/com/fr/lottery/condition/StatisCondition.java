package com.fr.lottery.condition;

/**
 * Created by Administrator on 2017/11/29.
 */
public class StatisCondition {
    private String p_userId;

    private String p_handicapId;

    private String p_xpath;

    private String p_categoryId;

    private String p_gameType;

    private Integer p_start;

    private Integer p_pageSize;


    public String getP_userId() {
        return p_userId;
    }

    public void setP_userId(String p_userId) {
        this.p_userId = p_userId;
    }

    public String getP_handicapId() {
        return p_handicapId;
    }

    public void setP_handicapId(String p_handicapId) {
        this.p_handicapId = p_handicapId;
    }

    public String getP_xpath() {
        return p_xpath;
    }

    public void setP_xpath(String p_xpath) {
        this.p_xpath = p_xpath;
    }

    public String getP_categoryId() {
        return p_categoryId;
    }

    public void setP_categoryId(String p_categoryId) {
        this.p_categoryId = p_categoryId;
    }

    public String getP_gameType() {
        return p_gameType;
    }

    public void setP_gameType(String p_gameType) {
        this.p_gameType = p_gameType;
    }

    public Integer getP_start() {
        return p_start;
    }

    public void setP_start(Integer p_start) {
        this.p_start = p_start;
    }

    public Integer getP_pageSize() {
        return p_pageSize;
    }

    public void setP_pageSize(Integer p_pageSize) {
        this.p_pageSize = p_pageSize;
    }
}
