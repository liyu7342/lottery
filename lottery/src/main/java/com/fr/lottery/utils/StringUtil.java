package com.fr.lottery.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断字符串工具类
 * @author Ivan
 *
 */
public class StringUtil {
	
	//{{判断字符串是否为空
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		boolean result = false;
		
		if ((str == null) || ((str.trim().isEmpty()))) {
			result = true;
		}
		return result;
	}
	//}}
	
	//{{中文编码
		/**
		 * 字符串中文编码
		 * @param result
		 * @return
		 * @throws IOException
		 */
		public static String encoding(String result) throws IOException {
			result = new String(result.getBytes("iso8859-1"),"GBK");
			return result;
		}
		//}}
		
		/**
		 * 判断字符串是否为空
		 * @param str
		 * @return
		 */
		public static String checkEmpty(String str){
			if ((str != null) && (!(str.trim().isEmpty()))) {
				return str;
			}
			return "";
		}

	/**
	 * 从头开始截取
	 *
	 * @param str 字符串
	 * @param end 结束位置
	 * @return
	 */
	public static String subStrStart(String str, int end){
		return subStr(str, 0, end);
	}

	/**
	 * 从尾开始截取
	 *
	 * @param str 字符串
	 * @param start 开始位置
	 * @return
	 */
	public static String subStrEnd(String str, int start){
		return subStr(str, str.length()-start, str.length());
	}

	/**
	 * 截取字符串 （支持正向、反向截取）<br/>
	 *
	 * @param str 待截取的字符串
	 * @param length 长度 ，>=0时，从头开始向后截取length长度的字符串；<0时，从尾开始向前截取length长度的字符串
	 * @return 返回截取的字符串
	 * @throws RuntimeException
	 */
	public static String subStr(String str, int length) throws RuntimeException{
		if(str==null){
			throw new NullPointerException("字符串为null");
		}
		int len = str.length();
		if(len<Math.abs(length)){
			throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(length)));
		}
		if(length>=0){
			return  subStr(str, 0,length);
		}else{
			return subStr(str, len-Math.abs(length), len);
		}
	}


	/**
	 * 截取字符串 （支持正向、反向选择）<br/>
	 *
	 * @param str  待截取的字符串
	 * @param start 起始索引 ，>=0时，从start开始截取；<0时，从length-|start|开始截取
	 * @param end 结束索引 ，>=0时，从end结束截取；<0时，从length-|end|结束截取
	 * @return 返回截取的字符串
	 * @throws RuntimeException
	 */
	public static String subStr(String str, int start, int end) throws RuntimeException{
		if(str==null){
			throw new NullPointerException("");
		}
		int len = str.length();
		int s = 0;//记录起始索引
		int e = 0;//记录结尾索引
		if(len<Math.abs(start)){
			throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(start)));
		}else if(start<0){
			s = len - Math.abs(start);
		}else if(start<0){
			s=0;
		}else{//>=0
			s = start;
		}
		if(len<Math.abs(end)){
			throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(end)));
		}else if (end <0){
			e = len - Math.abs(end);
		}else if (end==0){
			e = len;
		}else{//>=0
			e = end;
		}
		if(e<s){
			throw new StringIndexOutOfBoundsException("截至索引小于起始索引:"+(e-s));
		}

		return str.substring(s, e);
	}

	/*
   * 替换Excel中导入的数字中自动加 .0的情况
   * */
	public static String subZeroAndDot(String s) {
		if (s.indexOf(".") > 0) {
			s = s.replaceAll("0+?$", "");//去掉多余的0
			s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
		}
		return s;
	}

	//判断是否为数字
	public static boolean isNumeric(String str) {
		if(str==null || str.equals(""))
			return true;
		// 该正则表达式可以匹配所有的数字 包括负数
		Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
		String bigStr;
		try {
			bigStr = new BigDecimal(str).toString();
		} catch (Exception e) {
			return false;//异常 说明包含非数字。
		}
		Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	/**
	 * 格式化string为Date
	 *
	 * @param datestr
	 * @return date
	 */
	public static Date parseDate(String datestr) {
		if (null == datestr || "".equals(datestr)) {
			return null;
		}
		try {
			String fmtstr = null;
			if (datestr.indexOf(':') > 0) {
				fmtstr = "yyyy-MM-dd HH:mm:ss";
			} else {
				fmtstr = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);
			return sdf.parse(datestr);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 完整的判断中文汉字和符号
	 * @param strName
	 * @return
     */
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	public static String getVersion(){
		DecimalFormat df = new DecimalFormat("######0.0000");
		Random random = new Random();
		String version=df.format(1+random.nextDouble() * 8);
		return version;
	}

	/*
    * 替换非法字符
    * */
	public static String replaceIllegaChar(String value){
		String reg = "['\"]";
		Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		return matcher.replaceAll("");
	}

	/**
	 *  根据Unicode编码完美的判断中文汉字和符号
	 * @param c
	 * @return
     */
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	public static String getUUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-","");
	}
}
