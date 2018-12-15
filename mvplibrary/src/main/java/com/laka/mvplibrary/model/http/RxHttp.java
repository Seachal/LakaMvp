package com.laka.mvplibrary.model.http;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:网络请求总入口
 */

import android.text.TextUtils;

import com.laka.mvplibrary.BuildConfig;
import com.laka.mvplibrary.model.interceptor.CommonParameterIntercepter;
import com.laka.mvplibrary.model.interceptor.DynamicParameterIntercepter;
import com.laka.mvplibrary.model.interceptor.LogIntercepter;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求总入口
 */
public class RxHttp<T> {

    public static final String TAG = "RxHttp";
    public static RxHttp instance;
    private Flowable mFlowable;
    private boolean mAddCommonParameter;
    private boolean mAddDynamicParameter;


    public static RxHttp getInstance() {
        if (instance == null) {
            synchronized (RxHttp.class) {
                if (instance == null) {
                    instance = new RxHttp();
                }
            }
        }
        return instance;
    }

    private RxHttp() {

    }


    /**
     * 设置observable
     *
     * @param flowable
     * @return
     */
    public RxHttp setFlowable(Flowable flow) {
        mFlowable = flow;
        return instance;
    }

    /**
     * 线程调度
     * @return
     */
    public RxHttp compose(){
        mFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return instance;
    }

    /**
     * 添加公共参数
     * @return
     */
    public RxHttp addCommonParameter(boolean addCommonParameter){
        mAddCommonParameter = addCommonParameter;
        return instance;
    }

    public <T> RxHttp<T> addDynamicParameter(boolean isAddDynamicParameter) {
        mAddDynamicParameter = isAddDynamicParameter;
        return instance;
    }


    /**
     * 设置ApiSubscriber
     *
     * @param subscriber
     * @return
     */
    public RxHttp subscriber(ApiSubscriber<T> subscriber) {
        mFlowable.subscribe(subscriber); //RxJava
        return instance;
    }



}
