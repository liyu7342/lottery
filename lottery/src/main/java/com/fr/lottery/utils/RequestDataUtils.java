package com.fr.lottery.utils;


import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URLDecoder;

/**
 * Created by Administrator on 2017/3/21.
 */
public class RequestDataUtils {
    // {{获取post方式传递过来的参数
    /**
     * 获取post方式传递过来的数据
     *
     * @param request
     * @return
     */
    public static String getPostData(HttpServletRequest request) {
        try {
            ServletInputStream stream = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    stream, "UTF-8"));
            String line;
            String data = "";
            while ((line = reader.readLine()) != null) {
                data += line;
            }
            return data;

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    // }}

    // {{获取get方式传递过来的参数,封装为对象
    /**
     * 获取get方式传递过来的参数
     * 通过反射，赋值给对象
     *
     * @param request
     * @param clz
     * @return
     */
    public static <T> T getRequestParams(HttpServletRequest request,
                                         Class<T> clz) {
        T data = null;
        try {
            data = clz.newInstance();
            // 获取实体类的所有属性，返回Field数组
            Field[] fields = clz.getDeclaredFields();
            String dataValue = "";
            for (Field field : fields) {
                // 获取属性值
                dataValue = request.getParameter(field.getName());
                if(dataValue == null){
                    dataValue = "";
                }
                if (StringUtils.isNotBlank(dataValue)) {
//					dataValue = new String(dataValue.getBytes("iso8859-1"),"UTF-8");
                    dataValue = URLDecoder.decode(dataValue, "UTF-8");// 转码
                }
                field.setAccessible(true);
                field.set(data, dataValue);// 赋值
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
