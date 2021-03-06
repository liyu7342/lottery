package com.fr.lottery.utils;


import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author yzx
 * @date 2015/6/24 10:55
 */
public class DateTimeUtils {
    private static SimpleDateFormat dateFormatSimple = new SimpleDateFormat(
            "yyyy-MM-dd");
    private static SimpleDateFormat dateFormatLong = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static String Date2StringSimple(Date date) {
        if(date ==null) return "";
        return dateFormatSimple.format(date);
    }
    public static String Date2StringLong(Date date) {
        if(date ==null) return "";
        return dateFormatLong.format(date);
    }
    public static String Date2String(Date date,String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format);
        return dateFormat.format(date);
    }
    public static Date String2DateSimple(String date) {
        try {
            if(StringUtils.isNotBlank(date)){
                return dateFormatSimple.parse(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date String2DateLong(String date) {
        try {
        	if(StringUtils.isNotBlank(date)){
        		return dateFormatLong.parse(date);
        	}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
    }
    public static Date String2Date(String date,String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format);
        return dateFormat.parse(date);
    }
    public static String getDayLast(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return Date2String(calendar.getTime(),"yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDate(int hour,int minute,int second){
        Calendar calendar =  Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        return calendar.getTime();
    }
    public static String getDayFirst(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return Date2String(calendar.getTime(),"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取几小时前
     * @return
     */
    public static String getDay(Date date,Integer hour,Integer minute,Integer second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(hour!=null)
            calendar.add(Calendar.HOUR_OF_DAY,hour);
        if(minute!=null)
            calendar.add(Calendar.MINUTE,minute);
        if(second!=null)
            calendar.add(Calendar.SECOND,second);
        return Date2String(calendar.getTime(),"yyyy-MM-dd HH:mm:ss");
    }


    public static Date addSeconds(Date date,Integer second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(second!=null)
            calendar.add(Calendar.SECOND,second);
        return calendar.getTime();
    }

    public static Date addDays(Date date,Integer days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if(days!=null)
            calendar.add(Calendar.DAY_OF_YEAR,days);
        return calendar.getTime();
    }

    public  static Date addMonths(Date date,Integer month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(month!=null){
            calendar.add(Calendar.MONTH,month);
        }
        return calendar.getTime();
    }

    /**
     * 获取指定的时间格式:yyyy-MM-dd  HH:mm:ss
     *
     * @return
     */
    public static String getTimeByCalendar() {
        String[] week = {"一", "二", "三", "四", "五", "六","日"};
        Calendar cal = Calendar.getInstance();
        //一周第一天是否为星期天
        boolean isFirstSunday = (cal.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = format.format(date);
        String times[] = time.split(" ");
        String returnTime = times[0]+" 星期" + week[weekDay-1]+" "+times[1];
        return returnTime;
    }

    public static String getTimeByCalendar(String riqi,String format){
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt( riqi.substring(0,4)),Integer.parseInt(riqi.substring(5,7))-1,Integer.parseInt(riqi.substring(8,10)));
        //一周第一天是否为星期天
        boolean isFirstSunday = (cal.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format);
        String returnTime = dateFormat.format(cal.getTime());
        return  returnTime+ "（星期"+weekDay+"）";

    }
}
