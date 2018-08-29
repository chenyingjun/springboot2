package com.chenyingjun.springboot2.utils;

/**
 * 常用的正则表达式，用于匹配字符串等
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
public class RegexStringsUtil {
	
	/** 全数字,最少一位 **/
	public final static String REG_NUMBER = "^[0-9]+$";
	
	/** 银行账号校验,数字或-符号，最少一位 **/
	public final static String REG_BANK_ACCOUNT = "^[\\d\\-]+$";
	
	/** 特殊字符special_char */
	public final static String REG_SPECIAL_CHAR = "^[^鸂麪鼱隣獱珷瑺瓲疇癄\"“”'/\\\\|\\[\\]<>《》‘’\\t\\r\\n]*$";
	
	/** 完整日期，支持“/”格式，年月日时分秒，匹配例如2013-06-18 20:50:00,带连字符“-”和“:” */
    public final static String REG_RULE_FULL_DATE = "^(19|20)\\d{2}[/]([0]{0,1}[1-9]|[1][0-2])[/]([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])[ ](([0]{0,1}[0-9]|[1][0-9]|[2][0-3])([:](([0]{0,1}[0-9])|([1-5][0-9]))){2})";
    /** 日期，年月日，支持“/”格式，匹配例如2013-06-18或20130618的格式，带或者不带连字符“-” */
    public final static String REG_RULE_DATE = "^(19|20)\\d{2}[/]{0,1}([0]{0,1}[1-9]|[1][0-2])[/]{0,1}([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])$";
    /** 年月日时分，支持“/”格式，匹配例如2013-06-18 20:50,带连字符“-”和“:” */
    public final static String REG_RULE_PART_DATE = "^(19|20)\\d{2}[/]([0]{0,1}[1-9]|[1][0-2])[/]([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])[ ](([0]{0,1}[0-9]|[1][0-9]|[2][0-3])([:](([0]{0,1}[0-9])|([1-5][0-9]))))";

    /** 日期，年月日，匹配例如2013-06-18的格式，带连字符“-” */
    public final static String REG_DATE_WITH_CONNECTOR = "^(19|20)\\d{2}[-]([0]{0,1}[1-9]|[1][0-2])[-]([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])$";

    /** 日期，年月日，匹配例如2013-06-18或20130618的格式，带或者不带连字符“-” */
    public final static String REG_DATE = "^(19|20)\\d{2}[-]{0,1}([0]{0,1}[1-9]|[1][0-2])[-]{0,1}([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])$";

    /** 时间，时分秒，匹配例如20:50:00 */
    public final static String REG_TIME = "^[0]{0,1}[0-9]|[1][0-9]|[2][0-3]([:](([0]{0,1}[0-9])|([1-5][0-9]))){2}$";

    /** 完整日期，年月日时分秒，匹配例如2013-06-18 20:50:00,带连字符“-”和“:” */
    public final static String REG_FULL_DATE = "^(19|20)\\d{2}[-]([0]{0,1}[1-9]|[1][0-2])[-]([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])[ ](([0]{0,1}[0-9]|[1][0-9]|[2][0-3])([:](([0]{0,1}[0-9])|([1-5][0-9]))){2})";

    /** 年月日时分，匹配例如2013-06-18 20:50,带连字符“-”和“:” */
    public final static String REG_PART_DATE = "^(19|20)\\d{2}[-]([0]{0,1}[1-9]|[1][0-2])[-]([0]{0,1}[1-9]|[1-2][0-9]|[3][0-1])[ ](([0]{0,1}[0-9]|[1][0-9]|[2][0-3])([:](([0]{0,1}[0-9])|([1-5][0-9]))))";

    /** 身份证15位 */
    public final static String REG_IDCARD_15 = "^[1-9]\\d{13}[Xx|0-9]$";

    /** 身份证18位 */
    public final static String REG_IDCARD_18 = "^[1-9]\\d{16}[Xx|0-9]$";

    /** 金额，最多只能到分，例如1.23或者12 */
    public final static String REG_MONEY = "^([1-9]{1}\\d{0,13})([.]\\d{0,2}){0,1}$";
    /**
     * 匹配中文
     */
    public final static String REG_CHINA = "[\\u4e00-\\u9fa5]";
    
    /** 家庭电话正则  */
    public final static String REG_HOME_TELEPHONE_FIRST = "^(\\+?\\d{1,3}\\-){0,1}0\\d{2,3}\\-\\d{7,8}(\\-\\d*){0,1}$";
    public final static String REG_HOME_TELEPHONE_TWO = "^{0,1}0\\d{2,3}\\,\\d{7,8}(\\-\\d*){0,1}$";
    
    /** 车牌信息正则 */ 
    public final static String REG_CAR_MARK = "^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z0-9_-]{5}[a-zA-Z_0-9_\u4e00-\u9fa5]$";
    public final static String REG_CAR_MARK_ONE = "^([\u4e00-\u9fa5]|WJ)[A-Z]*\\d*[A-Z]*$";
    public final static String REG_CAR_MARK_TWO = "^([\u4e00-\u9fa5]|WJ)([A-Z]|\\d)*$";
    
    
    //编码
    public static final String ENCODING_GBK = "GBK";
    public static final String ENCODING_UTF_8 = "UTF-8";
    
}
