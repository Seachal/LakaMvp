package com.laka.lakamvp.kotlinlearn.bean

import com.laka.lakamvp.R
import com.laka.mvplibrary.view.BaseActivity

/**
 * @Author:summer
 * @Date:2018/12/6
 * @Description:
 */
class KotlinTestActivity : BaseActivity() {
    override fun bindPresenter() {
    }

    override fun loadData() {
    }

    override fun initEvent() {
    }

    override fun initView() {
        var student: Student = Student("小明", 12)
        println(student.toString())
        var teacher:Teacher = Teacher("杨老师",23)
        println(teacher.toString())
        var school:School = School("车陂小学",101,1001)
        println(school.toString())
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_kotlin_test
    }
}