package com.laka.commonlibrary.utils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: PermissionUtils
 * @Description: 权限工具
 * @Author: chuan
 * @Date: 09/01/2018
 */

public final class PermissionUtils {
    private final static List<String> PERMISSIONS = getPermissions();  //app声明的权限列表

    /**
     * 获取app声明的权限列表
     *
     * @return app声明的权限列表
     */
    public static List<String> getPermissions() {
        return getPermissions(ApplicationUtils.getApplication().getPackageName());
    }

    /**
     * 获取指定包名下声明的权限列表
     *
     * @param packageName 包名
     * @return 权限列表
     */
    public static List<String> getPermissions(String packageName) {
        PackageManager pm = ApplicationUtils.getApplication().getPackageManager();

        try {
            return Arrays.asList(
                    pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
                            .requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }

    /**
     * 判断当前app是否获得权限
     *
     * @param permission 相关权限
     * @return true , 表示具备该权限；false,不具备该权限
     */
    public static boolean checkPermission(String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(ApplicationUtils.getApplication(), permission) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        } else {
            PackageManager pm = ApplicationUtils.getApplication().getPackageManager();
            if (pm.checkPermission(permission, ApplicationUtils.getApplication().getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }

        return result;
    }

    /**
     * 判断当前app是否获得权限
     *
     * @param permissions 相关权限
     * @return true , 表示具备该权限；false,不具备该权限
     */
    public static boolean checkPermission(String... permissions) {
        for (String permission : permissions) {
            if (!checkPermission(permission)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 打开应用具体设置
     */
    public static void openAppSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + ApplicationUtils.getApplication().getPackageName()));
        ApplicationUtils.getApplication().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }


    public static class Builder {
        private Set<String> mPermissions;
        private ResultCallback mResultCallback;
        private DetailResultCallback mDetailResultCallback;

        public Builder(String... permissions) {
            mPermissions = new LinkedHashSet<>();

            for (String permission : permissions) {
                if (PERMISSIONS.contains(permission)) {
                    mPermissions.add(permission);
                }
            }
        }

        public Builder setResultCallback(ResultCallback resultCallback) {
            mResultCallback = resultCallback;
            return this;
        }

        public Builder setDetailResultCallback(DetailResultCallback resultCallback) {
            mDetailResultCallback = resultCallback;
            return this;
        }


    }

    /**
     * 简单结果回调
     */
    public interface ResultCallback {
        void onGranted();

        void onDenied();
    }

    /**
     * 详细结果回调
     */
    public interface DetailResultCallback {
        void onGranted(List<String> permissions);

        void onDenied(List<String> permissions);
    }

    public interface OnRationaleListener {

        void rationale(ShouldRequest shouldRequest);

        interface ShouldRequest {
            void again(boolean again);
        }
    }


}
