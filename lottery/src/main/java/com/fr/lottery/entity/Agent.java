package com.fr.lottery.entity;


import java.io.Serializable;

public class Agent extends User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;

    private String parentid;

    private String companyid;

    private Byte isreplenish;

    private Integer zhanchenghe;

    private Integer zongdaizhanchengshu;

    private Integer replenishpercent;

    private Integer agenttype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public Byte getIsreplenish() {
        return isreplenish;
    }

    public void setIsreplenish(Byte isreplenish) {
        this.isreplenish = isreplenish;
    }

    public Integer getZhanchenghe() {
        return zhanchenghe;
    }

    public void setZhanchenghe(Integer zhanchenghe) {
        this.zhanchenghe = zhanchenghe;
    }

    public Integer getZongdaizhanchengshu() {
        return zongdaizhanchengshu;
    }

    public void setZongdaizhanchengshu(Integer zongdaizhanchengshu) {
        this.zongdaizhanchengshu = zongdaizhanchengshu;
    }

    public Integer getReplenishpercent() {
        return replenishpercent;
    }

    public void setReplenishpercent(Integer replenishpercent) {
        this.replenishpercent = replenishpercent;
    }

    public Integer getAgenttype() {
        return agenttype;
    }

    public void setAgenttype(Integer agenttype) {
        this.agenttype = agenttype;
    }
}