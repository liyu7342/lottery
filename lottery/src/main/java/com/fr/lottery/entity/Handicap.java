package com.fr.lottery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Handicap {
    private String id;

    private String qishu;

    private Byte status;

    private Integer no1;

    private Integer no2;

    private Integer no3;

    private Integer no4;

    private Integer no5;

    private Integer no6;

    private Integer tema;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date opentime;

    private Boolean autoopen;

    private Boolean temastatus;

    private Boolean zhengmastatus;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date temaclosetime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date zhengmaclosetime;

    private Boolean issettlement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQishu() {
        return qishu;
    }

    public void setQishu(String qishu) {
        this.qishu = qishu == null ? null : qishu.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getNo1() {
        return no1;
    }

    public void setNo1(Integer no1) {
        this.no1 = no1;
    }

    public Integer getNo2() {
        return no2;
    }

    public void setNo2(Integer no2) {
        this.no2 = no2;
    }

    public Integer getNo3() {
        return no3;
    }

    public void setNo3(Integer no3) {
        this.no3 = no3;
    }

    public Integer getNo4() {
        return no4;
    }

    public void setNo4(Integer no4) {
        this.no4 = no4;
    }

    public Integer getNo5() {
        return no5;
    }

    public void setNo5(Integer no5) {
        this.no5 = no5;
    }

    public Integer getNo6() {
        return no6;
    }

    public void setNo6(Integer no6) {
        this.no6 = no6;
    }

    public Integer getTema() {
        return tema;
    }

    public void setTema(Integer tema) {
        this.tema = tema;
    }


    public Date getOpentime() {
        return opentime;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    public Boolean getAutoopen() {
        return autoopen;
    }

    public void setAutoopen(Boolean autoopen) {
        this.autoopen = autoopen;
    }

    public Boolean getTemastatus() {
        return temastatus;
    }

    public void setTemastatus(Boolean temastatus) {
        this.temastatus = temastatus;
    }

    public Boolean getZhengmastatus() {
        return zhengmastatus;
    }

    public void setZhengmastatus(Boolean zhengmastatus) {
        this.zhengmastatus = zhengmastatus;
    }


    public Date getTemaclosetime() {
        return temaclosetime;
    }

    public void setTemaclosetime(Date temaclosetime) {
        this.temaclosetime = temaclosetime;
    }


    public Date getZhengmaclosetime() {
        return zhengmaclosetime;
    }

    public void setZhengmaclosetime(Date zhengmaclosetime) {
        this.zhengmaclosetime = zhengmaclosetime;
    }

    public Boolean getIssettlement() {
        return issettlement;
    }

    public void setIssettlement(Boolean issettlement) {
        this.issettlement = issettlement;
    }
}