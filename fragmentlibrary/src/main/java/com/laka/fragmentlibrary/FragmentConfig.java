package com.laka.fragmentlibrary;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.laka.fragmentlibrary.base.BaseStackFragment;


public class FragmentConfig {


    /**
     * 当前的根屏幕
     */
    public static String CurrentRootScreenName = "";
    /**
     * 当前屏幕
     */
    public static BaseStackFragment mCurrentFragment;


    /**
     * 目前仅支持supportFragmentManager
     */
    public static android.support.v4.app.FragmentManager v4FragmentManager;

    /**
     * 每个需要使用该fragment任务栈的activity, 都需要在activity 中进行fragmentManager的初始化
     * fragmentManger是对应于所处的activity的,不同的activity使用不同的fragmentManger操作fragment.
     */
    public static void initFragmentManager(FragmentActivity activity) {
        v4FragmentManager = activity.getSupportFragmentManager();
    }

    public static void initFragmentManager(AppCompatActivity activity) {
        v4FragmentManager = activity.getSupportFragmentManager();
    }


}
