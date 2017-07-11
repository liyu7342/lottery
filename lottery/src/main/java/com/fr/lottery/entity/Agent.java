package com.fr.lottery.entity;


import javax.xml.registry.infomodel.*;
import java.io.Serializable;

public class Agent extends User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;

    private String userid;

    private String parentid;

    private String companyid;

    private Integer tSinglemin;

    private Integer tSinglemax;

    private Integer tSinglehighest;

    private Integer zSinglemin;

    private Integer zSinglemax;

    private Integer zSinglehighest;

    private Integer ztSinglemin;

    private Integer ztSinglemax;

    private Integer ztSinglehighest;

    private Integer l2Singlemin;

    private Integer l2Singlemax;

    private Integer l2Singlehighest;

    private Integer l3Singlemin;

    private Integer l3Singlemax;

    private Integer l3Singlehighest;

    private Integer ggSinglemin;

    private Integer ggSinglemax;

    private Integer ggSinglehighest;

    private Integer bbSinglemin;

    private Integer bbSinglemax;

    private Integer bbSinglehighest;

    private Integer lxSinglemin;

    private Integer lxSinglemax;

    private Integer lxSinglehighest;

    private Integer lmSinglemin;

    private Integer lmSinglemax;

    private Integer lmSinglehighest;

    private Integer txSinglemin;

    private Integer txSinglemax;

    private Integer txSinglehighest;

    private Integer sxlSinglemin;

    private Integer sxlSinglemax;

    private Integer sxlSinglehighest;

    private Integer wslSinglemin;

    private Integer wslSinglemax;

    private Integer wslSinglehighest;

    private Float taRetreat;

    private Float tbRetreat;

    private Float tcRetreat;

    private Float zaRetreat;

    private Float zbRetreat;

    private Float zcRetreat;

    private Float ztaRetreat;

    private Float ztbRetreat;

    private Float ztcRetreat;

    private Float l2aRetreat;

    private Float l2bRetreat;

    private Float l2cRetreat;

    private Float l3aRetreat;

    private Float l3bRetreat;

    private Float l3cRetreat;

    private Float ggaRetreat;

    private Float ggbRetreat;

    private Float ggcRetreat;

    private Float bbaRetreat;

    private Float bbbRetreat;

    private Float bbcRetreat;

    private Float lxaRetreat;

    private Float lxbRetreat;

    private Float lxcRetreat;

    private Float lmaRetreat;

    private Float lmbRetreat;

    private Float lmcRetreat;

    private Float txaRetreat;

    private Float txbRetreat;

    private Float txcRetreat;

    private Float sxlaRetreat;

    private Float sxlbRetreat;

    private Float sxlcRetreat;

    private Byte isreplenish;

    private Integer zhanchenghe;

    private Integer zongdaizhanchengshu;

    private Integer replenishpercent;

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

    public Integer gettSinglemin() {
        return tSinglemin;
    }

    public void settSinglemin(Integer tSinglemin) {
        this.tSinglemin = tSinglemin;
    }

    public Integer gettSinglemax() {
        return tSinglemax;
    }

    public void settSinglemax(Integer tSinglemax) {
        this.tSinglemax = tSinglemax;
    }

    public Integer gettSinglehighest() {
        return tSinglehighest;
    }

    public void settSinglehighest(Integer tSinglehighest) {
        this.tSinglehighest = tSinglehighest;
    }

    public Integer getzSinglemin() {
        return zSinglemin;
    }

    public void setzSinglemin(Integer zSinglemin) {
        this.zSinglemin = zSinglemin;
    }

    public Integer getzSinglemax() {
        return zSinglemax;
    }

    public void setzSinglemax(Integer zSinglemax) {
        this.zSinglemax = zSinglemax;
    }

    public Integer getzSinglehighest() {
        return zSinglehighest;
    }

    public void setzSinglehighest(Integer zSinglehighest) {
        this.zSinglehighest = zSinglehighest;
    }

    public Integer getZtSinglemin() {
        return ztSinglemin;
    }

    public void setZtSinglemin(Integer ztSinglemin) {
        this.ztSinglemin = ztSinglemin;
    }

    public Integer getZtSinglemax() {
        return ztSinglemax;
    }

    public void setZtSinglemax(Integer ztSinglemax) {
        this.ztSinglemax = ztSinglemax;
    }

    public Integer getZtSinglehighest() {
        return ztSinglehighest;
    }

    public void setZtSinglehighest(Integer ztSinglehighest) {
        this.ztSinglehighest = ztSinglehighest;
    }

    public Integer getL2Singlemin() {
        return l2Singlemin;
    }

    public void setL2Singlemin(Integer l2Singlemin) {
        this.l2Singlemin = l2Singlemin;
    }

    public Integer getL2Singlemax() {
        return l2Singlemax;
    }

    public void setL2Singlemax(Integer l2Singlemax) {
        this.l2Singlemax = l2Singlemax;
    }

    public Integer getL2Singlehighest() {
        return l2Singlehighest;
    }

    public void setL2Singlehighest(Integer l2Singlehighest) {
        this.l2Singlehighest = l2Singlehighest;
    }

    public Integer getL3Singlemin() {
        return l3Singlemin;
    }

    public void setL3Singlemin(Integer l3Singlemin) {
        this.l3Singlemin = l3Singlemin;
    }

    public Integer getL3Singlemax() {
        return l3Singlemax;
    }

    public void setL3Singlemax(Integer l3Singlemax) {
        this.l3Singlemax = l3Singlemax;
    }

    public Integer getL3Singlehighest() {
        return l3Singlehighest;
    }

    public void setL3Singlehighest(Integer l3Singlehighest) {
        this.l3Singlehighest = l3Singlehighest;
    }

    public Integer getGgSinglemin() {
        return ggSinglemin;
    }

    public void setGgSinglemin(Integer ggSinglemin) {
        this.ggSinglemin = ggSinglemin;
    }

    public Integer getGgSinglemax() {
        return ggSinglemax;
    }

    public void setGgSinglemax(Integer ggSinglemax) {
        this.ggSinglemax = ggSinglemax;
    }

    public Integer getGgSinglehighest() {
        return ggSinglehighest;
    }

    public void setGgSinglehighest(Integer ggSinglehighest) {
        this.ggSinglehighest = ggSinglehighest;
    }

    public Integer getBbSinglemin() {
        return bbSinglemin;
    }

    public void setBbSinglemin(Integer bbSinglemin) {
        this.bbSinglemin = bbSinglemin;
    }

    public Integer getBbSinglemax() {
        return bbSinglemax;
    }

    public void setBbSinglemax(Integer bbSinglemax) {
        this.bbSinglemax = bbSinglemax;
    }

    public Integer getBbSinglehighest() {
        return bbSinglehighest;
    }

    public void setBbSinglehighest(Integer bbSinglehighest) {
        this.bbSinglehighest = bbSinglehighest;
    }

    public Integer getLxSinglemin() {
        return lxSinglemin;
    }

    public void setLxSinglemin(Integer lxSinglemin) {
        this.lxSinglemin = lxSinglemin;
    }

    public Integer getLxSinglemax() {
        return lxSinglemax;
    }

    public void setLxSinglemax(Integer lxSinglemax) {
        this.lxSinglemax = lxSinglemax;
    }

    public Integer getLxSinglehighest() {
        return lxSinglehighest;
    }

    public void setLxSinglehighest(Integer lxSinglehighest) {
        this.lxSinglehighest = lxSinglehighest;
    }

    public Integer getLmSinglemin() {
        return lmSinglemin;
    }

    public void setLmSinglemin(Integer lmSinglemin) {
        this.lmSinglemin = lmSinglemin;
    }

    public Integer getLmSinglemax() {
        return lmSinglemax;
    }

    public void setLmSinglemax(Integer lmSinglemax) {
        this.lmSinglemax = lmSinglemax;
    }

    public Integer getLmSinglehighest() {
        return lmSinglehighest;
    }

    public void setLmSinglehighest(Integer lmSinglehighest) {
        this.lmSinglehighest = lmSinglehighest;
    }

    public Integer getTxSinglemin() {
        return txSinglemin;
    }

    public void setTxSinglemin(Integer txSinglemin) {
        this.txSinglemin = txSinglemin;
    }

    public Integer getTxSinglemax() {
        return txSinglemax;
    }

    public void setTxSinglemax(Integer txSinglemax) {
        this.txSinglemax = txSinglemax;
    }

    public Integer getTxSinglehighest() {
        return txSinglehighest;
    }

    public void setTxSinglehighest(Integer txSinglehighest) {
        this.txSinglehighest = txSinglehighest;
    }

    public Integer getSxlSinglemin() {
        return sxlSinglemin;
    }

    public void setSxlSinglemin(Integer sxlSinglemin) {
        this.sxlSinglemin = sxlSinglemin;
    }

    public Integer getSxlSinglemax() {
        return sxlSinglemax;
    }

    public void setSxlSinglemax(Integer sxlSinglemax) {
        this.sxlSinglemax = sxlSinglemax;
    }

    public Integer getSxlSinglehighest() {
        return sxlSinglehighest;
    }

    public void setSxlSinglehighest(Integer sxlSinglehighest) {
        this.sxlSinglehighest = sxlSinglehighest;
    }

    public Integer getWslSinglemin() {
        return wslSinglemin;
    }

    public void setWslSinglemin(Integer wslSinglemin) {
        this.wslSinglemin = wslSinglemin;
    }

    public Integer getWslSinglemax() {
        return wslSinglemax;
    }

    public void setWslSinglemax(Integer wslSinglemax) {
        this.wslSinglemax = wslSinglemax;
    }

    public Integer getWslSinglehighest() {
        return wslSinglehighest;
    }

    public void setWslSinglehighest(Integer wslSinglehighest) {
        this.wslSinglehighest = wslSinglehighest;
    }

    public Float getTaRetreat() {
        return taRetreat;
    }

    public void setTaRetreat(Float taRetreat) {
        this.taRetreat = taRetreat;
    }

    public Float getTbRetreat() {
        return tbRetreat;
    }

    public void setTbRetreat(Float tbRetreat) {
        this.tbRetreat = tbRetreat;
    }

    public Float getTcRetreat() {
        return tcRetreat;
    }

    public void setTcRetreat(Float tcRetreat) {
        this.tcRetreat = tcRetreat;
    }

    public Float getZaRetreat() {
        return zaRetreat;
    }

    public void setZaRetreat(Float zaRetreat) {
        this.zaRetreat = zaRetreat;
    }

    public Float getZbRetreat() {
        return zbRetreat;
    }

    public void setZbRetreat(Float zbRetreat) {
        this.zbRetreat = zbRetreat;
    }

    public Float getZcRetreat() {
        return zcRetreat;
    }

    public void setZcRetreat(Float zcRetreat) {
        this.zcRetreat = zcRetreat;
    }

    public Float getZtaRetreat() {
        return ztaRetreat;
    }

    public void setZtaRetreat(Float ztaRetreat) {
        this.ztaRetreat = ztaRetreat;
    }

    public Float getZtbRetreat() {
        return ztbRetreat;
    }

    public void setZtbRetreat(Float ztbRetreat) {
        this.ztbRetreat = ztbRetreat;
    }

    public Float getZtcRetreat() {
        return ztcRetreat;
    }

    public void setZtcRetreat(Float ztcRetreat) {
        this.ztcRetreat = ztcRetreat;
    }

    public Float getL2aRetreat() {
        return l2aRetreat;
    }

    public void setL2aRetreat(Float l2aRetreat) {
        this.l2aRetreat = l2aRetreat;
    }

    public Float getL2bRetreat() {
        return l2bRetreat;
    }

    public void setL2bRetreat(Float l2bRetreat) {
        this.l2bRetreat = l2bRetreat;
    }

    public Float getL2cRetreat() {
        return l2cRetreat;
    }

    public void setL2cRetreat(Float l2cRetreat) {
        this.l2cRetreat = l2cRetreat;
    }

    public Float getL3aRetreat() {
        return l3aRetreat;
    }

    public void setL3aRetreat(Float l3aRetreat) {
        this.l3aRetreat = l3aRetreat;
    }

    public Float getL3bRetreat() {
        return l3bRetreat;
    }

    public void setL3bRetreat(Float l3bRetreat) {
        this.l3bRetreat = l3bRetreat;
    }

    public Float getL3cRetreat() {
        return l3cRetreat;
    }

    public void setL3cRetreat(Float l3cRetreat) {
        this.l3cRetreat = l3cRetreat;
    }

    public Float getGgaRetreat() {
        return ggaRetreat;
    }

    public void setGgaRetreat(Float ggaRetreat) {
        this.ggaRetreat = ggaRetreat;
    }

    public Float getGgbRetreat() {
        return ggbRetreat;
    }

    public void setGgbRetreat(Float ggbRetreat) {
        this.ggbRetreat = ggbRetreat;
    }

    public Float getGgcRetreat() {
        return ggcRetreat;
    }

    public void setGgcRetreat(Float ggcRetreat) {
        this.ggcRetreat = ggcRetreat;
    }

    public Float getBbaRetreat() {
        return bbaRetreat;
    }

    public void setBbaRetreat(Float bbaRetreat) {
        this.bbaRetreat = bbaRetreat;
    }

    public Float getBbbRetreat() {
        return bbbRetreat;
    }

    public void setBbbRetreat(Float bbbRetreat) {
        this.bbbRetreat = bbbRetreat;
    }

    public Float getBbcRetreat() {
        return bbcRetreat;
    }

    public void setBbcRetreat(Float bbcRetreat) {
        this.bbcRetreat = bbcRetreat;
    }

    public Float getLxaRetreat() {
        return lxaRetreat;
    }

    public void setLxaRetreat(Float lxaRetreat) {
        this.lxaRetreat = lxaRetreat;
    }

    public Float getLxbRetreat() {
        return lxbRetreat;
    }

    public void setLxbRetreat(Float lxbRetreat) {
        this.lxbRetreat = lxbRetreat;
    }

    public Float getLxcRetreat() {
        return lxcRetreat;
    }

    public void setLxcRetreat(Float lxcRetreat) {
        this.lxcRetreat = lxcRetreat;
    }

    public Float getLmaRetreat() {
        return lmaRetreat;
    }

    public void setLmaRetreat(Float lmaRetreat) {
        this.lmaRetreat = lmaRetreat;
    }

    public Float getLmbRetreat() {
        return lmbRetreat;
    }

    public void setLmbRetreat(Float lmbRetreat) {
        this.lmbRetreat = lmbRetreat;
    }

    public Float getLmcRetreat() {
        return lmcRetreat;
    }

    public void setLmcRetreat(Float lmcRetreat) {
        this.lmcRetreat = lmcRetreat;
    }

    public Float getTxaRetreat() {
        return txaRetreat;
    }

    public void setTxaRetreat(Float txaRetreat) {
        this.txaRetreat = txaRetreat;
    }

    public Float getTxbRetreat() {
        return txbRetreat;
    }

    public void setTxbRetreat(Float txbRetreat) {
        this.txbRetreat = txbRetreat;
    }

    public Float getTxcRetreat() {
        return txcRetreat;
    }

    public void setTxcRetreat(Float txcRetreat) {
        this.txcRetreat = txcRetreat;
    }

    public Float getSxlaRetreat() {
        return sxlaRetreat;
    }

    public void setSxlaRetreat(Float sxlaRetreat) {
        this.sxlaRetreat = sxlaRetreat;
    }

    public Float getSxlbRetreat() {
        return sxlbRetreat;
    }

    public void setSxlbRetreat(Float sxlbRetreat) {
        this.sxlbRetreat = sxlbRetreat;
    }

    public Float getSxlcRetreat() {
        return sxlcRetreat;
    }

    public void setSxlcRetreat(Float sxlcRetreat) {
        this.sxlcRetreat = sxlcRetreat;
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
}