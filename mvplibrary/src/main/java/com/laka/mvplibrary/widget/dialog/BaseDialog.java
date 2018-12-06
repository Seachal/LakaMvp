package com.laka.mvplibrary.widget.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.laka.mvplibrary.R;

/**
 * Created by summer on 2018/11/22.
 * Dialog 基类
 */

public abstract class BaseDialog extends AlertDialog {

    // dialog 的内容对其方式
    private int mGravityType = Gravity.CENTER;

    // dialog 填充模式
    private int mLayoutParamsWidth = WindowManager.LayoutParams.WRAP_CONTENT;
    private int mLayoutParamsHeight = WindowManager.LayoutParams.WRAP_CONTENT;

    protected BaseDialog(Context context) {
        super(context, R.style.CommonDialogTheme);
    }

    protected BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = mLayoutParamsWidth;
        layoutParams.height = mLayoutParamsHeight;
        window.setAttributes(layoutParams);
        window.setGravity(mGravityType);
        setContentView(getLayoutId());
        initView();
        initEvent();
        initData();
    }

    /**
     * layout 资源 ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void initView();

    public void setGravityType(int gravityType) {
        mGravityType = gravityType;
    }

    public void setLayoutParams(int layoutParamsWidth, int layoutParamsHeight) {
        this.mLayoutParamsWidth = mLayoutParamsWidth;
        this.mLayoutParamsHeight = mLayoutParamsHeight;
    }

}
