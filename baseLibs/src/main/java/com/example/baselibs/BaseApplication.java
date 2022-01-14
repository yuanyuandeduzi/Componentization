package com.example.baselibs;

import android.app.Application;
import android.os.Bundle;

public abstract class BaseApplication extends Application {

    public abstract void init(Application application);
    public abstract void initOver(Application application);
}
