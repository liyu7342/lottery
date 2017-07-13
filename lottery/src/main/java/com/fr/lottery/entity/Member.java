package com.fr.lottery.entity;

import org.joda.time.DateTime;

import java.math.BigDecimal;

public class Member  extends User{
    private String agentid;

    private Long credits;

    private Integer proportional;

    private String handicap;

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

    private BigDecimal taRetreat;

    private BigDecimal tbRetreat;

    private BigDecimal tcRetreat;

    private BigDecimal zaRetreat;

    private BigDecimal zbRetreat;

    private BigDecimal zcRetreat;

    private BigDecimal ztaRetreat;

    private BigDecimal ztbRetreat;

    private BigDecimal ztcRetreat;

    private BigDecimal l2aRetreat;

    private BigDecimal l2bRetreat;

    private BigDecimal l2cRetreat;

    private BigDecimal l3aRetreat;

    private BigDecimal l3bRetreat;

    private BigDecimal l3cRetreat;

    private BigDecimal ggaRetreat;

    private BigDecimal ggbRetreat;

    private BigDecimal ggcRetreat;

    private BigDecimal bbaRetreat;

    private BigDecimal bbbRetreat;

    private BigDecimal bbcRetreat;

    private BigDecimal lxaRetreat;

    private BigDecimal lxbRetreat;

    private BigDecimal lxcRetreat;

    private BigDecimal lmaRetreat;

    private BigDecimal lmbRetreat;

    private BigDecimal lmcRetreat;

    private BigDecimal txaRetreat;

    private BigDecimal txbRetreat;

    private BigDecimal txcRetreat;

    private BigDecimal sxlaRetreat;

    private BigDecimal sxlbRetreat;

    private BigDecimal sxlcRetreat;

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
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
        this.handicap = handicap == null ? null : handicap.trim();
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

    public BigDecimal getTaRetreat() {
        return taRetreat;
    }

    public void setTaRetreat(BigDecimal taRetreat) {
        this.taRetreat = taRetreat;
    }

    public BigDecimal getTbRetreat() {
        return tbRetreat;
    }

    public void setTbRetreat(BigDecimal tbRetreat) {
        this.tbRetreat = tbRetreat;
    }

    public BigDecimal getTcRetreat() {
        return tcRetreat;
    }

    public void setTcRetreat(BigDecimal tcRetreat) {
        this.tcRetreat = tcRetreat;
    }

    public BigDecimal getZaRetreat() {
        return zaRetreat;
    }

    public void setZaRetreat(BigDecimal zaRetreat) {
        this.zaRetreat = zaRetreat;
    }

    public BigDecimal getZbRetreat() {
        return zbRetreat;
    }

    public void setZbRetreat(BigDecimal zbRetreat) {
        this.zbRetreat = zbRetreat;
    }

    public BigDecimal getZcRetreat() {
        return zcRetreat;
    }

    public void setZcRetreat(BigDecimal zcRetreat) {
        this.zcRetreat = zcRetreat;
    }

    public BigDecimal getZtaRetreat() {
        return ztaRetreat;
    }

    public void setZtaRetreat(BigDecimal ztaRetreat) {
        this.ztaRetreat = ztaRetreat;
    }

    public BigDecimal getZtbRetreat() {
        return ztbRetreat;
    }

    public void setZtbRetreat(BigDecimal ztbRetreat) {
        this.ztbRetreat = ztbRetreat;
    }

    public BigDecimal getZtcRetreat() {
        return ztcRetreat;
    }

    public void setZtcRetreat(BigDecimal ztcRetreat) {
        this.ztcRetreat = ztcRetreat;
    }

    public BigDecimal getL2aRetreat() {
        return l2aRetreat;
    }

    public void setL2aRetreat(BigDecimal l2aRetreat) {
        this.l2aRetreat = l2aRetreat;
    }

    public BigDecimal getL2bRetreat() {
        return l2bRetreat;
    }

    public void setL2bRetreat(BigDecimal l2bRetreat) {
        this.l2bRetreat = l2bRetreat;
    }

    public BigDecimal getL2cRetreat() {
        return l2cRetreat;
    }

    public void setL2cRetreat(BigDecimal l2cRetreat) {
        this.l2cRetreat = l2cRetreat;
    }

    public BigDecimal getL3aRetreat() {
        return l3aRetreat;
    }

    public void setL3aRetreat(BigDecimal l3aRetreat) {
        this.l3aRetreat = l3aRetreat;
    }

    public BigDecimal getL3bRetreat() {
        return l3bRetreat;
    }

    public void setL3bRetreat(BigDecimal l3bRetreat) {
        this.l3bRetreat = l3bRetreat;
    }

    public BigDecimal getL3cRetreat() {
        return l3cRetreat;
    }

    public void setL3cRetreat(BigDecimal l3cRetreat) {
        this.l3cRetreat = l3cRetreat;
    }

    public BigDecimal getGgaRetreat() {
        return ggaRetreat;
    }

    public void setGgaRetreat(BigDecimal ggaRetreat) {
        this.ggaRetreat = ggaRetreat;
    }

    public BigDecimal getGgbRetreat() {
        return ggbRetreat;
    }

    public void setGgbRetreat(BigDecimal ggbRetreat) {
        this.ggbRetreat = ggbRetreat;
    }

    public BigDecimal getGgcRetreat() {
        return ggcRetreat;
    }

    public void setGgcRetreat(BigDecimal ggcRetreat) {
        this.ggcRetreat = ggcRetreat;
    }

    public BigDecimal getBbaRetreat() {
        return bbaRetreat;
    }

    public void setBbaRetreat(BigDecimal bbaRetreat) {
        this.bbaRetreat = bbaRetreat;
    }

    public BigDecimal getBbbRetreat() {
        return bbbRetreat;
    }

    public void setBbbRetreat(BigDecimal bbbRetreat) {
        this.bbbRetreat = bbbRetreat;
    }

    public BigDecimal getBbcRetreat() {
        return bbcRetreat;
    }

    public void setBbcRetreat(BigDecimal bbcRetreat) {
        this.bbcRetreat = bbcRetreat;
    }

    public BigDecimal getLxaRetreat() {
        return lxaRetreat;
    }

    public void setLxaRetreat(BigDecimal lxaRetreat) {
        this.lxaRetreat = lxaRetreat;
    }

    public BigDecimal getLxbRetreat() {
        return lxbRetreat;
    }

    public void setLxbRetreat(BigDecimal lxbRetreat) {
        this.lxbRetreat = lxbRetreat;
    }

    public BigDecimal getLxcRetreat() {
        return lxcRetreat;
    }

    public void setLxcRetreat(BigDecimal lxcRetreat) {
        this.lxcRetreat = lxcRetreat;
    }

    public BigDecimal getLmaRetreat() {
        return lmaRetreat;
    }

    public void setLmaRetreat(BigDecimal lmaRetreat) {
        this.lmaRetreat = lmaRetreat;
    }

    public BigDecimal getLmbRetreat() {
        return lmbRetreat;
    }

    public void setLmbRetreat(BigDecimal lmbRetreat) {
        this.lmbRetreat = lmbRetreat;
    }

    public BigDecimal getLmcRetreat() {
        return lmcRetreat;
    }

    public void setLmcRetreat(BigDecimal lmcRetreat) {
        this.lmcRetreat = lmcRetreat;
    }

    public BigDecimal getTxaRetreat() {
        return txaRetreat;
    }

    public void setTxaRetreat(BigDecimal txaRetreat) {
        this.txaRetreat = txaRetreat;
    }

    public BigDecimal getTxbRetreat() {
        return txbRetreat;
    }

    public void setTxbRetreat(BigDecimal txbRetreat) {
        this.txbRetreat = txbRetreat;
    }

    public BigDecimal getTxcRetreat() {
        return txcRetreat;
    }

    public void setTxcRetreat(BigDecimal txcRetreat) {
        this.txcRetreat = txcRetreat;
    }

    public BigDecimal getSxlaRetreat() {
        return sxlaRetreat;
    }

    public void setSxlaRetreat(BigDecimal sxlaRetreat) {
        this.sxlaRetreat = sxlaRetreat;
    }

    public BigDecimal getSxlbRetreat() {
        return sxlbRetreat;
    }

    public void setSxlbRetreat(BigDecimal sxlbRetreat) {
        this.sxlbRetreat = sxlbRetreat;
    }

    public BigDecimal getSxlcRetreat() {
        return sxlcRetreat;
    }

    public void setSxlcRetreat(BigDecimal sxlcRetreat) {
        this.sxlcRetreat = sxlcRetreat;
    }
}