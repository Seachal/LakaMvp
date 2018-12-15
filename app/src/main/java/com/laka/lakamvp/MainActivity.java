package com.laka.lakamvp;

import android.app.AppOpsManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 获取渠道号
////                try {
////                    ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
////                    String umengChannelValue = info.metaData.getString("UMENG_CHANNEL_VALUE");
////                    Log.i(TAG, umengChannelValue);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//                test("hello world");
//            }
//        });
//
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                test(null);
//            }
//        });





//        AppOpsManager appOpsManager = (AppOpsManager) getSystemService(APP_OPS_SERVICE);
//        int checkOp = appOpsManager.checkOp(AppOpsManager.OPSTR_FINE_LOCATION, Process.myUid(), getPackageName());
//        if (checkOp == AppOpsManager.MODE_IGNORED) {
//            // 权限被拒绝了 .
//        }


        final Timer timer = new Timer(true);
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.e("main","------------------ 定时测试 ------------------");
            }
        };
        timer.schedule(timerTask,1000,1000);
    }


    public void test(@NonNull String parameter) {
        Log.i(TAG, "-------parameter-------:" + parameter.length());
    }


    public void test2(TestBean testBean) {

    }


    public static void isValid(Object object) {
        if (object instanceof TestBean) {
            TestBean bean = (TestBean) object;
        }
    }


    /**
     * 在操作数组前进行判断
     *
     * @param array
     * @param index
     * @return
     */
    public static boolean isVaild(int[] array, int index) {
        if (array == null || array.length == 0 || array.length <= index) {
            return false;
        }
        return true;
    }

    /**
     * 针对小米手机进行的权限检查
     *
     * @return
     */
//    public boolean checkSelfPermissionForXiaoMi() {
//        AppOpsManager appOpsManager = (AppOpsManager) getSystemService(APP_OPS_SERVICE);
//        int checkOp = appOpsManager.checkOp(AppOpsManager.OPSTR_FINE_LOCATION, Process.myUid(), getPackageName());
//        if (checkOp == AppOpsManager.MODE_IGNORED) {
//            // 权限被拒绝了 .
//            return false;
//        }
//        return true;
//    }


    class TestBean {
        private String name;
    }


    /**
     * 针对小米手机做的权限检查
     */
    public boolean checkSelfPermissionForXiaoMi() {
        AppOpsManager manager = (AppOpsManager) getSystemService(this.APP_OPS_SERVICE);
        try {
            Method method = manager.getClass().getDeclaredMethod("checkOp", int.class, int.class, String.class);
            int property = (Integer) method.invoke(manager, 26, Binder.getCallingUid(), getPackageName());
            if (AppOpsManager.MODE_ALLOWED == property) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
