package com.fr.lottery.enums;

/**
 * Created by Liyu7342 on 2017-7-27.
 */
public enum GameTypeEnum {
    特码(0),
    正码(1),
    正码特(2),
    連碼二(3),
    連碼三(4),
    過關(5),
    生肖(6),
    尾數(7),
    半波(8),
    六肖(9),
    兩面(10),
    色波(11),
    特肖(12),
    生肖連(13),
    尾數連(14),
    不中(15);

    private Integer value;
    private GameTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
