package com.project.utils;

import java.util.UUID;

public class UUIDFactory {
    public String getUUIDString(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
