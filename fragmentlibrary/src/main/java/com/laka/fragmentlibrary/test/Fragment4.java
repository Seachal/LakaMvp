package com.laka.fragmentlibrary.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.laka.commonlibrary.utils.LogUtils;
import com.laka.fragmentlibrary.R;
import com.laka.fragmentlibrary.base.BaseStackFragment;

/**
 * @Author:summer
 * @Date:2018/12/27
 * @Description:
 */
public class Fragment4 extends BaseStackFragment {

    private static final String TAG = "Fragment4";

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment4;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.error(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.error(TAG, "onCreate");
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.error(TAG, "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.error(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.error(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.error(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.error(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.error(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.error(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.error(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.error(TAG, "onDetach");
    }

}
