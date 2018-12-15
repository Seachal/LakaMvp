package com.laka.mvplibrary.model;

import com.laka.mvplibrary.model.callback.RequestModelCallBack;
import com.laka.mvplibrary.model.http.ApiSubscriber;
import com.laka.mvplibrary.model.http.MobileApi;
import com.laka.mvplibrary.model.http.RxHttp;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2018/11/22.
 * model 层基类
 */

public class BaseModel implements IModel {

    private List<Subscription> mSubscriptionList = new ArrayList<>();

    public <T> void postLoad(String url, HashMap<String, String> parameter, final RequestModelCallBack<T> callBack) {
        postLoad(url, parameter, false, callBack);
    }

    public <T> void postLoad(String url, HashMap<String, String> parameter, boolean isAddCommonParameter, final RequestModelCallBack<T> callBack) {
        postLoad(url, parameter, isAddCommonParameter, false, callBack);
    }

    public <T> void postLoad(String url, HashMap<String, String> parameter, boolean isAddCommonParameter, boolean isAddHeader, final RequestModelCallBack<T> callBack) {
        RxHttp.getInstance().setFlowable(MobileApi.getFlowble(MobileApi.getApiService(isAddCommonParameter, isAddHeader).postRequest(url)))
                .subscriber(new ApiSubscriber<T>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        super.onSubscribe(s);
                        mSubscriptionList.add(s);
                    }

                    @Override
                    public void onNext(T t) {
                        callBack.onSuccess(t);
                    }
                });
    }

    public <T> void getLoad(String url, HashMap<String, String> parameter, final RequestModelCallBack<T> callBack) {
        postLoad(url, parameter, false, callBack);
    }

    public <T> void getLoad(String url, HashMap<String, String> parameter, boolean isAddCommonParameter, final RequestModelCallBack<T> callBack) {
        postLoad(url, parameter, isAddCommonParameter, false, callBack);
    }

    public <T> void getLoad(String url, HashMap<String, String> parameter, boolean isAddCommonParameter, boolean isAddHeader, final RequestModelCallBack<T> callBack) {
        RxHttp.getInstance().setFlowable(MobileApi.getFlowble(MobileApi.getApiService(isAddCommonParameter, isAddHeader).getRequest(url)))
                .subscriber(new ApiSubscriber<T>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        super.onSubscribe(s);
                        mSubscriptionList.add(s);
                    }

                    @Override
                    public void onNext(T t) {
                        callBack.onSuccess(t);
                    }
                });
    }


    //TODO 上传json、上传图片


    @Override
    public void onDestory() {
        if (mSubscriptionList != null && mSubscriptionList.size() > 0) {
            for (int i = 0; i < mSubscriptionList.size(); i++) {
                mSubscriptionList.get(i).cancel();
            }
        }
    }
}
