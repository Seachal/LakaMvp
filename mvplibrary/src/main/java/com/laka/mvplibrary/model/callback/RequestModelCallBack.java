package com.laka.mvplibrary.model.callback;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:
 */
public interface RequestModelCallBack<T> {
    void onSuccess(T t);
    void onFail(int code,String msg);
}
