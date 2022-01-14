package com.example.share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibs.Const_ARouter;
import com.example.baselibs.LoginService;
import com.example.baselibs.ServiceFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import eventBus.EventMessage;
import eventBus.EventMessage2;

@Route(path = Const_ARouter.SHARE_MAIN)
public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ServiceFactory.getInstance().getLoginService().isLogin()) {
                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv = findViewById(R.id.text1);
        tv.setText("nifoaf");

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void showEventBus(EventMessage eventMessage2) {
        tv.setText(eventMessage2.account);
    }
}