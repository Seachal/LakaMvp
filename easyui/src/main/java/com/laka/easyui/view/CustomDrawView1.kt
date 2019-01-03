package com.laka.easyui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

/**
 * @Author:summer
 * @Date:2019/1/3
 * @Description:
 */
class CustomDrawView1 : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL
        // 每两个点（四个数字）组成一条线，线段绘制之间是抬起笔触的
        val points = floatArrayOf(20F, 20F, 120F, 20F, 70F, 20F, 70F, 120F, 20F, 120F, 120F, 120F, 150F, 20F, 250F, 20F, 150F, 20F, 150F, 120F, 250F, 20F, 250F, 120F, 150F, 120F, 250F, 120F)
        canvas?.drawLines(points, paint)
        // 绘制扇形
        canvas?.drawArc(100f, 150f, 300f, 300f, -90f, 90f, true, paint)
        canvas?.drawArc(100f, 150f, 300f, 300f, 90f, 90f, true, paint)
        paint.style = Paint.Style.STROKE
        canvas?.drawArc(100f, 150f, 300f, 300f, 0f, 90f, false, paint)
        canvas?.drawArc(100f, 150f, 300f, 300f, 180f, 90f, false, paint)

    }

}