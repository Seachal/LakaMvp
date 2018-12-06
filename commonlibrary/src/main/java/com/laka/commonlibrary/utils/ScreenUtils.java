package com.laka.commonlibrary.utils;

/**
 * @ClassName: ScreenUtils
 * @Description: 屏幕工具
 * @Author: chuan
 * @Date: 09/01/2018
 */

public final class ScreenUtils {
    private static int mScreenWidth = 0;
    private static int mScreenHeight = 0;
    private static int mStatusBarHeight = 0;

    private ScreenUtils() {
        throw new UnsupportedOperationException("do not instantiate me , please.");
    }

    /**
     * 得到设备屏幕的宽度
     *
     * @return 屏幕宽度 pixels
     */
    public static int getScreenWidth() {
        if (mScreenWidth <= 0) {
            mScreenWidth = ApplicationUtils.getApplication().getResources().getDisplayMetrics().widthPixels;
        }
        return mScreenWidth;
    }

    /**
     * 得到设备屏幕的高度
     *
     * @return 屏幕高度 pixels
     */
    public static int getScreenHeight() {
        if (mScreenHeight <= 0) {
            mScreenHeight = ApplicationUtils.getApplication().getResources().getDisplayMetrics().heightPixels;
        }
        return mScreenHeight;
    }

    /**
     * 获取StatusBar高度
     *
     * @return StatusBar高度 pixels
     */
    public static int getStatusBarHeight() {
        if (mStatusBarHeight <= 0) {
            int resourceId = ApplicationUtils.getApplication().getResources().getIdentifier(
                    "status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                mStatusBarHeight = ApplicationUtils.getApplication().getResources().getDimensionPixelSize(resourceId);
            }
        }
        return mStatusBarHeight;
    }

    /**
     * 获取屏幕高度。不包括状态栏的高度
     *
     * @return 屏幕高度 pixels
     */
    public static int getScreenHeightWithoutStatusBar() {
        if (mScreenHeight <= 0) {
            getScreenHeight();
        }

        if (mStatusBarHeight <= 0) {
            getStatusBarHeight();
        }

        return mScreenHeight - mStatusBarHeight;
    }

    /**
     * dp值转化为px值
     *
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(float dpValue) {
        final float scale = ApplicationUtils.getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px值转化为dp值
     *
     * @param pxValue px值
     * @return dp值
     */
    public static float px2dp(float pxValue) {
        final float scale = ApplicationUtils.getApplication().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * px值转化为sp值
     *
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp(float pxValue) {
        final float fontScale = ApplicationUtils.getApplication().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * sp值转化为px值
     *
     * @param spValue sp值
     * @return px值
     */
    public static int sp2px(float spValue) {
        final float fontScale = ApplicationUtils.getApplication().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
