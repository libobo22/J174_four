package com.project.frame.user;

import com.project.frame.IMessage;
import com.project.frame.IMyFrame;
import com.project.frame.MyFrame;

public class T {
    public static void main(String[] args){
        //创建指令
        IMessage message=new UserCar();
        //运行框架
        //创建框架对象
        IMyFrame frame=new MyFrame();
        //调用框架，放入用户指令
        frame.contrllorCar(message);
    }
}
