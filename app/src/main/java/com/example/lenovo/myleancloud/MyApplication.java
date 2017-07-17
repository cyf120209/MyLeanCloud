package com.example.lenovo.myleancloud;

import android.app.Application;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVOSCloud;

/**
 * Created by lenovo on 2017/7/13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"xgxgXgyYEsBJH7C3Fa0enWtC-gzGzoHsz", "vmfYrjkGUYnVmWJXwojzbmvY");
        AVOSCloud.setDebugLogEnabled(true);
        AVAnalytics.enableCrashReport(this, true);
    }
}
