package com.money.util;

import java.util.UUID;

public class UUIDUtil {
    public static String createID() {
        String s = UUID.randomUUID().toString();
        String s1 = s.replaceAll("-","");
        return s1;
    }

    public static void main(String[] args) {
        createID();
    }
}
