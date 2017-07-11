package com.fr.lottery.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Lthui on 2017/3/6.
 */
public class FileUtils {
    public static void DownloadFileFromNet(String url,String fileName, HttpServletResponse response){
        DataInputStream in=null;
        OutputStream out =null;
        try{

           url= url.replace("+","%2b");//将＋ 转义 ，否则数字签名出现 + 时通不过
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            in = new DataInputStream(connection.getInputStream());
            response.setContentType("application/octet-stream");
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            byte[] buf = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }
            out.flush();
            out.close();
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}