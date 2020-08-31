package com.example.freightmanagement.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyubing on 2019/3/29.
 */
public class StringUtil {

    private static final Pattern PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");;

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0 && str.trim().length() > 0;
    }

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static boolean isNotEmpty(Integer integer) {
        return integer != null && !integer.equals("");
    }

    public static boolean isEmpty(Integer integer) {
        return !isNotEmpty(integer);
    }
    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (isEmpty(str)){
            return false;
        }
        return PATTERN.matcher(str).matches();
    }

    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[`_~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 获取内容中-汉字个数
     * @param content - 内容
     * @return int
     */
    public static int getChineseSize(String content) {
        int count = 0;//汉字数量
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        int len = m.groupCount();
        while (m.find()) {
            for (int i = 0; i <= len; i++) {
                count = count + 1;
            }
        }
        return count;
    }

    /**
     * 判断是否是正整数
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        if((str.matches("[0-9]+"))&&(Integer.parseInt(str)>0)) {
            return true;
        }
        return false;
    }


}
