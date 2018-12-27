package com.laka.fragmentlibrary.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.laka.fragmentlibrary.FragmentConfig;
import com.laka.fragmentlibrary.FragmentTools;
import com.laka.fragmentlibrary.R;
import com.laka.fragmentlibrary.base.BaseStackFragment;

/**
 * @Author:summer
 * @Date:2018/12/27
 * @Description:
 */
public class Fragment1 extends BaseStackFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTools.pushScreen(Fragment2.class);
            }
        });
    }
}
