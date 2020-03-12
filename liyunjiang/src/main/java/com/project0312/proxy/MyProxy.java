package com.project0312.proxy;

import java.lang.reflect.Proxy;

public class MyProxy {
    public static void main(String[] args) {
        IUser user=new User();
        user= (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(),
                user.getClass().getInterfaces(),
                new MyInvocationHandler(user)
                );
        user.runMethod();

//        System.out.println(obj);
    }
}
