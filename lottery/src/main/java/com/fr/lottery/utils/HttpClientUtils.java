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

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
public class HttpClientUtils {
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


    public static final String clientGetByHttps(String url){
        HttpURLConnection connection = null;

        try {
            URL realUrl  = new URL(url);
            if("https".equalsIgnoreCase(realUrl.getProtocol())){
                SslUtil.ignoreSsl();
            }
            connection = (HttpURLConnection) realUrl.openConnection();
            final BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String line;
            final StringBuffer stringBuffer = new StringBuffer(255);

            synchronized (stringBuffer) {
                while ((line = in.readLine()) != null) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
                return stringBuffer.toString();
            }

        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        } catch (final Exception e1){
            e1.printStackTrace();
            return null;
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
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

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

}
