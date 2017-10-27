package com.fr.lottery.enums;

/**
 * Created by Administrator on 2017/10/27.
 */
public enum LianMaEnum {
    zhengchang("1"),
    dantuo("4"),
    shengxiaoduipeng("2"),
    shengweiduipeng("7"),
    weishuduipeng("30"),
    suiyipeng("5");
    private String value;
    private LianMaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
