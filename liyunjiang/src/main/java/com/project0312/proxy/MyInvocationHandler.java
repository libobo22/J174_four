package com.project0312.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long s=System.currentTimeMillis();
        Object obj=method.invoke(target,args);
        long e=System.currentTimeMillis();
        System.out.println("执行时间："+(e-s));
        return obj;
    }
}
