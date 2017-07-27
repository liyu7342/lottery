package com.fr.lottery.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/16.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
   private String account;
   private String name;
   private String password;
   private Integer status;
    private Date createDate;
    private boolean isDefault;

    private Long credits;

    private Integer proportional;

    private String handicap;

    private Integer isreplenish;

    private Integer zhanchenghe;

    private Integer zongdaizhanchengshu;

    private Integer replenishpercent;

    private Integer userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
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
        this.handicap = handicap;
    }

    public Integer getIsreplenish() {
        return isreplenish;
    }

    public void setIsreplenish(Integer isreplenish) {
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


}
