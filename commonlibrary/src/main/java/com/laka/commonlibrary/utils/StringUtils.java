package com.laka.commonlibrary.utils;

/**
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 * @Author: chuan
 * @Date: 10/01/2018
 */

public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("do not instantiate me , please.");
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 待判断字符串
     * @return true, 字符串为空；false,字符串不为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串是否为空，不包括" "
     *
     * @param str 待判断字符串
     * @return true, 字符串为空；false,字符串不为空
     */
    public static boolean isTrimEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断两个String是否相等
     *
     * @param strA String
     * @param strB String
     * @return true ， 相等；false，不相等
     */
    public static boolean equals(String strA, String strB) {
        return (strA == null && strB == null)
                || (strA != null) && (strB != null) && strA.equals(strB);
    }

    /**
     * 判断两个String是否相等
     * 忽略大小写
     *
     * @param strA String
     * @param strB String
     * @return true ， 相等；false，不相等
     */
    public static boolean equalsIgnoreCase(String strA, String strB) {
        return (strA == null && strB == null)
                || (strA != null) && (strB != null) && strA.equalsIgnoreCase(strB);
    }

    /**
     * 转化String为int值
     *
     * @param str String值
     * @return String转化的int值或0
     */
    public static int parseInt(String str) {
        return parseInt(str, 0);
    }

    /**
     * 转化String为int值
     *
     * @param str      String值
     * @param defValue 转化失败时的默认值
     * @return String转化的int值或defValue
     */
    public static int parseInt(String str, int defValue) {
        int result = defValue;

        if (isTrimEmpty(str)) {
            return result;
        }

        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            result = defValue;
        }

        return result;
    }

    /**
     * 转化String值为float值
     *
     * @param str String值
     * @return String转化成功的float值或0f
     */
    public static float parseFloat(String str) {
        return parseFloat(str, 0f);
    }

    /**
     * 转化String值为float值
     *
     * @param str      String值
     * @param defValue 转化失败时返回的默认值
     * @return String转化成功的float值或defValue
     */
    public static float parseFloat(String str, float defValue) {
        float result = defValue;

        if (isTrimEmpty(str)) {
            return result;
        }

        try {
            result = Float.parseFloat(str);
        } catch (Exception e) {
            e.printStackTrace();
            result = defValue;
        }

        return result;
    }

    /**
     * 转化String值为long值
     *
     * @param str String值
     * @return String转化成功的long值或0L
     */
    public static long parseLong(String str) {
        return parseLong(str, 0L);
    }

    /**
     * 转化String值为long值
     *
     * @param str      String值
     * @param defValue 转化失败时的默认值
     * @return String转化成功的long值或defValue
     */
    public static long parseLong(String str, long defValue) {
        long result = defValue;

        if (isTrimEmpty(str)) {
            return result;
        }

        try {
            result = Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            result = defValue;
        }

        return result;
    }

    /**
     * String值转化为boolean值
     *
     * @param str String值
     * @return boolean值
     */
    public static boolean parseBoolean(String str) {
        return "true".equalsIgnoreCase(str);
    }
}
