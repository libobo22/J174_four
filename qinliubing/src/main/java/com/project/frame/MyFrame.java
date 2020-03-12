package com.project.frame;

public class MyFrame implements IMyFrame {
    @Override
    public void contrllorCar(IMessage message) {
        //获得指令
        String info=message.getMessage();
        if(info.equals("start")){
            System.out.println("发动汽车");
        }else if(info.equals("stop")){
            System.out.println("停止汽车");
        }
    }
}
