package com.perperon.single.lazy.sync;

/**
 * @author perperon
 * @date 2024/3/10
 * @apiNote 懒汉式 线程安全
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
