package com.project.hibernate.util;

import java.util.UUID;

public class GetUUID {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String str = UUID.randomUUID().toString();
            str = str.replaceAll("-", "");
            System.out.println(str);
        }

    }
}
