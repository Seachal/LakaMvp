package com.laka.mvplibrary.model.http;

/**
 * @Author:summer
 * @Date:2018/12/15
 * @Description:响应体
 */
public class ResponseInfo<T> {
    private String message;
    private T data;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
