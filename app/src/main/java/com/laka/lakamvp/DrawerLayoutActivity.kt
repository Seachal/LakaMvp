package com.laka.lakamvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_drawer_layout.*

/**
 * @Author:summer
 * @Date:2018/12/19
 * @Description:
 */
class DrawerLayoutActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)
    }

    private fun leftLayoutToggle(){
        if (drawer_layout_main.isDrawerOpen(relative_layout_centent_main)){
            drawer_layout_main.closeDrawer(Gravity.START)
        }else{
            drawer_layout_main.openDrawer(Gravity.START)
        }
    }



}