package com.laka.mvplibrary.model;

import com.laka.mvplibrary.model.callback.RequestModelCallBack;
import com.laka.mvplibrary.model.http.NetConfig;

import java.util.HashMap;

/**
 * @Author:summer
 * @Date:2018/12/15
 * @Description:
 */
public class LoginModel<T> extends BaseModel<T> {


    public void getUserInfo(HashMap<String, String> parameter, final RequestModelCallBack<T> callBack) {
        postLoad(NetConfig.GET_USER_INFO, parameter, callBack);
    }

}
