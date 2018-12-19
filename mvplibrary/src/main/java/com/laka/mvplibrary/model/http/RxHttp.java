package com.laka.mvplibrary.model.http;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:网络请求总入口
 */
public class RxHttp {

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
    public <T> RxHttp setFlowable(Flowable<T> flow) {
        mFlowable = flow;
        return instance;
    }

    /**
     * 线程调度
     *
     * @return
     */
    public RxHttp compose() {
        mFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return instance;
    }

    /**
     * 添加公共参数
     *
     * @return
     */
    public RxHttp addCommonParameter(boolean addCommonParameter) {
        mAddCommonParameter = addCommonParameter;
        return instance;
    }

    public <T> RxHttp addDynamicParameter(boolean isAddDynamicParameter) {
        mAddDynamicParameter = isAddDynamicParameter;
        return instance;
    }


    /**
     * 设置ApiSubscriber
     *
     * @param subscriber
     * @return
     */
    public <T> RxHttp subscriber(ApiSubscriber<T> subscriber) {
        mFlowable.subscribe(subscriber); //RxJava
        return instance;
    }


}
