package com.laka.commonlibrary.utils.toast;

/**
 * @Author Lyf
 * @CreateTime 2018/3/7
 * @Description
 **/
public interface ICustomToast {

    void setText(CharSequence s);

    void show();

    void setDuration(int duration);

    void setGravity(int gravity, int xOffset, int yOffset);

}
