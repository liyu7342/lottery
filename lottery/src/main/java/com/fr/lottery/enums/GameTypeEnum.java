package com.fr.lottery.enums;

/**
 * Created by Liyu7342 on 2017-7-27.
 */
public enum GameTypeEnum {
    特码("00"),
    正码("01"),
    正码特("02"),
    連碼二("03"),
    連碼三("04"),
    過關("05"),
    生肖("06"),
    尾數("07"),
    半波("08"),
    六肖("09"),
    兩面("10"),
    色波("11"),
    特肖("12"),
    生肖連("13"),
    尾數連("14"),
    不中("15");

    private String value;
    private GameTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
