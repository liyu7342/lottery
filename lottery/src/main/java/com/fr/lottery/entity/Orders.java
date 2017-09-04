package com.fr.lottery.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liyu7342 on 2017-7-27.
 */
public class Orders implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;

    private String handicapid;

    private String userid;

    private Integer orderamount;

    private String orderdetail;

    private Date createdate;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHandicapid() {
        return handicapid;
    }

    public void setHandicapid(String handicapid) {
        this.handicapid = handicapid == null ? null : handicapid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Integer orderamount) {
        this.orderamount = orderamount;
    }

    public String getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(String orderdetail) {
        this.orderdetail = orderdetail == null ? null : orderdetail.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

