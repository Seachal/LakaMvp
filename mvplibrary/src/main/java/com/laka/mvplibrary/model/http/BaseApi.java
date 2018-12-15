package com.laka.mvplibrary.model.http;

import com.google.gson.Gson;
import com.laka.mvplibrary.model.fun.ApiThrowExcepitionFun1;
import com.laka.mvplibrary.model.fun.ObjectToJSONObjectFun1;
import com.laka.mvplibrary.model.fun.StringToJSONObjectFun1;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:基类 api
 */
public abstract class BaseApi {

    /**
     * 整合json为 RequestBody 对象
     * @param map
     * @return
     */
    public static RequestBody toBody(HashMap map) {
        Gson gson = new Gson();
        ResponseInfo requestBean= new ResponseInfo();
        requestBean.setData(map);
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), gson.toJson(requestBean));
    }

    public static RequestBody toBody(JSONObject jsonObject) {
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (jsonObject).toString());
    }

    /**
     * 通过外部传入
     */
    public static class FlowableBuilder {
        private Flowable mFlowable;
        private boolean apiException;
        private boolean toJSONJbject;
        private boolean isWeb;
        private Scheduler subscribeScheduler;
        private Scheduler obscerveScheduler;

        public void setObscerveScheduler(Scheduler obscerveScheduler) {
            this.obscerveScheduler = obscerveScheduler;
        }

        public void setSubscribeScheduler(Scheduler subscribeScheduler) {
            this.subscribeScheduler = subscribeScheduler;
        }

        public FlowableBuilder(Flowable o) {
            this.mFlowable = o;
        }

        public FlowableBuilder addApiException(){
            apiException = true;
            return this;
        }
        public FlowableBuilder addToJSONObject(){
            toJSONJbject = true;
            return this;
        }

        public FlowableBuilder isWeb() {
            isWeb = true;
            return this;
        }

        public Flowable build(){
            if(isWeb){
                mFlowable = mFlowable.map(new StringToJSONObjectFun1());
            }
            if(apiException){
                mFlowable = mFlowable.flatMap(new ApiThrowExcepitionFun1());
            }
            if(toJSONJbject){
                mFlowable = mFlowable.map(new ObjectToJSONObjectFun1());
            }
            if(subscribeScheduler!=null){
                mFlowable = mFlowable.subscribeOn(subscribeScheduler);
            }else {
                mFlowable = mFlowable.subscribeOn(Schedulers.io());
            }
            if(obscerveScheduler!=null){
                mFlowable = mFlowable.observeOn(obscerveScheduler);
            }else{
                mFlowable = mFlowable.observeOn(AndroidSchedulers.mainThread());
            }
            return mFlowable;
        }
    }
}
