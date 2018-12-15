package com.laka.mvplibrary.model.http;

import android.text.TextUtils;

import com.laka.mvplibrary.BuildConfig;
import com.laka.mvplibrary.model.interceptor.CommonParameterIntercepter;
import com.laka.mvplibrary.model.interceptor.DynamicParameterIntercepter;
import com.laka.mvplibrary.model.interceptor.HeaderIntercepter;
import com.laka.mvplibrary.model.interceptor.LogIntercepter;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:Api类
 */
public class MobileApi extends BaseApi {

    public static Flowable mFlowable;

    /**
     * 封装json body
     * @param json
     * @return
     */
    public static RequestBody createJsonRequestBody(String json) {
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
    }

    /**
     * 封装图片 body
     * @param file
     * @return
     */
    public static  MultipartBody.Part createRequestPart(File file){
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        return filePart;
    }


    /**
     * 在该方法中对请求回来的Flowable添加特别处理
     *
     * @param flow
     * @return
     */
    public static <T> Flowable getFlowble(Flowable<T> flow) {
        mFlowable = new FlowableBuilder(flow)
                .addApiException()   //添加 apiExcetion 过滤
                .build();
        return mFlowable;
    }


    /**
     * 获取ApiService对象
     *
     * @param isAddCommonParameter
     * @param isAddHeader
     * @return
     */
    public static ApiService getApiService(boolean isAddCommonParameter, boolean isAddHeader) {
        return new ApiServiceBuilder()
                .addParameter(isAddCommonParameter)
                .addHeader(isAddHeader)
                .build();
    }

    /**
     * 使用 Retrofit.Builder 和 OkHttpClient.Builder 构建 NetworkApi
     */
    public static class ApiServiceBuilder {
        private String baseUrl;  //根地址
        private boolean isAddHeader; //是否添加请求头拦截器
        private HashMap<String, String> addDynamicParameterMap; //url动态参数
        private boolean isAddCommonParameter; //url是否添加固定参数
        private Retrofit.Builder rtBuilder;
        private OkHttpClient.Builder okBuild;
        private Converter.Factory convertFactory;

        public ApiServiceBuilder setConvertFactory(Converter.Factory convertFactory) {
            this.convertFactory = convertFactory;
            return this;
        }

        public ApiServiceBuilder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public ApiServiceBuilder addParameter(boolean isAddCommonParameter) {
            isAddCommonParameter = true;
            return this;
        }

        public ApiServiceBuilder addHeader(boolean isAddHeader) {
            isAddHeader = true;
            return this;
        }

        public ApiServiceBuilder addDynamicParameter(HashMap map) {
            addDynamicParameterMap = map;
            return this;
        }


        public ApiService build() {
            rtBuilder = new Retrofit.Builder();
            okBuild = new OkHttpClient().newBuilder();
            if (!TextUtils.isEmpty(baseUrl)) {
                rtBuilder.baseUrl(baseUrl);
            } else {
                rtBuilder.baseUrl(Mobile.BASE_URL);
            }
            if (isAddHeader) {
                okBuild.addInterceptor(new HeaderIntercepter());
            }
            if (isAddCommonParameter) {
                okBuild.addInterceptor(new CommonParameterIntercepter());
            }
            if (addDynamicParameterMap != null) {
                okBuild.addInterceptor(new DynamicParameterIntercepter(addDynamicParameterMap));
            }
            //warning:must in the last intercepter to log the network;
            if (BuildConfig.DEBUG) { //改成自己的显示log判断逻辑
                okBuild.addInterceptor(new LogIntercepter());
            }
            if (convertFactory != null) {
                rtBuilder.addConverterFactory(convertFactory);
            } else {
                // 默认使用 Gson 转换器
                rtBuilder.addConverterFactory(GsonConverterFactory.create());
            }
            rtBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            rtBuilder.client(okBuild.build());
            return rtBuilder.build().create(ApiService.class);
        }
    }

}
