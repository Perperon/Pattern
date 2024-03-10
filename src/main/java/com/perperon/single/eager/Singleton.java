package com.perperon.single.eager;

/**
 * @author perperon
 * @date 2024/3/9
 * @apiNote 饿汉式
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
