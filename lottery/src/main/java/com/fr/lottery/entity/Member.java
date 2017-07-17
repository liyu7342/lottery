package com.fr.lottery.entity;


public class Member  extends User{
    private String id;

    private String agentid;

    private Long credits;

    private Integer proportional;

    private String handicap;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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


}