package com.money.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    //src是被加密的数据
    //md5加密
    public static String encrypt(String src) {
        try {
            //创建消息摘要实例对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] a = md5.digest(src.getBytes());
            System.out.println("---" + a);
            StringBuilder sd = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
                int x = (int)a[i] & 0xff;
                //没有这一条是标准算法，二进制转十六进制，容易破解
                //加盐值，不易破解
                x = x + 1;
                if (x < 16) {
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));
            }
            System.out.println(sd.toString());
            return sd.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] agrs) {
        encrypt("admin" );
    }*/
}
