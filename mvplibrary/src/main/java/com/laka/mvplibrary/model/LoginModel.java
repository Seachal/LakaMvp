package com.laka.mvplibrary.model;

import com.laka.mvplibrary.model.callback.RequestModelCallBack;
import com.laka.mvplibrary.model.http.NetConfig;

import java.util.HashMap;

/**
 * @Author:summer
 * @Date:2018/12/15
 * @Description:
 */
public class LoginModel extends BaseModel {


    public void getUserInfo(HashMap<String, String> parameter, final RequestModelCallBack<String> callBack) {
        postLoad(NetConfig.GET_USER_INFO, parameter, callBack);
    }

}
