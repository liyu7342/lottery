package com.fr.lottery.dto;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-8.
 */
public class StatisTable1<T> {
    //<input type="hidden" name="category_id" value='00'>
    //<input type="hidden" name="game_id" value='000'>
    //<input type="hidden" name="time_stamp" value='1512634637,1512648422,0'>
    //<input type="hidden" name="fresh" value='0'>
    //<input type="hidden" name="level" value='2'>
    //<input type="hidden" name="odds_set" value='S'>
    //<table>

    private String footer;

     private static final String _className  = "g-t1 g-t2";

    private String className;

    private List<ColumnDto> columnDtos;

    private List<T> data;

    private List<String> _htmlList;

    public StatisTable1( List<ColumnDto> columnDtos,List<T> data){
        this.data = data;
        this.columnDtos=columnDtos;
        this.className= _className;
        _htmlList = new ArrayList<String>();
    }

    public StatisTable1(List<ColumnDto> columnDtos,List<T> data,String className){
        this.columnDtos= columnDtos;
        this.data = data;
        this.className=className;
        _htmlList = new ArrayList<String>();
    }
    @Override
    public String toString(){
        _htmlList.add("<table class=\""+className+"\">");
         List<String> headList =  this.generateHeader();
        _htmlList.addAll(headList);
        List<String> bodyList = this.generateBody();
        _htmlList.addAll(bodyList);
        _htmlList.add(footer);
        _htmlList.add("</table>");
        String str = StringUtils.join(_htmlList,"\r\n");
        return  str;
    }



    private List<String> generateHeader(){
        List<String> _header =new ArrayList<String>();
        _header.add("<thead>");
        _header.add("<tr>");
        for(ColumnDto columnDto : columnDtos){
            _header.add("<td class=\""+columnDto.getHeaderClassName()+"\">"+columnDto.getHeaderName()+"</td>");
        }
        _header.add("</tr>");
        _header.add("</thead>");
         return  _header;
    }

    private List<String> generateBody(){

        if(this.data.size()==0)
            return new ArrayList<String>();
        List<String> bodyList = new ArrayList<String>();
        // 通过反射机制获取子类传递过来的实体类的类型信息

        bodyList.add("<tbody>");
        for(T t : data){
            Class clazz =t.getClass();
//            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//            Class clazz = (Class<T>) type.getActualTypeArguments()[0];
            Field[] fields = clazz.getDeclaredFields();//取得所有类成员变量
            bodyList.add("<tr id=\""+"123"+"\">");

            for(Field field:fields){
                for(ColumnDto columnDto:columnDtos){
                    if(field.getName().equals(columnDto.getColumnName())){
                        field.setAccessible(true);
                        try {

                            bodyList.add("<td class=\""+columnDto.getClassName()+"\">"+field.get(t)+"</td>");
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
            bodyList.add("</tr>");
        }
        bodyList.add("</tbody>");
        return bodyList;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public static void main(String[] args) {
        List<ColumnDto> columnDtos = new ArrayList<ColumnDto>();
        ColumnDto columnDto= new ColumnDto();
        columnDto.setColumnName("gameType");
        columnDtos.add(columnDto);
        ColumnDto columnDto1 = new ColumnDto();
        columnDto1.setColumnName("description");
        columnDtos.add(columnDto1);
        List<StatisDto> statisDtos = new ArrayList<StatisDto>();
        StatisDto statisDto = new StatisDto();
        statisDto.setDescription("123");
        statisDto.setGameType("000");
        StatisDto statisDto1 = new StatisDto();
        statisDto1.setDescription("1234");
        statisDto1.setGameType("0004");
        statisDtos.add(statisDto);
        statisDtos.add(statisDto1);
        StatisTable1<StatisDto> statisTable = new StatisTable1<StatisDto>(columnDtos,statisDtos);
        String str= statisTable.toString();
        System.out.print(str);
    }
}


