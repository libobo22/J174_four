package com.project0312.test.user;

import com.project0312.test.IFrame;
import com.project0312.test.IMessage;
import com.project0312.test.MyFrame;

public class TestMain {
    public static void main(String[] args) {
        IMessage message=new UserMessage();
        IFrame frame=new MyFrame();
        frame.runFrame(message);
    }
}
