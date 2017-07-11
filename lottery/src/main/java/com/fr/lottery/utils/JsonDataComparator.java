package com.fr.lottery.utils;

/**
 * Created by Administrator on 2017/4/7.
 */

import net.sf.json.JSONObject;

import java.util.Comparator;

/**
 * @author dengbojing
 * @date 2016-1-15
 * @description
 */
public class JsonDataComparator implements Comparator<JSONObject> {
    String dataName = "";
    public JsonDataComparator(String dateName){
        this.dataName = dateName;
    }
    @Override
    public int compare(JSONObject json1, JSONObject json2){
        String data1 = json1.optString(dataName);
        String data2 = json2.optString(dataName);
        int ret = 0;
        if(isInteger(data1) && isInteger(data2)){
            int param1 = Integer.parseInt(data1);
            int param2 = Integer.parseInt(data2);
            if(param1 - param2 > 0){
                ret = 1;
            }else if(param1 - param2 < 0){
                ret = -1;
            }
        }else{
            ret = data1.compareTo(data2);
        }
        return ret;
    }

    private  boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
