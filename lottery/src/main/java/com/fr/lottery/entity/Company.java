package com.fr.lottery.entity;

import java.io.Serializable;

/**
 * Created by Liyu7342 on 2017-6-18.
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String code;

    private String name;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
