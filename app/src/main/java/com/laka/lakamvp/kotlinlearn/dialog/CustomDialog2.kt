package com.laka.lakamvp.kotlinlearn.dialog

import android.app.AlertDialog
import android.content.Context

/**
 * @Author:summer
 * @Date:2018/12/6
 * @Description: kotlin 主构建函数，必须调用父类某个构造函数进行父类的初始化
 */
class CustomDialog2(context: Context, themeResId: Int = 100) : AlertDialog(context,themeResId) {

    //constructor(context: Context, themeResId: Int) : this(context, themeResId)

}