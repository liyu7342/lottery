package com.fr.lottery.dto;

/**
 * Created by Liyu7342 on 2017-8-16.
 */
public class OrderDto {
    private String game_ids;

    private Integer order_allamount;

    private String odds_set;

    private String orderData;

    private String detailOdds;

    private Integer timeout;

    private String submit_time_msec;

    private Integer version_number;

    public String getGame_ids() {
        return game_ids;
    }

    public void setGame_ids(String game_ids) {
        this.game_ids = game_ids;
    }

    public Integer getOrder_allamount() {
        return order_allamount;
    }

    public void setOrder_allamount(Integer order_allamount) {
        this.order_allamount = order_allamount;
    }

    public String getOdds_set() {
        return odds_set;
    }

    public void setOdds_set(String odds_set) {
        this.odds_set = odds_set;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public String getDetailOdds() {
        return detailOdds;
    }

    public void setDetailOdds(String detailOdds) {
        this.detailOdds = detailOdds;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getSubmit_time_msec() {
        return submit_time_msec;
    }

    public void setSubmit_time_msec(String submit_time_msec) {
        this.submit_time_msec = submit_time_msec;
    }

    public Integer getVersion_number() {
        return version_number;
    }

    public void setVersion_number(Integer version_number) {
        this.version_number = version_number;
    }
}
