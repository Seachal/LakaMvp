package com.laka.lakamvp.kotlinlearn.bean

/**
 * @Author:summer
 * @Date:2018/12/6
 * @Description:创建kotlin data class 类，自动生成get、set等方法，这种数据类必须提供构造方法，并且构造方法的参数
 * 至少为1个，类里面的成员变量必须进行初始化，因为要生成相应的get、set方法，如果不初始化，get方法返回的值将是null，
 * 而kotlin旨在解决空指针异常的语言，是不允许这样的情况发生的。
 */
data class Student(var name: String, var age: Int)

data class Teacher(var name: String, var age: Int)
data class School(var name: String, var age: Int, var number: Int)
data class Course(var courseName: String, var achievement: Int) {
    var age: Int = 10
}


/**
 * 可继承的类都需要显性添加 open 修饰符，如果没有open 修饰符，则该类为 final 类型，是无法进行继承的。
 * open 类可被继承，open 修饰的方法可以被子类重写，非 open 修饰的方法不能被子类重写，因为默认是final的
 * 在final 类中，出现 open 类型的成员是不允许的，override 修饰的方法是 open 的（父类open修饰，子类override修饰）
 * 如果子类不想让孙子类重写该方法，则可以使用 final 修饰。
 */
open class Base {
    open fun v() {}
    fun nv() {}
}

open class Derived() : Base() {
    final override fun v() {}
    open fun nnv() {}
}

class Child() : Derived() {
    override fun nnv() {
        super.nnv()
    }

}


class A {
    fun foo() {
        println("对象A原来的foo方法")
    }

    fun A.foo(i: Int) {
        println("对象A针对foo进行的扩展")
        this.foo()
    }
}

class B {
    var a: A = A()
    fun fbb() {
        // 扩展函数
        fun A.foo(i: Int) {
            println("对象A针对foo进行的扩展")
            this.foo()
        }
        a.foo(1)
    }
}





