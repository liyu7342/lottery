package com.fr.lottery.dto;

import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-8.
 */
public class StatisTable {
    //<input type="hidden" name="category_id" value='00'>
    //<input type="hidden" name="game_id" value='000'>
    //<input type="hidden" name="time_stamp" value='1512634637,1512648422,0'>
    //<input type="hidden" name="fresh" value='0'>
    //<input type="hidden" name="level" value='2'>
    //<input type="hidden" name="odds_set" value='S'>
    //<table>

    private static final String _className = "g-t1 g-t2";

    private String className;

    private String category_id;

    private List<StatisDto> data;

    private List<String> _htmlList;

    public StatisTable( List<StatisDto> data,String category_id) {
        this.data = data;
        this.category_id = category_id;
        this.className = _className;
        _htmlList = new ArrayList<String>();
    }

    public StatisTable( List<StatisDto> data, String category_id,String className) {

        this.data = data;
        this.category_id = category_id;
        this.className = className;
        _htmlList = new ArrayList<String>();
    }

    @Override
    public String toString() {
        _htmlList.add("<table class=\"" + className + "\">");
        if(GameTypeEnum.特码.getValue().equals( this.category_id)){

            List<String> headList = this.generateTemaHeader();
            _htmlList.addAll(headList);
            List<String> bodyList = this.generateTemaBody();
            _htmlList.addAll(bodyList);
            List<String> footerList = this.generateTemaFooter();
            _htmlList.addAll(footerList);

        }
        else if(GameTypeEnum.連碼二.getValue().equals(category_id) || GameTypeEnum.連碼三.getValue().equals(category_id)
                || GameTypeEnum.生肖連.getValue().equals(category_id) || GameTypeEnum.尾數連.getValue().equals(category_id)){
            List<String> headList = this.generateLianmaHeader();
            _htmlList.addAll(headList);
            List<String> bodyList = this.generateLianmaBody();
            _htmlList.addAll(bodyList);
            List<String> footerList = this.generateLianmaFooter();
            _htmlList.addAll(footerList);
        }else{
            List<String> headList = this.generateZhengmaHeader();
            _htmlList.addAll(headList);
            List<String> bodyList = this.generateZhengmaBody();
            _htmlList.addAll(bodyList);
            List<String> footerList = this.generateZhengmaFooter();
            _htmlList.addAll(footerList);
        }
        _htmlList.add("</table>");
        String str = StringUtils.join(_htmlList, "\r\n");
        return str;
    }


    private List<String> generateTemaHeader() {
        List<String> _header = new ArrayList<String>();
        _header.add("<thead>");
        _header.add("<tr>");
        String[] columnList = new String[]{
                "序號","玩法","数量","下注總額","總佔成","平均賠率","勝出金額",
                "補倉(<span class=\"red\" id=\"amt\">5,000</span>) <button act=\"db\" class=\"gms_ctl\" to=\"/statis/duobu?game_id=000\"  type=\"button\">多補</button>",
                "赔率<select act=\"qh\" class=\"red\">\n" +
                        "                                        <option value=\"S\" selected>全部</option>\n" +
                        "                                        <option value=\"AA\" >A(特A)</option>\n" +
                        "                                        <option value=\"AB\" >A(特B)</option>\n" +
                        "                                        <option value=\"BA\" >B(特A)</option>\n" +
                        "                                        <option value=\"BB\" >B(特B)</option>\n" +
                        "                                        <option value=\"CA\" >C(特A)</option>\n" +
                        "                                        <option value=\"CB\" >C(特B)</option>\n" +
                        "                                    </select>"
        };
        for (String columnName : columnList) {
            _header.add("<td >" + columnName+ "</td>");
        }
        _header.add("</tr>");
        _header.add("</thead>");
        return _header;
    }

    private List<String> generateTemaBody() {
        List<String> bodyList = new ArrayList<String>();

        bodyList.add("<tbody>");
        int index = 1;
        for (StatisDto t : data) {
            String descEnc="";
            try{
                descEnc= URLEncoder.encode(t.getDescription(), "UTF-8");
            }
            catch (UnsupportedEncodingException ex){
                ex.printStackTrace();
            }
            bodyList.add("<tr id=\"" + t.getNo() + "\">");
            bodyList.add("<td>" + index + "</td>");
            bodyList.add("<td><a href=\"javascript:void(0);\" to=\"/order/xiazhumingxi?game_id=" + t.getGameType() + "&number=" + t.getNo() + "&name="
                    + descEnc + "\">" + t.getDescription() + "</a></td>");
            bodyList.add("<td>" + t.getOrderNum() + "</td>");
            bodyList.add("<td>" + t.getAmount() + "</td>");
            bodyList.add("<td>" + StringUtil.ToInteger(t.getShareTotal().toString()) + "</td>");
            bodyList.add("<td>" + t.getAveOdds() + "</td>");
            bodyList.add("<td>" +StringUtil.ToInteger(t.getWinAmount().toString())  + "</td>");
            bodyList.add("<td><a href=\"javascript:void(0);\" to=\"/statis/short_covering?number="+t.getNo()+"&amp;game_id="+t.getGameType()
                    +"&amp;amt=0\" class=\"red gms_a\">"+ (t.getBuhuo()==null?0:StringUtil.ToInteger(t.getBuhuo().toString())) +"</a></td>");
            bodyList.add("<td><span oddsSet='AA'>"+t.getAaOdds()+"</span><span oddsSet='AB'  class=\"hid\">"+t.getAbOdds()+"</span><span   oddsSet='BA' class=\"hid\">"+t.getBaOdds()
                    +"</span><span   oddsSet='BB' class=\"hid\">"+t.getBbOdds()+"</span><span   oddsSet='CA' class=\"hid\">"
                    +t.getCaOdds()+"</span><span   oddsSet='CB' class=\"hid\">"+t.getCbOdds()+"</span></td>");
            bodyList.add("</tr>");
            index++;
        }
        bodyList.add("</tbody>");
        return bodyList;
    }

    private List<String> generateTemaFooter(){
        List<String> _footerList= new ArrayList<String>();
        Integer orderNum=0;
        Float amount =0F;
        Float shareTotal=0F;

        for(StatisDto statisDto :this.data){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal+= statisDto.getShareTotal();
        }
        _footerList.add("<tfoot>");
        _footerList.add("<td></td>");
        _footerList.add("<td>總計</td>");
        _footerList.add("<td>"+orderNum+"</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(amount.toString())+"</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(shareTotal.toString())+"</td>");
        _footerList.add("<td colspan=\"4\"></td>");
        _footerList.add("</tfoot>");
        return _footerList;
    }

    private List<String> generateZhengmaHeader() {
        List<String> _header = new ArrayList<String>();
        _header.add("<thead>");
        _header.add("<tr>");
        String[] columnList = new String[]{
                "序號","玩法","数量","下注總額","<em><span class=\"hc\" act=\"hide\">總佔成</span></em>","佣金收入","彩金","平均賠率","勝出金額",
                "補倉(<span class=\"red\" id=\"amt\">5,000</span>) <button act=\"db\" class=\"gms_ctl\" to=\"/statis/duobu?game_id=001\"  type=\"button\">多補</button>",
                "賠率\n" +
                        "                <select act=\"qh\" class=\"red\">\n" +
                        "                                        <option value=\"S\" selected>全部</option>\n" +
                        "                                        <option value=\"A\" >A</option>\n" +
                        "                                        <option value=\"B\" >B</option>\n" +
                        "                                        <option value=\"C\" >C</option>\n" +
                        "                                    </select>"
        };
        for (String columnName : columnList) {
            _header.add("<td >" + columnName+ "</td>");
        }
        _header.add("</tr>");
        _header.add("</thead>");
        return _header;
    }

    private List<String> generateZhengmaBody() {

        if (this.data.size() == 0)
            return new ArrayList<String>();
        List<String> bodyList = new ArrayList<String>();

        bodyList.add("<tbody>");
        int index = 1;
        for (StatisDto t : data) {
            String descEnc="";
            try{
                descEnc= URLEncoder.encode(t.getDescription(), "UTF-8");
            }
            catch (UnsupportedEncodingException ex){
                ex.printStackTrace();
            }
            bodyList.add("<tr id=\"" + t.getNo() + "\">");
            bodyList.add("<td>" + index + "</td>");
            bodyList.add("<td><a href=\"javascript:void(0);\" to=\"/order/xiazhumingxi?game_id=" + t.getGameType() + "&number=" + t.getNo() + "&name="
                    + descEnc + "\">" + t.getDescription() + "</a></td>");
            bodyList.add("<td>" + t.getOrderNum() + "</td>");
            bodyList.add("<td>" + StringUtil.ToInteger(t.getAmount().toString())  + "</td>");
            bodyList.add("<td>" + StringUtil.ToInteger(t.getShareTotal().toString()) + "</td>");
            bodyList.add("<td>" + StringUtil.ToInteger(t.getYongJin().toString()) + "</td>");
            bodyList.add("<td>" + StringUtil.ToInteger(t.getCaiJin().toString()) + "</td>");
            bodyList.add("<td>" + t.getAveOdds() + "</td>");
            bodyList.add("<td>" +StringUtil.ToInteger(t.getWinAmount().toString())  + "</td>");
            bodyList.add("<td><a href=\"javascript:void(0);\" to=\"/statis/short_covering?number="+t.getNo()+"&amp;game_id="+t.getGameType()
                    +"&amp;amt=0\" class=\"red gms_a\">"+ (t.getBuhuo()==null?0:StringUtil.ToInteger(t.getBuhuo().toString())) +"</a></td>");
            bodyList.add("<td><span oddsSet='A'>"+t.getAaOdds()+"</span><span oddsSet='B'  class=\"hid\">"+t.getBaOdds()
                    +"</span><span   oddsSet='C' class=\"hid\">"+t.getCaOdds()  +"</span></td>");
            bodyList.add("</tr>");
            index++;
        }
        bodyList.add("</tbody>");
        return bodyList;
    }

    private List<String> generateZhengmaFooter(){
        List<String> _footerList= new ArrayList<String>();
        Integer orderNum=0;
        Float amount =0F;
        Float shareTotal=0F;
        Float yongjin=0F;
        Float caijin=0F;

        for(StatisDto statisDto :this.data){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal+= statisDto.getShareTotal();
            yongjin+=statisDto.getYongJin();
            caijin +=statisDto.getCaiJin();
        }
        _footerList.add("<tfoot>");
        _footerList.add("<td></td>");
        _footerList.add("<td>總計</td>");
        _footerList.add("<td>"+orderNum+"</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(amount.toString())+"</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(shareTotal.toString())+"</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(yongjin.toString())+"</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(caijin.toString())+"</td>");
        _footerList.add("<td colspan=\"4\"></td>");
        _footerList.add("</tfoot>");
        return _footerList;
    }

    private List<String> generateLianmaHeader() {
        List<String> _header = new ArrayList<String>();
        _header.add("<thead>");
        _header.add("<tr>");
        String[] columnList = new String[]{
                "序號","玩法","佔成收入",
                "<em class=\"r\">補倉</em>"

        };
        for (String columnName : columnList) {
            _header.add("<td >" + columnName+ "</td>");
        }
        _header.add("</tr>");
        _header.add("</thead>");
        return _header;
    }

    private List<String> generateLianmaBody() {

        List<String> bodyList = new ArrayList<String>();

        bodyList.add("<tbody>");
        int index = 1;
        for (StatisDto t : data) {
            String descEnc="";
            try{
                descEnc= URLEncoder.encode(t.getDescription(), "UTF-8");
            }
            catch (UnsupportedEncodingException ex){
                ex.printStackTrace();
            }
            bodyList.add("<tr id=\"" + t.getNo() + "\">");
            bodyList.add("<td>" + index + "</td>");
            bodyList.add("<td><a href=\"javascript:void(0);\" to=\"/order/xiazhumingxi?game_id=" + t.getGameType() + "&number=" + t.getNo() + "&name="
                    + descEnc + "\">" + t.getDescription() + "</a></td>");
            bodyList.add("<td>" + StringUtil.ToInteger(t.getShareTotal().toString()) + "</td>");
            bodyList.add("<td>" + t.getAveOdds() + "</td>");
            bodyList.add("<td><a href=\"javascript:void(0);\" to=\"/statis/short_covering?number="+t.getNo()+"&amp;game_id="+t.getGameType()
                    +"&amp;amt=0\" class=\"red gms_a\">"+ (t.getBuhuo()==null?0:StringUtil.ToInteger(t.getBuhuo().toString())) +"</a></td>");
            bodyList.add("</tr>");
            index++;
        }
        bodyList.add("</tbody>");
        return bodyList;
    }

    private List<String> generateLianmaFooter(){
        List<String> _footerList= new ArrayList<String>();

        Float shareTotal=0F;

        for(StatisDto statisDto :this.data){
            shareTotal+= statisDto.getShareTotal();
        }
        _footerList.add("<tfoot>");
        _footerList.add("<td colspan=\"2\">總 計</td>");
        _footerList.add("<td>"+ StringUtil.ToInteger(shareTotal.toString())+"</td>");
        _footerList.add("<td></td>");
        _footerList.add("</tfoot>");
        return _footerList;
    }

}


