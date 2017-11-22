package com.fr.lottery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Handicap {
    private String id;

    private String qishu;

    private String riqi;

    private Integer status;

    private String no1;

    private String no2;

    private String no3;

    private String no4;

    private String no5;

    private String no6;

    private String tema;

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


     private String xiao1;
    private String xiaoName1;
    private String xiao2;
    private String xiaoName2;
    private String xiao3;
    private String xiaoName3;
    private String xiao4;
    private String xiaoName4;
    private String xiao5;
    private String xiaoName5;
    private String xiao6;
    private String xiaoName6;
    private String texiaono;
    private String texiaoName;
private String heDanshuang;
    private Integer zongfen;
    private String teDanshuang;
    private String teDaxiao;
    private String zongDanshuang;
    private String zongDaxiao;


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNo1() {
        return no1;
    }

    public void setNo1(String no1) {
        this.no1 = no1;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getNo3() {
        return no3;
    }

    public void setNo3(String no3) {
        this.no3 = no3;
    }

    public String getNo4() {
        return no4;
    }

    public void setNo4(String no4) {
        this.no4 = no4;
    }

    public String getNo5() {
        return no5;
    }

    public void setNo5(String no5) {
        this.no5 = no5;
    }

    public String getNo6() {
        return no6;
    }

    public void setNo6(String no6) {
        this.no6 = no6;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
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

    public String getXiaoName4() {
        return xiaoName4;
    }

    public void setXiaoName4(String xiaoName4) {
        this.xiaoName4 = xiaoName4;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getXiao1() {
        return xiao1;
    }

    public void setXiao1(String xiao1) {
        this.xiao1 = xiao1;
    }

    public String getXiaoName1() {
        return xiaoName1;
    }

    public void setXiaoName1(String xiaoName1) {
        this.xiaoName1 = xiaoName1;
    }

    public String getXiao2() {
        return xiao2;
    }

    public void setXiao2(String xiao2) {
        this.xiao2 = xiao2;
    }

    public String getXiaoName2() {
        return xiaoName2;
    }

    public void setXiaoName2(String xiaoName2) {
        this.xiaoName2 = xiaoName2;
    }

    public String getXiao3() {
        return xiao3;
    }

    public void setXiao3(String xiao3) {
        this.xiao3 = xiao3;
    }

    public String getXiaoName3() {
        return xiaoName3;
    }

    public void setXiaoName3(String xiaoName3) {
        this.xiaoName3 = xiaoName3;
    }

    public String getXiao4() {
        return xiao4;
    }

    public void setXiao4(String xiao4) {
        this.xiao4 = xiao4;
    }

    public String getXiao5() {
        return xiao5;
    }

    public void setXiao5(String xiao5) {
        this.xiao5 = xiao5;
    }

    public String getXiaoName5() {
        return xiaoName5;
    }

    public void setXiaoName5(String xiaoName5) {
        this.xiaoName5 = xiaoName5;
    }

    public String getXiao6() {
        return xiao6;
    }

    public void setXiao6(String xiao6) {
        this.xiao6 = xiao6;
    }

    public String getXiaoName6() {
        return xiaoName6;
    }

    public void setXiaoName6(String xiaoName6) {
        this.xiaoName6 = xiaoName6;
    }

    public String getTexiaono() {
        return texiaono;
    }

    public void setTexiaono(String texiaono) {
        this.texiaono = texiaono;
    }

    public String getTexiaoName() {
        return texiaoName;
    }

    public void setTexiaoName(String texiaoName) {
        this.texiaoName = texiaoName;
    }

    public Integer getZongfen() {
        return zongfen;
    }

    public void setZongfen(Integer zongfen) {
        this.zongfen = zongfen;
    }

    public String getTeDanshuang() {
        return teDanshuang;
    }

    public void setTeDanshuang(String teDanshuang) {
        this.teDanshuang = teDanshuang;
    }

    public String getTeDaxiao() {
        return teDaxiao;
    }

    public void setTeDaxiao(String teDaxiao) {
        this.teDaxiao = teDaxiao;
    }

    public String getZongDanshuang() {
        return zongDanshuang;
    }

    public void setZongDanshuang(String zongDanshuang) {
        this.zongDanshuang = zongDanshuang;
    }

    public String getZongDaxiao() {
        return zongDaxiao;
    }

    public void setZongDaxiao(String zongDaxiao) {
        this.zongDaxiao = zongDaxiao;
    }

    public String getHeDanshuang() {
        return heDanshuang;
    }

    public void setHeDanshuang(String heDanshuang) {
        this.heDanshuang = heDanshuang;
    }
}