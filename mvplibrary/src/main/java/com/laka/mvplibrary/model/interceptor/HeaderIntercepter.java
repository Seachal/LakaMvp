package com.laka.mvplibrary.model.interceptor;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description: 添加请求头拦截器
 */
public class HeaderIntercepter implements Interceptor {

    private Context mContext;

    public HeaderIntercepter(){}

    public HeaderIntercepter(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
