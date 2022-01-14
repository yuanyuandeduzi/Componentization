package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibs.BaseApplication;
import com.example.baselibs.Const_ARouter;
import com.example.baselibs.ServiceFactory;

import org.greenrobot.eventbus.EventBus;

import eventBus.EventMessage;
import eventBus.EventMessage2;

@Route(path = Const_ARouter.LOGIN_MAIN)
public class Login extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Log.d("TAG", "onCreate: ");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceFactory.getInstance().setLoginService(new AccountService(true,"159487qq"));
                Toast.makeText(Login.this, "ahhh", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(new EventMessage("A122hhhh"));
            }
        });
    }
}