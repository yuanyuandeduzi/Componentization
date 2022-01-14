package com.example.baselibs;

public class ServiceFactory {
    private LoginService loginService;

    public static ServiceFactory getInstance(){
        return Inner.serviceFactory;
    }

    private static class Inner{
        private static ServiceFactory serviceFactory = new ServiceFactory();
    }

    public void setLoginService(LoginService loginService){
        this.loginService = loginService;
    }
    public LoginService getLoginService(){
        if(loginService == null){
            return new Empty();
        }else{
            return loginService;
        }
    }
}
