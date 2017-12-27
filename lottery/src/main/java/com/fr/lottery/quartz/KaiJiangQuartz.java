package com.fr.lottery.quartz;

import com.fr.lottery.entity.Handicap;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by Liyu7342 on 2017-12-12.
 */
@Service
public class KaiJiangQuartz {
    @Autowired
    private IHandicapService handicapService;

    public void  work()  {
        Handicap handicap =handicapService.getNotOpenHandicap();
        if(handicap ==null) return;
        int index=0;
        String url=Global.properties.get("6hbd_"+index).toString();
        int repeatTime = 0;
        while (true){
          String str=  handicapService.get6hbd(url);
          try{

          if(StringUtils.isNotBlank(str)) {
              JsonObject jsonObject = JsonUtil.getJson(str);
              if (jsonObject != null && !jsonObject.get("id").isJsonNull() && !jsonObject.get("year").isJsonNull()) {
                  if ((jsonObject.get("id").getAsString()).equals(handicap.getQishu())) {
                      if (jsonObject.get("ma").isJsonArray()) {
                          JsonArray jsonArray = jsonObject.get("ma").getAsJsonArray();

                          if (jsonArray != null && jsonArray.size() >0 ) {
                              Integer c = 0;
                              //Integer total = 0;

                              for (Integer i = 0, len = jsonArray.size(); i < len; ) {
                                  Integer no = jsonArray.get(i++).getAsInt();
                                  //total +=no;
                                  String xiao = jsonArray.get(i++).getAsString();
                                  String color = jsonArray.get(i++).getAsString();
                                  String noStr;
                                  if (no != null && no != 0) {

                                      c++;
                                      if (no < 10) {
                                          noStr = "0" + no;
                                      } else {
                                          noStr = no.toString();
                                      }
                                      switch (c) {
                                          case 1:
                                              handicap.setNo1(noStr);
                                              handicap.setXiaoName1(xiao);
                                              break;
                                          case 2:
                                              handicap.setNo2(noStr);
                                              handicap.setXiaoName2(xiao);
                                              break;
                                          case 3:
                                              handicap.setNo3(noStr);
                                              handicap.setXiaoName3(xiao);
                                              break;
                                          case 4:
                                              handicap.setNo4(noStr);
                                              handicap.setXiaoName4(xiao);
                                              break;
                                          case 5:
                                              handicap.setNo5(noStr);
                                              handicap.setXiaoName5(xiao);
                                              break;
                                          case 6:
                                              handicap.setNo6(noStr);
                                              handicap.setXiaoName6(xiao);
                                              break;
                                          case 7:
                                              handicap.setTema(noStr);
                                              handicap.setTexiaoName(xiao);
                                              break;
                                          default:
                                              break;
                                      }
                                  }
                              }
                              handicapService.save(handicap);
                              if (c == 7){
                                  handicapService.openHandicap(handicap);
                                  break;
                              }

                          }
                      }
                  }

              }
          }
          else{
              index++;
              index %=5;
              url= Global.properties.get("6hbd_"+index).toString();
          }
          }
          catch (Exception ex){
              ex.printStackTrace();
          }
            try{
                Thread.sleep(5000);
                repeatTime++;
                if(repeatTime>200)
                    break;
                System.out.println("Thread.sleep(5000)");
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
}
