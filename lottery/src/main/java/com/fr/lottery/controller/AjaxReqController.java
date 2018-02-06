package com.fr.lottery.controller;

import com.fr.lottery.dto.ColumnDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.dto.StatisTable;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Map<String,String> map =new HashMap<String, String>();
        if(StringUtils.isBlank(act)){
            return map;
        }
        String[] actArr = act.split("\\|");
        for(String action :actArr){
            if("get_statics_data".equals(action)){
              Map map1=  get_statics_data(request,response);
              map.put(action, JsonUtil.toJson( map1));
            }
            else
            map.put(action,null);
        }
        return map;
}

    private Map get_statics_data(HttpServletRequest request , HttpServletResponse response) throws IOException{
        String category_id =request.getParameter("category_id");
        String game_id =request.getParameter("game_id");
        Map map = new HashMap();
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();

        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put(menumap.get("category").toString(),put);
        }
        menumaps.put("03",menumaps.get("03")+menumaps.get("04"));
        map.put("menus",menumaps);
        map.put("stops",new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        map.put("bChangeOrder",0);
        String[] gameTypes ;
        if(StringUtils.isNotBlank(game_id)){
            gameTypes = game_id.split("\\|");
        }else{
            gameTypes = GameCfg.getCategoryGame(category_id);
        }

        if(GameTypeEnum.特码.getValue().equals( category_id)) {
            List<StatisDto> statisDtos= orderService.getStatis(category_id,gameTypes);
            StatisTable table = new StatisTable(statisDtos,category_id);
            map.put("cnt",table.toString());
        }
        else if("03|04".equals(category_id)){
            List<String> tableHtml =new ArrayList<String>();
            tableHtml.add("<table class=\"g-tl\">");
            tableHtml.add("<tbody nomovod>");
            tableHtml.add("<tr>");


            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">二全中\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=009\" act=\"db\" gid=\"008\" type=\"button\">多補</button></h3></div>");
            //二全中
            Page<StatisDto> statisDtoList= orderService.getStatisLianma(GameTypeEnum.連碼二.getValue(),new String[]{OddsTypeEnum.erquanzh.getValue()},1);
            StatisTable statisTable008 =new StatisTable(statisDtoList.getList(),GameTypeEnum.連碼二.getValue(),statisDtoList.getOtherInfo());
            tableHtml.add(statisTable008.toString());
            tableHtml.add("</td>");


            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">二中特\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=009\" act=\"db\" gid=\"009\" type=\"button\">多補</button></h3></div>");
            //二中特
            Page<StatisDto> statisDtoList009= orderService.getStatisLianma(GameTypeEnum.連碼二.getValue(),new String[]{OddsTypeEnum.erzhongte.getValue()},1);
            StatisTable statisTable009 =new StatisTable(statisDtoList009.getList(),GameTypeEnum.連碼二.getValue(),statisDtoList009.getOtherInfo());
            tableHtml.add(statisTable009.toString());
            tableHtml.add("</td>");

            //特串
            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">特串\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=010\" act=\"db\" gid=\"010\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList010= orderService.getStatisLianma(GameTypeEnum.連碼二.getValue(),new String[]{OddsTypeEnum.techuan.getValue()},1);
            StatisTable statisTable010 =new StatisTable(statisDtoList010.getList(),GameTypeEnum.連碼二.getValue(),statisDtoList010.getOtherInfo());
            tableHtml.add(statisTable010.toString());
            tableHtml.add("</td>");
            //三全中

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">三全中\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=011\" act=\"db\" gid=\"011\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList011= orderService.getStatisLianma(GameTypeEnum.連碼三.getValue(),new String[]{OddsTypeEnum.sanquanzh.getValue()},1);
            StatisTable statisTable011 =new StatisTable(statisDtoList011.getList(),GameTypeEnum.連碼三.getValue(),statisDtoList011.getOtherInfo());
            tableHtml.add(statisTable011.toString());
            tableHtml.add("</td>");

            //三中二

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">三中二\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=012\" act=\"db\" gid=\"012\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList012= orderService.getStatisLianma(GameTypeEnum.連碼三.getValue(),new String[]{OddsTypeEnum.sanzher.getValue()},1);
            StatisTable statisTable012 =new StatisTable(statisDtoList012.getList(),GameTypeEnum.連碼三.getValue(),statisDtoList012.getOtherInfo());
            tableHtml.add(statisTable012.toString());
            tableHtml.add("</td>");
            tableHtml.add("</tr>");
            tableHtml.add("</tbody>");
            tableHtml.add("</table>");
            map.put("cnt",StringUtils.join(tableHtml,"\r\n"));
        }
        else if(GameTypeEnum.生肖連.getValue().equals(category_id)){
            List<String> tableHtml =new ArrayList<String>();
            tableHtml.add("<table class=\"g-tl\">");
            tableHtml.add("<tbody nomovod>");
            tableHtml.add("<tr>");
            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">二肖连(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=035\" act=\"db\" gid=\"035\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList= orderService.getStatisLianma(category_id,new String[]{"035"},1);
            StatisTable statisTable035 =new StatisTable(statisDtoList.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList.getOtherInfo());
            tableHtml.add(statisTable035.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">二肖连(不中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=036\" act=\"db\" gid=\"036\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList036= orderService.getStatisLianma(category_id,new String[]{"036"},1);
            StatisTable statisTable036 =new StatisTable(statisDtoList036.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList036.getOtherInfo());
            tableHtml.add(statisTable036.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">三肖连(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=037\" act=\"db\" gid=\"037\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList037= orderService.getStatisLianma(category_id,new String[]{"037"},1);
            StatisTable statisTable037 =new StatisTable(statisDtoList037.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList037.getOtherInfo());
            tableHtml.add(statisTable037.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">三肖连(不中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=038\" act=\"db\" gid=\"038\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList038= orderService.getStatisLianma(category_id,new String[]{"038"},1);
            StatisTable statisTable038 =new StatisTable(statisDtoList038.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList038.getOtherInfo());
            tableHtml.add(statisTable038.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">四肖连(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=039\" act=\"db\" gid=\"039\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList039= orderService.getStatisLianma(category_id,new String[]{"039"},1);
            StatisTable statisTable039 =new StatisTable(statisDtoList039.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList039.getOtherInfo());
            tableHtml.add(statisTable039.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">四肖连(不中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=040\" act=\"db\" gid=\"040\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList040 =orderService.getStatisLianma(category_id,new String[]{"040"},1);
            StatisTable statisTable040 =new StatisTable(statisDtoList040.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList040.getOtherInfo());
            tableHtml.add(statisTable040.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">五肖连(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=054\" act=\"db\" gid=\"054\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList054= orderService.getStatisLianma(category_id,new String[]{"054"},1);
            StatisTable statisTable054 =new StatisTable(statisDtoList054.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList054.getOtherInfo());
            tableHtml.add(statisTable054.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">五肖连(不中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=055\" act=\"db\" gid=\"055\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList055 =orderService.getStatisLianma(category_id,new String[]{"055"},1);
            StatisTable statisTable055 =new StatisTable(statisDtoList055.getList(),GameTypeEnum.生肖連.getValue(),statisDtoList055.getOtherInfo());
            tableHtml.add(statisTable055.toString());
            tableHtml.add("</td>");
            tableHtml.add("</tr>");
            tableHtml.add("</tbody>");
            tableHtml.add("</table>");
            map.put("cnt",StringUtils.join(tableHtml,"\r\n"));

        }
        else if(GameTypeEnum.尾數連.getValue().equals(category_id)){
            List<String> tableHtml =new ArrayList<String>();
            tableHtml.add("<table class=\"g-tl\">");
            tableHtml.add("<tbody nomovod>");
            tableHtml.add("<tr>");
            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">二尾連(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=041\" act=\"db\" gid=\"041\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList041= orderService.getStatisLianma(category_id,new String[]{"041"},1);
            StatisTable statisTable041 =new StatisTable(statisDtoList041.getList(),GameTypeEnum.尾數連.getValue(),statisDtoList041.getOtherInfo());
            tableHtml.add(statisTable041.toString());
            tableHtml.add("</td>");
            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">二尾連(不中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=042\" act=\"db\" gid=\"042\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList042= orderService.getStatisLianma(category_id,new String[]{"042"},1);
            StatisTable statisTable042 =new StatisTable(statisDtoList042.getList(),GameTypeEnum.尾數連.getValue(),statisDtoList042.getOtherInfo());
            tableHtml.add(statisTable042.toString());
            tableHtml.add("</td>");
            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">三尾連(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=043\" act=\"db\" gid=\"043\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList043= orderService.getStatisLianma(category_id,new String[]{"043"},1);
            StatisTable statisTable043 =new StatisTable(statisDtoList043.getList(),GameTypeEnum.尾數連.getValue(),statisDtoList043.getOtherInfo());
            tableHtml.add(statisTable043.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">三尾連(不中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=044\" act=\"db\" gid=\"044\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList044= orderService.getStatisLianma(category_id,new String[]{"044"},1);
            StatisTable statisTable044 =new StatisTable(statisDtoList044.getList(),GameTypeEnum.尾數連.getValue(),statisDtoList044.getOtherInfo());
            tableHtml.add(statisTable044.toString());
            tableHtml.add("</td>");

            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">四尾連(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=045\" act=\"db\" gid=\"045\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList045= orderService.getStatisLianma(category_id,new String[]{"045"},1);
            StatisTable statisTable045 =new StatisTable(statisDtoList045.getList(),GameTypeEnum.尾數連.getValue(),statisDtoList045.getOtherInfo());
            tableHtml.add(statisTable045.toString());
            tableHtml.add("</td>");
            tableHtml.add("<td class=\"ts\">");
            tableHtml.add("<div class=\"g-tif\"><h3 class=\"m\">四尾連(中)\n" +
                    "                    <button class=\"gms_ctl\" to=\"/statis/duobu?game_id=046\" act=\"db\" gid=\"046\" type=\"button\">多補</button></h3></div>");
            Page<StatisDto> statisDtoList046= orderService.getStatisLianma(category_id,new String[]{"046"},1);
            StatisTable statisTable046 =new StatisTable(statisDtoList046.getList(),GameTypeEnum.尾數連.getValue() ,statisDtoList046.getOtherInfo());
            tableHtml.add(statisTable046.toString());
            tableHtml.add("</td>");
            tableHtml.add("</tr>");
            tableHtml.add("</tbody>");
            tableHtml.add("</table>");
            map.put("cnt",StringUtils.join(tableHtml,"\r\n"));
        }
        else{
            List<StatisDto> statisDtos= orderService.getStatis(category_id,gameTypes);
            StatisTable table = new StatisTable(statisDtos,category_id);
            map.put("cnt",table.toString());
        }

        return map;
    }

    private List<ColumnDto> getColumnDtos(String category_id){
        List<ColumnDto> columnDtos =new ArrayList<ColumnDto>();
         if(GameTypeEnum.特码.getValue().equals( category_id)){
            columnDtos.add(new ColumnDto("description","玩法"));
             columnDtos.add(new ColumnDto("orderNum","数量"));
             columnDtos.add(new ColumnDto("amount","下注總額"));
             columnDtos.add(new ColumnDto("shareTotal","總佔成"));
             columnDtos.add(new ColumnDto("aveOdds","平均賠率"));
             columnDtos.add(new ColumnDto("winAmount","勝出金額"));
             columnDtos.add(new ColumnDto("buhuo","補倉(<span class=\"red\" id=\"amt\">5,000</span>) <button act=\"db\" class=\"gms_ctl\" to=\"/statis/duobu?game_id=000\"  type=\"button\">多補</button>"));
             columnDtos.add(new ColumnDto("odds","赔率<select act=\"qh\" class=\"red\">\n" +
                     "                                        <option value=\"S\" selected>全部</option>\n" +
                     "                                        <option value=\"AA\" >A(特A)</option>\n" +
                     "                                        <option value=\"AB\" >A(特B)</option>\n" +
                     "                                        <option value=\"BA\" >B(特A)</option>\n" +
                     "                                        <option value=\"BB\" >B(特B)</option>\n" +
                     "                                        <option value=\"CA\" >C(特A)</option>\n" +
                     "                                        <option value=\"CB\" >C(特B)</option>\n" +
                     "                                    </select>"));
        }
        else if(GameTypeEnum.連碼二.getValue().equals( category_id) ||GameTypeEnum.連碼三.getValue().equals( category_id)
                ||GameTypeEnum.生肖連.getValue().equals( category_id) ||GameTypeEnum.尾數連.getValue().equals( category_id)){


        }
        else {

        }
        return columnDtos;
    }
}
