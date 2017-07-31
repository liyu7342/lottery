package com.fr.lottery.entity;

import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.utils.StringUtil;

import java.io.Serializable;

public class LimitSet  implements Serializable{

    public LimitSet(){

    }

    public LimitSet(String userId,GameTypeEnum gameTypeEnum, Integer min, Integer max, Integer itemmax, Float aRetreat, Float bRetreat, Float cRetreat){
        this.id = StringUtil.getUUID();
        this.limitType =gameTypeEnum.getValue();
        this.singlemin =min;
        this.singlemax = max;
        this.singlehighest = itemmax;
        this.aRetreat = aRetreat;
        this.bRetreat = bRetreat;
        this.cRetreat = cRetreat;
        this.userId = userId;
    }

    private String id;

    private String userId;


    private Integer limitType;

    private Integer singlemin;

    private Integer singlemax;

    private Integer singlehighest;

    private Float aRetreat;

    private Float bRetreat;

    private Float cRetreat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLimitType() {
        return limitType;
    }

    public void setLimitType(Integer type) {
        this.limitType = type;
    }

    public Integer getSinglemin() {
        return singlemin;
    }

    public void setSinglemin(Integer singlemin) {
        this.singlemin = singlemin;
    }

    public Integer getSinglemax() {
        return singlemax;
    }

    public void setSinglemax(Integer singlemax) {
        this.singlemax = singlemax;
    }

    public Integer getSinglehighest() {
        return singlehighest;
    }

    public void setSinglehighest(Integer singlehighest) {
        this.singlehighest = singlehighest;
    }

    public Float getaRetreat() {
        return aRetreat;
    }

    public void setaRetreat(Float aRetreat) {
        this.aRetreat = aRetreat;
    }

    public Float getbRetreat() {
        return bRetreat;
    }

    public void setbRetreat(Float bRetreat) {
        this.bRetreat = bRetreat;
    }

    public Float getcRetreat() {
        return cRetreat;
    }

    public void setcRetreat(Float cRetreat) {
        this.cRetreat = cRetreat;
    }
}