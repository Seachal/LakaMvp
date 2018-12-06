package com.laka.commonlibrary.utils;

import java.util.Collection;

/**
 * @ClassName:
 * @Description:
 * @Author: chuan
 * @Date: 07/03/2018
 */

public class ListUtils {
    private ListUtils() {
        throw new UnsupportedOperationException("do not instantiate me , please.");
    }

    /**
     * 判断List是否为空
     */
    public static boolean listIsNullOrEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }
}
