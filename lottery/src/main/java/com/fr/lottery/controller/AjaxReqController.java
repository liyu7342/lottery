package com.fr.lottery.controller;

import com.fr.lottery.init.GameCfg;
import com.fr.lottery.service.inter.IOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-12-3.
 */
@Controller
@RequestMapping("/ajax_req")
public class AjaxReqController {

    @Autowired
    private IOrderService orderService;
    @RequestMapping("/req")
    @ResponseBody
    public Map req(String act, HttpServletRequest request , HttpServletResponse response) throws IOException{
        Map<String,Map> map =new HashMap<String, Map>();
        if(StringUtils.isBlank(act)){
            return map;
        }
        String[] actArr = act.split("\\|");
        for(String action :actArr){
            if("get_statics_data".equals(action)){
              Map map1=  get_statics_data(request,response);
              map.put(action,map1);
            }
            else
            map.put(action,null);
        }
        return map;
}

    private Map get_statics_data(HttpServletRequest request , HttpServletResponse response) throws IOException{
        String category_id="0";
        String game_id ="";
        String odds_set="";
        String[] gameTypes;
        if(StringUtils.isBlank(game_id)){
            gameTypes = GameCfg.getCategoryGame(category_id);
        }
        else{
            gameTypes = new String[]{game_id};
        }
        orderService.getStatis(category_id,gameTypes);
        return null;
    }

}
