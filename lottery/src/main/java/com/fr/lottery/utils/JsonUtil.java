package com.fr.lottery.utils;

import com.google.gson.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;


import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.*;

/**
 * json格式工具类
 * 
 * @author Ivan
 * 
 */
public class JsonUtil {

	// {{json字符串转换为bean对象公共方法
	/**
	 * json转换为bean对象公共方法
	 * 
	 * @param data
	 * @param typeOfT
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObj(String data, Type typeOfT) {
		// 把json字符串转换为bean对象
		T t = null;
		try {
			if(!StringUtil.isNullOrEmpty(data)){
				data = URLDecoder.decode(data, "UTF-8");// 转码
				Gson gson = new Gson();
				t = (T) gson.fromJson(data, typeOfT);
			}
			return t;

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// }}
	
	
	//{{json字符串转为json对象
	/**
	 * json字符串转为json对象
	 * @param data
	 * @return
	 */
	public static JsonObject getJson(String data){
		JsonObject jsonObj = null;
		JsonParser parser = new JsonParser();
		JsonElement el =parser.parse(data);
		if(el.isJsonObject()){
			jsonObj = el.getAsJsonObject();  
		}
		return jsonObj;
	}
	
	//}}


	//{{带有Extend字段的obj对象转为字符串
	/**
	 * 带有Extend字段的obj对象转为字符串
	 * @param obj
	 * @return String
	 */
	public static String getExtendJsonString(Object obj){
		Gson gson=new Gson();
		String str=gson.toJson(obj);
		str=str.replace("\"extendCol\":\"{\\\"","\"").replace("\\\"}\"","\"").replace("\\\"","\"");
		return str;
	}

	// }}

	public static String toJson(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	public static String toJson(Object obj,String timeFormat){
		if(StringUtils.isBlank(timeFormat))
			timeFormat="yyyy-MM-dd HH:mm:ss";
		Gson gson = new GsonBuilder().setDateFormat(timeFormat).create();

		return gson.toJson(obj);
	}

	/**
	 * 将Json对象转换成Map
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> jsontoMap(String jsonStr){
		Map<String, Object> map = new HashMap<String, Object>();
		//最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for(Object k : json.keySet()){
			Object v = json.get(k);
			//如果内层还是数组的话，继续解析
			if(v instanceof JSONArray){
				List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
				Iterator<JSONObject> it = ((JSONArray)v).iterator();
				while(it.hasNext()){
					JSONObject json2 = it.next();
					list.add(jsontoMap(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}
}
