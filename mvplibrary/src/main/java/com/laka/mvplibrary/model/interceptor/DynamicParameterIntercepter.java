package com.laka.mvplibrary.model.interceptor;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:动态添加参数拦截器
 */
public class DynamicParameterIntercepter implements Interceptor {

    private HashMap<String, String> mHashParameter;
    public DynamicParameterIntercepter(HashMap<String,String> hashParameter) {
        mHashParameter = hashParameter;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
