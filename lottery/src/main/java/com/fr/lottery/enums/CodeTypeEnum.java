package com.fr.lottery.enums;

/**
 * Created by Liyu7342 on 2017-12-13.
 */
public enum CodeTypeEnum {
    單號("danhao"),
    補倉單號("bucangdanhao"),
    期數("qishu");

    private String value;
    private CodeTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
