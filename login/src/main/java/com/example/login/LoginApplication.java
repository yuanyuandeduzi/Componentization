package com.example.login;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.BaseApplication;
import com.example.baselibs.ServiceFactory;

public class LoginApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
        initOver(this);
    }

    @Override
    public void init(Application application) {
        ServiceFactory.getInstance().setLoginService(new AccountService(true,"AHHHH"));
    }

    @Override
    public void initOver(Application application) {

    }
}
