package com.project0312.test;

public class MyFrame implements IFrame {
    @Override
    public void runFrame(IMessage message) {
        System.out.println(message.getMessage());
    }
}
