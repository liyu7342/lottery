package com.fr.lottery.entity;

public class Odds {
    private String id;

    private String oddSet;

    private String type;

    private Boolean isdefault;

    private String numkey;

    private Float numvalue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOddSet() {
        return oddSet;
    }

    public void setOddSet(String oddSet) {
        this.oddSet = oddSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public String getNumkey() {
        return numkey;
    }

    public void setNumkey(String numkey) {
        this.numkey = numkey == null ? null : numkey.trim();
    }

    public Float getNumvalue() {
        return numvalue;
    }

    public void setNumvalue(Float numvalue) {
        this.numvalue = numvalue;
    }
}