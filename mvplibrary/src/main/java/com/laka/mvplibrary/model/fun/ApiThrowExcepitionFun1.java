package com.laka.mvplibrary.model.fun;

import com.laka.mvplibrary.model.exception.ApiException;
import com.laka.mvplibrary.model.http.ResponseInfo;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * @Author:summer
 * @Date:2018/12/15
 * @Description:用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 */
public class ApiThrowExcepitionFun1<T> implements Function<ResponseInfo<T>, Flowable<T>> {

    @Override
    public Flowable<T> apply(ResponseInfo<T> responseInfo) throws Exception {
        if (responseInfo.getCode()!= 200) {  //如果code返回的不是200,则抛出ApiException异常，否则返回data数据
            return Flowable.error(new ApiException(responseInfo.getCode(),responseInfo.getMessage()));
        }
        return Flowable.just(responseInfo.getData());

    }
}
