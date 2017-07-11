package com.fr.lottery.exception;

/** 自定义异常
 * Created by Administrator on 2017/1/24.
 */
public class CustomException extends Exception {

    private String message;

    public CustomException(){}

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
