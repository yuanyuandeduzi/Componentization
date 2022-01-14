package com.example.componentization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.Const_ARouter;
import com.example.baselibs.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }

        ARouter.init(getApplication());

        init();
        Log.d("TAG", "onCreate: " + ServiceFactory.getInstance().getLoginService().isLogin());
        new MainApplication().init(getApplication());
    }

    private boolean isDebug(){
        return BuildConfig.DEBUG;
    }

    private void init() {
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Const_ARouter.LOGIN_MAIN).navigation();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Const_ARouter.ADD_MAIN).navigation();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Const_ARouter.SHARE_MAIN).navigation();
            }
        });
    }
}