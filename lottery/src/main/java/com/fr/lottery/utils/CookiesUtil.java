package com.fr.lottery.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/16.
 */
public class CookiesUtil {
    public static void addCookie(HttpServletResponse response, String name, String value,int time) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(name.trim(), URLEncoder.encode(value.trim(),"utf-8").toString());
        cookie.setMaxAge(time);// 设置为30min
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

    public static Cookie getCookieByName(String name)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

   public static void clearCookies(HttpServletRequest request,HttpServletResponse response)
   {
       Cookie[] cookies=request.getCookies();
       try{
           for(int i=0;i<cookies.length;i++){
               Cookie cookie = new Cookie("bbs_0001",null);
               cookie.setMaxAge(0);
               //cookie.setPath("/");//根据你创建cookie的路径进行填写
                   response.addCookie(cookie);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }

    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static  Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
