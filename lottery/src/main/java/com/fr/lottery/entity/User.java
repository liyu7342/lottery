package com.fr.lottery.entity;

import org.joda.time.DateTime;

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
    private Integer userType;
    private DateTime createDate;

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

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }
}
