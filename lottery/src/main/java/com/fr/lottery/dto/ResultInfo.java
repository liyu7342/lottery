package com.fr.lottery.dto;

/**
 * Created by Administrator on 2017/6/16.
 */
public class ResultInfo<T> {

    // {{参数定义
    /**
     * 布尔型值，true为委托成功，false为委托失败
     */
    private boolean success;
    /**
     * 系统操作返回值
     */
    private String msg;
    /**
     * 系统对象信息
     */
    private T data;
    /**
     * 相关的扩展数据使用
     */
    private String others;

    // }}

    // {{构造函数

    /**
     * 构造函数
     */
    public ResultInfo() {
        this.success = false;
        this.msg = "success";
        this.others = "";
    }

    // }}

    // {{set/get方法

    /**
     * 布尔型值，true为委托成功，false为委托失败
     */
    public boolean getSuccess() {
        return this.success;
    }

    /**
     * 布尔型值，true为委托成功，false为委托失败
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 系统操作返回值
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * 系统操作返回值
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 系统对象信息
     */
    public T getData() {
        return this.data;
    }

    /**
     * 系统对象信息
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 相关的扩展数据使用
     */
    public String getOthers() {
        return this.others;
    }

    /**
     * 相关的扩展数据使用
     */
    public void setOthers(String others) {
        this.others = others;
    }

    // }}

    // {{toString()
    public String toString() {
        return "Result [success=" + this.success + ", msg=" + this.msg
                + ", data=" + this.data + ", others=" + this.others + "]";
    }
// }}
}