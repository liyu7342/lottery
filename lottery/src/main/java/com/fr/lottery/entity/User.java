package com.fr.lottery.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/16.
 */

public class User implements Serializable {
    public User() {
        this.status = 1;
        this.shortCovering = 1;
        this.shareUp = 0;
        this.shareTotal = 0;
        this.shareFlag = 0;
        this.credits = 0L;
        this.id = "";
    }

    private static final long serialVersionUID = 1L;

    private String id;

    private String parentid;

    private String parentAccount;


    private String account;

    private String userName;

    private String parentName;
    private String dagudongId;
    private String dagudongAccount;
    private String dagudongName;
    private Integer dagudongShare;
    private String gudongId;
    private String gudongAccount;
    private String gudongName;
    private Integer gudongShare;
    private String zongdailiId;
    private String zongdaiAccount;
    private String zongdailiName;
    private Integer zongdaiShare;
    private String dailiId;
    private String dailiAccount;
    private String dailiName;
    private Integer dailiShare;

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

    private Integer member_shareUp;

    private Boolean needToChangePwd;

    private Date lastChangeDate;

    private String sessionId;

    private Integer realUserType;

    /**
     * 真实Id
     */
    private String realId;

    private String virtualName;


    /**
     * 小股东数量
     */
    private Integer gudongNumber;
    /**
     * 总代数量
     */
    private Integer zongdaiNumber;
    /**
     * 代理商数量
     */
    private Integer dailiNumber;
    /**
     * 会员数量
     */
    private Integer memberNumber;

    private Integer userAdminNumber;

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

    public String getDagudongId() {
        return dagudongId;
    }

    public void setDagudongId(String dagudongId) {
        this.dagudongId = dagudongId;
    }

    public String getDagudongAccount() {
        return dagudongAccount;
    }

    public void setDagudongAccount(String dagudongAccount) {
        this.dagudongAccount = dagudongAccount;
    }

    public String getDagudongName() {
        return dagudongName;
    }

    public void setDagudongName(String dagudongName) {
        this.dagudongName = dagudongName;
    }

    public String getGudongId() {
        return gudongId;
    }

    public void setGudongId(String gudongId) {
        this.gudongId = gudongId;
    }

    public String getGudongAccount() {
        return gudongAccount;
    }

    public void setGudongAccount(String gudongAccount) {
        this.gudongAccount = gudongAccount;
    }

    public String getGudongName() {
        return gudongName;
    }

    public void setGudongName(String gudongName) {
        this.gudongName = gudongName;
    }

    public String getZongdailiId() {
        return zongdailiId;
    }

    public void setZongdailiId(String zongdailiId) {
        this.zongdailiId = zongdailiId;
    }

    public String getZongdaiAccount() {
        return zongdaiAccount;
    }

    public void setZongdaiAccount(String zongdaiAccount) {
        this.zongdaiAccount = zongdaiAccount;
    }

    public String getZongdailiName() {
        return zongdailiName;
    }

    public void setZongdailiName(String zongdailiName) {
        this.zongdailiName = zongdailiName;
    }

    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId;
    }

    public String getDailiAccount() {
        return dailiAccount;
    }

    public void setDailiAccount(String dailiAccount) {
        this.dailiAccount = dailiAccount;
    }

    public String getDailiName() {
        return dailiName;
    }

    public void setDailiName(String dailiName) {
        this.dailiName = dailiName;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public Integer getMember_shareUp() {
        return member_shareUp;
    }

    public void setMember_shareUp(Integer member_shareUp) {
        this.member_shareUp = member_shareUp;
    }


    public boolean getNeedToChangePwd() {
        return needToChangePwd;
    }

    public void setNeedToChangePwd(boolean needToChangePwd) {
        this.needToChangePwd = needToChangePwd;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getGudongNumber() {
        return gudongNumber;
    }

    public void setGudongNumber(Integer gudongNumber) {
        this.gudongNumber = gudongNumber;
    }

    public Integer getZongdaiNumber() {
        return zongdaiNumber;
    }

    public void setZongdaiNumber(Integer zongdaiNumber) {
        this.zongdaiNumber = zongdaiNumber;
    }


    public Integer getDailiNumber() {
        return dailiNumber;
    }

    public void setDailiNumber(Integer dailiNumber) {
        this.dailiNumber = dailiNumber;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId;
    }

    public Integer getRealUserType() {
        return realUserType;
    }

    public void setRealUserType(Integer realUserType) {
        this.realUserType = realUserType;
    }

    public Integer getDagudongShare() {
        return dagudongShare;
    }

    public void setDagudongShare(Integer dagudongShare) {
        this.dagudongShare = dagudongShare;
    }

    public Integer getGudongShare() {
        return gudongShare;
    }

    public void setGudongShare(Integer gudongShare) {
        this.gudongShare = gudongShare;
    }

    public Integer getZongdaiShare() {
        return zongdaiShare;
    }

    public void setZongdaiShare(Integer zongdaiShare) {
        this.zongdaiShare = zongdaiShare;
    }

    public Integer getDailiShare() {
        return dailiShare;
    }

    public void setDailiShare(Integer dailiShare) {
        this.dailiShare = dailiShare;
    }

    public void setNeedToChangePwd(Boolean needToChangePwd) {
        this.needToChangePwd = needToChangePwd;
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    public Integer getUserAdminNumber() {
        return userAdminNumber;
    }

    public void setUserAdminNumber(Integer userAdminNumber) {
        this.userAdminNumber = userAdminNumber;
    }
}