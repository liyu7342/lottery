package com.fr.lottery.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/16.
 */

public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;

    private String parentid;

    private String account;

    private String userName;

    private String parentName;

    private String password;

    private Integer status;

    private Integer usertype;

    private Date createdate;

    private Long credits;

    private Integer shortCovering;

    private Integer shareTotal;

    private Integer shareUp;

    private Integer shareFlag;

    private Integer proportional;

    private String handicap;

    private Integer amount;

    private String xpath;

    private Integer xseq;

    private String sys_user_oddsSet;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
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

    public Integer getShortCovering() {
        return shortCovering;
    }

    public void setShortCovering(Integer shortCovering) {
        this.shortCovering = shortCovering;
    }

    public Integer getShareTotal() {
        return shareTotal;
    }

    public void setShareTotal(Integer shareTotal) {
        this.shareTotal = shareTotal;
    }

    public Integer getShareUp() {
        return shareUp;
    }

    public void setShareUp(Integer shareUp) {
        this.shareUp = shareUp;
    }

    public Integer getShareFlag() {
        return shareFlag;
    }

    public void setShareFlag(Integer shareFlag) {
        this.shareFlag = shareFlag;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getXseq() {
        return xseq;
    }

    public void setXseq(Integer xseq) {
        this.xseq = xseq;
    }

    public String getSys_user_oddsSet() {
        return sys_user_oddsSet;
    }

    public void setSys_user_oddsSet(String sys_user_oddsSet) {
        this.sys_user_oddsSet = sys_user_oddsSet;
    }
}