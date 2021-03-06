package com.fr.lottery.init;

/**
 * Created by Administrator on 2017/6/16.
 */


import com.fr.lottery.entity.LotConfig;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.utils.LotConfigHelper;
import com.fr.lottery.utils.ReadPropertiesData;
import com.fr.lottery.utils.ShengXiaoConfigHelper;
import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * 全局配置类
 *
 * @version 2014-06-25
 */
public class Global {

//    /**
//     * 当前对象实例
//     */
//    private static Global global = new Global();

//    /**
//     * 保存全局属性值
//     */
//    private static Map<String, String> map = Maps.newHashMap();

//    /**
//     * 属性文件加载对象
//     */
//    private static PropertiesLoader loader = new PropertiesLoader("data.properties");

    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";

    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public static final Integer pageSize=20;
    public static final Integer pageSizeOfTen=10;
    public static  final Integer pageSizeOfFiften=15;
    public static final Integer pageSizeOfTh=30;

    public static final Integer userStatus_qiyong=1;
    public static final Integer userStatus_tingyong=0;
    public static final Integer userStatus_tingya=2;
    public static final Integer userStatus_jinzhidenglu=3;
    public static final Integer userStatus_delete=4;

    public static final String memcached_user_key="user_user_";

    public static final Map<String,LotConfig> lotConfigDic =new HashMap<String, LotConfig>();

    public static final Map<String,ShengXiao> shengxiaoDic = new HashMap<String, ShengXiao>();

    public static Properties  properties;
    static {
        List<LotConfig> lotConfigs= LotConfigHelper.findAll();
        for(LotConfig lotConfig: lotConfigs){
            Global.lotConfigDic.put(lotConfig.getGameNo(),lotConfig);
        }
        Map<String,ShengXiao> _shengxiaoDic = ShengXiaoConfigHelper.findShengxiaos();
        for(String key :_shengxiaoDic.keySet()){
            Global.shengxiaoDic.put(key,_shengxiaoDic.get(key));
        }

        properties= ReadPropertiesData.readPropertie("config");
    }




}