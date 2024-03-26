package com.perperon.pattern.single.interior;

/**
 * @author perperon
 * @date 2024/3/10
 * @apiNote 静态内部类实现单例模式
 */
public class Singleton {
    private Singleton() {}
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
