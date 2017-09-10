package com.fr.lottery.entity;

/**
 * Created by Liyu7342 on 2017-9-9.
 */
public class LotConfig {
    private long id;
    private String gameType;
    private String gameTypeDesc;
    private String gameNum;
    private String gameNumDesc;
    private String gameNo;
    private String gameDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameTypeDesc() {
        return gameTypeDesc;
    }

    public void setGameTypeDesc(String gameTypeDesc) {
        this.gameTypeDesc = gameTypeDesc;
    }

    public String getGameNum() {
        return gameNum;
    }

    public void setGameNum(String gameNum) {
        this.gameNum = gameNum;
    }

    public String getGameNumDesc() {
        return gameNumDesc;
    }

    public void setGameNumDesc(String gameNumDesc) {
        this.gameNumDesc = gameNumDesc;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }
}
