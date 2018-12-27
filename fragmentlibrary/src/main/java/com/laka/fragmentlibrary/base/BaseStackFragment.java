package com.laka.fragmentlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laka.fragmentlibrary.R;


/**
 * @Author:summer
 * @Date:2018/12/27
 * @Description:Fragment栈管理基类,只需要在自定义的BaseFragment中继承此类即可使用Fragment任务栈,如果自定义的BaseFragment需要继承第三方的LazyFragment,则可以更改当前类继承的父类
 */
public abstract class BaseStackFragment extends Fragment {

    private ViewGroup mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_root_view, container, false);
        inflater.inflate(getLayoutRes(),mRootView,true);
        return mRootView;
    }

    protected abstract int getLayoutRes();
}
