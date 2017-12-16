package com.fr.lottery.enums;

/**
 * Created by Liyu7342 on 2017-12-16.
 */
public enum OrderTypeEnum {
    下注("xiazhu"),
    补仓("bucang");

    private String value;
    private OrderTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
