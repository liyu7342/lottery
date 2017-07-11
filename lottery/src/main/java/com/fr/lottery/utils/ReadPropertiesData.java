package com.fr.lottery.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author yzx
 * 读取properties文件
 */
public class ReadPropertiesData {

    /**
     * 读取文档
     * @param propertiesName
     * @return
     */
    public static Properties readPropertie(String propertiesName) {
        //String PropertiesPath1 = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
         Properties fileProperties = new Properties();
        //String url=PropertiesPath1 +"/"+ propertiesName + ".properties";
        InputStream loadFile = ReadPropertiesData.class.getClassLoader()
                .getResourceAsStream(propertiesName+ ".properties");
        try {
            fileProperties.load(loadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileProperties;
    }

}
