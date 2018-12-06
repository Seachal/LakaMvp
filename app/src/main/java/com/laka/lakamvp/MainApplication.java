package com.laka.lakamvp;

import android.app.Application;
import android.util.Log;

/**
 * Created by summer on 2018/11/27.
 */

public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        String channel = BuildConfig.CHANNEL;
    }
}
