package com.money.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {
    public static ExecutorService pool;
    static {
        pool = Executors.newFixedThreadPool(5);
    }
}
