package com.fr.lottery.entity;

public class LimitSet {
    private String id;

    private String userId;


    private String limitType;

    private Integer singlemin;

    private Integer singlemax;

    private Integer singlehighest;

    private Long aRetreat;

    private Long bRetreat;

    private Long cRetreat;

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

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String type) {
        this.limitType = type == null ? null : type.trim();
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

    public Long getaRetreat() {
        return aRetreat;
    }

    public void setaRetreat(Long aRetreat) {
        this.aRetreat = aRetreat;
    }

    public Long getbRetreat() {
        return bRetreat;
    }

    public void setbRetreat(Long bRetreat) {
        this.bRetreat = bRetreat;
    }

    public Long getcRetreat() {
        return cRetreat;
    }

    public void setcRetreat(Long cRetreat) {
        this.cRetreat = cRetreat;
    }
}