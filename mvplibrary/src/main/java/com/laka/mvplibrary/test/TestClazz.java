package com.laka.mvplibrary.test;

/**
 * @Author:summer
 * @Date:2018/12/5
 * @Description:测试类
 */
public class TestClazz {
    private static final int SOME_CONSTANT = 1001;
    private int mParameter1;
    protected int mParameter2;
    private static int sStatic;

    private boolean mCondition;

    public void test(){
        if(mCondition){
            body();
        }

        if (mCondition) body();

        if (mCondition)
            body();

    }


    public void body(){

    }


}
