package com.example.baselibs;

public class Empty implements LoginService{
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
