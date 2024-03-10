package com.perperon.single.lazy.nosync;

/**
 * @author perperon
 * @date 2024/3/9
 * @apiNote 懒汉式 非线程安全
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static  Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
