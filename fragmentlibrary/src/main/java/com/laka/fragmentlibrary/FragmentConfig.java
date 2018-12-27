package com.laka.fragmentlibrary;

import android.app.Activity;
import android.app.FragmentManager;
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
     * */
    public static android.support.v4.app.FragmentManager v4FragmentManager;
//    private static FragmentManager appFragmentManager;

    public static void initFragmentManager(FragmentActivity activity){
        v4FragmentManager = activity.getSupportFragmentManager();
    }

    public static void initFragmentManager(AppCompatActivity activity){
        v4FragmentManager = activity.getSupportFragmentManager();
    }

//    public static void initFragmentManager(Activity activity){
//        appFragmentManager = activity.getFragmentManager();
//    }
//

}
