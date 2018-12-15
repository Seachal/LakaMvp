package com.laka.lakamvp.kotlinlearn.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle

/**
 * @Author:summer
 * @Date:2018/12/6
 * @Description:
 */
class CustomDialog1 : AlertDialog {

    /**
     * 一个参数的构造方法中调用父类两个参数的构造方法
     */
    constructor(context: Context?) : super(context, 101)

    /**
     * 二级构造函数
     * */
    constructor(context: Context?, themeResId: Int) : super(context, themeResId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun MutableList<Int>.swap(x: Int, y: Int) {
        val tmp = this[x] // this 对应 list
        this[x] = this[y]
        this[y] = tmp
    }


}