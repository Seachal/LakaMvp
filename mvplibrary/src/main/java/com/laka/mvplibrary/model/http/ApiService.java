package com.laka.mvplibrary.model.http;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:Retrofit2 的 api 类
 */
public interface ApiService {

    @POST()
    @FormUrlEncoded
    Flowable<ResponseInfo> postRequest(@Url() String url, @FieldMap Map<String, String> params);

    @POST()
    Flowable<ResponseInfo> postRequest(@Url() String url);

    @GET()
    @FormUrlEncoded
    Flowable<ResponseInfo> getRequest(@Url() String url, @FieldMap Map<String, String> params);

    @GET()
    Flowable<ResponseInfo> getRequest(@Url() String url);

    /**
     * 多参数多图片上传
     * @param url
     * @param maps
     * @param filePart
     * @return
     */
    @POST()
    Flowable<ResponseInfo> uploadImage(@Url() String url, @PartMap() Map<String, RequestBody> maps, @Part List<MultipartBody.Part> filePart);

    /**
     * 上传json数据
     * @param url
     * @return
     */
    @POST
    Flowable<ResponseInfo> uploadJson(@Url() String url, @Body RequestBody jsonBody);


}
