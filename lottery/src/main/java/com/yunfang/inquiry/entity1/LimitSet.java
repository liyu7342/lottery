package com.yunfang.inquiry.entity1;

import java.math.BigDecimal;

public class LimitSet {
    private String id;

    private String userid;

    private String limittype;

    private Integer singlemin;

    private Integer singlemax;

    private Integer singlehighest;

    private BigDecimal aRetreat;

    private BigDecimal bRetreat;

    private BigDecimal cRetreat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getLimittype() {
        return limittype;
    }

    public void setLimittype(String limittype) {
        this.limittype = limittype == null ? null : limittype.trim();
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

    public BigDecimal getaRetreat() {
        return aRetreat;
    }

    public void setaRetreat(BigDecimal aRetreat) {
        this.aRetreat = aRetreat;
    }

    public BigDecimal getbRetreat() {
        return bRetreat;
    }

    public void setbRetreat(BigDecimal bRetreat) {
        this.bRetreat = bRetreat;
    }

    public BigDecimal getcRetreat() {
        return cRetreat;
    }

    public void setcRetreat(BigDecimal cRetreat) {
        this.cRetreat = cRetreat;
    }
}