package com.laka.fragmentlibrary.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.laka.fragmentlibrary.FragmentConfig;
import com.laka.fragmentlibrary.R;

public class TestActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        // 初始化FragmentManager
        FragmentConfig.initFragmentManager(this);
    }


    public void clickTest1(View view) {
        startActivity(new Intent(this, TestActivity2.class));
    }

}
