package com.fr.lottery.quartz;

import com.fr.lottery.entity.Handicap;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


/**
 * Created by Liyu7342 on 2017-12-12.
 */
@Service
public class KaiJiangQuartz {
    @Autowired
    private IHandicapService handicapService;
    @Autowired
    private IOrderService orderService;

    public void work() {
        Handicap handicap = handicapService.getNotOpenHandicap();
        if (handicap == null) return;
        int index = 0;
        String url = Global.properties.get("6hbd_" + index).toString();
        int repeatTime = 0;
        while (true) {
                boolean isFinish = otherOpen(handicap);
            if (isFinish)
                break;
//
//            String str = handicapService.get6hbd(url);
//            System.out.println("第 " + repeatTime + " 次请求 url：" + url + "   返回結果：" + str);
//            try {
//
//                if (StringUtils.isNotBlank(str) && !"404".equals(str)) {
//                    JsonObject jsonObject = JsonUtil.getJson(str);
//                    if (jsonObject != null && !jsonObject.get("id").isJsonNull() && !jsonObject.get("year").isJsonNull()) {
//                        if ((jsonObject.get("id").getAsInt()) == Integer.valueOf(handicap.getQishu())) {
//                            if (jsonObject.get("ma").isJsonArray()) {
//                                JsonArray jsonArray = jsonObject.get("ma").getAsJsonArray();
//
//                                if (jsonArray != null && jsonArray.size() > 0) {
//                                    Integer c = 0;
//                                    //Integer total = 0;
//
//                                    for (Integer i = 0, len = jsonArray.size(); i < len; ) {
//                                        Integer no = jsonArray.get(i++).getAsInt();
//                                        //total +=no;
//                                        String xiao = jsonArray.get(i++).getAsString();
//                                        String color = jsonArray.get(i++).getAsString();
//                                        String noStr;
//                                        if (no != null && no != 0) {
//
//                                            c++;
//                                            if (no < 10) {
//                                                noStr = "0" + no;
//                                            } else {
//                                                noStr = no.toString();
//                                            }
//                                            switch (c) {
//                                                case 1:
//                                                    handicap.setNo1(noStr);
//                                                    handicap.setXiaoName1(xiao);
//                                                    break;
//                                                case 2:
//                                                    handicap.setNo2(noStr);
//                                                    handicap.setXiaoName2(xiao);
//                                                    break;
//                                                case 3:
//                                                    handicap.setNo3(noStr);
//                                                    handicap.setXiaoName3(xiao);
//                                                    break;
//                                                case 4:
//                                                    handicap.setNo4(noStr);
//                                                    handicap.setXiaoName4(xiao);
//                                                    break;
//                                                case 5:
//                                                    handicap.setNo5(noStr);
//                                                    handicap.setXiaoName5(xiao);
//                                                    break;
//                                                case 6:
//                                                    handicap.setNo6(noStr);
//                                                    handicap.setXiaoName6(xiao);
//                                                    break;
//                                                case 7:
//                                                    handicap.setTema(noStr);
//                                                    handicap.setTexiaoName(xiao);
//                                                    break;
//                                                default:
//                                                    break;
//                                            }
//                                        }
//                                    }
//                                    handicapService.save(handicap);
//                                    if (c == 7) {
//                                        handicapService.openHandicap(handicap);
//                                        break;
//                                    }
//
//                                }
//                            }
//                        }
//
//                    }
//                } else {
//                    index++;
//                    index %= 5;
//                    url = Global.properties.get("6hbd_" + index).toString();
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }

            try {
                Thread.sleep(5000);
                repeatTime++;
                if (repeatTime > 200)
                    break;

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    private boolean otherOpen(Handicap handicap) {
        try{


        int index = 0;
        String url = Global.properties.get("otherOpenurl").toString();
        int repeatTime = 0;

        String str = handicapService.get6hbd(url);
        str = str.substring(3);
        try{
            byte[]  bt = str.getBytes("GBK");
            byte[]  bt1 = str.getBytes("ISO8859-1");
            byte[]  bt2 = str.getBytes("UTF-8");

            String str1 =new String(bt,"utf-8");
            String str2 =new String(bt,"utf-8");
            String str3 =new String(bt,"utf-8");

            System.out.print( str1);
            System.out.print( str1);
            System.out.print( str1);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }

        System.out.println("第 " + repeatTime + " 次请求 url：" + url + "   返回結果：" + str);

        if (StringUtils.isNotBlank(str) && !"404".equals(str)) {
            JsonObject jsonObject = JsonUtil.getJson(str);

            if (jsonObject != null && !jsonObject.get("k").isJsonNull()) {
                String[] arr = StringUtils.split(jsonObject.get("k").getAsString(), ",");
                if (arr.length > 0) {
                    String qishu = arr[0];
                    boolean hasFinish = false;
                    if (qishu.equals(handicap.getQishu())) {
                        if (arr.length > 2 && StringUtils.isNumeric(arr[1])) {
                            handicap.setNo1(arr[1]);
                        }
                        if (arr.length > 3 && StringUtils.isNumeric(arr[2])) {
                            handicap.setNo2(arr[2]);
                        }
                        if (arr.length > 4 && StringUtils.isNumeric(arr[3])) {
                            handicap.setNo3(arr[3]);
                        }
                        if (arr.length > 5 && StringUtils.isNumeric(arr[4])) {
                            handicap.setNo4(arr[4]);
                        }
                        if (arr.length > 6 && StringUtils.isNumeric(arr[5])) {
                            handicap.setNo5(arr[5]);
                        }
                        if (arr.length > 7 && StringUtils.isNumeric(arr[6])) {
                            handicap.setNo6(arr[6]);
                        }
                        if (arr.length > 8 && StringUtils.isNumeric(arr[7])) {
                            handicap.setTema(arr[7]);
                            hasFinish = true;
                        }
                        handicapService.save(handicap);
                        if (hasFinish) {
                            handicapService.openHandicap(handicap);
                            orderService.settlement(handicap.getId());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        }
        catch (Exception ex){
            return false;
        }
    }


}
