package com.fr.lottery.enums;

/**
 * Created by Liyu7342 on 2017-8-8.
 */
public enum OddsTypeEnum {
    tema("000"),
    zhengma("001"),
    zhengmate1("002"),
    zhengmate2("003"),
    zhengmate3("004"),
    zhengmate4("005"),
    zhengmate5("006"),
    zhengmate6("007"),
    erquanzh("008"),
    erzhongte("009"),
    techuan("010"),
    sanquanzh("011"),
    sanzher("012"),
    guoguan("013"),
    shxiao("014"),
    weishu("015"),
    banbo("016"),
    liuxiaozh("017"),
    liuxiaobuzh("018"),
    jinliudansh("999"),
    lmtema("019"),
    lmzhma("020"),
    lmzhmate1("021"),
    lmzhmate2("022"),
    lmzhmate3("023"),
    lmzhmate4("024"),
    lmzhmate5("025"),
    lmzhmate6("026"),
    sebotema("027"),
    sebozhmate1("028"),
    sebozhmate2("029"),
    sebozhmate3("030"),
    sebozhmate4("031"),
    sebozhmate5("032"),
    sebozhmate6("033"),
    texiao("034"),
    shengxiaolian("035|036|037|038|039|040"),
    weishulian("041|042|043|044|045|046"),
    buzhong("047|048|049|050|051|052"),
    shengxiaobuzhong("053");

    private String value;
    private OddsTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
