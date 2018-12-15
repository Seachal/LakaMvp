package com.laka.mvplibrary.model.exception;

/**
 * @Author:summer
 * @Date:2018/12/14
 * @Description:
 */
public class ApiException extends RuntimeException {

    private int mCode;
    private String mMessage;

    public ApiException(int code, String message) {
        mCode = code;
        mMessage = message;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
