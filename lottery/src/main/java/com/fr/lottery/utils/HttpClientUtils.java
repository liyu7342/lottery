package com.fr.lottery.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
public class HttpClientUtils {
    // {{httpclient post方式
    /**
     * httpclient post方式一
     *
     * @param url
     * @param value
     * @return
     */
    public static String clientPost(String url, String value) {
        String result = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            // 设置参数
            StringEntity stringEntity = new StringEntity(value, "utf-8");
            // 设置参数类型
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            result = "404";
            System.out.println("post响应失败!");
        }
        return result;
    }

    // }}

    // {{httpclient get方式
    /**
     * httpclient get方式请求
     *
     * @param url
     * @return
     */
    public static String clientGet(String url) {
        url = url.replaceAll(" ", "%20");
        String result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpclient.execute(httpget);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            result = "404";
            System.out.println("get响应失败!");
        }
        return result;
    }

    // }}

    // {{httpclient post方式二
    /**
     * httpclient post方式二
     *
     * @param url
     * @param formparams
     * @return
     */
    public static String clientPost1(String url, List<NameValuePair> formparams) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    // }}

    // {{httpclient get方式二
    /**
     * httpclient get方式请求
     *
     * @param url
     * @return
     */
    public static String clientGet1(String url) {
        url = url.replaceAll(" ", "%20");
        String result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpclient.execute(httpget);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(httpResponse.getEntity());
                result =  new String(result.getBytes("ISO8859-1"), "UTF-8");
            }
        } catch (Exception e) {
            result = "404";
            System.out.println("get响应失败!");
        }
        return result;
    }
    //}}
}
