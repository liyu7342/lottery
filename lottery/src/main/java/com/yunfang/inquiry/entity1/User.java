package com.yunfang.inquiry.entity1;

import java.util.Date;

public class User {
    private String id;

    private String parentid;

    private String account;

    private String name;

    private String password;

    private Byte status;

    private Byte usertype;

    private Date createdate;

    private Long credits;

    private Byte isreplenish;

    private Integer zhanchenghe;

    private Integer zongdaizhanchengshu;

    private Integer replenishpercent;

    private Integer proportional;

    private String handicap;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
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

    public Integer getProportional() {
        return proportional;
    }

    public void setProportional(Integer proportional) {
        this.proportional = proportional;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap == null ? null : handicap.trim();
    }
}