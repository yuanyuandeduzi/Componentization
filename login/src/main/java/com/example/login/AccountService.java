package com.example.login;

import com.example.baselibs.LoginService;

public class AccountService implements LoginService {
    boolean isLogin;
    String getPassword;

    public AccountService(boolean isLogin, String getPassword) {
        this.isLogin = isLogin;
        this.getPassword = getPassword;
    }

    @Override
    public boolean isLogin() {
        return isLogin;
    }

    @Override
    public String getPassword() {
        return getPassword;
    }
}
