package com.example.componentization;

import android.app.Application;
import android.media.audiofx.DynamicsProcessing;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.AppConfig;
import com.example.baselibs.BaseApplication;
import com.example.login.BuildConfig;

public class MainApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //ARouter后台有ILogger接口，定义了一些输出日志
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化ARouter

        init(this);
        Log.d("TAG", "onCreate111: ");
        initOver(this);
    }
    private boolean isDebug() {
        String name;
        return BuildConfig.DEBUG;
    }

    @Override
    public void init(Application application) {
        for (String module : AppConfig.modules) {
            try {
                Class<?> aClass = Class.forName(module);
                BaseApplication baseApplication = (BaseApplication) aClass.newInstance();
                baseApplication.init(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initOver(Application application) {
        for (String module : AppConfig.modules) {
            try {
                Class<?> aClass = Class.forName(module);
                BaseApplication baseApplication = (BaseApplication) aClass.newInstance();
                baseApplication.initOver(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
