package com.project0312.proxy;

public class User implements IUser {
    @Override
    public void runMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行User类runMethod方法");
    }
}
