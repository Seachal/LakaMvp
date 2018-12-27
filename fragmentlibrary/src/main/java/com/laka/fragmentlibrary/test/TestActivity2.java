package com.laka.fragmentlibrary.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.laka.fragmentlibrary.FragmentConfig;
import com.laka.fragmentlibrary.FragmentTools;
import com.laka.fragmentlibrary.R;

public class TestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        FragmentConfig.initFragmentManager(this);
        FragmentTools.pushScreen(Fragment1.class, new Bundle());
    }


}
